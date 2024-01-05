package com.danilo.school.school.student;

public class StudentFactory {

    private Student student;

    //! -----------------------------------------------  METHODS  ------------------------------------------------------
    //Criar Estudante com Nome, CPF e Email
    public StudentFactory StudentFactoryWithNameCPFEmail(String name, String cpf, String email){
        this.student = new Student(name, new CPF(cpf), new Email(email));
        return this;
    }

    //Adicionar telefone ao Estudante
    public StudentFactory withPhone(String ddd, String phoneNumber){
        this.student.addPhone(ddd, phoneNumber);
        return this;
    }

    //Retornar Estudante
    public Student build(){
        return this.student;
    }
}
