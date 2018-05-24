package test;

import java.util.ResourceBundle;

/**
* @author Nimish T
*
*/
public class SMSConfig {

/**
*
*/
public SMSConfig() {
// TODO Auto-generated constructor stub
}
private static ResourceBundle resourceBundle;
public static String USERNAME;
public static String PASSWORD;
public static boolean PROXY;
public static String PROXY_HOST;
public static int PROXY_PORT;
public static String PROTOCOL;
static {
try {
resourceBundle=ResourceBundle.getBundle("smsconfig");
init();
} catch (Exception e) {
//e.getMessage();
e.printStackTrace();
}
}
private static void init(){
USERNAME=resourceBundle.getString("user");
PASSWORD=resourceBundle.getString("password");
PROXY=Boolean.valueOf(resourceBundle.getString("proxy_enabled"));
if(PROXY){
PROXY_HOST=resourceBundle.getString("proxy_host");
PROXY_PORT=Integer.parseInt(resourceBundle.getString("proxy_port"));
PROTOCOL=resourceBundle.getString("protocol");
}

}
}



