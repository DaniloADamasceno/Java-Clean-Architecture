package com.danilo.school.infrastructure.student;

import com.danilo.school.domain.student.PasswordEncryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptionWithMD5 implements PasswordEncryption {

    //! -----------------------------------------------   METHODS   ----------------------------------------------------

    // --> Criptografar a senha
    @Override
    public String encrypt(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte aByte : bytes) {
                stringBuilder.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar a senha | Error encrypting password " + e.getMessage());
        }
    }

    // --> Validar a senha
    @Override
    public boolean validate(String password, String encryptedPassword) {
        return encryptedPassword.equals(encrypt(password));
    }
}
