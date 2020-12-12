package SchoolManagement;
import java.sql.*;  
/**
 *
 
 */
public class conn{
    Connection c;
    Statement s;
    public conn(){  
        
        try{  
            String username = "root";
            String password = "jeetubhaiya109205144181";
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root/SchoolManagement",username,password);    
            s =c.createStatement();  
            //String queryString = "select * from student";
            //ResultSet Rs  = s.executeQuery(queryString);
            //Rs.next();
           // String user = Rs.getInt(1) + " : " + Rs.getString(2)+ " "+ Rs.getString(3)+ " "+Rs.getString(4);
            //System.out.println(user);
        }
        catch(Exception e){ 
            System.out.println(e);
        }  
    
    }  
}


