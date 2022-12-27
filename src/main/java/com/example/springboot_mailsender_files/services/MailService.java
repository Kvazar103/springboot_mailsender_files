package com.example.springboot_mailsender_files.services;

import com.example.springboot_mailsender_files.models.Customer;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender javaMailSender;

    public void send(Customer customer){

        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setTo(customer.getEmail());
//            mimeMessageHelper.setText("mailsender");
            mimeMessageHelper.setText("<a href='http://localhost:8080/customers/activate/"+customer.getId()+"'>click to activate</a>",true);
            mimeMessageHelper.setReplyTo("m");
            mimeMessageHelper.setSubject("subject");
            mimeMessageHelper.setFrom(new InternetAddress("nazar.voinarovych250@gmail.com"));
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        javaMailSender.send(mimeMessage);
    }
}
