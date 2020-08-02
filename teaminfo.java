import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class teaminfo extends HttpServlet{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
      // JDBC driver name and database URL
      final String driver = "com.mysql.jdbc.Driver";  
      final String URL="jdbc:mysql://localhost/miniproject0";

      //  Database credentials
      final String USER = "root";
      final String PASS = "root";

      // Set response content type
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      String title = "GAMES INFORMATION"; 
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      pw.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#E0FFFF\r\n" + 
         "\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n");
      
      try {
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         Connection conn = DriverManager.getConnection(URL, USER, PASS);

         // Execute SQL query
         Statement st = conn.createStatement();
         String sql;
         

         sql = "SELECT * FROM teams";
         ResultSet rs = st.executeQuery(sql);
			pw.print("<table border='1'>");

         
         
         
			pw.print("<tr>");
			pw.print("<th>"+"TEAM ID"+"</th>");
			pw.print("<th>"+"TEAM NAME"+"</th>");
			pw.print("<th>"+"TEAM CAPTIAN"+"</th>");
			pw.print("<th>"+"PLAYER NAME"+"</th>");
			pw.print("<th>"+"COACH ID"+"</th>");


			pw.print("</tr>");
         
         // Extract data from result set
			
			
	         while(rs.next()){

			
		    	 pw.print("<tr>");
			String GID=rs.getString(1);	
			String GNAME=rs.getString(2);
			String TID=rs.getString(3);			
			String EID=rs.getString(4);			
			String PID=rs.getString(4);			

			pw.print("<td>"+GID+"</td>");
			pw.print("<td>"+GNAME+"</td>");
			pw.print("<td>"+TID+"</td>");
			pw.print("<td>"+EID+"</td>");
			pw.print("<td>"+PID+"</td>");


			pw.print("</tr>");
			   
			}
		     
				pw.print("</table>");
         
				
         pw.println("</body></html>");


         // Clean-up environment
         rs.close();
         st.close();
         conn.close();
      } 
	         catch(SQLException se) {
       
    	  //Handle errors for JDBC
         se.printStackTrace();
      } catch(Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally {
         //finally block used to close resources
         try {
        	 

             // Open a connection
             Connection conn = DriverManager.getConnection(URL, USER, PASS);

             // Execute SQL query
             Statement st = conn.createStatement();
        	 

            if(st!=null)
               st.close();
         } catch(SQLException se2) {
         } // nothing we can do
         try {

             // Open a connection
             Connection conn = DriverManager.getConnection(URL, USER, PASS);

             // Execute SQL query
             Statement st = conn.createStatement();
        	 
        	 

            if(conn!=null)
            conn.close();
         } catch(SQLException se) {
            se.printStackTrace();
         } //end finally try
      } //end try
   }
} 