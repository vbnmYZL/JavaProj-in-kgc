package com.kgc.yzl;
//package com.yzl;

import java.util.Arrays;
import java.util.Scanner;

public class WXWS_ShoppingSys {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int choiceFirst;
		
		//用于存储用户信息的外部变量
		int[] vipNum = new int[10];
		String[] birthDay = new String[10];
		int[] score = new int[10];
		
		int temp;
		
		do {
			//第一步，提示信息
			System.out.println("********************************************************************************");
			System.out.println("");
			System.out.println("\t\t\t1. 登 录 系 统");
			System.out.println("");
			System.out.println("\t\t\t2. 更 改 管 理 员 密 码");
			System.out.println("");
			System.out.println("\t\t\t3. 退 出");
			System.out.println("");
			System.out.println("********************************************************************************");
			
			//用户输入
			System.out.print("请选择，输入数字：");
			choiceFirst = input.nextInt();
//			input.close();  ???
			
			//根据用户选择执行功能
			switch (choiceFirst) {
			case 1:
				System.out.print("请输入用户名：");
				String userName = input.next();
				System.out.print("请输入密码：");
				String passwd = input.next();
				
				System.out.println();  //执行功能1(登录)
				
				boolean wxwsgwglFlag = false;//返回“我行我素购物管理系统”标志位
				
				do {
					System.out.println("\t\t\t欢迎使用我行我素购物管理系统");
					System.out.println("");
					System.out.println("********************************************************************************");
					System.out.println("");
					System.out.println("\t\t\t1. 客 户 信 息 管 理");
					System.out.println("");
					System.out.println("\t\t\t2. 购 物 结 算");
					System.out.println("");
					System.out.println("\t\t\t3. 真 情 回 馈");
					System.out.println("");
					System.out.println("\t\t\t3. 注 销");
					System.out.println("");
					System.out.println("********************************************************************************");
					
					boolean khxxglFlag = false;  //回到“客户信息管理”界面的标志位
					boolean zqhkFlag = false;  //回到“真情回馈”界面的标志位
					
					System.out.print("请选择，输入数字：");
					String choiceSecond = input.next();  //直接跳过？？？？？
	//				input.close();  ???
						switch (choiceSecond) {
						//客户信息管理
						case "1":
							do {
								System.out.println("我行我素购物管理系统> 客户信息管理");
								System.out.println("");
								System.out.println("********************************************************************************");
								System.out.println("");
								System.out.println("\t\t\t1. 显 示 所 有 客 户 信 息");
								System.out.println("");
								System.out.println("\t\t\t2. 添 加 客 户 信 息");
								System.out.println("");
								System.out.println("\t\t\t3. 修 改 客 户 信 息");
								System.out.println("");
								System.out.println("\t\t\t3. 查 询 客 户 信 息");
								System.out.println("");
								System.out.println("********************************************************************************");
								
								System.out.println("");
								System.out.println("请选择，输入数字或按n返回上一级菜单：");
								String choiceThirdForkhxxgl = input.next();
								
								switch (choiceThirdForkhxxgl) {
								//显示客户信息
								case "1":
									System.out.println("我行我素购物管理系统> 客户信息管理> 显示所有客户信息");
									System.out.println("会员号\t\t\t生日\t\t\t积分");
									System.out.println("---------------|------------------|-----------------|");
									for (int i = 0; i < vipNum.length && birthDay[i] != null; i++) {
										System.out.println(vipNum[i]+"\t\t\t"+birthDay[i]+"\t\t\t"+score[i]);
									}
									
									System.out.print("请按n返回上一级菜单");
									String choiceForth = input.next(); //暂时没让他起作用
									
								/*	if(choiceForth == "n")
										//返回上一级菜单
										continue;
									else
										System.out.println("This is an wrong choice!");*/
										
									break;
									
								//添加客户信息
								case "2":
									System.out.println("我行我素购物管理系统> 客户信息管理> 添加客户信息");
									for (int i = 0; i < vipNum.length; i++) {
										if(vipNum[i] == 0) {
											System.out.print("请输入会员号：");
											temp = input.nextInt();
											if(temp <1000 ||temp>9999) {
												System.out.println("客户号"+temp+"是无效的会员号！\n录入信息失败");
												System.out.print("继续添加会员吗？(y/n)");
												if(input.next().equals("n"))
													break;
												i--;
											} else {
												vipNum[i] = temp;
												System.out.print("请输入会员生日(月/日<用两位数表示>)：");
												birthDay[i] = input.next();
												System.out.print("请输入积分：");
												score[i] = input.nextInt();
												System.out.print("新会员添加成功！");
												System.out.print("继续添加会员吗？(y/n)");
												if(input.next().equals("n"))
													break;
											}			
										}
									}
									System.out.print("请按n返回上一级菜单");
									input.next();
									break;
									
								//修改客户信息
								case "3":
									System.out.println("我行我素购物管理系统> 客户信息管理> 添加客户信息");
									System.out.print("请输入会员号：");
									temp = input.nextInt();
									for (int i = 0; i < vipNum.length; i++) {
										if(temp == vipNum[i]) {
											temp = i;
											System.out.println("会员号\t\t\t生日\t\t\t积分");
											System.out.println("---------------|------------------|-----------------|");
											System.out.println(vipNum[i]+"\t\t\t"+birthDay[i]+"\t\t\t"+score[i]);
											break;
										}
										System.out.println("无此会员！");
									}
									System.out.println("************************************************************");
									System.out.println();
									System.out.println("\t\t\t1. 修改会员生日");
									System.out.println();
									System.out.println("\t\t\t1. 修改会员积分");
									System.out.println();
									System.out.println("************************************************************");
									String xgkhxxXZFlag; 
									do {
										System.out.print("请选择，输入数字：");
										if(input.nextInt()==1) {
											System.out.print("请输入修改后的生日：");
											birthDay[temp] = input.next();
											System.out.println("生日信息已更改！");
										}else {
											System.out.print("请输入修改后的会员积分：");
											score[temp] = input.nextInt();
											System.out.println("会员积分已更改！");
										}
										System.out.println("是否修改其他属性(y/n):");
										xgkhxxXZFlag = input.next();
									} while(xgkhxxXZFlag.equals("y"));
									
									System.out.print("请按n返回上一级菜单");
									input.next();
									break;
									
								//查询客户信息
								case "4":
									System.out.println("我行我素购物管理系统> 客户信息管理> 查询客户信息");
									String jxcxFlag;
									do {
										System.out.print("请输入会员号：");
										temp = input.nextInt();
										for (int i = 0; i < vipNum.length; i++) {
											if(temp == vipNum[i]) {
												System.out.println("会员号\t\t\t生日\t\t\t积分");
												System.out.println("---------------|------------------|-----------------|");
												System.out.println(vipNum[i]+"\t\t\t"+birthDay[i]+"\t\t\t"+score[i]);
												break;
											}
											System.out.println("无此会员！");
										}
										System.out.print("要继续查询吗?(y/n)");
										jxcxFlag = input.next();
									}while(jxcxFlag.equals("y"));
									
									System.out.print("请按n返回上一级菜单");
									input.next();
									break;
									
								case "n":
									khxxglFlag = true;
									break;
								//返回上级菜单
								default:
									System.out.println("This is a wrong choice!");
									break;
								}
							}while(khxxglFlag == false);
					
						//购物结算(无内层选项)
						case "2": 
							//定义商品信息存储变量
							String[] allGoods = {"addidas运动鞋","Kappa网球裙","网球拍","addidasT恤","Nike运动鞋","Kappa网球","KappaT恤"};//全部商品
							double[] priceOfGoods = {300,200,300,500,900,50,150};  //各个商品单价
							
							//定义用户购买清单存储变量
							String[] goods = new String[10];  //商品名称
							double[] eachPrice = new double[10];  //单价
							int[] numbers = new int[10];  //个数
							double[] sumPrice = new double[10];  //金额
									
							double discount = 0.95;  //折扣		
							
							//输出商品列表信息
							System.out.println("***************************************************");
							System.out.println("请选择购买的商品编号：");
							System.out.println("1. addidas运动鞋");
							System.out.println("2. Kappa网球裙");
							System.out.println("3. 网球拍");
							System.out.println("4. addidasT恤");
							System.out.println("5. Nike运动鞋");
							System.out.println("6. Kappa网球");
							System.out.println("7. KappaT恤");
							System.out.println("***************************************************");
							System.out.println();
							
							//用户录入购买相关信息
							int vipNumForPurchase;
							
							String ifBuy = "";//是否继续购买标志位
							
							System.out.print("请输入会员号：");
							vipNumForPurchase = input.nextInt();
							int i = 0;
							int tempForGoodNum;
							do {
								System.out.print("请输入商品编号：");
								tempForGoodNum = input.nextInt();
								goods[i] = allGoods[tempForGoodNum-1];
								eachPrice[i] = priceOfGoods[tempForGoodNum-1];
								System.out.print("请输入数目：");
								numbers[i] = input.nextInt();
								sumPrice[i] = eachPrice[i] * numbers[i];  //计算金额
								
								i++;
								
								System.out.print("是否继续(y/n)：");
								ifBuy=input.next();
							}while(ifBuy.equals("y"));
							
							double sumOfsumPrice = 0.0;  //消费总计
							int points = 36; //积分
							
							System.out.println("*****************消费清单*****************");
							System.out.println("物品\t\t单价\t\t个数\t\t金额");
							for (int j = 0; j < goods.length; j++) {
								if(goods[j] != null) {
									System.out.println(goods[j] + "\t\t￥" + eachPrice[j] + "\t\t" + numbers[j] + "\t\t" + sumPrice[j]);
									sumOfsumPrice += sumPrice[j];
								} else
									break;
							}
							System.out.println("折扣：" + discount);
							System.out.println("金额总计：￥" + sumOfsumPrice*discount);
							System.out.print("实际交费：￥");
							
							double payment = input.nextDouble();  //实付款
							
							System.out.println("找钱：￥" + (payment-sumOfsumPrice*discount));
							
							System.out.println("本次购物所获的积分是：" + points);
							System.out.println("请按n返回上一级菜单");
							//input.hasNext();  //“直接跳过”的原因
							input.next();
							break;
							
						//真情回馈
						case "3":
							do {
								System.out.println("我行我素购物管理系统> 真情回馈");
								System.out.println("");
								System.out.println("********************************************************************************");
								System.out.println("");
								System.out.println("\t\t\t1. 幸 运 大 放 送");
								System.out.println("");
								System.out.println("\t\t\t2. 幸 运 抽 奖");
								System.out.println("");
								System.out.println("\t\t\t3. 生 日 问 候");
								System.out.println("");
								System.out.println("********************************************************************************");
								
								System.out.println("");
								System.out.println("请选择，输入数字或按n返回上一级菜单：");
								String choiceThirdForzqhk = input.next();
								
								switch(choiceThirdForzqhk){
								//幸运大放送
								case "1":
									System.out.println("我行我素购物管理系统> 真情回馈>幸运大放送");
									//找积分最大的客户
									int max = score[0];
									for (int j = 1; j < score.length; j++) {
										max = max>score[j]?max:score[j];
									}
									int theMark = Arrays.binarySearch(score,max);
									
									System.out.println("具有最高积分的会员是：" + vipNum[theMark] + "\t" + birthDay[theMark] + "\t" + score[theMark]);
									if(Math.random()<0.5)
										System.out.println("恭喜！获得礼品：一个价值12000元的苹果笔记本电脑！");
									else
										System.out.println("恭喜！获得礼品：一个价值3000元的小米电视！");
									break;
								//幸运抽奖	
								case "2":
									System.out.println("我行我素购物管理系统> 真情回馈>幸运抽奖");
									System.out.print("是否开始(y/n):");
									if(input.next().equals("y")) {
										int randomForLottery;
										for (int j = 0; j < vipNum.length; j++) {
											if(vipNum[j] / 100 % 10 == (int)Math.random())
												System.out.println("幸运客户获赠MP3：" + vipNum[j]);
										}
									}
										
									break;
								//生日问候
								case "3":
									System.out.println("我行我素购物管理系统> 真情回馈>生日问候");
									System.out.print("请输入今天的日期(月/日<用两位表示>)：");
									String tempForBirthday = input.next();
									boolean isFound = false;
									for (int j = 0; j < birthDay.length; j++) {
										if(tempForBirthday == birthDay[j]) {
											isFound = true;
											System.out.println("过生日的会员是：" + vipNum[j] + "\n恭喜！获赠MP3一个！");
										}
									}
									if(isFound == false)
										System.out.println("今天没有过生日的会员！");

									break;
								case "n":
									zqhkFlag = true;
									break;
								default:
									System.out.println("This is a wrong choice!");
									break;
								}
								
							} while (zqhkFlag == false);
							break;
						//注销
						case "4":
							System.out.println("此处为注销功能");
							break;
						case "n":
							wxwsgwglFlag = true;
							break;
						default:
							System.out.println("This is a wrong choice!");
							break;
						}
				}while (wxwsgwglFlag == false);
				break;
			case 2:
				System.out.println("更改管理员密码相关功能");  //执行功能2(更改管理员密码)
				break;
			case 3:
				System.out.println("Welcome the next usage.");  //执行功能3(退出)
				break;
			default:
				System.out.println("This is a wrong choice!");
				break;
			}
		} while (choiceFirst!=3);
		
	}
}

