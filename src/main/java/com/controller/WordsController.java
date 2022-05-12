package com.controller;

import com.dao.interfaces.WordsDAO;
import com.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/work")
@Transactional
public class WordsController {
    private static final String NOT_PAIR = "Такой пары не существует";
    @Autowired
    private WordsDAO wordsDAO;

    @PostMapping("/delete-pair")
    public String deletePair(@RequestParam(value = "key") String key,
                             @RequestParam(name = "id") Long id, Model model) {
        wordsDAO.delete(key, id);
        model.addAttribute("id", id);
        return "commands-results/delete_pair";
    }

    @PostMapping(value = "/add-pair")
    public String addPair(@RequestParam(value = "key") String key,
                          @RequestParam(value = "value") String value,
                          @RequestParam(value = "id") Long id, Model model) {

        List<String> resultList = wordsDAO.add(key, value, id);
        if (resultList.isEmpty()) {
            resultList.add("Пара добавлена");
        }
        model.addAttribute("result", resultList);
        model.addAttribute("id", id);
        return "commands-results/add_pair";
    }

    @GetMapping("/read-pairs")
    public String readPairs(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("pairs", wordsDAO.findAllByLibraryID(id));
        return "commands-results/read_pairs";
    }

    @GetMapping("/search-pair")
    public String searchPair(@RequestParam(value = "key") String key,
                             @RequestParam(name = "id") Long id, Model model) {
        Word pair;
        String resultSearch;
        try {
            pair = wordsDAO.getValuePairs(key,id).getWord2();
            resultSearch = pair.getValue();
        } catch (NullPointerException e) {
            resultSearch = NOT_PAIR;
        }

        model.addAttribute("key", key);
        model.addAttribute("value", resultSearch);
        model.addAttribute("id", id);
        return "commands-results/search_pair";
    }
}
