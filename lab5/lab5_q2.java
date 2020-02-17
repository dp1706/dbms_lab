import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;
 
class lab5_q2{
 
    private static final String url = "jdbc:mysql://localhost:3306/lab1?useSSL=false";
 
    private static final String user = "root";
 
    private static final String password = "*************";
 
    public static void main(String args[]) {
         Scanner sc=null;
         Connection con=null;
        Statement stmt=null;
          ResultSet rs=null;
        try {
    
            sc=new Scanner(System.in);
            con = DriverManager.getConnection(url, user, password);
            
            stmt=con.createStatement();  
           int i=1;
          
           rs=null;
           /*while(rs.next())
               System.out.println(i++ +": " +rs.getString(1));  

              String str[]=new String[20];*/
           System.out.println("the folloning operation according to the question :\n1:given room,print the name of all classes."+"\n"+"2:given name of course ,print rooms and times for that course."+"\n"+"3:given fname,print name of the courses that faculty member teaches."+"\n"+"4:print faculty member having did is 20 and whose course are conducted in room R128");
           System.out.println("enter your choice: ");
           int choice=sc.nextInt();

            //rs=stmt.executeQuery("desc "+choice);
            //int count=0;
            String st,sql;
             switch(choice){

                case 1:
                        System.out.println("Enter the name of the room: ");
                        sc.nextLine();
                         st=sc.nextLine();
                         sql="select distinct name from class where room='"+st+"'";
                        rs=stmt.executeQuery(sql);
                        System.out.println("           name        ");
                        while(rs.next())
                           System.out.println(rs.getString("name"));
              
                     break;

                 case 2:
                         System.out.println("Enter the name of the course: ");
                        sc.nextLine();
                        st=sc.nextLine();
                        sql="select distinct room,meets_at from class where name='"+st+"'";
                        rs=stmt.executeQuery(sql);
                        System.out.println("    room    "+"    meets_at     ");
                        while(rs.next())
                           System.out.println(rs.getString("room")+"   "+rs.getString("meets_at"));
           
                      break;
                 case 3:
                         
                         System.out.println("Enter the name of the faculty member: ");
                         sc.nextLine();
                         st=sc.nextLine();
                         sql="select distinct name  from class,faculty where class.fid=faculty.fid and fname='"+st+"'";
                         rs=stmt.executeQuery(sql);
                         System.out.println("    name   ");
                         while(rs.next())
                           System.out.println(rs.getString("name"));
                          
                       break;
                  case 4:
                       
                     
                        sql="select distinct faculty.fid,fname  from class,faculty where class.fid=faculty.fid and class.room='R128' and faculty.deptid=20";
                         rs=stmt.executeQuery(sql);
                         System.out.println("    fid   "+"   fname    ");
                         while(rs.next())
                           System.out.println(rs.getString("faculty.fid")+"          "+rs.getString("fname"));
                          
                      break;

              }
                            
          
          
 
        } 
           catch(SQLException e){
                          e.getMessage();

             }

          catch (Exception e) {
            e.printStackTrace();
        }
        finally{
                   try{
                        rs.close();
                        stmt.close();
                        con.close();}
                    catch(Exception e){
                                     e.printStackTrace();}}
    }
}
