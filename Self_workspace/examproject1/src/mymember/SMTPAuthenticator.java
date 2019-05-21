package mymember;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {
	protected PasswordAuthentication getPasswordAuthentication() {
		String id = "hbaymail";
		String pass = "smtptest123";
		return new PasswordAuthentication(id, pass);
	}
}
