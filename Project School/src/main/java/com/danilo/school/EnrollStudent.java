package com.danilo.school;

import com.danilo.school.application.applicationStudent.registerApplication.RegisterStudentApplication;
import com.danilo.school.application.applicationStudent.registerApplication.RegisterStudentDto;
import com.danilo.school.infrastructure.student.RepositoryStudentMemory;

public class EnrollStudent {

    public static void main(String[] args) {

        String name = "Aluno TESTE";
        String cpf = "123.456.789-00";
        String email = "alunoTESTE@email.com";

        // --> Matricular um aluno
        RegisterStudentApplication registerStudent = new RegisterStudentApplication(new RepositoryStudentMemory());
        registerStudent.execute(new RegisterStudentDto(name, cpf, email));

    }
}
