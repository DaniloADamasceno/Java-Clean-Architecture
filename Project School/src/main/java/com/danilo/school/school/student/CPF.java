package com.danilo.school.school.student;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CPF {

    //! -------------------------------------------  GETTERS AND SETTERS -----------------------------------------------
    private String number;

    //! -----------------------------------------------  CONSTRUCTORS  -------------------------------------------------

    public CPF(String number) {
        if (number == null || !number.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$")) {
            throw new IllegalArgumentException("Formato do CPF e invalido | Invalid CPF format.");
        }
        this.number = number;
    }

}
