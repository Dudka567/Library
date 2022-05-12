package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionUtil {
    protected SessionFactory sessionFactory;

    public SessionUtil(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

}
