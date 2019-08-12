package com.yzl.work1;

import java.util.ArrayList;
import java.util.List;

public class Grade {

	private List<Student> stuList = new ArrayList<>();   //某班级内的学生集合
	private String grade;    //年级名称
	
	public Grade() {
		super();
	}

	public Grade(List<Student> stuList, String grade) {
		super();
		this.stuList = stuList;
		this.grade = grade;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
