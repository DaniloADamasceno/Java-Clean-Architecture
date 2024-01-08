package com.danilo.school.application.applicationStudent.registerApplication;

import com.danilo.school.domain.student.RepositoryStudent;
import com.danilo.school.domain.student.Student;

public class RegisterStudentApplication {

    private RepositoryStudent repositoryStudentApplication;


    //! -----------------------------------------------   CONSTRUCTOR   ------------------------------------------------
    public RegisterStudentApplication(RepositoryStudent repositoryStudentApplication) {
        this.repositoryStudentApplication = repositoryStudentApplication;
    }

    //! -----------------------------------------------   METHODS   ----------------------------------------------------

    // --> Registrar um aluno
    public void execute(RegisterStudentDto registerStudentDto) {

        Student newStudent = registerStudentDto.creatStudent();
        repositoryStudentApplication.register(newStudent);


    }
}
