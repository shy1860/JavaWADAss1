package ca.gbc.ass;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;  

public class DataManager {
	public static  String regCheck(String fn,String ln,String em,String add,String pswd) throws Exception{
		if(fn.equals(null) || fn.equals("")) {
			return "First name can't not be empty";
		}else if(!fn.matches("[A-Za-z]+")) {
			return "First name didn't meet stardard! Only letters are allowed!";
		}else if(ln.equals(null) || ln.equals("")) {
			return "Last name can't not be empty";
		}else if(!ln.matches("[A-Za-z]+")) {
			return "Last name didn't meet stardard! Only letters are allowed!";
		}else if(em.equals(null) || em.equals("")) {
			return "Email name can't not be empty";
		}else if(!em.matches( "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$")) {
			return "Email format is incorrect! ";
		}else if(add.equals(null) || add.equals("")) {
			return "Address name can't not be empty";
		}else if(pswd.equals(null) || pswd.equals("")) {
			return "Password name can't not be empty";
		}else if(!pswd.matches("^(?=.*?[A-Z])(?=.*?[a-z]).{6,12}$")) {
			return "Passwords must\r\n" + 
					"o be 6-12 characters in length and must contain\r\n" + 
					"o contain at least 1 uppercase letter\r\n" + 
					"o contain at least 1 special character";
		}else {
		return "good";}
	}

	public static  String userNameCheck(String username,String password) throws Exception {
		MySQLAccess c = new MySQLAccess();
		String role=null,pswd=null;
		Connection connect = c.connectDataBase();
		Statement st = connect.createStatement();
		String query = "SELECT * FROM users where email='"+username+"'";
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
		    role = rs.getString("role");
		    pswd=rs.getString("password");
		}
		if(role==null) {
			st.close();
			connect.close();
			rs.close();
			return "empty";
		}
		else if(password.compareTo(pswd)!=0) {
			
			st.close();
			connect.close();
			rs.close();
		return "wrongpswd";
		}else{
			st.close();
			connect.close();
			rs.close();
			return role;
		}

	}
	public static  User emailObject(String username) throws Exception {
		MySQLAccess c = new MySQLAccess();
		String role=null,pswd=null,address=null,firstname=null,lastname=null,created=null,id=null;
		Connection connect = c.connectDataBase();
		Statement st = connect.createStatement();
		String query = "SELECT * FROM users where email='"+username+"'";
		ResultSet rs = st.executeQuery(query);
		User uu=null;

		while (rs.next()) {
			id=rs.getString ("id");
		    role = rs.getString("role");
		    pswd=rs.getString("password");
		    address=rs.getString("address");
		    firstname=rs.getString("firstname");
		    lastname=rs.getString("lastname");
		    created=rs.getString("created");
		    
		}
		st.close();
		connect.close();
		rs.close();
		return  uu=new User(id, firstname, lastname, username, pswd, role, address, created);

	}
	public static  User userContentCreator(String username,String password) throws Exception {
		MySQLAccess c = new MySQLAccess();
		String id=null,role=null,pswd=null,fn=null,ln=null,address=null,createdTime=null;
		Connection connect = c.connectDataBase();
		Statement st = connect.createStatement();
		String query = "SELECT * FROM users where email='"+username+"'";
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
		    role = rs.getString("role");
		    pswd=rs.getString("password");
		    id=rs.getString("id");
		    fn=rs.getString("firstname");
		    ln=rs.getString("lastname");
		    address=rs.getString("address");
		    createdTime=rs.getString("created");
		};
		User newUser=new User(id,fn,ln,username,password,role,address,createdTime);
		st.close();
		connect.close();
		rs.close();
		return newUser;
	}	
	
	public static  String clientReg(String fn,String ln,String em,String add,String pswd) throws Exception {
		MySQLAccess c = new MySQLAccess();
		if(userNameCheck(em,pswd)=="empty") {
		Connection connect = c.connectDataBase();
		Statement st = connect.createStatement();
		String insert = "INSERT INTO `comp3095`.`users` "
				+ "( `firstname`, `lastname`, `email`, `role`, `password`, `address`) "
				+ "VALUES ('"+fn+"','"+ln+"','"+em+"',"+"'client','"+pswd+"','"+add+"');";
		System.out.println(insert);
	st.executeUpdate(insert);
	st.close();
	connect.close();
	
		return "success";
		}
		else {			
		return "user in database already";
		}
		}

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
    			+"\nCreated: "+c.createdTime;
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

            // To get the array of addresses

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
	
	