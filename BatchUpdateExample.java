package batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchUpdateExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
		Statement stat=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		con.setAutoCommit(false);
		stat.addBatch("insert into course values(1011,'suleman',23000)");
		stat.addBatch("insert into course values(1012,'rajesh',33000)");
		stat.addBatch("insert into course values(1013,'sonam',43000)");
		stat.addBatch("insert into course values(1014,'dinesh',13000)");
		stat.addBatch("insert into course values(1015,'paresh',23000)");
		stat.executeBatch();
		con.commit();
		System.out.println("record updated.....");

	}

}
