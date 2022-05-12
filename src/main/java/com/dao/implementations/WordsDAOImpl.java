package com.dao.implementations;

import com.controller.validators.LibraryValidator;
import com.controller.validators.ValidationResult;
import com.controller.validators.Validator;
import com.dao.SessionUtil;
import com.dao.interfaces.WordsDAO;
import com.model.Libraries;
import com.model.Word;
import com.model.Words;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class WordsDAOImpl extends SessionUtil implements WordsDAO {
    private static final Integer SOURCE_WORD_POSITION = 0;
    private static final Integer TARGET_WORD_POSITION = 1;
    private static final String ERROR_ADD_WORDS = " уже есть в словаре";

    public WordsDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void delete(String key, Long libraryID) {
        Session session = currentSession();
        Libraries library = new LanguagesDAOImpl(sessionFactory).get(libraryID);
        Words word = currentSession().createQuery("from Words where language1.id=:sourceLanguage and language2.id=:targetLanguage and word1.value=:key", Words.class)
                .setParameter("sourceLanguage", library.getSource_language().getId())
                .setParameter("targetLanguage", library.getTarget_language().getId())
                .setParameter("key", key)
                .getSingleResult();
        session.delete(word);
    }

    @Override
    public List<String> add(String firstWord, String secondWord, Long libraryID) {
        Session session = currentSession();
        Libraries library = new LanguagesDAOImpl(sessionFactory).get(libraryID);

        List<String> patterns = new RulesDAOImpl(sessionFactory).get(libraryID);
        String patternSourceWord = patterns.get(SOURCE_WORD_POSITION);
        String patternTargetWord = patterns.get(TARGET_WORD_POSITION);
        Validator pairValidator = new LibraryValidator(patternSourceWord, patternTargetWord);
        ValidationResult validationResult = pairValidator.validatePair(firstWord, secondWord);
        List<String> resultList = validationResult.getErrorsValidation();

        if (validationResult.isValid()) {
            Word word_source = new Word(firstWord);
            Word word_target = new Word(secondWord);
            Words words = new Words(library.getSource_language(), word_source, library.getTarget_language(), word_target);

            if (!checkingForUniqueness(firstWord, secondWord, resultList)) {
                session.save(words);
            }

        }
        return resultList;
    }

    @Override
    public List<Words> findAllByLibraryID(Long libraryID) {
        Libraries library = new LanguagesDAOImpl(sessionFactory).get(libraryID);
        return currentSession().createQuery("from Words where language1.id=:sourceLanguage and language2.id=:targetLanguage", Words.class)
                .setParameter("sourceLanguage", library.getSource_language().getId())
                .setParameter("targetLanguage", library.getTarget_language().getId())
                .getResultList();
    }

    @Override
    public Words getValuePairs(String key, Long libraryID) {
        Words value;
        Libraries library = new LanguagesDAOImpl(sessionFactory).get(libraryID);
        try {
            value = currentSession().createQuery("from Words where word1.value=:key " +
                            "and language1.name=:language", Words.class)
                    .setParameter("key", key)
                    .setParameter("language",library.getSource_language())
                    .getSingleResult();
        } catch (Exception e) {
            value = null;
        }
        return value;
    }

    protected boolean checkingForUniqueness(String firstWord, String secondWord, List<String> resultList) {
        List<Word> allWords = new WordDAOImpl(sessionFactory).findAll();
        boolean isHave = false;
        for (Word word : allWords) {
            String tableWorld = word.getValue();
            if (tableWorld.equals(firstWord) || tableWorld.equals(secondWord)) {
                isHave = true;
                resultList.add(tableWorld + ERROR_ADD_WORDS);
            }
        }
        return isHave;
    }


}
