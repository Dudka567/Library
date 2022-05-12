package com.dao.implementations;

import com.dao.SessionUtil;
import com.dao.interfaces.LanguagesDAO;
import com.model.Libraries;
import org.hibernate.SessionFactory;

public class LanguagesDAOImpl extends SessionUtil implements LanguagesDAO {
    public LanguagesDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Libraries get(Long libraryID) {
        Libraries library = currentSession().createQuery("from Libraries where id=:id", Libraries.class)
                .setParameter("id", libraryID)
                .getSingleResult();
        return library;
    }
}
