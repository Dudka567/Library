package com.dao;

import com.model.Libraries;
import com.model.Word;
import com.model.Words;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordsDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    public boolean delete(String key, Libraries library) {
        try {
            sessionFactory.getCurrentSession().delete(getValuePairs(key, library));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void add(String firstWord, String secondWord, Libraries library) {
        Word word_source = new Word(firstWord);
        Word word_target = new Word(secondWord);
        Words pair = new Words(library.getSource_language(), word_source, library.getTarget_language(), word_target);
        sessionFactory.getCurrentSession().save(pair);
    }

    public List<Words> findAllByLibrary(Libraries library) {
        return sessionFactory.getCurrentSession().createQuery("from Words words join fetch words.language1 " +
                        "join fetch words.language2 join fetch words.word1 join fetch words.word2 " +
                        "where words.language1.id=:sourceLanguage and words.language2.id=:targetLanguage", Words.class)
                .setParameter("sourceLanguage", library.getSource_language().getId())
                .setParameter("targetLanguage", library.getTarget_language().getId())
                .getResultList();
    }

    public Words getValuePairs(String key, Libraries library) {
        return sessionFactory.getCurrentSession().createQuery("from Words words join fetch words.language1 " +
                        "join fetch words.language2 join fetch words.word1 join fetch words.word2 " +
                        "where words.language1.id=:sourceLanguage and words.language2.id=:targetLanguage and words.word1.value=:key", Words.class)
                .setParameter("sourceLanguage", library.getSource_language().getId())
                .setParameter("targetLanguage", library.getTarget_language().getId())
                .setParameter("key", key)
                .getSingleResult();
    }

}
