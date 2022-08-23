package com.dao;

import com.model.Libraries;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibrariesDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    public List<Libraries> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Libraries libraries join fetch libraries.source_language" +
                " join fetch libraries.target_language", Libraries.class).getResultList();
    }

    public Libraries getByID(Long libraryID) {
        return sessionFactory.getCurrentSession().createQuery("from Libraries libraries join fetch libraries.source_language" +
                        " join fetch libraries.target_language join fetch libraries.target_language.rules " +
                        "join fetch libraries.source_language.rules where libraries.id=:libraryID", Libraries.class)
                .setParameter("libraryID", libraryID)
                .getSingleResult();
    }
}
