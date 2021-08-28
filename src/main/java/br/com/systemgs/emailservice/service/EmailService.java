package br.com.systemgs.emailservice.service;

import br.com.systemgs.emailservice.enums.StatusEmail;
import br.com.systemgs.emailservice.model.ModelEmail;
import br.com.systemgs.emailservice.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public ModelEmail sendEmail(ModelEmail modelEmail) {
       modelEmail.setSendDateEmail(LocalDateTime.now());

       try{
           SimpleMailMessage message = new SimpleMailMessage();
           message.setFrom(modelEmail.getEmailFrom());
           message.setTo(modelEmail.getEmailTo());
           message.setSubject(modelEmail.getSubject());
           message.setText(modelEmail.getText());

           javaMailSender.send(message);
            modelEmail.setStatusEmail(StatusEmail.SUCCESS);
       }catch(MailException exception){
           modelEmail.setStatusEmail(StatusEmail.ERROR);
           exception.printStackTrace();
       } finally {
           return emailRepository.save(modelEmail);
       }

    }
}
