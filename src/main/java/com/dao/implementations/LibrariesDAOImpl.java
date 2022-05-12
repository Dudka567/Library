package com.dao.implementations;

import com.dao.SessionUtil;
import com.dao.interfaces.LibrariesDAO;
import com.model.Libraries;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LibrariesDAOImpl extends SessionUtil implements LibrariesDAO {

    public LibrariesDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Libraries> findAll() {
        return currentSession().createQuery("from Libraries", Libraries.class).getResultList();
    }
}
