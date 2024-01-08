package com.danilo.school.application.recommendationApplication;

import com.danilo.school.domain.student.Student;

public interface SendReferralEmail {

    // --> Enviar email de indicação
    void SendEmail(Student nominatedStudent);


}
