package com.flashcards.repository;

import com.flashcards.model.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long>{
    //Não é necessário implementar nada, o Spring cuidará de tudo.
}
