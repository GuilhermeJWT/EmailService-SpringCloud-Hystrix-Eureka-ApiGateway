package br.com.systemgs.emailservice.service;

import br.com.systemgs.emailservice.model.ModelEmail;
import br.com.systemgs.emailservice.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public void sendEmail(ModelEmail modelEmail) {

    }
}
