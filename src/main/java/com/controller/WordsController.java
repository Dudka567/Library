package com.controller;

import com.dto.Pair;
import com.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/work")
public class WordsController {
    @Autowired
    private WordsService wordsService;

    @DeleteMapping(value = "/delete-pair/{id}/{key}")
    public ResponseEntity<?> deletePair(@PathVariable(name = "id") Long id,
                                        @PathVariable(name = "key") String key) {
        return new ResponseEntity<>(wordsService.deletePair(key, id),HttpStatus.OK);
    }

    @PostMapping(value = "/add-pair")
    public ResponseEntity<?> addPair(@RequestBody Pair pair) {
        return new ResponseEntity<>(wordsService.add(pair), HttpStatus.OK);
    }

    @GetMapping("/read-pairs/{id}")
    public ResponseEntity<?> readPairs(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(wordsService.findAllPairsByLibraryID(id), HttpStatus.OK);
    }

    @GetMapping("/search-pair/{id}/{key}")
    public ResponseEntity<?> searchPair(@PathVariable(name = "id") Long id,
                                        @PathVariable(name = "key") String key) {
        return new ResponseEntity<>(wordsService.getSearchPair(key, id), HttpStatus.OK);
    }
}
