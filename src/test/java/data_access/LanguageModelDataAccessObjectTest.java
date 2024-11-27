package data_access;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LanguageModelDataAccessObjectTest {

    @Test
    public void queryTest(){
        // checks that the key is in the right place and is functional
        LanguageModelDataAccessObject languageModelDataAccessObject = new LanguageModelDataAccessObject();
        final String response = languageModelDataAccessObject.query("A song where a man steals a car piece by piece.");

        assertNotNull(response);

    }
}
