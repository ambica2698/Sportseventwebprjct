import java.io.*;

import javax.servlet.*;
import java.sql.*;

public class coachretrieve extends GenericServlet
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
		String cphno=request.getParameter("cphno");
	
		try
		{
		String query="select * from coachs where cphno=?";

		PreparedStatement ps=con.prepareStatement(query);

		ps.setString(3,cphno);
		ResultSet rs=ps.executeQuery();
		
		
		 
		pw.print("<tr>");
		pw.print("<th>"+"COACH ID"+"</th>");
		pw.print("<th>"+"COACH NAME"+"</th>");
		pw.print("<th>"+"COACH PHNO"+"</th>");
		pw.print("<th>"+"COACH  EMAIL"+"</th>");
		pw.print("<th>"+"CLUB NAME"+"</th>");


		pw.print("</tr>");
     
     // Extract data from result set
		
		
         while(rs.next()){

		
	    	 pw.print("<tr>");
		String CID=rs.getString(1);	
		String CNAME=rs.getString(2);
		String cphno1=rs.getString(3);
		String CEMAIL=rs.getString(4);			
		String CLNAME=rs.getString(5);			

		pw.print("<td>"+CID+"</td>");
		pw.print("<td>"+CNAME+"</td>");
		pw.print("<td>"+cphno1+"</td>");
		pw.print("<td>"+CEMAIL+"</td>");
		pw.print("<td>"+CLNAME+"</td>");

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