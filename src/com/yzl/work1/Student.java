package com.yzl.work1;

public class Student {

	private String stuName;
	private String stuNo;
	private int age;
	private Gender sex;
	
	private String grade;    //年级
	private String schoolName;    //学校
	
	public Student() {
		super();
	}

	public Student(String stuName, String stuNo, int age, Gender sex) {
		super();
		this.stuName = stuName;
		this.stuNo = stuNo;
		this.age = age;
		this.sex = sex;
	}

	public Student(String stuName, String stuNo, int age, Gender sex,
			String grade, String schoolName) {
		super();
		this.stuName = stuName;
		this.stuNo = stuNo;
		this.age = age;
		this.sex = sex;
		this.grade = grade;
		this.schoolName = schoolName;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
