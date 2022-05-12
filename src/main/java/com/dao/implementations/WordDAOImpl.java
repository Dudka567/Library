package com.dao.implementations;

import com.dao.SessionUtil;
import com.dao.interfaces.WordDAO;
import com.model.Word;
import org.hibernate.SessionFactory;

import java.util.List;

public class WordDAOImpl extends SessionUtil implements WordDAO {
    public WordDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Word> findAll() {
        List<Word> words = currentSession().createQuery("from Word",Word.class).getResultList();
        return words;
    }
}
