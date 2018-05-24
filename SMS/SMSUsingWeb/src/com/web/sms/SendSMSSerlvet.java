package com.web.sms;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendSMSSerlvet
 */
@WebServlet("/SendSMSSerlvet")
public class SendSMSSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String smsHost="http://localhost:8800/"; //this is the url of nowSMS gateway.
		String username="suleman";//create a user in nowSMS gateway with username and password
		String password="suleman";
		
		
		
		String phoneNumber=request.getParameter("no");
		String message=request.getParameter("message");
		
		try {
			phoneNumber=URLEncoder.encode(phoneNumber,"UTF-8");
			
			message=URLEncoder.encode(message,"UTF-8");
		} catch (Exception e) {
			response.getWriter().println("invalid number.");
		}
		
		String urlString=smsHost+"?user="+username+"&password="+password+"&PhoneNumber="+phoneNumber+"&Text="+message;
		
		URL url=new URL(urlString);
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setDoOutput(false);
		connection.setDoInput(true);
		
		String res=connection.getResponseMessage();
		
		int code=connection.getResponseCode();
		
		if(res.equals("OK"))
		{
			response.getWriter().println("SMS Sent...");
		}
		connection.disconnect();
		
		
	}

}
