import java.io.IOException;

import com.SMS;

public class Test {
	
	public static void main(String[] args) {
		
		
		try {
			SMS.send("soudagarsuleman@gmail.com", "salamasa", "9657715476", "THIS IS TEST");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("SENT....");
		
	}

}
