package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 class Test  {

	public static void main(String[] args) throws Exception{
		
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:\\sample.mdb;";
		Connection con=DriverManager.getConnection(database,"","");
		System.out.println("Connected");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from course");
		while(res.next())
		{
			System.out.print(res.getString(1));
			System.out.println(res.getString(2));
		}
		
	}
}
