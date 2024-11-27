package data_access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatRequestAssistantMessage;
import com.azure.ai.openai.models.ChatRequestMessage;
import com.azure.ai.openai.models.ChatRequestSystemMessage;
import com.azure.ai.openai.models.ChatRequestUserMessage;
import com.azure.core.credential.AzureKeyCredential;
import use_case.recommend.RecommendLanguageModelDataAccessInterface;
import use_case.search.SearchLanguageModelDataAccessInterface;

/**
 * Data access object to connect to Azure openAI.
 */
public class LanguageModelDataAccessObject implements RecommendLanguageModelDataAccessInterface,
        SearchLanguageModelDataAccessInterface {

    final private String endpoint = "https://spotifycompanion.openai.azure.com/";
    final private String accessToken;

    public LanguageModelDataAccessObject() {
        accessToken = getKey();
    }

    /**
     * This is a helper method to get the Azure API key.
     * @return the access token stored in the local keys.txt file
     */
    private String getKey() {
        final File file;
        file = new File("src/keys");
        String key = "not found";
        try {
            final BufferedReader br = new BufferedReader(new FileReader(file));
            key = br.readLine();

            br.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("The file which should contain the " +
                    "azure access token does not exist in the correct place. Either create the file and place a valid api key in it or move the file to the src folder");
        }
        catch (IOException ex) {
            System.out.println("Error reading file");
        }
        return key;
    }

    @Override
    public String query(String prompt) {
        final OpenAIClient client = new OpenAIClientBuilder()
                .credential(new AzureKeyCredential(accessToken))
                .endpoint(endpoint)
                .buildClient();
        final List<ChatRequestMessage> chatMessages = new ArrayList<>();
        chatMessages.add(new ChatRequestSystemMessage("You are a Spotify analyst, you will either send back a "
                + "list of songs based on a description or a list of songs which are similar to a provided list."));
        chatMessages.add(new ChatRequestUserMessage("Can you help me find songs similar to Driver's License"));
        chatMessages.add(new ChatRequestAssistantMessage(" Similar songs include Femininomenon by Chappell Roan"
                + ", Birds of A Feather by Billie Eilish and Part of Me by Noah Kahan"));
        chatMessages.add(new ChatRequestUserMessage("Is there a song about a house in the south of"
                + " the US and includes something about the sun?"));
        chatMessages.add(new ChatRequestUserMessage("House of the Rising Sun by The Animals."));
        chatMessages.add(new ChatRequestUserMessage(prompt));

        final ChatCompletions chatCompletions = client.getChatCompletions("gpt-4",
                new ChatCompletionsOptions(chatMessages));
        final int back = chatCompletions.getChoices().size() - 1;
        return chatCompletions.getChoices().get(back).getMessage().getContent();

    }
}
