package com.example.SMS.db;

import com.example.SMS.model.Student;

import java.sql.*;

public class DbConnection {

    public static  Connection connection;

public DbConnection() throws SQLException{
    createConnection();
    createTable();
}


    public  static Connection  createConnection() throws SQLException{

        if (connection == null)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagementapp", "root", "root");
        return connection;
    }


    public void createTable() throws SQLException {
        String sql = "create table if not exists studentdetails( rollNum INT primary key auto_increment,name VARCHAR(30), clgName VARCHAR(30), city VARCHAR(30), percentage double)";
        Statement st = connection.createStatement();
        st.execute(sql);
    }

    public  static boolean insertStudentData(Student s) throws SQLException {
        boolean flag =false;
       // System.out.println(s.getRollNum() + " " + s.getName() + " " + s.getClgName() + " " + s.getCity()+ " " + s.getPercentage());
        String sql = "INSERT INTO studentdetails(name,clgname,city,percentage) values( '"+s.getName()+"' , '"+s.getClgName()+"' , '"+s.getCity()+"' , "+s.getPercentage()+" )";
        Statement st = connection.createStatement();
        int ans= st.executeUpdate(sql);
            if(ans!=0)
                flag =true;

           return flag;
    }
    public static void showAllStudents() throws SQLException {
        String query="Select * from studentdetails";
        Statement st= connection.createStatement();
        ResultSet res=st.executeQuery(query);

        while(res.next()){
            System.out.println("RollNum: "+res.getInt(1) + "\n"+
                    "name: "+ res.getString(2) +"\n" +
                    "collegeName: " + res.getString(3)+"\n" +
                    "city: " + res.getString(4) +"\n" +
                    "percentage: "+res.getDouble(5));
            System.out.println();
        }

    }

    public static boolean showStudentsById(int id) throws SQLException {
        boolean flag=false;
    String query="Select * from studentdetails where rollNum=" +id;
        Statement st= connection.createStatement();
        ResultSet res=st.executeQuery(query);

        while(res.next()){
            System.out.println("RollNum: "+res.getInt(1) + "\n"+
                    "name: "+ res.getString(2) +"\n" +
                    "collegeName: " + res.getString(3)+"\n" +
                    "city: " + res.getString(4) +"\n" +
                    "percentage: "+res.getDouble(5));
            flag=true;
            System.out.println();
        }
        return flag;
    }

    public static boolean delete(int id) throws SQLException {
        boolean flag=false;

        String query="delete from studentdetails where rollNum=" +id;
        Statement st= connection.createStatement();
         int ans=st.executeUpdate(query);

         if(ans!=0)
             flag=true;

        return flag;
    }
    public static boolean update(int id, String updateName) throws SQLException {
        boolean flag=false;
        String sql="update  studentdetails set name= '"+updateName+"' where rollNum="+id;

        Statement st= connection.createStatement();
        int ans=st.executeUpdate(sql);
        if(ans!=0)
            flag=true;

        return flag;
    }
}
