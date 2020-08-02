
import java.io.*;
import javax.servlet.*;
import java.sql.*;


public class playerreg extends GenericServlet {
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
		
		String pid=request.getParameter("pid");
	    String pname=request.getParameter("pname");
		String pphone=request.getParameter("pphone");
		String clbname=request.getParameter("clbname");
		String pword=request.getParameter("psw");
		
		
		try
		{
			String query="insert into player values(?,?,?,?,?)";
			
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,pid);
			ps.setString(2,pname);
			ps.setString(3,pphone);
			ps.setString(4,clbname);
			ps.setString(5,pword);
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

