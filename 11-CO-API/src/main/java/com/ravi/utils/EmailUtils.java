package com.ravi.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmial(String to, String subject, String body, File file) {
		boolean status = false;
		try {
			// used to send email with attachment and formated text.
			MimeMessage message = mailSender.createMimeMessage();

			// used to set details for message object.
			MimeMessageHelper helper = new MimeMessageHelper(message,true);

			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.addAttachment(file.getName(), file);
			mailSender.send(message);
			status = true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
}
