package com.danilo.school.school;

public class CPF {

    private String number;

    //! -----------------------------------------------  CONSTRUCTORS  -------------------------------------------------

    public CPF(String number) {
        if (number == null || !number.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$")) {
            throw new IllegalArgumentException("Formato do CPF e invalido | Invalid CPF format.");
        }
        this.number = number;
    }

    //! -------------------------------------------  GETTERS AND SETTERS -----------------------------------------------
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
