package com.danilo.school.domain.student;

import com.danilo.school.domain.student.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void shouldReturnExceptionWhenCPFIsNull() {  // Verificação de cenários de erro CPF

        assertThrows(IllegalArgumentException.class, () -> new CPF(null)); // Verificar CPF nulo
        assertThrows(IllegalArgumentException.class, () -> new CPF("")); // Verificar CPF vazio
        assertThrows(IllegalArgumentException.class, () -> new CPF("123456789")); // Verificar CPF com 9 dígitos
        assertThrows(IllegalArgumentException.class, () -> new CPF("123456789012")); // Verificar CPF com 12 dígitos
        assertThrows(IllegalArgumentException.class, () -> new CPF("12345678901")); // Verificar CPF com 11 dígitos
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890")); // Verificar CPF com 10 dígitos
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890a")); // Verificar CPF com 10 dígitos e 1 letra
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890a1")); // Verificar CPF com 10 dígitos e 2 letras
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890a12")); // Verificar CPF com 10 dígitos e 3 letras
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890a123")); // Verificar CPF com 10 dígitos e 4 letras
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890a1234")); // Verificar CPF com 10 dígitos e 5 letras
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890a12345")); // Verificar CPF com 10 dígitos e 6 letras
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890a123456")); // Verificar CPF com 10 dígitos e 7 letras
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890a1234567")); // Verificar CPF com 10 dígitos e 8 letras
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890a12345678")); // Verificar CPF com 10 dígitos e 9 letras

    }
}