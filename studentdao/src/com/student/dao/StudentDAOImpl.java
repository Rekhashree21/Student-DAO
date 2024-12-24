package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.connector.ConnectionFactory;
import com.student.dto.Student;

public class StudentDAOImpl implements StudentDAO {
	
	private Connection con;

	public StudentDAOImpl() {
		super();
		this.con = ConnectionFactory.requestConnection();//making this connection as global
	}

	@Override
	public boolean insertStudent(Student s) {
		// JDBC LOGICC FOR INSERT OPERATION 
		String query="INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
		
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2,s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6,s.getPassword());
			
			res=ps.executeUpdate();//res stores value whether the data inserted or not
				
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}
	

	@Override
	public boolean updateStudent(Student s) {
		String query="UPDATE STUDENT SET PHONE=? WHERE ID=?";
		int res=0;
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			//ps.setString(1,s.getName());
			ps.setLong(1,s.getPhone());
			ps.setInt(2, s.getId());
			//ps.setString(4, s.getBranch());
			//ps.setInt(5, s.getLid());
			//ps.setString(6, s.getPass());
			res=ps.executeUpdate();
			} 
		  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			if(res>0)
			{
			return true;
			}
			else
			{
			return false;
			}
		
	}

	@Override
	public boolean deleteStudent(Student s) {
	//delete operation
		String query="DELETE FROM STUDENT WHERE ID=?";
	
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1,s.getId());
			
			res=ps.executeUpdate();
		}//res stores value whether the data inserted or not
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(res>0) {
				return true;
			}
			else {
				return false;
			}
		}
		
	@Override
	public Student getStudent(String mail, String pass) {
		String query="SELECT * FROM STUDENT WHERE MAILID=? AND PASSWORD=?";
		Student s=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,mail);
			ps.setString(2,pass);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				
				//String name=re.getString("name");
				//s.setName(name);
				
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
		
		} 
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Student> getStudent() {
		ArrayList<Student>students=new ArrayList<Student>();
		Student s=null;
		String query="SELECT * FROM STUDENT";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				
				//String name=re.getString("name");
				//s.setName(name);
				
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				students.add(s);
			}
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

}
