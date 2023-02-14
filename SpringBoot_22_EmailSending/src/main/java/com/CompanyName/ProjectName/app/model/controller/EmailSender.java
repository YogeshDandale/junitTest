package com.CompanyName.ProjectName.app.model.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSender {

	private String formmail;
	private String tomail;
	private String subject;
	private String massage;
}
