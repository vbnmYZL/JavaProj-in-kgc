package com.yzl.work1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * ѧ����Ϣ������
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
	 * ѧ����Ϣ����
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
	 * ѧ����Ϣ����չʾ
	 */
	public void showInfo(String stuNo) {
		Student s = stuFind(stuNo);
		if(s != null)
			System.out.println("������ϢΪ��\nѧ�ţ�"+s.getStuNo()+"\t������"+s.getStuName()+"\t�Ա�"+s.getSex()+"�����꼶��"+s.getGrade());
		else
			System.out.println("�޴�ѧ����Ϣ��");
		return;
	}
	
	/*
	 * ���ѧ����Ϣ
	 */
	public void stuAdd(String stuNo) {
		Student ss = stuFind(stuNo);
		if(ss != null)
			System.out.println("�Ѵ��ڸ�����Ϣ�����ʧ�ܣ�");
		else {
			Student s = new Student();
			s.setStuNo(stuNo);
			System.out.print("������ѧ��������");
			s.setStuName(input.next());
			System.out.print("���������䣺");
			s.setAge(input.nextInt());
			System.out.print("�������Ա�");
			s.setSex(Gender.valueOf(input.next()));
			System.out.print("�������꼶��");
			String tempGrade =input.next();
			s.setGrade(tempGrade);
			try {
				stuMap.get(tempGrade).getStuList().add(s);
				System.out.println("���ѧ����Ϣ�ɹ�");
			} catch(Exception e) {
				e.printStackTrace();
//				e.getMessage();
				System.out.println("���ʧ�ܣ�");
			}
		}
	}
	
	/*
	 * �޸�ѧ����Ϣ
	 */
	public void stuUpdate(String stuNo) {
		Student s = stuFind(stuNo);
		if(s == null)
			System.out.println("�޸�����Ϣ���޸�ʧ�ܣ�");
		else {
			System.out.println("������¼�������Ϣ��");
			try {
				System.out.print("������ѧ��������");
				s.setStuName(input.next());
				System.out.print("���������䣺");
				s.setAge(input.nextInt());
				System.out.print("�������Ա�");
				s.setSex(Gender.valueOf(input.next()));
				System.out.print("�������꼶��");
				s.setGrade(input.next());
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("�޸�ʧ�ܣ�");
			}
		}
	}
	
	/*
	 * ɾ��ѧ����Ϣ
	 * 
	 */
	public void stuDel(String stuNo) {
		Student s = stuFind(stuNo);
		if(s == null)
			System.out.println("�޸�����Ϣ��ɾ��ʧ�ܣ�");
		else {
			try {
				stuMap.get(s.getGrade()).getStuList().remove(s);
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("ɾ��ʧ�ܣ�");
			}
		}
	}
	
	/*
	 * ѧ����Ϣչʾ
	 */
	public void showInfo() {
		for (Entry<String, Grade> en : stuMap.entrySet()) {
			System.out.println(en.getKey()+"��ѧ����ϢΪ��");
			Iterator<Student> it = en.getValue().getStuList().iterator();
			while(it.hasNext()) {
				Student s = it.next();
				System.out.println(s.getStuName()+"\t"+s.getStuNo()+"\t"+s.getAge()+"\t"+s.getSex());
			}
		}
	}
}
