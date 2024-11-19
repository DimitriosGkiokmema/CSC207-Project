package interface_adapter.search;

import interface_adapter.ViewModel;

/**
* The view model for the Search use case.
 */
public class SearchViewModel extends ViewModel<SearchState> {

    public SearchViewModel() {
        super("search");
        setState(new SearchState());
    }
}
