package com.lambda.controllers;

import com.lambda.model.EmailTemplate;
import com.lambda.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailTemplate emailTemplate) {
        emailService.sendEmail("mouranatan933@gmail.com", "detalhes", emailService.populateTemplate(emailTemplate));
        return "email enviador";
    }
}
