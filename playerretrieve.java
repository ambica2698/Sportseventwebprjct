import java.io.*;

import javax.servlet.*;
import java.sql.*;

public class playerretrieve extends GenericServlet
{
	Connection con;
	public void init() throws ServletException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject0","root","root");
		        
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String pid=request.getParameter("pid");
	
		try
		{
		String query="select * from player where pid=?";

		PreparedStatement ps=con.prepareStatement(query);

		ps.setString(1,pid);
		ResultSet rs=ps.executeQuery();
		
		
		
		pw.print("<table border='1'>");
       	pw.print("<tr>");
			pw.print("<th>"+"PLAYER ID"+"</th>");

			pw.print("<th>"+"PLAYER NAME"+"</th>");
			pw.print("<th>"+"PLAYER PHONE"+"</th>");
			pw.print("<th>"+"CLUB NAME"+"</th>");

			pw.print("</tr>");
         
         // Extract data from result set
			
			
	         while(rs.next()){

			
		    	 pw.print("<tr>");
			String pid1=rs.getString(1);	
			String pname=rs.getString(2);
			String pphone=rs.getString(3);
			String clname=rs.getString(4);			
			
			pw.print("<td>"+pid1+"</td>");
			pw.print("<td>"+pname+"</td>");
			pw.print("<td>"+pphone+"</td>");
			pw.print("<td>"+clname+"</td>");

			pw.print("</tr>");
			   
			}
		     
				pw.print("</table>");
         
				
		
		
		
		
	/*	while(rs.next())
		{
			String pid1=rs.getString(1);
			String pname=rs.getString(2);
		String pphone=rs.getString(3);
		String clname=rs.getString(4);
pw.println(pid1+"\t" +pname+"\t" +pphone+ "\t" +clname);
}*/
         
         
		
		}
		catch(Exception e)
		{
			pw.println(e);
		}
		
	}
}