package com.surveypro.member.service;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.MemberDAO;
import com.surveypro.member.exception.MemberEmailEmptyException;
import com.surveypro.member.exception.MemberPassUpdateException;

public class SendTempPassService implements IMemberService {

	public MemberDAO dao;

	public SendTempPassService() {
		dao = (MemberDAO) DAOManager.getDAO(MemberDAO.KEY);
	}

	public static void sendEmail(String email, String pass) {
		final String bodyEncoding = "UTF-8";
		String subject = "Temporary Password Email";
		String fromEmail = "vc.system.noreply@gmail.com";
		String fromUsername = "VC SYSTEM MANAGER";
		String toEmail = email;

		final String username = "vc.system.noreply";
		final String password = "xjaitzlgbrodjvth";

		StringBuffer sendBuffer = new StringBuffer();
		sendBuffer.append("<h3>안녕하세요</h3>\n");
		sendBuffer.append("<h4>다음은 발급해드린 임시 비밀번호입니다.</h4>\n");
		sendBuffer.append("<h1>").append(pass).append("</h1>\n");
		sendBuffer.append("<h4>위 임시 비밀번호로 로그인 후 비밀번호를 변경해주시길 바랍니다.</h4>");
		String html = sendBuffer.toString();

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.quitwait", "false");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		try {
			Authenticator auth = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			};

			Session session = Session.getInstance(props, auth);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail, fromUsername));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail, false));
			message.setSubject(subject);
			message.setSentDate(new Date());

			Multipart mParts = new MimeMultipart();
			MimeBodyPart mTextPart = new MimeBodyPart();
			// MimeBodyPart mFilePart = null;

			mTextPart.setText(html, bodyEncoding, "html");
			mParts.addBodyPart(mTextPart);

			message.setContent(mParts);

			MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
			MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
			MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
			MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
			MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
			MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");

			CommandMap.setDefaultCommandMap(MailcapCmdMap);

			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String email = (String) request.getParameter("email");
		StringBuffer passBuilder = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			int rIndex = random.nextInt(3);
			switch (rIndex) {
			case 0:
				passBuilder.append((char) ((int) (random.nextInt(26)) + 97));
				break;
			case 1:
				passBuilder.append((char) ((int) (random.nextInt(26)) + 65));
				break;
			case 2:
				passBuilder.append(random.nextInt(10));
				break;
			}
		}
		if (email == null || email.trim().equals("")) {
			throw new MemberEmailEmptyException();
		}

		String pass = passBuilder.toString().substring(0, 6);

		System.out.println("이메일을 전송합니다!");
		sendEmail(email, pass);

		synchronized (dao) {
			if (dao.updatePassword(email, pass)) {
				request.setAttribute("passUpdateResult", true);
			} else {
				throw new MemberPassUpdateException();
			}
		}
	}

}
