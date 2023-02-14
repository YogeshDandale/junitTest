package com.CompanyName.ProjectName.app.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CompanyName.ProjectName.app.model.controller.EmailSender;
import com.CompanyName.ProjectName.app.service.MailService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmailController {
	@Autowired
	MailService se;
	
	@Value("${spring.mail.username}") // properties file 
	private String  formmail;
	
	@PostMapping(value = "/sendd")
	public String sendmail(@RequestBody EmailSender e) {
		e.setFormmail(formmail); 
		System.out.println(e.getFormmail());
		System.out.println(e.getTomail());
		System.out.println(e.getSubject());
		System.out.println(e.getMassage());
			try {
				se.mailSender(e);
			} catch (Exception e2) {
				e2.printStackTrace();
				return "Mail can not send";
			}
		return "Mail Send SuccessFully";
	}
	@RequestMapping(value = "/sendwithfile",method =RequestMethod.POST )
	public String EmailsendWithAttachement(@RequestBody EmailSender e) throws MessagingException {
		e.setFormmail(formmail);
		System.out.println(e.getTomail());
		System.out.println(e.getSubject());
		System.out.println(e.getMassage());
		try {
			se.EmailsendWithAttachement(e);
		} catch (Exception e2) {
			return "not send";
		}
		return "send successfulls";
		
	}
}
