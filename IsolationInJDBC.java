package batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class BatchUpdateExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
		Statement stat=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
		ResultSet res=stat.executeQuery("select * from course");
		while(res.next())
		{
			System.out.print(res.getString(1));
			System.out.print("\t"+res.getString(2));
			System.out.println("\t"+res.getString(3));
		}
	}

}
