package com.danilo.school.school;

import com.danilo.school.school.student.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldntCreateEmailsWithInvalidAddresses() { // Não deve criar emails com endereços inválidos
        assertThrows(IllegalArgumentException.class, () -> new Email(null)); // se eu passar null, deve lançar uma exceção
        assertThrows(IllegalArgumentException.class, () -> new Email("")); // se eu passar uma string vazia, deve lançar uma exceção
        assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido")); // se eu passar um email inválido, deve lançar uma exceção
        assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido@")); // se eu passar um email inválido, deve lançar uma exceção
        assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido.com")); // se eu passar um email inválido, deve lançar uma exceção

    }


}