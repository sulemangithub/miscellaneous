import java.net.*; 
import java.io.*; 
import javax.swing.*; 
import javax.net.ssl.HttpsURLConnection; 


class SMTPSend
{ 

	public static void main(String args[]) 
	{ 
		boolean debug=true; 

		String phone	="9657715476"; 
		String message	="gun guna rahe hai bhavre sun rahi kali kali"; 
		String ppgHost	="http://localhost:8800/"; 
		String username ="suleman";
		String password ="suleman";
		
		try
		{ 
			//phone=URLEncoder.encode("8366xxxx", "UTF-8"); 

			if(debug) 
				System.out.println("phone------>"+phone); 
				message=URLEncoder.encode(message, "UTF-8"); 

			if(debug) 
				System.out.println("message---->"+message); 
		} 
		catch (UnsupportedEncodingException e) 
		{ 
			System.out.println("Encoding not supported"); 
		} 

		//String url_str=ppgHost+"?PhoneNumber="+phone+"&Text="+message; 
		 String url_str=ppgHost+"?user="+username+"&password="+password+"&PhoneNumber="+phone+"&Text="+message; 

		if(debug)                   
			System.out.println("url string->"+url_str); 

		
		try
		{		
			URL url2=new URL(url_str); 

			HttpURLConnection connection = (HttpURLConnection) url2.openConnection(); 
			connection.setDoOutput(false); 
			connection.setDoInput(true); 

			if(debug)                  
				System.out.println("Opened Con->"+connection); 
	
			String res=connection.getResponseMessage(); 
		
			if(debug) 
				System.out.println("Get Resp  ->"+res); 
	
			int code = connection.getResponseCode () ; 
		
			if ( code == HttpURLConnection.HTTP_OK ) 
			{ 
				connection.disconnect() ; 
			}
		}
		catch(IOException e)
		{
			System.out.println("unable to create new url"+e.getMessage());
		}

	

	} // main
} // class 