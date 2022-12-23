package com.example.SMS.dao;

import com.example.SMS.db.DbConnection;
import com.example.SMS.model.Student;

import java.sql.Connection;
import java.sql.SQLException;

public class StudentDao implements StudentDaoInterface {
    //DbConnection connection;
    @Override
    public boolean addStudent(Student s) throws SQLException{
      return DbConnection.insertStudentData(s);

    }

    @Override
    public boolean delete(int rollNum) throws SQLException {
        return DbConnection.delete(rollNum);
    }

    @Override
    public boolean update(int rollNum, String updateName,int choice) throws SQLException {
        boolean flag=false;

     if(choice==1)
      flag = DbConnection.update(rollNum,updateName);

        return flag;
    }

    @Override
    public void showAllStudents() throws SQLException {
    DbConnection.showAllStudents();
    }

    @Override
    public boolean showStudentsById(int rollNum) throws SQLException {
        return DbConnection.showStudentsById(rollNum);

    }
}
