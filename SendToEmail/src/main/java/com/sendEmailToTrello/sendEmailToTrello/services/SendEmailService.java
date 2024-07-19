package com.sendEmailToTrello.sendEmailToTrello.services;


import com.sendEmailToTrello.sendEmailToTrello.dto.EmailSendDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @KafkaListener(topics = "pdv-estudos", groupId = "pdv-estudos")
    public void processarVenda(String mensagemKafka) {
        System.out.println("Venda recebida: " + mensagemKafka);
        EmailSendDTO emailData = new EmailSendDTO("danielmenezesdev2512@gmail.com", "Pedido Realizado", mensagemKafka);
        sendEmail(emailData);
    }


    @KafkaListener(topics = "pdv-estudos", groupId = "pdv-estudos")
    public void sendEmail(EmailSendDTO data) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(data.destinatario());
            helper.setSubject(data.assunto());
            helper.setText(data.conteudo());
            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }




}
