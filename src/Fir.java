import java.sql.*;
import java.util.Scanner;

class Fir {
    Connection conn;
    Statement smt;
    ResultSet rs;


    public Fir() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "");
            smt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("class not found !!! " + e.getMessage());
        }

    }

    public void DataInserted() throws SQLException {
        Scanner sc = new Scanner(System.in);
        // Scanner s = new Scanner(System.in);

        String stu_name, fname, cmd, stu_id, mobile, pass;
        System.out.println("Enter Student id :   ");
        stu_id = sc.nextLine();
        System.out.println("Enter Student Name :   ");
        stu_name = sc.nextLine();
        System.out.println("Enter Fathers  Name :   ");
        fname = sc.nextLine();
        System.out.println("Enter mobile Number :   ");
        mobile = sc.nextLine();
        System.out.println("Enter Password :   ");
        pass = sc.nextLine();
        cmd = "INSERT INTO stu_table VALUES('" + stu_id + "','" + stu_name + "','" + fname + "','" + mobile + "','"
                + pass + "')";
        smt.executeUpdate(cmd);
        System.out.println("Student Registered!!");
    }

    public void DataDeleted() throws SQLException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Student id : ");
        int stu_id = s.nextInt();
        smt.executeUpdate("DELETE FROM stu_data WHERE stu_id='" + stu_id + "'");
        System.out.println("Data Deleted");
    }

    public void DisplayData() throws SQLException {
        rs = smt.executeQuery("SELECT * FROM stu_table");
        while (rs.next()) {
            System.out.println("---------------------------------");
            System.out.println("Stu_id : " + rs.getString("stu_id"));
            System.out.println("Stu_name : " + rs.getString("Sudent_Name"));
            System.out.println("Fathers Name : " + rs.getString("Father_Name"));
            System.out.println("Mobile Number : " + rs.getString("Mobile_no"));
            System.out.println("Password : " + rs.getString("Password"));
        }
    }

    void checkResult() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id : ");
        String id = sc.nextLine();
        rs = smt.executeQuery("SELECT * FROM stu_table WHERE stu_id='" + id + "'");
        while (rs.next()) {
            System.out.println("Stu_id : " + rs.getString("stu_id"));
            System.out.println("Stu_name : " + rs.getString("sudent_Name"));
            System.out.println("Fathers Name : " + rs.getString("Father_Name"));
            System.out.println("Mobile Number : " + rs.getString("Mobile_no"));
            System.out.println("Password : " + rs.getString("Password"));
            DisplayexamData(id);
        }
    }

    public void DisplayexamData(String sr) throws SQLException {
        Scanner s = new Scanner(System.in);
        int c = 0;

        rs = smt.executeQuery("SELECT * FROM exam_data");
        while (rs.next()) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Question : " + rs.getString("Question"));
            System.out.println("" + rs.getString("op_A"));
            System.out.println("" + rs.getString("op_B"));
            System.out.println("" + rs.getString("op_C"));
            System.out.println("" + rs.getString("op_D"));
            System.out.println("Enter Correct Answer : ");
            int ans = s.nextInt();
            int cr = rs.getInt("ans");

            if (ans == cr) {
                c++;
            }
        }
        marks(sr, c);

    }

    public void marks(String stu_id, int marks) throws SQLException {
        int Total_Marks = 10;

        String cmd = "INSERT INTO marks VALUES('" + stu_id + "','" + marks + "','" + Total_Marks + "')";
        smt.executeUpdate(cmd);

    }

    public void DisplayMarks() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id : ");
        String id = sc.nextLine();
        rs = smt.executeQuery("SELECT * FROM marks WHERE stu_id='" + id + "'");

        while (rs.next()) {
            System.out.println("---------------------------------");
            System.out.println("Stu_id : " + rs.getString("stu_id"));
            System.out.println("Marks : " + rs.getString("Marks"));
            System.out.println("Total Marks : " + rs.getString("Total_Marks"));
        }

    }
}
