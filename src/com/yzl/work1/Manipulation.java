package com.yzl.work1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 学生信息操作类
 * @author Administrator
 *
 */
public class Manipulation {

	public Map<String, Grade> stuMap = new HashMap<String, Grade>();
	
	Scanner input = new Scanner(System.in);

	public Manipulation() {
		super();
	}

	public Manipulation(Map<String, Grade> stuMap) {
		super();
		this.stuMap = stuMap;
	}
	
	/*
	 * 学生信息查找
	 */
	public Student stuFind(String stuNo) {
//		boolean isFound = false;
		for (Entry<String, Grade> en : stuMap.entrySet()) {
			for (Student s : en.getValue().getStuList()) {
				if(stuNo.equals(s.getStuNo())) {
					return s;
				}
			}
		}
		return null;
	}
	
	/*
	 * 学生信息查找展示
	 */
	public void showInfo(String stuNo) {
		Student s = stuFind(stuNo);
		if(s != null)
			System.out.println("该生信息为：\n学号："+s.getStuNo()+"\t姓名："+s.getStuName()+"\t性别"+s.getSex()+"所在年级："+s.getGrade());
		else
			System.out.println("无此学生信息！");
		return;
	}
	
	/*
	 * 添加学生信息
	 */
	public void stuAdd(String stuNo) {
		Student ss = stuFind(stuNo);
		if(ss != null)
			System.out.println("已存在该生信息，添加失败！");
		else {
			Student s = new Student();
			s.setStuNo(stuNo);
			System.out.print("请输入学生姓名：");
			s.setStuName(input.next());
			System.out.print("请输入年龄：");
			s.setAge(input.nextInt());
			System.out.print("请输入性别：");
			s.setSex(Gender.valueOf(input.next()));
			System.out.print("请输入年级：");
			String tempGrade =input.next();
			s.setGrade(tempGrade);
			try {
				stuMap.get(tempGrade).getStuList().add(s);
				System.out.println("添加学生信息成功");
			} catch(Exception e) {
				e.printStackTrace();
//				e.getMessage();
				System.out.println("添加失败！");
			}
		}
	}
	
	/*
	 * 修改学生信息
	 */
	public void stuUpdate(String stuNo) {
		Student s = stuFind(stuNo);
		if(s == null)
			System.out.println("无该生信息，修改失败！");
		else {
			System.out.println("请重新录入该生信息：");
			try {
				System.out.print("请输入学生姓名：");
				s.setStuName(input.next());
				System.out.print("请输入年龄：");
				s.setAge(input.nextInt());
				System.out.print("请输入性别：");
				s.setSex(Gender.valueOf(input.next()));
				System.out.print("请输入年级：");
				s.setGrade(input.next());
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("修改失败！");
			}
		}
	}
	
	/*
	 * 删除学生信息
	 * 
	 */
	public void stuDel(String stuNo) {
		Student s = stuFind(stuNo);
		if(s == null)
			System.out.println("无该生信息，删除失败！");
		else {
			try {
				stuMap.get(s.getGrade()).getStuList().remove(s);
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("删除失败！");
			}
		}
	}
	
	/*
	 * 学生信息展示
	 */
	public void showInfo() {
		for (Entry<String, Grade> en : stuMap.entrySet()) {
			System.out.println(en.getKey()+"的学生信息为：");
			Iterator<Student> it = en.getValue().getStuList().iterator();
			while(it.hasNext()) {
				Student s = it.next();
				System.out.println(s.getStuName()+"\t"+s.getStuNo()+"\t"+s.getAge()+"\t"+s.getSex());
			}
		}
	}
}
