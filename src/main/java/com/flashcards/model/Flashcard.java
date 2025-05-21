package com.flashcards.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


@Entity // Mapeia como tabela no banco de dados H2
@Data   // Lombok: cria automaticamente getters, setters, etc.

public class Flashcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera ID automático
    
    private Long id; //identificador unico do flashcard
    private String question; // pergunta do flashcard
    private String answer; // resposta do flashcard

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date(); // data de criação automatica
}
