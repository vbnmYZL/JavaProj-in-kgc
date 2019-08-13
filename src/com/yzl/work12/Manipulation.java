package com.yzl.work12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Manipulation {

	Map<String, Vip> vipMap= null;
	Scanner input = new Scanner(System.in);
	static String path = "d:\\test.txt";

	public Manipulation() {
		super();
		
		init();		
		while(true) {
			System.out.println("*****************��ӭ���볬�л�Ա����ϵͳ****************");
			System.out.println("1.�ۼƻ���    2.���ֶһ�    3.��ѯʣ�����    4.�޸�����    5.����    6.�˳�");
			System.out.println("*************************************************");
			System.out.print("��ѡ��");
			int choice1 = input.nextInt();
			switch (choice1) {
			case 1:
				pointAdd();
				break;
			case 2:
				pointExchange();
				break;
			case 3:
				showPoint();	
				break;
			case 4:
				passwdExchge();
				break;
			case 5:
				acctOpen();
				break;
			case 6:
				System.out.println("��л����ʹ�ã���ӭ�´ι���");
				DaoToFile.writeobject(vipMap, path);
				System.exit(0);
				break;
			default:
				System.out.println("�������ѡ������");
				break;
			}

		}
		
	}
	
	/*
	 * ��ʼ������
	 */
	public void init() {
		File file = new File(path);
		if(file.exists())
			vipMap = DaoToFile.readobject(path);
		else
			vipMap = new HashMap<>();
	}
	
	/*
	 * ����
	 */
	public int acctOpen() {
		System.out.print("������ע��������");
		String username = input.next();
		System.out.print("������ע�����룺");
		String passwd = input.next();
		while(passwd.length()<6) {
			System.out.print("��Ա���벻��С��6λ������������ע�����룺");
			passwd = input.next();
		}
		
		Random random = new Random();
		String vipnum = Integer.toString(random.nextInt(99999999));
		Date date = new Date();
		Vip v = new Vip(username, passwd, vipnum, 100, date);
		vipMap.put(vipnum, v);
		System.out.println("��ϲ����ͨ��Ա���ɹ���ϵͳ������100���֣����Ļ�Ա����Ϊ��" + vipnum);

		return 0;
	}
	
	/*
	 * �ۼƻ���
	 */
	public int pointAdd() {
		String vipnum = isVip();
		if(vipnum == null) {
			System.out.println("�޷��ۼƻ���\n�����ۼ�ʧ��");
			return 0;
		}
		System.out.print("���������˴ε����ѽ�����1Ԫ�ۼ�1���֣���");
		double consume = input.nextDouble();
		vipMap.get(vipnum).setPoint(vipMap.get(vipnum).getPoint() + (int)consume);
		System.out.println("�����ۼƳɹ���");

		return 0;
		
	}
	
	/*
	 * ���ֶһ�
	 */
	public int pointExchange() {
		String vipnum = isVip();
		if(vipnum == null) {
			System.out.println("�޷��һ�����\n���ֶһ�ʧ��");
			return 0;
		}
		System.out.print("��������Ҫ�һ�ʹ�õĻ��֣�100���ֵ���0.1Ԫ������100�Ļ��ֲ������ã���");
		int points = input.nextInt();
		int temp = points / 100;
		if(temp <= 0)
			System.out.println("��Ǹ�����Ļ��ֲ������޷��������ѽ�\n���ֶһ�ʧ��");
		else {
			vipMap.get(vipnum).setPoint(vipMap.get(vipnum).getPoint() - temp * 100);
			System.out.println("�������ѽ����ʹ�û��ֵ���"+(0.1*temp)+"Ԫ��\n���ֶһ��ɹ�");
		}
		return 0;
	}
	
	/*
	 * ʣ����ֲ�ѯ
	 */
	public void showPoint() {
		String vipnum = isVip();
		if(vipnum == null) {
			System.out.println("��ѯʧ�ܣ�");
			return;
		}
		Vip vip = vipMap.get(vipnum);
		System.out.println("����\t��Ա����\tʣ�����\t��������");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(vip.getDate());
		System.out.println(vip.getUserName()+"\t"+vip.getVipNum()+"\t"+vip.getPoint()+"\t"+date);
		return;
	}
	
	/*
	 * �޸�����
	 */
	public void passwdExchge() {
		String vipnum = isVip();
		if(vipnum == null) {
			System.out.println("�����޸�ʧ�ܣ�");
			return;
		}
		System.out.print("�������µĻ�Ա���룺");
		String newPasswd = input.next();
		while(newPasswd.length()<6) {
			System.out.print("��Ա���벻��С��6λ���������������룺");
			newPasswd = input.next();
		}
		vipMap.get(vipnum).setPasswd(newPasswd);
		System.out.println("�����޸ĳɹ���");
	}
	/*
	 * ��Ա��֤
	 */
	public String isVip() {
		System.out.print("���������Ļ�Ա���ţ�");
		String vipnum = input.next();
		System.out.print("���������Ļ�Ա�����룺");
		String passwd = input.next();
		if(!vipMap.containsKey(vipnum)) {
			System.out.print("�޴˻�Ա��");
			return null;
		}
		if(!vipMap.get(vipnum).getPasswd().equals(passwd)) {
			System.out.print("���������������");
			return null;
		}
		
		return vipnum;
	}
}
