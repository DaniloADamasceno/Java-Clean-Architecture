package com.danilo.school.infrastructure.student;

import com.danilo.school.domain.student.CPF;
import com.danilo.school.domain.student.Exceptions.StudentNotFound;
import com.danilo.school.domain.student.RepositoryStudent;
import com.danilo.school.domain.student.Student;

import java.util.ArrayList;
import java.util.List;

public class RepositoryStudentMemory implements RepositoryStudent {

    private final List<Student> enrolledStudents = new ArrayList<>();

    //! -----------------------------------------------   METHODS   ----------------------------------------------------

    //   --> REGISTRAR ALUNO
    @Override
    public void register(Student student) {
        this.enrolledStudents.add(student);

    }

    //   --> BUSCAR POR CPF
    @Override
    public Student findByCPF(CPF cpf) {
        return this.enrolledStudents.stream()
                .filter(studentFilter -> studentFilter.getCpf().equals(cpf.getNumber()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFound(cpf));
    }

    //   --> LISTAR TODOS OS ALUNOS
    @Override
    public List<Student> listAllStudents() {
        return this.enrolledStudents;
    }
}
