package com.ravi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {


	@Autowired
	private JavaMailSender mailSender;

	public String sendEmial(EmailDetails details) {
		try {
			 SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
			mailSender.send(mailMessage);
			return "Mail Sent Successfully...";

		} catch (Exception ex) {
			return "Error while Sending Mail";
		}
	}
}
