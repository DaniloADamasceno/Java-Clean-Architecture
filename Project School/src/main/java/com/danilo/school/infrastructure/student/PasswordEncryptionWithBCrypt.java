package com.danilo.school.infrastructure.student;

import com.danilo.school.domain.student.PasswordEncryption;

public class PasswordEncryptionWithBCrypt implements PasswordEncryption {

    //! -----------------------------------------------   METHODS   ----------------------------------------------------



    // --> Criptografar a senha
    @Override
    public String encrypt(String password) {
        return null;
    }

    // --> Validar a senha
    @Override
    public boolean validate(String password, String encryptedPassword) {
        return encryptedPassword.equals(encrypt(password));
    }
}
