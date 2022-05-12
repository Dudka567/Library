package com.dao.interfaces;

import com.model.Word;

import java.util.List;

public interface WordDAO {
    List<Word> findAll();
}
