package data_access;

import use_case.search.SearchLanguageModelDataAccessInterface;

public class SearchTestDataAccessObject implements SearchLanguageModelDataAccessInterface {

    public SearchTestDataAccessObject(){}

    @Override
    public String query(String prompt) {
        return "One Piece at a Time by Johnny Cash";
    }
}
