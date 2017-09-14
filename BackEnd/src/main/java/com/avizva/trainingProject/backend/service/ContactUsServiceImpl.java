package com.avizva.trainingProject.backend.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.avizva.trainingProject.backend.dao.ContactUsDAO;
import com.avizva.trainingProject.backend.model.ContactUs;

@Service
public class ContactUsServiceImpl implements ContactUsService {
	
	@Autowired
	private ContactUsDAO contactUsDAO;
	
	private static final Logger LOGGER = Logger.getLogger(ContactUsServiceImpl.class);

	@Autowired
	private MailSender mailSender;
	
	public boolean contactUs(ContactUs contactUs){
		boolean flag=false;
		if(contactUsDAO.contactus(contactUs)){
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("Admin@GAMAZON");
			message.setTo(contactUs.getEmail());
			message.setSubject("Thank You for Contacting Us");
			message.setText("Hi " + contactUs.getName() + "!, Thank you for your time. We will get back to you as soon as possible. ");
			mailSender.send(message);
			
			LOGGER.info("<--- Mail Send for Contacting --->");
			flag=true;
		}
		LOGGER.error("<-- Mail Connot be sent Error --> ");
		return flag;
	}
	
	
	
}
