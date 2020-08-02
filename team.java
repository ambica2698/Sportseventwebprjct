
import java.io.*;
import javax.servlet.*;
import java.sql.*;


public class team extends GenericServlet {
	Connection con;
	public void init()throws ServletException
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject0","root","root");	
		}catch(Exception e)
		{
			System.out.print(e);
		}	
	}
	public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");  
		PrintWriter pw = response.getWriter(); 
		
		String tid=request.getParameter("tid");
	    String tname=request.getParameter("tname");
		String tcaptain=request.getParameter("tcaptain");
		String pname=request.getParameter("pname");
		String cid=request.getParameter("cid");

		
		try
		{
			String query="insert into teams values(?,?,?,?,?)";
			
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,tid);
			ps.setString(2,tname);
			ps.setString(3,tcaptain);
			ps.setString(4,pname);
			ps.setString(5,cid);

			int i=ps.executeUpdate();
			
			if(i>0)
			{
				pw.println("<h1>"+"VALUES INSERTED SUCCESFULLY"+"</h1>");
			}
			else
			{
				pw.println("<h1>"+"VALUES DOES NOT INSERTED SUCCESFULLY"+"</h1>");
			}

				}catch(Exception e)
		{
			
			pw.println(e);
		}
		
		pw.print("<center><a href='homepage.html'>BACK</a>");
		pw.close();
	}

}

