package week1.day2;
import java.util.Scanner;
public class Student {
    String name;
    int rollNo;
    int marks;

    public void setDetails(String n,int r,int m) {
        if (r < 0 || m < 0 || m > 100) {
            System.out.println("Invalid value");
            return;
        }
        name = n;
        rollNo = r;
        marks = m;
        printDetails();
    }
        public void printDetails () {
            System.out.print("Name:" + name + " , ");
            System.out.print("rollNo:" + rollNo + " , " );
            System.out.print("marks:" + marks + " , ");
        }
        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter name: ");
            String name = sc.nextLine();
            System.out.print("Please enter rollNo: ");
            int rollNo = sc.nextInt();
            System.out.print("Please enter marks: ");
            int marks = sc.nextInt();
            Student s= new Student();
            s.setDetails(name,rollNo,marks);
        }
    }

