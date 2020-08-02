
import java.io.*;
import javax.servlet.*;
import java.sql.*;


public class coachreg extends GenericServlet {
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
		
		String cid=request.getParameter("cid");
	    String cname=request.getParameter("cname");
		String cphno=request.getParameter("cphno");
		String cemail=request.getParameter("cemail");
		String clname=request.getParameter("clname");
		String pwd=request.getParameter("pwd");
		
		
		try
		{
			String query="insert into coachs values(?,?,?,?,?,?)";
			
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,cid);
			ps.setString(2,cname);
			ps.setString(3,cphno);
			ps.setString(4,cemail);
			ps.setString(5,clname);
			ps.setString(6,pwd);
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				pw.println("<h1>"+"REGISTERED SUCCESFULLy!"+"</h1>");
			}
			else
			{
				pw.println("<h1>"+"NOT REGISTERED!"+"</h1>");
				pw.print("<center><a href='coachreg.html'>Try again</a>");

			}

				}catch(Exception e)
		{
			
			pw.println(e);
		}

		pw.print("<center><a href='homepage.html'>BACK</a>");
		pw.close();
	}

}

