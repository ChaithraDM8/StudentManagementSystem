package com.example.SMS.dao;

import com.example.SMS.model.Student;

import java.sql.SQLException;

public interface StudentDaoInterface {
  public boolean addStudent(Student s) throws SQLException;
  public boolean delete(int rollNum) throws SQLException;
  public boolean update(int roolNum, String update, int choice) throws SQLException;
  public void showAllStudents() throws SQLException;
  public boolean showStudentsById(int rollNum) throws SQLException;
}
