package com.dao;

import com.model.Languages;
import com.model.Rules;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LanguagesDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    public Languages getByName(String nameLanguage) {
        return sessionFactory.getCurrentSession().createQuery("from Languages where name=:nameLanguage", Languages.class)
                .setParameter("nameLanguage", nameLanguage)
                .getSingleResult();
    }

    public Rules getRulesByLanguageName(String nameLanguage){
        return sessionFactory.getCurrentSession().createQuery(" from Languages language join fetch language.rules " +
                        "where language.name=:nameLanguage", Languages.class)
                .setParameter("nameLanguage", nameLanguage)
                .getSingleResult()
                .getRules();
    }
}
