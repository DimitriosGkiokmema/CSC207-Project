package interface_adapter.keyword;

import interface_adapter.ViewModel;
import interface_adapter.search.SearchState;

import java.util.List;
/**
* The view model for the Search use case.
*/
public class KeywordViewModel extends ViewModel<KeywordState> {

    public KeywordViewModel() {
        super("keyword");
        setState(new KeywordState());
    }

}