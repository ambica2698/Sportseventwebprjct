
import java.io.*;
import javax.servlet.*;
import java.sql.*;


public class event extends GenericServlet {
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
		
		String eid=request.getParameter("eid");
	    String ename=request.getParameter("ename");
	    String edate=request.getParameter("edate");
		String evenue=request.getParameter("evenue");
		String tid=request.getParameter("tid");
		
		
		try
		{
			String query="insert into event1 values(?,?,?,?,?)";
			
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,eid);
			ps.setString(2,ename);
			ps.setString(3,edate);
			ps.setString(4,evenue);
			ps.setString(5,tid);
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
		
		pw.print("<center><a href='homepage.html'>BACK</a></center>");
		pw.close();
	}

}

