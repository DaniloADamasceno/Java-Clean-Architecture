package com.danilo.school.domain.student;

public class Email {

    private String address;


    //! -----------------------------------------------  CONSTRUCTORS  -------------------------------------------------

    public Email(String address) {
        if (address == null || !address.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Formato do e-mail e invalido | Invalid e-mail address format.");
        }
        this.address = address;
    }

    //! -------------------------------------------  GETTERS AND SETTERS -----------------------------------------------
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
