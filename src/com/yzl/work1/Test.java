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

		//�༶1��ѧ��
		Student s1g1 = new Student("����","1001",21,Gender.��,"3�꼶","kgc");
		Student s2g1 = new Student("����","1002",18,Gender.Ů,"3�꼶","kgc");
		Student s3g1 = new Student("����","1003",25,Gender.��,"3�꼶","kgc");
		Grade g1 = new Grade();
		List<Student> stuList = new ArrayList<>();
		stuList.add(s1g1);stuList.add(s2g1);stuList.add(s3g1);
		g1.setStuList(stuList);
		g1.setGrade("3�꼶");
		
		//�༶2��ѧ��
		Student s1g2 = new Student("Сѧ������","1001101",10,Gender.��,"Сѧ��","kgc");
		Student s2g2 = new Student("Сѧ������","1001202",11,Gender.Ů,"Сѧ��","kgc");
		Student s3g2 = new Student("Сѧ������","1001303",9,Gender.��,"Сѧ��","kgc");
		Grade g2 = new Grade();
		List<Student> stuList2 = new ArrayList<>();
		stuList2.add(s1g2);stuList2.add(s2g2);stuList2.add(s3g2);
		g2.setStuList(stuList2);
		g2.setGrade("Сѧ��");
		
		
		//ѧУ
		Map<String, Grade> stuMap = new HashMap<String, Grade>();
		stuMap.put(g1.getGrade(), g1);
		stuMap.put(g2.getGrade(), g2);
		
//		School school = new School("kgc", stuMap);  //���п���
		
		Manipulation man = new Manipulation(stuMap);
		man.showInfo();
		
//		man.stuUpdate("1002");
//		man.stuDel("1001");
		man.stuAdd("1001404");
		
		man.showInfo();
		

	}

}
