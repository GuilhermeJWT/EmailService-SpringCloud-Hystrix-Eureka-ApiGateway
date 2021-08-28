package br.com.systemgs.emailservice.controller;

import br.com.systemgs.emailservice.dto.ModelEmailDTO;
import br.com.systemgs.emailservice.model.ModelEmail;
import br.com.systemgs.emailservice.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<ModelEmail> sendEmail(@RequestBody @Valid ModelEmailDTO modelEmailDTO){
      ModelEmail modelEmail = new ModelEmail();
      BeanUtils.copyProperties(modelEmailDTO, modelEmail);
      emailService.sendEmail(modelEmail);

      return new ResponseEntity<>(modelEmail, HttpStatus.CREATED);
    }

}
