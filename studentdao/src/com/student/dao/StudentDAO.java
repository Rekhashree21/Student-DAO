package com.student.dao;

import java.util.List;

import com.student.dto.Student;

public interface StudentDAO {
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	public Student getStudent(String mail,String pass);   //to get the specific students details
	public List<Student> getStudent();     //to retrieve all the student details
	
}
