package com.student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.Service.StudentDaoService;
import com.student.model.Student;


@RestController
public class StudentController {

	@Autowired
	private StudentDaoService studService;
	
	@GetMapping("/getStudent")
	public List<Student> getAllStudent(){
		return studService.getStudent();
	}
	@PostMapping("/addStudent")
	public void addCustomerData(@RequestBody Student student) {
		studService.addStudent(student);
	}
	@PostMapping("/deleteStudent")
	public void removeStudent(@RequestBody int studentid) {
		studService.removeStudent(studentid);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/updatestudent")
	public void updateStudent(@RequestBody Student student) {
		studService.updatestudent(student);
	}
}
