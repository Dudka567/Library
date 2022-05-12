package com.dao.implementations;

import com.dao.SessionUtil;
import com.dao.interfaces.RulesDAO;
import com.model.Libraries;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class RulesDAOImpl extends SessionUtil implements RulesDAO {
    public RulesDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<String> get(Long libraryID) {
        Libraries libraries = new LanguagesDAOImpl(sessionFactory).get(libraryID);
        List<String> rules = new ArrayList<>();
        rules.add(libraries.getSource_language().getRules().getPattern());
        rules.add(libraries.getTarget_language().getRules().getPattern());
        return rules;
    }
}
