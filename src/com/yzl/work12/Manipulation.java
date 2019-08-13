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
			System.out.println("*****************欢迎进入超市会员管理系统****************");
			System.out.println("1.累计积分    2.积分兑换    3.查询剩余积分    4.修改密码    5.开卡    6.退出");
			System.out.println("*************************************************");
			System.out.print("请选择：");
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
				System.out.println("感谢您的使用！欢迎下次光临");
				DaoToFile.writeobject(vipMap, path);
				System.exit(0);
				break;
			default:
				System.out.println("您输入的选项有误！");
				break;
			}

		}
		
	}
	
	/*
	 * 初始化函数
	 */
	public void init() {
		File file = new File(path);
		if(file.exists())
			vipMap = DaoToFile.readobject(path);
		else
			vipMap = new HashMap<>();
	}
	
	/*
	 * 开卡
	 */
	public int acctOpen() {
		System.out.print("请输入注册姓名：");
		String username = input.next();
		System.out.print("请输入注册密码：");
		String passwd = input.next();
		while(passwd.length()<6) {
			System.out.print("会员密码不能小于6位，请重新输入注册密码：");
			passwd = input.next();
		}
		
		Random random = new Random();
		String vipnum = Integer.toString(random.nextInt(99999999));
		Date date = new Date();
		Vip v = new Vip(username, passwd, vipnum, 100, date);
		vipMap.put(vipnum, v);
		System.out.println("恭喜，开通会员卡成功，系统赠送您100积分！您的会员卡号为：" + vipnum);

		return 0;
	}
	
	/*
	 * 累计积分
	 */
	public int pointAdd() {
		String vipnum = isVip();
		if(vipnum == null) {
			System.out.println("无法累计积分\n积分累计失败");
			return 0;
		}
		System.out.print("请输入您此次的消费金额（消费1元累计1积分）：");
		double consume = input.nextDouble();
		vipMap.get(vipnum).setPoint(vipMap.get(vipnum).getPoint() + (int)consume);
		System.out.println("积分累计成功！");

		return 0;
		
	}
	
	/*
	 * 积分兑换
	 */
	public int pointExchange() {
		String vipnum = isVip();
		if(vipnum == null) {
			System.out.println("无法兑换积分\n积分兑换失败");
			return 0;
		}
		System.out.print("请输入您要兑换使用的积分（100积分抵用0.1元，不足100的积分不作抵用）：");
		int points = input.nextInt();
		int temp = points / 100;
		if(temp <= 0)
			System.out.println("抱歉，您的积分不够，无法抵用消费金额。\n积分兑换失败");
		else {
			vipMap.get(vipnum).setPoint(vipMap.get(vipnum).getPoint() - temp * 100);
			System.out.println("您的消费金额中使用积分抵消"+(0.1*temp)+"元。\n积分兑换成功");
		}
		return 0;
	}
	
	/*
	 * 剩余积分查询
	 */
	public void showPoint() {
		String vipnum = isVip();
		if(vipnum == null) {
			System.out.println("查询失败！");
			return;
		}
		Vip vip = vipMap.get(vipnum);
		System.out.println("姓名\t会员卡号\t剩余积分\t开卡日期");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(vip.getDate());
		System.out.println(vip.getUserName()+"\t"+vip.getVipNum()+"\t"+vip.getPoint()+"\t"+date);
		return;
	}
	
	/*
	 * 修改密码
	 */
	public void passwdExchge() {
		String vipnum = isVip();
		if(vipnum == null) {
			System.out.println("密码修改失败！");
			return;
		}
		System.out.print("请输入新的会员密码：");
		String newPasswd = input.next();
		while(newPasswd.length()<6) {
			System.out.print("会员密码不能小于6位，请重新输入密码：");
			newPasswd = input.next();
		}
		vipMap.get(vipnum).setPasswd(newPasswd);
		System.out.println("密码修改成功！");
	}
	/*
	 * 会员验证
	 */
	public String isVip() {
		System.out.print("请输入您的会员卡号：");
		String vipnum = input.next();
		System.out.print("请输入您的会员卡密码：");
		String passwd = input.next();
		if(!vipMap.containsKey(vipnum)) {
			System.out.print("无此会员！");
			return null;
		}
		if(!vipMap.get(vipnum).getPasswd().equals(passwd)) {
			System.out.print("您输入的密码有误！");
			return null;
		}
		
		return vipnum;
	}
}
