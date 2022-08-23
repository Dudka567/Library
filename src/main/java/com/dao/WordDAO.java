package com.dao;

import com.model.Word;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    public List<Word> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Word",Word.class).getResultList();
    }
}
