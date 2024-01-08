package com.danilo.school.application.applicationStudent;

import com.danilo.school.application.applicationStudent.registerApplication.RegisterStudentApplication;
import com.danilo.school.application.applicationStudent.registerApplication.RegisterStudentDto;
import com.danilo.school.domain.student.CPF;
import com.danilo.school.domain.student.Student;
import com.danilo.school.infrastructure.student.RepositoryStudentMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegisterStudentApplicationTest {

    // --> Registrar um aluno
    @Test
    void StudentRegistration() {
        RepositoryStudentMemory repositoryMemory = new RepositoryStudentMemory();
        RegisterStudentApplication registerStudentApplication = new RegisterStudentApplication(repositoryMemory);

        RegisterStudentDto registerStudentDto = new RegisterStudentDto("Aluno TESTE", "123.456.789-00", "AlunoTeste@email.com");
        registerStudentApplication.execute(registerStudentDto);


        Student foundStudentTest = repositoryMemory.findByCPF(new CPF("123.456.789-00"));

        assertEquals("Aluno TESTE", foundStudentTest.getName());
        assertEquals("123.456.789-00", foundStudentTest.getCpf());
        assertEquals("AlunoTeste@email.com", foundStudentTest.getEmail());


    }
}