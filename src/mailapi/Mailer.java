package mailapi;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import database.StudentDBHelper;
import database.TeacherDBHelper;

import java.util.ArrayList;

public class Mailer {
	public final static String from = "INSERT ADMIN MAIL ID HERE";
	public final static String password = "INSERT PASSWORD HERE";

	public static ArrayList<String> getToAddresses(String query) {
		if (query.equals("To all Students")) {
			return StudentDBHelper.allStudentEmails();
		} else if (query.equals("To all Teachers")) {
			return TeacherDBHelper.allTeacherEmails();
		}
		ArrayList<String> fin = StudentDBHelper.allStudentEmails();
		fin.addAll(TeacherDBHelper.allTeacherEmails());
		return fin;

	}

	private static Session getSession() {
		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		return session;
	}

	public static void send(String to, String sub, String msg) {
		Session session = getSession();
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setSubject(sub);
			message.setText(msg);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			System.out.println("Message sent Successfully");
		} catch (MessagingException e) {
			System.out.println("Message not sent");
		}

	}

	public static void send(ArrayList<String> to, String sub, String msg) {
		Session session = getSession();
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setSubject(sub);
			message.setText(msg);
			for (String sendID : to) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendID));
			}
			Transport.send(message);

			System.out.println("Message sent Successfully");
		} catch (MessagingException e) {
			System.out.println("Message not sent");
		}

	}

	public static void main(String[] args) {
		// from,password,to,subject,message
		// Mailer.send(new String[] { "19eucs117@skcet.ac.in", }, "This is the subject",
		// "This is a test body text message, just raw text");
		// change from, password and to
	}
}