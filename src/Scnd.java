import java.sql.*;
import java.util.Scanner;

class Scndd{
        public static void main(String[] args) throws SQLException {
            Statement smt;
            Connection conn;
            ResultSet rs;
              rs= smt.executeQuery("SELECT * FROM exam_data");

        while(rs.next()){
            System.out.println("---------------------------------");
            System.out.println("Question : "+rs.getString("Question"));
            System.out.println("A : "+rs.getString("op_A"));
            System.out.println("B : "+rs.getString("op_B"));
            System.out.println("C : "+rs.getString("op_C"));
            System.out.println("D : "+rs.getString("op_D"));
        }
           

     
        try {

            Class.forName("com.mysql.jdbc.Driver");
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_data","root"," ");
              smt=conn.createStatement();

            smt.executeQuery("SELECT * FROM exam_data");
        } catch (Exception e) {
            System.out.println("class not found !!! "+e.getMessage());}

        }


        

    }
        
    