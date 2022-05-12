package com.dao.interfaces;

import com.model.Words;

import java.util.List;

public interface WordsDAO {
    void delete(String key, Long libraryID);

    List<String> add(String firstWord, String secondWord, Long libraryID);

    List<Words> findAllByLibraryID(Long libraryID);

    Words getValuePairs(String key, Long libraryID);
}
