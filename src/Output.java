import java.sql.SQLException;
import java.util.Scanner;

class Output{
    public static void main(String[]args) throws Exception{
                Scanner sc=new Scanner(System.in);
    Fir obj=new Fir();
while(true){
         System.out.println("1.Student Registration");
        System.out.println("2.Display Student's Data");
        System.out.println("3.Get exam");
        System.out.println("4.Exam Result");

        System.out.println("Enter Choice : ");
        int d =sc.nextInt();
     if(d==1){
             obj.DataInserted();

        }
        else if(d==2){
            obj.DisplayData();
        }
        else if(d==3){
            obj.checkResult();
        }
        else if(d==4){
            obj.DisplayMarks();
        }}
      
      }}