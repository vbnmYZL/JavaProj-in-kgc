package com.yzl;
/**
 * 吃货联盟订餐系统
 * @author YZL
 */
import java.util.Scanner;

public class CHLM_NetOrderSys {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean isExit = false; //服务结束标志位
		int mainMenuR = -1; //返回主菜单标志位
		
		//定义数组用于存储可提供的菜品信息
		String[] dishName = {"红烧鱼","鱼香肉","鲜蔬"};          //菜品名称
		double[] price = new double[] {48.0, 33.0, 14.0};   //菜品价格
		int[] praiseNums = new int[3];                      //点赞数
		
		//定义数组用于存储客户的订单信息(10条)
		String[] names = new String[10];   //客户姓名   
		int[][] dishMegs = new int[10][2]; // 二维数组用于存储所点菜品及其对应的份数,dishMegs[x][0]为菜品编号，dishMegs[x][1]为数量
		int[] times = new int[10];
		String[] address = new String[10];
		int[] states = new int[10];  //保存订单状态：0表示已预定，1表示已完成
		double[] sumPrices = new double[10];  //每笔订单总价
		
//		int currentLoc = 0; //用于定位当前操作的订单位置
		
		System.out.println("欢迎使用“吃货联盟订餐系统”");
		
		do {
			System.out.println("*********************************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐袋");
			System.out.println("3、签收订单");
			System.out.println("4、删除订单");
			System.out.println("5、我要点赞");
			System.out.println("6、退出系统");
			System.out.println("*********************************");
			
			System.out.print("请选择：");
			int choice1lev = input.nextInt();
		
			switch (choice1lev) {
			case 1:
				//订餐系统
				System.out.println("***我要订餐***");
				boolean isAdd = false;  //记录是否可以订餐(是否有订餐空位)
				
				//用户输入订餐信息
				for (int i = 0; i < names.length; i++) {
					if(names[i] == null) {
						isAdd = true;
						System.out.print("请输入订餐人姓名：");
						names[i]=input.next();
						System.out.println("序号\t菜名\t单价\t点赞数");
						for (int j = 0; j < dishName.length; j++) {
							System.out.println((j+1) + "\t" + dishName[j]+"\t"+ price[j] + "\t" + praiseNums[j]);
						}
						System.out.print("请选择您要点的菜品编号：");
						dishMegs[i][0]=input.nextInt();
						System.out.print("请选择您需要的份数：");
						dishMegs[i][1]=input.nextInt();
						//计算总金额(含送餐费)
						//计算送餐费
						if(price[dishMegs[i][0]-1] * dishMegs[i][0]>=50)
							sumPrices[i] = price[dishMegs[i][0]-1] * dishMegs[i][0];
						//	System.out.println("餐费：" + sumPrices[i] + "，送餐费0.0元，总计：" + sumPrices[i] + "元。");
						else
							sumPrices[i] = price[dishMegs[i][0]-1] * dishMegs[i][0] + 5;
						//	System.out.println("餐费：" + sumPrices[i] + "，送餐费5元，总计：" + (sumPrices[i]+5) + "元。");
						sumPrices[i] = price[dishMegs[i][0]-1] * dishMegs[i][0];
						System.out.print("请输入送餐时间(送餐时间为10点至20点间整点送餐)");
						while(!input.hasNextInt()) {
							System.out.println("输入错误，重新输入");
							input = new Scanner(System.in);
						}
						int time=input.nextInt();
						while (time<10||time>20) {
							System.out.println("您的输入有误，请输入10到20的整数");
							time = input.nextInt();
						}
						times[i] = time;
						System.out.print("请输入送餐地址：");
						address[i] = input.next();
						states[i] = 0;
						System.out.println("订餐成功");
						System.out.println("您订的是：" + dishName[dishMegs[i][0]-1] + dishMegs[i][0] + "份");
						System.out.println("送餐时间：" + times[i] + "点");
						//计算总金额(含送餐费)
						//计算送餐费
						if(price[dishMegs[i][0]-1] * dishMegs[i][0]>=50)
							System.out.println("餐费：" + sumPrices[i] + "，送餐费0.0元，总计：" + sumPrices[i] + "元。");
						else
							System.out.println("餐费：" + (sumPrices[i] - 5) + "，送餐费5元，总计：" + sumPrices[i] + "元。");
						break;
					}
				}
				if(!isAdd) {
					System.out.println("对不起，您的餐袋已满");
				}				
				break;
			case 2:
				//查看餐袋系统
				System.out.println("***查看餐袋***");
				System.out.println("序号\t订餐人\t餐品信息\t送餐时间\t送餐地址\t总金额\t订单状态");
				for (int currentRecord = 0; names[currentRecord] != null && currentRecord < names.length; currentRecord++) {
					System.out.println((currentRecord+1) + "\t" + names[currentRecord] + "\t" + dishName[dishMegs[currentRecord][0]-1] 
							+ dishMegs[currentRecord][0] + "份\t" + times[currentRecord] + "点\t" + address[currentRecord] + "\t" +
							sumPrices[currentRecord] + "\t" + (states[currentRecord]==0?"已预定":"已完成"));
				}
				if(names[0] == null)
					System.out.println("无订单记录");
				break;
			case 3:
				//签收订单系统
				System.out.println("***签收订单***");
				System.out.print("请选择要签收的订单序号：");
				int signNum = input.nextInt();
				boolean isSignFound = false;
				for (int currentRecord = 0; names[currentRecord] != null && currentRecord < names.length; currentRecord++) {
					if(currentRecord == (signNum-1)) {
						states[currentRecord] = 1;
						System.out.println("订单签收成功！");
						isSignFound = true;
						break;
					}
				}
				if(isSignFound == false)
					System.out.println("您选择的订单不存在！");
				break;
			case 4:
				//删除订单系统（可以删除“已完成”状态下的订单）
				System.out.println("***删除订单***");
				System.out.print("请选择要删除的订单序号：");
				int deleteNum = input.nextInt();
				boolean isDeleteFound = false;
				for (int currentRecord = 0; names[currentRecord] != null && currentRecord < names.length; currentRecord++) {
					if(currentRecord == (deleteNum-1)) {
						if(states[currentRecord] == 1) {
							for (int j = currentRecord; j < sumPrices.length - 1; j++) {
								names[j] = names[j+1];
								dishMegs[j] = dishMegs[j+1];
								times[j] = times[j+1];
								address[j] = address[j+1];
								states[j] = states[j+1];
								sumPrices[j] = sumPrices[j+1];
							}
							int endIndex = names.length - 1;
							names[endIndex] = null;
							dishMegs[endIndex] = null;
							times[endIndex] = 0;
							address[endIndex] = null;
							states[endIndex] = 0;
							sumPrices[endIndex] = 0.0;
							System.out.println("删除订单成功");
						}else
							System.out.println("您选择的订单未签收，不能删除！");
						isDeleteFound = true;
						break;	
					}
				}
				if(isDeleteFound == false)
					System.out.println("您选择的订单不存在！");
				break;
			case 5:
				//点赞系统
				System.out.println("***我要点赞***");
				//显示菜品列表
				System.out.println("序号\t菜名\t单价\t点赞数");
				for (int j = 0; j < dishName.length; j++) {
					System.out.println((j+1) + "\t" + dishName[j]+"\t"+ price[j] + "\t" + praiseNums[j]);
				}
				System.out.print("请选择您要点赞的菜品序号：");
				int praiseNum = input.nextInt();
				praiseNums[praiseNum-1]++;
				System.out.println("点赞成功！");
				break;
			case 6:
				//退出系统
				isExit =true;
				break;
			default:
				System.out.println("录入选项有误，请重新录入");
				continue;
			}
			if(!isExit) {
				System.out.print("输入0返回：");
				mainMenuR=input.nextInt();
				while(mainMenuR!=0) {
					System.out.println("请输入0返回上级菜单");
					mainMenuR=input.nextInt();
				}		
			} else {
				break;
			}
		} while(mainMenuR==0);
		
		input.close();
		System.out.println("谢谢使用，欢迎下次光临！");
			
		
	}
}
