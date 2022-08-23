package com.service;

import com.dao.LibrariesDAO;
import com.model.Libraries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LibrariesService {
    @Autowired
    LibrariesDAO librariesDAO;

    public List<Libraries> findAllLibraries() {
        return librariesDAO.findAll();
    }

    public Libraries getLibraryByID(Long libraryID){
        return librariesDAO.getByID(libraryID);
    }
}
