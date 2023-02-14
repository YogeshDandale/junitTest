package com.CompanyName.ProjectName.app.service;

import javax.mail.MessagingException;

import com.CompanyName.ProjectName.app.model.controller.EmailSender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface MailService {

	public void mailSender(EmailSender e);

	public void EmailsendWithAttachement(EmailSender e) throws MessagingException;
}
