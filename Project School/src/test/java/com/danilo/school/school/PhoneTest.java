package com.danilo.school.school;

import com.danilo.school.school.student.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void shouldReturnExceptionWhenDDDIsNull() {  // Verificação de cenários de erro DDD

        assertThrows(IllegalArgumentException.class, () -> new Phone(null, "123456789")); // Verificar DDD nulo
        assertThrows(IllegalArgumentException.class, () -> new Phone("", "12345678")); // Verificar DDD vazio
        assertThrows(IllegalArgumentException.class, () -> new Phone("1", "12345678")); // Verificar DDD com 1 digito
        assertThrows(IllegalArgumentException.class, () -> new Phone("123", "12345678")); // Verificar DDD com 3 dígitos


    }

    @Test
    void shouldReturnExceptionWhenPhoneIsInvalid() {  // Verificação de cenários de erro Telefone

        String ddd = "11";
        String phoneNumber = "123456789";

        Phone phoneTestClass = new Phone(ddd, phoneNumber);
        assertEquals(ddd, phoneTestClass.getDdd());
        assertEquals(phoneNumber, phoneTestClass.getPhoneNumber());



    }

}