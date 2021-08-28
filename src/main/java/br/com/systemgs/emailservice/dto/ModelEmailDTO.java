package br.com.systemgs.emailservice.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class ModelEmailDTO {

    @NotBlank(message = "OwnerRef must be informed!")
    private String ownerRef;

    @Email(message = "Invalid Email!")
    @NotBlank(message = "EmailFrom must be informed!")
    private String emailFrom;

    @Email(message = "Invalid Email!")
    @NotBlank(message = "EmailTo must be informed!")
    private String emailTo;

    @NotBlank(message = "Subject must be informed!")
    private String subject;

    @NotBlank(message = "Text must be informed!")
    private String text;

}
