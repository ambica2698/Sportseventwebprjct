
import java.io.*;
import javax.servlet.*;
import java.sql.*;


public class clubs extends GenericServlet {
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
		
		String clid=request.getParameter("clid");
	    String clname=request.getParameter("clname");
		String clsec=request.getParameter("clsec");
		String pid=request.getParameter("pid");
		
		
		try
		{
			String query="insert into clubs values(?,?,?,?)";
			
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,clid);
			ps.setString(2,clname);
			ps.setString(3,clsec);
			ps.setString(4,pid);
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

