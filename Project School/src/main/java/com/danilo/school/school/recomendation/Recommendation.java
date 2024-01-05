package com.danilo.school.school.recomendation;

import com.danilo.school.school.student.Student;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Recommendation {

    private Student indicated; // Quem indicou
    private Student indicatedBy; // Quem foi indicado
    private LocalDateTime dateNomination; // Data da indicação


    //! -----------------------------------------------  CONSTRUCTORS  -------------------------------------------------
    public Recommendation(Student indicated, Student indicatedBy, LocalDateTime dateNomination) {
        this.indicated = indicated;
        this.indicatedBy = indicatedBy;
        this.dateNomination = LocalDateTime.now(); // Pegar a Data e Hora atual do sistema
    }

}
