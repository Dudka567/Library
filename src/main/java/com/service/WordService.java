package com.service;

import com.dao.WordDAO;
import com.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WordService {
    @Autowired
    WordDAO wordDAO;

    public List<Word> findAllWord() {
        return wordDAO.findAll();
    }
}
