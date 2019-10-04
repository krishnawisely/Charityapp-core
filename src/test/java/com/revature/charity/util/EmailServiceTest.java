package com.revature.charity.util;

import org.junit.Test;

public class EmailServiceTest {
	@Test
	public void mailTest()
	{
		  String host = "smtp.gmail.com";
	         String username = "krishna192168@gmail.com";
	         String password = "tcadazgqjllzkmba";
	         String fromAddress = "krishna192168@gmail.com";
	         String toAddress = "jayakrishnakrish1998@gmail.com";
	         String subject = "Password Verification";
	         String text = "Activate Account</br><a href=\"http://13.232.142.59:8080/Charityapp-frontend/\">Click here</a>";
	         MailServiceUtil.sendMailUsingTLS(host, username, password,
	         fromAddress, toAddress, subject, text);
	         MailServiceUtil.sendMailUsingSSL(host, username, password, fromAddress, toAddress,
	        subject, text);
	}
}
