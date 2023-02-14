package com.CompanyName.ProjectName.app.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.CompanyName.ProjectName.app.model.controller.EmailSender;
import com.CompanyName.ProjectName.app.service.MailService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender sender;
	@Override
	public void mailSender(EmailSender e) {
		
		SimpleMailMessage masMessage=new SimpleMailMessage();
		masMessage.setFrom(e.getFormmail());
		masMessage.setTo(e.getTomail());
		masMessage.setSubject(e.getSubject());
		masMessage.setText(e.getMassage());
		
		sender.send(masMessage);
	}
	@Override
	public void EmailsendWithAttachement(EmailSender e) throws MessagingException {
		
		MimeMessage msg=sender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(msg,true);
		helper.setTo(e.getTomail());
		helper.setFrom(e.getFormmail());
		helper.setSubject(e.getMassage());
		helper.setText(e.getMassage());
		
		FileSystemResource file=new FileSystemResource("E:\\abc.pdf");
		helper.addAttachment(file.getFilename(), file);
		sender.send(msg);
		
	}

	
}
