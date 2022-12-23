package com.example.SMS.main;

import com.example.SMS.dao.StudentDao;
import com.example.SMS.db.DbConnection;
import com.example.SMS.model.Student;

import java.sql.SQLException;
import java.util.Scanner;

public class User {
    public static void main(String[] args) throws SQLException{
    Scanner sc = new Scanner(System.in);
    StudentDao studentDao=new StudentDao();
    System.out.print("Welcome to student Management Application");
    while(true){
        System.out.println("\n 1. Add Student" +
                "\n 2. Show All Students" +
                "\n 3. Get student based on roll number" +
                "\n 4. Delete Student" +
                "\n 5. Update Student" +
                "\n 6. Exit" );

        System.out.println("Enter choice : ");
        int choice=sc.nextInt();
        DbConnection dbConnection=new DbConnection() ;
        switch(choice){
            case 1:
                System.out.println("Add students");

                System.out.println("Enter Student Name");
                String name= sc.next();

                System.out.println("Enter student college name");
                String clgName= sc.next();

                System.out.println("Enter city");
                String city = sc.next();

                System.out.println("Enter percentage");
                double percentage=sc.nextDouble();

                Student st=new Student(name,clgName,city,percentage);
                //System.out.println(st.getRollNum() + " " + st.getName() + " " + st.getClgName() + " " + st.getCity()+ " " + st.getPercentage());
                boolean ans=studentDao.addStudent(st);
                if(ans){
                    System.out.println("Record inserted successfully");
                }
                else{
                    System.out.println("Something went wrong please try again");
                }
                break;

            case 2:
                System.out.println("Show all students");
                studentDao.showAllStudents();
                break;

            case 3:
               // System.out.println("Get student based on rollnumber");
                System.out.println("Enter roll number");
                int rollnum=sc.nextInt();
                boolean flag =studentDao.showStudentsById(rollnum);
                    if(!flag)
                        System.out.println("Student with this id is not available");

                break;

            case 4:
                System.out.println("Delete student");
                System.out.println("Enter roll number");

                boolean f =studentDao.delete( sc.nextInt());
                if(!f){
                    System.out.println("Something went wrong");
                }
                else{
                    System.out.println("Record deleted successfully....");
                }
                break;

            case 5:
                System.out.println("Update the student");
                System.out.println("\n1.Update name\n2.Update clgName");
                System.out.println("enter your choice");
                int ch=sc.nextInt();

                if(ch==1){

                    System.out.println("enter roll number");
                    int rnum=sc.nextInt();

                    System.out.println("Enter new name");
                    String sname=sc.next();

                    Student std=new Student();
                    std.setName(sname);

                    boolean ff=  studentDao.update(rnum,sname,ch);

                    if(ff)
                        System.out.println("Name updated successfully");
                    else
                        System.out.println("Something went wrong...");
                }
                break;

            case 6:
                System.out.println("Thank you for using the Application!!!");
                System.exit(0);
            default :
                System.out.println("Please enter valid choice");
        }
    }
    }
}
