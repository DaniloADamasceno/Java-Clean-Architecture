package com.danilo.school.application.applicationStudent.registerApplication;

import com.danilo.school.domain.student.CPF;
import com.danilo.school.domain.student.Email;
import com.danilo.school.domain.student.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterStudentDto {

    private  String nameDTO;
    private String cpfDTO;
    private String emailDTO;

    //! -----------------------------------------------   CONSTRUCTOR   ------------------------------------------------
    public RegisterStudentDto(String nameDTO, String cpfDTO, String emailDTO) {
        this.nameDTO = nameDTO;
        this.cpfDTO = cpfDTO;
        this.emailDTO = emailDTO;
    }


    //! -----------------------------------------------   METHODS   ----------------------------------------------------
    // --> Criar um aluno
    public Student creatStudent() {
        return new Student(nameDTO, new CPF(cpfDTO), new Email(emailDTO));

    }
}
