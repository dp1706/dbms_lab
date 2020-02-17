
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;
 
class lab5_q1{
 
    private static final String url = "jdbc:mysql://localhost:3306/lab1?useSSL=false";
 
    private static final String user = "root";
 
    private static final String password = "*************";
 
    public static void main(String args[]) {
        try {
    
            Scanner sc=new Scanner(System.in);
            Connection con = DriverManager.getConnection(url, user, password);
            
           Statement stmt=con.createStatement();  
           int i=1;
           
           ResultSet rs=stmt.executeQuery("show tables");
           while(rs.next())
               System.out.println(i++ +": " +rs.getString(1));  

              String str[]=new String[20];

           System.out.println("enter your choice: ");
           String choice=sc.nextLine();

          rs=stmt.executeQuery("desc "+choice);
            int count=0;

          while(rs.next()){
                    str[count]=rs.getString(1);
                    count++;}

              System.out.println();
              System.out.print("| ");
          for(i=0;i<count;i++){
              System.out.print(str[i]+"     "+"|");}

           rs=stmt.executeQuery("select * from "+choice);
           while(rs.next()){
                System.out.println();
                  for(i=1;i<=count;i++){
                      System.out.print(rs.getString(i) + "     "+"|");
                            }}
            System.out.println();
             rs.close();
             stmt.close();
           con.close();   
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
