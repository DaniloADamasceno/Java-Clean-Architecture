package com.danilo.school.domain.student.Exceptions;

import com.danilo.school.domain.student.CPF;

public class StudentNotFound extends  RuntimeException{

    private static final long serialVersionUID = 1L;

    public StudentNotFound(CPF cpf) {
        super("Aluno não encontrado | Student not found: " + cpf.getNumber());
    }
}
