package com.yzl.work1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//班级1的学生
		Student s1g1 = new Student("张三","1001",21,Gender.男,"3年级","kgc");
		Student s2g1 = new Student("李四","1002",18,Gender.女,"3年级","kgc");
		Student s3g1 = new Student("王五","1003",25,Gender.男,"3年级","kgc");
		Grade g1 = new Grade();
		List<Student> stuList = new ArrayList<>();
		stuList.add(s1g1);stuList.add(s2g1);stuList.add(s3g1);
		g1.setStuList(stuList);
		g1.setGrade("3年级");
		
		//班级2的学生
		Student s1g2 = new Student("小学生张三","1001101",10,Gender.男,"小学生","kgc");
		Student s2g2 = new Student("小学生李四","1001202",11,Gender.女,"小学生","kgc");
		Student s3g2 = new Student("小学生王五","1001303",9,Gender.男,"小学生","kgc");
		Grade g2 = new Grade();
		List<Student> stuList2 = new ArrayList<>();
		stuList2.add(s1g2);stuList2.add(s2g2);stuList2.add(s3g2);
		g2.setStuList(stuList2);
		g2.setGrade("小学生");
		
		
		//学校
		Map<String, Grade> stuMap = new HashMap<String, Grade>();
		stuMap.put(g1.getGrade(), g1);
		stuMap.put(g2.getGrade(), g2);
		
//		School school = new School("kgc", stuMap);  //可有可无
		
		Manipulation man = new Manipulation(stuMap);
		man.showInfo();
		
//		man.stuUpdate("1002");
//		man.stuDel("1001");
		man.stuAdd("1001404");
		
		man.showInfo();
		

	}

}
