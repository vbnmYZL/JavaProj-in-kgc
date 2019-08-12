package com.yzl.work1;

import java.util.HashMap;
import java.util.Map;

public class School {

	private String schoolName;
	private Map<String, Grade> stuMap = new HashMap<>();
	
	public School() {
		super();
	}

	public School(String schoolName, Map<String, Grade> stuMap) {
		super();
		this.schoolName = schoolName;
		this.stuMap = stuMap;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Map<String, Grade> getStuMap() {
		return stuMap;
	}

	public void setStuMap(Map<String, Grade> stuMap) {
		this.stuMap = stuMap;
	}
	
}
