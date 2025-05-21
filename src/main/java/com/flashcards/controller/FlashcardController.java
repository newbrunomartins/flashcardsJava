package com.flashcards.controller;

import com.flashcards.model.Flashcard;
import com.flashcards.repository.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController //define como controlador REST
@RequestMapping("/api/flashcards") // url base da API

public class FlashcardController {
    
    @Autowired
    private FlashcardRepository repository;

    @PostMapping
    private Flashcard create(@RequestBody Flashcard flashcard){
        return repository.save(flashcard); // injeta o repositório
    }

    @GetMapping
    public List<Flashcard> findAll(){
        return repository.findAll(); // lista todos os flashcards
    }

    @PutMapping("/{id}") // update dos dados
    public Flashcard update(@PathVariable Long id, @RequestBody Flashcard newFlashcard){
        return repository.findById(id).map(flashcard -> {
            flashcard.setQuestion(newFlashcard.getQuestion());
            flashcard.setAnswer(newFlashcard.getAnswer());

            return repository.save(flashcard);
        }).orElseThrow(() -> new RuntimeException("Flashcard not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }
}
