package com.service;

import com.dao.LibrariesDAO;
import com.dao.WordDAO;
import com.dao.WordsDAO;
import com.dto.Pair;
import com.model.Libraries;
import com.model.Word;
import com.model.Words;
import com.validators.LibraryValidator;
import com.validators.ValidationResult;
import com.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WordsService {
    private static final String ERROR_ADD_WORDS = " уже есть в словаре\n";
    @Autowired
    WordsDAO wordsDAO;
    @Autowired
    LibrariesDAO librariesDAO;
    @Autowired
    WordDAO wordDAO;

    public boolean deletePair(String key, Long libraryID) {
        return wordsDAO.delete(key, librariesDAO.getByID(libraryID));
    }

    public Words getSearchPair(String key, Long libraryID) {
        return wordsDAO.getValuePairs(key, librariesDAO.getByID(libraryID));
    }

    public List<Words> findAllPairsByLibraryID(Long libraryID) {
        return wordsDAO.findAllByLibrary(librariesDAO.getByID(libraryID));
    }

    public List<String> add(Pair pair) {
        Libraries library = librariesDAO.getByID(pair.getId());
        String patternKey = library.getSource_language().getRules().getPattern();
        String patternValue = library.getTarget_language().getRules().getPattern();

        Validator pairValidator = new LibraryValidator(patternKey, patternValue);
        ValidationResult validationResult = pairValidator.validatePair(pair.getKey(), pair.getValue());
        List<String> resultList = validationResult.getErrorsValidation();

        if (validationResult.isValid()) {
            if (checkingForUniqueness(pair.getKey(), pair.getValue(), wordDAO.findAll()).isEmpty()) {
                wordsDAO.add(pair.getKey(), pair.getValue(), library);
            } else {
                resultList.add(ERROR_ADD_WORDS);
            }
        }
        return resultList;
    }

    protected List<String> checkingForUniqueness(String key, String value, List<Word> allWords) {
        List<String> resultValidation = new ArrayList<>();

        for (Word word : allWords) {
            String tableWorld = word.getValue();
            if (tableWorld.equals(key) || tableWorld.equals(value)) {
                resultValidation.add(tableWorld + ERROR_ADD_WORDS);
            }
        }
        return resultValidation;
    }
}
