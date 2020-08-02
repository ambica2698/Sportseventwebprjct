
import java.io.*;
import javax.servlet.*;
import java.sql.*;


public class game extends GenericServlet {
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
		
		String gid=request.getParameter("gid");
	    String gname=request.getParameter("gname");
		String tid=request.getParameter("tid");
		String eid=request.getParameter("eid");
		
		
		try
		{
			String query="insert into game2 values(?,?,?,?)";
			
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,gid);
			ps.setString(2,gname);
			ps.setString(3,tid);
			ps.setString(4,eid);
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

