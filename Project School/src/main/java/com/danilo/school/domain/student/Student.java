package com.danilo.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private CPF cpf;
    private Email email;
    private List<Phone> phoneStudent = new ArrayList<>();
    private String registration;
    private String password;


    //! -----------------------------------------------  CONSTRUCTORS  -------------------------------------------------
    public Student(String name, CPF cpf, Email email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    //! -----------------------------------------------   METHODS   ----------------------------------------------------
    public void addPhone(String ddd, String phoneNumber){
        this.phoneStudent.add(new Phone(ddd, phoneNumber));
    }

    //! -----------------------------------------------  GETTERS AND SETTERS  ------------------------------------------

    public String getName() {
        return name;
    }

    public CPF getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    public List<Phone> getPhoneStudent() {
        return phoneStudent;
    }
}
