package com.student.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImpl;
import com.student.dto.Student;

public class Test {
	public static void main(String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
		//Student s=new Student();//creating the object
		StudentDAO sdao=new StudentDAOImpl();
		
		//collecting the data from user
		/*System.out.println("enter the name of student");
		
		//to set the value collected from the user to the pojo class object using setters
		//String name=sc.next();
		//s.setName(name);
		
		s.setName(sc.next());
        //directly the values are passed from next method from setters
		
		System.out.println("enter the phone number");
		s.setPhone(sc.nextLong());
		
		System.out.println("enter the mail id");
		s.setMail(sc.next());
		
		System.out.println("enter the branch");
		s.setBranch(sc.next());
		
		System.out.println("enter the location");
		s.setLocation(sc.next());
		
		System.out.println("set a password");
		String pass=sc.next();
		
		System.out.println("confirm password");
		String confirm=sc.next();
		
		if(pass.equals(confirm)) {
			s.setPassword(pass);
			boolean result=sdao.insertStudent(s);
			if(result) {
				System.out.println("data added successfully");
			}
			else {
				System.out.println("data not added");
			}
		}
		System.out.println("enter the student id to be deleted");
		int id=sc.nextInt();
		s.setId(id);
		if(id == (id)) {
		  s.setId(id);
		  boolean result=sdao.deleteStudent(s);
			if(result) {
				System.out.println("id deleted successfully");
			}
			else {
				System.out.println("id not deleted");
			}
		}*/
		
		//retrieving the data
		List<Student>studentsList=sdao.getStudent();
		Iterator<Student> it=studentsList.iterator();
		while(it.hasNext()) {
			Student s=it.next();
			System.out.println(s);
		}
		System.out.println("enter the mailid ");
		String mail=sc.next();
		System.out.println("enter the password");
		String pass=sc.next();
		Student s1=sdao.getStudent(mail, pass);
		
		if(s1!=null) {
			System.out.println(s1);
	    }
		
		else {
			System.out.println("invalid mailid or password");
		}
	
		
	//updating 
	
	System.out.println("enter the phone number to be updated");
	s1.setPhone(sc.nextLong());
	boolean res=sdao.updateStudent(s1);
		if(res)
		{
			System.out.println("phone number updated to "+s1.getPhone()+" "+"successfully");
		}
		else
		{
			System.out.println("failed to update");
	}
	}
	}

		
