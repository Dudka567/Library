package com.service;

import com.dao.LanguagesDAO;
import com.model.Languages;
import com.model.Rules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LanguagesService {
    @Autowired
    LanguagesDAO languagesDAO;

    public Languages getLanguageByName(String nameLanguage) {
        return languagesDAO.getByName(nameLanguage);
    }

    public Rules getRulesByLanguageName(String nameLanguage){
        return languagesDAO.getRulesByLanguageName(nameLanguage);
    }
}
