package com.danilo.school.infrastructure.student;

import com.danilo.school.domain.student.*;
import com.danilo.school.domain.student.Exceptions.StudentNotFound;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryStudentJDBC implements RepositoryStudent {

    private final Connection connection;


    //! -----------------------------------------------  CONSTRUCTORS  -------------------------------------------------
    public RepositoryStudentJDBC(Connection connection) {
        this.connection = connection;
    }


    //! -----------------------------------------------   METHODS   ----------------------------------------------------

    @Override
    public void register(Student student) {

        String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
        try {
            // --> Inserir o Aluno
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getCpf().getNumber());
            preparedStatement.setString(3, student.getEmail().getAddress());
            preparedStatement.execute();

            // --> Inserir os Telefones
            sql = "INSERT INTO PHONE VALUES(?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            for (Phone phone : student.getPhoneStudent()) {
                preparedStatement.setString(1, phone.getDdd());
                preparedStatement.setString(2, phone.getPhoneNumber());
                preparedStatement.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // --> BUSCAR POR CPF

    @Override
    public Student findByCPF(CPF cpf) {

        try {
            String sql = "SELECT * FROM STUDENT WHERE cpf = ?";
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf.getNumber());

            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new StudentNotFound(cpf);
            }

            // --> Buscar o Aluno
            String name = resultSet.getString("name");
            Email email = new Email(resultSet.getString("email"));
            Student foundStudent = new Student(name, cpf, email);

            // --> Buscar os Telefones
            sql = "SELECT * FROM PHONE WHERE student_cpf = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf.getNumber());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ddd = resultSet.getString("ddd");
                String phoneNumber = resultSet.getString("phone_number");
                foundStudent.addPhone(ddd, phoneNumber);
            }
            return foundStudent;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // --> LISTAR TODOS OS ALUNOS

    @Override
    public List<Student> listAllStudents() {

        try {
            String sql = "SELECT * FROM STUDENT";
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSetListAll;
            resultSetListAll = preparedStatement.executeQuery();
            List<Student> studentsList = new ArrayList<>();

            while (resultSetListAll.next()) {
                String name = resultSetListAll.getString("name");
                CPF cpf = new CPF(resultSetListAll.getString("cpf"));
                Email email = new Email(resultSetListAll.getString("email"));
                Student student = new Student(name, cpf, email);

                long id = resultSetListAll.getLong("id");
                sql = "SELECT * FROM PHONE WHERE student_cpf = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);

                ResultSet resultSetPhone;
                resultSetPhone = preparedStatement.executeQuery();
                while (resultSetPhone.next()) {
                    String ddd = resultSetPhone.getString("ddd");
                    String phoneNumber = resultSetPhone.getString("phone_number");
                    student.addPhone(ddd, phoneNumber);
                }
                studentsList.add(student);
            }
            return studentsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


