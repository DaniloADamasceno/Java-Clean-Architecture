package com.danilo.school.domain.student;

public interface PasswordEncryption {

    String encrypt(String password);                                    // --> Criptografar a senha
    boolean validate(String password, String encryptedPassword);        // --> Validar a senha
}
