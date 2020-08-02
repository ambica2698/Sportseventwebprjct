import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class playerinfo extends HttpServlet{

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
      String title = "COACH INFORMATION"; 
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
         

         sql = "SELECT * FROM player";
         ResultSet rs = st.executeQuery(sql);

         
         
         
         pw.println("<table>");
         pw.println("<tr>");

         
         // Extract data from result set
         
         while(rs.next()){
        	 
        	 
        	 
        	 
          pw.println("<tr>"+ "PLAYER ID \t: "+ rs.getString(1)   + "<br>");
          pw.println("---------------------------------------------------------------"+"<br>");  
          pw.println("<tr>"+"PLAYER NAME: \t"+   rs.getString(2)+"<br>");
          pw.println("<tr>"+ "PLAYER PHONE: \t"+ rs.getString(3)+"<br>");
          pw.println("<tr>"  +  "CLUB NAME: \t" +rs.getString(4)+"<br>");   
          pw.println("<br>");  

          
         }
         pw.println("</tr>");
         pw.println("</table>");
         pw.println("</body></html>");


         // Clean-up environment
         rs.close();
         st.close();
         conn.close();
      } catch(SQLException se) {
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