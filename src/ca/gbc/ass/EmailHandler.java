package ca.gbc.ass;
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
  
public class EmailHandler  
{

   
	public static String sendFromGMail(String to) throws Exception {
    	String from = "shy0105030229";
    	String pass = "Oakwood123";
    	String subject="Welcome joining us!";
    	User c=DataManager.emailObject(to);
    	System.out.println(c.toString());
    	String body="This is to inform you that you have registered from our website!"
    			+ "\nBelow are the details from your registration:"
    			+ "\nYour user name:"+c.email
    			+"\nPassword: "+c.password
    			+"\nFirst name: "+c.firstname
    			+"\nLast name: "+c.lastname
    			+"\nAddress: "+c.address
    			+"\nCreated: "+c.createdTime
    			+"\nPlease login via: http://localhost:8080/AssignmentWADJava/login.jsp";
    	Properties props = System.getProperties();
    	System.out.println("good1");
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress toAddress = new InternetAddress(to);
                toAddress= new InternetAddress(to);    
                message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
        
        return "success";
    }
}
