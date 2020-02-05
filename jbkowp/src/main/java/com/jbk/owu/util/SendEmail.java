package com.jbk.owu.util;

import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
public class SendEmail {
	public static String project = PropertyManager.getInstance().getProject();
	public static String email = PropertyManager.getInstance().getEmail();
	public static void execute(String reportFileName) throws Exception
	{
		System.out.println(1111);
		String path=Reports.reportPath;

		String[] to={email};
		String[] cc={};
		
		SendEmail.sendMail("ingale.subhash@gmail.com", "varsha@1984", "smtp.gmail.com",
				"465", "true", "true", true, "javax.net.ssl.SSLSocketFactory", "false",
				to, cc, "Automation trigger mail for OWP","Please find attached "+reportFileName+" file for detailed status of "+project+" automation execution build status.",
				path, reportFileName);
	}
	public static boolean sendMail(String userName,
			String passWord,
			String host,
			String port,
			String starttls,
			String auth,
			boolean debug,
			String socketFactoryClass,
			String fallback,
			String[] to,
			String[] cc,
			String subject,
			String text,
			String attachmentPath,
			String attachmentName){

		//Object Instantiation of a properties file.
		Properties props = new Properties();
		props.put("mail.smtp.user", userName);
		props.put("mail.smtp.host", host);

		if(!"".equals(port)){
			props.put("mail.smtp.port", port);
		}

		if(!"".equals(starttls)){
			props.put("mail.smtp.starttls.enable",starttls);
			props.put("mail.smtp.auth", auth);
		}

		if(debug){
			props.put("mail.smtp.debug", "true");
		}else{
			props.put("mail.smtp.debug", "false");
		}
		if(!"".equals(port)){
			props.put("mail.smtp.socketFactory.port", port);
		}
		if(!"".equals(socketFactoryClass)){
			props.put("mail.smtp.socketFactory.class",socketFactoryClass);
		}
		if(!"".equals(fallback)){
			props.put("mail.smtp.socketFactory.fallback", fallback);
		}

		try{

			Session session = Session.getDefaultInstance(props, null);

			session.setDebug(debug);

			MimeMessage msg = new MimeMessage(session);

			msg.setText(text);

			msg.setSubject(subject);

			BodyPart objMessageBodyPart = new MimeBodyPart();

			objMessageBodyPart.setContent("<h2>Mail from "+project+" Automation Project!</h2></br>" + text, "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(objMessageBodyPart);
			objMessageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentPath);
			objMessageBodyPart.setDataHandler(new DataHandler(source));
			objMessageBodyPart.setFileName(attachmentName);
			multipart.addBodyPart(objMessageBodyPart);
			msg.setContent(multipart);
			msg.setFrom(new InternetAddress(userName));

			for(int i=0;i<to.length;i++){
				msg.addRecipient(Message.RecipientType.TO, new
						InternetAddress(to[i]));
			}

			for(int i=0;i<cc.length;i++){
				msg.addRecipient(Message.RecipientType.CC, new
						InternetAddress(cc[i]));
			}
			msg.saveChanges();
			Transport transport = session.getTransport("smtp");

			transport.connect(host, userName, passWord);

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

			return true;

		} catch (Exception mex){
			mex.printStackTrace();
			return false;
		}
	}

}
