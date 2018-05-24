package com;
import java.io.*;
import java.net.*;
import java.util.Vector;

import test.SMSConfig;

public class SMS
{
public static void send(String uid, String pwd, String phone, String msg) throws IOException {

if (uid == null || 0 == uid.length())
throw new IllegalArgumentException("User ID should be present.");
else
uid = URLEncoder.encode(uid, "UTF-8");

if (pwd == null || 0 == pwd.length())
throw new IllegalArgumentException("Password should be present.");
else
pwd = URLEncoder.encode(pwd, "UTF-8");

if (phone == null || 0 == phone.length())
throw new IllegalArgumentException("At least one phone number should be present.");

if (msg == null || 0 == msg.length())
throw new IllegalArgumentException("SMS message should be present.");
else
msg = URLEncoder.encode(msg, "UTF-8");

Vector<Long> numbers = new Vector();
String pharr[];
if (phone.indexOf(';') >= 0) {
pharr = phone.split(";");
for (String t : pharr) {
try
{
numbers.add(Long.valueOf(t));
}
catch (NumberFormatException ex)
{
throw new IllegalArgumentException("Give proper phone numbers.");
}
}
} else {
try
{
numbers.add(Long.valueOf(phone));
}
catch (NumberFormatException ex)
{
throw new IllegalArgumentException("Give proper phone numbers.");
}
}

if (0 == numbers.size())
throw new IllegalArgumentException("At least one proper phone number should be present to send SMS.");

/*==================================================================*/

// Login
String temp = "";
String content = "username=" + uid + "&password=" + pwd + "&q=Deepika%20Padukone%20Photo%20Gallery";
URL u=null;
if(SMSConfig.PROXY){
u = new URL(SMSConfig.PROTOCOL,SMSConfig.PROXY_HOST,SMSConfig.PROXY_PORT,"http://wwwd.way2sms.com/auth.cl");
} else {
u = new URL("http://wwwd.way2sms.com/auth.cl");
}
HttpURLConnection uc = (HttpURLConnection) u.openConnection();
uc.setDoOutput(true);
uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5");
uc.setRequestProperty("Content-Length", String.valueOf(content.length()));
uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
uc.setRequestProperty("Accept", "*/*");
uc.setRequestMethod("POST");
uc.setInstanceFollowRedirects(false); // very important line :)
PrintWriter pw = new PrintWriter(new OutputStreamWriter(uc.getOutputStream()), true);
pw.print(content);
pw.flush();
pw.close();
BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
while ( (temp = br.readLine()) != null ) {}
String cookie = uc.getHeaderField("Set-Cookie");

// Send SMS to each of the phone numbers
u = null; uc = null;
for (long num : numbers)
{
content = "HiddenAction=instantsms&login=&pass=&custid=undefined&MobNo=" + num + "&textArea=" + msg;
if(SMSConfig.PROXY){
u = new URL(SMSConfig.PROTOCOL,SMSConfig.PROXY_HOST,SMSConfig.PROXY_PORT,"http://wwwd.way2sms.com/FirstServletsms?custid=");
} else {
u = new URL("http://wwwd.way2sms.com/FirstServletsms?custid=");
}
uc = (HttpURLConnection) u.openConnection();
uc.setDoOutput(true);
uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5");
uc.setRequestProperty("Content-Length", String.valueOf(content.length()));
uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
uc.setRequestProperty("Accept", "*/*");
uc.setRequestProperty("Cookie", cookie);
uc.setRequestMethod("POST");
uc.setInstanceFollowRedirects(false);
pw = new PrintWriter(new OutputStreamWriter(uc.getOutputStream()), true);
pw.print(content);
pw.flush();
pw.close();
br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
while ( (temp = br.readLine()) != null ) {}
br.close();
u = null;
uc = null;
}

// Logout
if(SMSConfig.PROXY){
u = new URL(SMSConfig.PROTOCOL,SMSConfig.PROXY_HOST,SMSConfig.PROXY_PORT,"http://wwwd.way2sms.com/jsp/logout.jsp");
} else {
u = new URL("http://wwwd.way2sms.com/jsp/logout.jsp");
}
uc = (HttpURLConnection) u.openConnection();
uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5");
uc.setRequestProperty("Accept", "*/*");
uc.setRequestProperty("Cookie", cookie);
uc.setRequestMethod("GET");
uc.setInstanceFollowRedirects(false);
br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
while ( (temp = br.readLine()) != null ) {}
br.close();
u = null;
uc = null;
}
}


