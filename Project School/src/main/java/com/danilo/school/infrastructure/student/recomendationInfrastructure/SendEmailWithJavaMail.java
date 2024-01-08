package com.danilo.school.infrastructure.student.recomendationInfrastructure;

import com.danilo.school.application.recommendationApplication.SendReferralEmail;
import com.danilo.school.domain.student.Student;
import javax.mail.Session;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailWithJavaMail implements SendReferralEmail {

    //! -----------------------------------------------   METHODS   ----------------------------------------------------
    @Override
    public void SendEmail(Student nominatedStudent) {


        // Configurações do servidor de e-mail
        Properties properties = new Properties();
        String host = "smtp.gmail.com";                             // --> Servidor de Email
        String port = "587";                                        // --> Porta do Servidor de Email
        final String usernameEmployee = "seu_email@seudomínio.com";         // --> Seu Email do Funcionário    
        final String passwordEmployee = "sua_senha";                        // --> Sua Senha do Funcionário

        // Configurações do remetente e destinatário
        String send = "seu_email@seudomínio.com";
        String destinatario = "destinatario@email.com";

        // --> Configuração do Remetente e Destinatário
        String senderName = nominatedStudent.getName();
        String senderEmail = nominatedStudent.getEmail().getAddress();

        String recipientName = nominatedStudent.getName();
        String recipientEmail = nominatedStudent.getEmail().getAddress();

        // --> Configuração do Assunto e Corpo do Email
        String subject = "SoftWay School -- Indication of | Indicação de " + nominatedStudent.getName();
        String body = "Hello | Olá, " + recipientName + "!\n\n" +
                senderName + " indicated you to study at SoftWay School | Indicou você para estudar na escola SoftWay.\n\n" +
                "To complete your registration, click on the link below: | Complete o seu cadastro acessando o link:\n\n" +
                "http://localhost:8080/student/registration?email=" + recipientEmail +
                "\n\n" + "Welcome to SoftWay School! | Bem-vindo à SoftWay School!";

        // Configurações adicionais, se necessário
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Cria uma sessão de e-mail autenticada
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usernameEmployee, passwordEmployee);
            }
        });
        
        try {
            // Cria uma mensagem MIME
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(subject);
            message.setText(body);

            // Envia a mensagem
            Transport.send(message);

            System.out.println("Email successfully sent. | E-mail enviado com sucesso.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
