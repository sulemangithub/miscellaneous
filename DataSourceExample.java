package com.suleman.dsn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DataSourceExample
 */
@WebServlet("/DataSourceExample")
public class DataSourceExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/mysql")
	DataSource ds;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=response.getWriter();
		
		try {
			/*InitialContext con=new InitialContext();
			DataSource ds=(DataSource)con.lookup("jdbc/mysql");*/
			out.println("Datasource found....");
			
			Connection cn=ds.getConnection();
			
			Statement st=cn.createStatement();
			
			ResultSet res=st.executeQuery("select * from course");
			
			while(res.next())
			{
				out.println(res.getString(1));
				out.println(res.getString(2));
				out.println(res.getString(3)+"<BR>");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
