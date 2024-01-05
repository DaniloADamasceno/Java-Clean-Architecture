package com.danilo.school.domain.student;

import java.util.List;

public interface RepositoryStudent{

    void register(Student student);             // Matricular um aluno
    Student findByCPF(CPF cpf);                 // Buscar um aluno por CPF
    List<Student> listAllStudents();            // Listar todos os alunos matriculados


}
