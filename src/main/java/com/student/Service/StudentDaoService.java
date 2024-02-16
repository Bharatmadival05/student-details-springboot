package com.student.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.model.Student;

@Service
public interface StudentDaoService {

	public List<Student> getStudent();
	public void addStudent(Student student);
	public void removeStudent(int studentid);
	public void updatestudent(Student student);
	public boolean studentLoginValidation(String username,String password);
}