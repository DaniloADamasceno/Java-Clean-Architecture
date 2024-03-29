package com.danilo.school.domain.student;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Phone {

    private String ddd;
    private String phoneNumber;


    //! -----------------------------------------------  CONSTRUCTORS  -------------------------------------------------

    public Phone(String ddd, String phoneNumber) {

        // --> Verificar se os números não são nulos
        if (ddd == null || phoneNumber == null) {
            throw new IllegalArgumentException("Numero de telefone invalido | Invalid phone number.");
        }

        // --> Verificar se o numero de telefone tem 8 ou 9 dígitos
        if (ddd.length() != 2 || phoneNumber.length() > 9 || phoneNumber.length() < 8) {
            throw new IllegalArgumentException("Numero de telefone invalido | Invalid phone number.");
        }

        // --> Verificar se o DDD e valido
        if (!ddd.matches("\\d{2}")) {
            throw new IllegalArgumentException("DDD invalido | Invalid DDD.");
        }

        // --> Verificar se o formato do DDD e valido
        if (!ddd.matches("^[0-9]{2}$")) {
            throw new IllegalArgumentException("Formato do DDD invalido | Invalid DDD format.");
        }

        this.ddd = ddd;
        this.phoneNumber = phoneNumber;
    }

}
