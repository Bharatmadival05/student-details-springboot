package com.student.ServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.student.Service.StudentDaoService;
import com.student.model.Student;
import com.student.util.DButil;

@Service
public class StudentDaoServiceImpl implements StudentDaoService {

	ArrayList<Student> studentList=new ArrayList<Student>();
	
	private static Connection connection=null;
	public StudentDaoServiceImpl(){
		
		try {
			connection =DButil.getConnection();
			System.out.println("connection: "+connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Student> getStudent(){
		studentList.clear();
		String getStudentQuery="SELECT * FROM student;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(getStudentQuery);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Student stud=new Student();
				stud.setStudentid(rs.getInt(1));
				stud.setStudentName(rs.getString(2));
				stud.setGender(rs.getString(3));
				stud.setContactNo(rs.getLong(4));
				stud.setEmail(rs.getString(5));
				stud.setAddress(rs.getString(6));
				stud.setPincode(rs.getInt(7));
				studentList.add(stud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
		
	}
	public void addStudent(Student student) {
		 int studentid = student.getStudentid();
		 String studentName = student.getStudentName();
		 String Gender = student.getGender();
		 long contactNo = student.getContactNo();
		 String email = student.getEmail();
		 String address = student.getAddress();
		 int pincode = student.getPincode();
		 
		 String insertQuery="INSERT INTO student VALUES("+studentid+",'"+studentName+"','"+Gender+"',"+contactNo+",'"+email+"','"+address+"',"+pincode+")";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println(insertQuery);
			System.out.println("Student added successfully ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public boolean studentLoginValidation(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeStudent(int studentid) {
		String deleteQuery="DELETE FROM student WHERE studentid=("+studentid+")";
		
		PreparedStatement stmt1;
		try {
			stmt1 = connection.prepareStatement(deleteQuery);
			stmt1.executeUpdate();
			System.out.println("Student deleted successfully ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updatestudent(Student student) {
		// TODO Auto-generated method stub
		int studentid=student.getStudentid();
		String studentName=student.getStudentName();
		String gender=student.getGender();
		long contactNo=student.getContactNo();
		String email=student.getEmail();
		String address=student.getAddress();
		int pincode=student.getPincode();
		
		StringBuilder updateQuery=new StringBuilder("UPDATE student SET");
		
		if(studentName!=null) {
			updateQuery.append(" studentName = '").append(studentName).append("',");
		}
		if(gender!=null) {
			updateQuery.append(" Gender = '").append(gender).append("',");
		}
		if(contactNo!=0) {
			updateQuery.append(" contactNo = ").append(contactNo).append(",");
		}
		if(email!=null) {
			updateQuery.append(" email = '").append(email).append("',");
		}
		if(address!=null) {
			updateQuery.append(" address = '").append(address).append("',");
		}
		if(pincode!=0) {
			updateQuery.append(" pincode = ").append(pincode).append(",");
		}
		
		updateQuery.setLength(updateQuery.length()-1);
		updateQuery.append("WHERE studentid = ").append(studentid).append(";");
		
		PreparedStatement stmt;
		
		try {
			stmt=connection.prepareStatement(updateQuery.toString());
			int rowsUpdated=stmt.executeUpdate();
			if (rowsUpdated > 0) {
		        System.out.println("Student updated successfully");
		    } else {
		        System.out.println("No rows were updated.");
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}