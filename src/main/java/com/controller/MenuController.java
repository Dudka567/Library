package com.controller;

import com.dao.interfaces.LibrariesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/work")
public class MenuController {
    @Autowired
    private LibrariesDAO menuDAO;

    @GetMapping("/add-pair-menu")
    public String menuAddPair(@RequestParam(name = "id") Long id, Model model){
        model.addAttribute("id", id);
        return "menu/menu_add_pair";
    }

    @GetMapping("/delete-pair-menu")
    public String menuDeletePair(@RequestParam(name = "id") Long id, Model model){
        model.addAttribute("id", id);
        return "menu/menu_delete_pair";
    }

    @GetMapping("/search-pair-menu")
    public String menuSearchPair(@RequestParam(name = "id") Long id, Model model){
        model.addAttribute("id", id);
        return "menu/menu_search_pair";
    }

    @GetMapping("/start")
    public String menuLibraries(Model model) {
        model.addAttribute("libs", menuDAO.findAll());
        return "menu/menu_libraries";
    }

    @GetMapping("/work-lib-menu")
    public String workWithLibrary(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("id", id);
        return "menu/menu_library";
    }

}
