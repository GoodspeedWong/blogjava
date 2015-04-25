package controllers;

import org.apache.commons.mail.EmailAttachment;

import models.TCfgUser;
import play.Play;
import play.mvc.Mailer;

public class Mail extends Mailer {

	public static void welcome(TCfgUser user){
		setSubject("欢迎使用XXX, %s", user.displayName);
		addRecipient(user.email);
		setFrom("humin@lexiang12.com");
		EmailAttachment attachment = new EmailAttachment();
		attachment.setDescription("123455");
		attachment.setPath(Play.getFile("conf/application.conf").getPath());
		addAttachment(attachment);
		send(user);
	}
}
