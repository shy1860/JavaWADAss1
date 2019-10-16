package ca.gbc.ass;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class SessionCookieCoordinator {
	public static  String getSessionID() 
	{
		 Random rand = new Random();
		 int max=999999,min=100000;
	
	
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	String kk=Integer.toString(randomNum);
	    return kk;
	}
	
	public static  boolean updateSession(HttpServletRequest request,String email,String pswd) throws Exception  
	{
		HttpSession session = request.getSession();
		User userInfo = (User) session.getAttribute("userInfo");
		if(userInfo==null) {
			
			session.setAttribute("userInfo",DataManager.userContentCreator(email,pswd));
		}
		
			return true;
		
		}
	

}
