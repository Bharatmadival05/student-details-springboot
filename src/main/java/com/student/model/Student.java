package com.student.model;

public class Student {

	private int studentid;
	private String studentName;
	private String Gender;
	private long contactNo;
	private String email;
	private String address;
	private int pincode;
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Student(int studentid, String studentName, String gender, long contactNo, String email, String address,
			int pincode) {
		super();
		this.studentid = studentid;
		this.studentName = studentName;
		this.Gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.address = address;
		this.pincode = pincode;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
