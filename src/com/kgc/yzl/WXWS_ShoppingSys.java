package com.kgc.yzl;
//package com.yzl;

import java.util.Arrays;
import java.util.Scanner;

public class WXWS_ShoppingSys {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int choiceFirst;
		
		//���ڴ洢�û���Ϣ���ⲿ����
		int[] vipNum = new int[10];
		String[] birthDay = new String[10];
		int[] score = new int[10];
		
		int temp;
		
		do {
			//��һ������ʾ��Ϣ
			System.out.println("********************************************************************************");
			System.out.println("");
			System.out.println("\t\t\t1. �� ¼ ϵ ͳ");
			System.out.println("");
			System.out.println("\t\t\t2. �� �� �� �� Ա �� ��");
			System.out.println("");
			System.out.println("\t\t\t3. �� ��");
			System.out.println("");
			System.out.println("********************************************************************************");
			
			//�û�����
			System.out.print("��ѡ���������֣�");
			choiceFirst = input.nextInt();
//			input.close();  ???
			
			//�����û�ѡ��ִ�й���
			switch (choiceFirst) {
			case 1:
				System.out.print("�������û�����");
				String userName = input.next();
				System.out.print("���������룺");
				String passwd = input.next();
				
				System.out.println();  //ִ�й���1(��¼)
				
				boolean wxwsgwglFlag = false;//���ء��������ع������ϵͳ����־λ
				
				do {
					System.out.println("\t\t\t��ӭʹ���������ع������ϵͳ");
					System.out.println("");
					System.out.println("********************************************************************************");
					System.out.println("");
					System.out.println("\t\t\t1. �� �� �� Ϣ �� ��");
					System.out.println("");
					System.out.println("\t\t\t2. �� �� �� ��");
					System.out.println("");
					System.out.println("\t\t\t3. �� �� �� ��");
					System.out.println("");
					System.out.println("\t\t\t3. ע ��");
					System.out.println("");
					System.out.println("********************************************************************************");
					
					boolean khxxglFlag = false;  //�ص����ͻ���Ϣ��������ı�־λ
					boolean zqhkFlag = false;  //�ص����������������ı�־λ
					
					System.out.print("��ѡ���������֣�");
					String choiceSecond = input.next();  //ֱ����������������
	//				input.close();  ???
						switch (choiceSecond) {
						//�ͻ���Ϣ����
						case "1":
							do {
								System.out.println("�������ع������ϵͳ> �ͻ���Ϣ����");
								System.out.println("");
								System.out.println("********************************************************************************");
								System.out.println("");
								System.out.println("\t\t\t1. �� ʾ �� �� �� �� �� Ϣ");
								System.out.println("");
								System.out.println("\t\t\t2. �� �� �� �� �� Ϣ");
								System.out.println("");
								System.out.println("\t\t\t3. �� �� �� �� �� Ϣ");
								System.out.println("");
								System.out.println("\t\t\t3. �� ѯ �� �� �� Ϣ");
								System.out.println("");
								System.out.println("********************************************************************************");
								
								System.out.println("");
								System.out.println("��ѡ���������ֻ�n������һ���˵���");
								String choiceThirdForkhxxgl = input.next();
								
								switch (choiceThirdForkhxxgl) {
								//��ʾ�ͻ���Ϣ
								case "1":
									System.out.println("�������ع������ϵͳ> �ͻ���Ϣ����> ��ʾ���пͻ���Ϣ");
									System.out.println("��Ա��\t\t\t����\t\t\t����");
									System.out.println("---------------|------------------|-----------------|");
									for (int i = 0; i < vipNum.length && birthDay[i] != null; i++) {
										System.out.println(vipNum[i]+"\t\t\t"+birthDay[i]+"\t\t\t"+score[i]);
									}
									
									System.out.print("�밴n������һ���˵�");
									String choiceForth = input.next(); //��ʱû����������
									
								/*	if(choiceForth == "n")
										//������һ���˵�
										continue;
									else
										System.out.println("This is an wrong choice!");*/
										
									break;
									
								//��ӿͻ���Ϣ
								case "2":
									System.out.println("�������ع������ϵͳ> �ͻ���Ϣ����> ��ӿͻ���Ϣ");
									for (int i = 0; i < vipNum.length; i++) {
										if(vipNum[i] == 0) {
											System.out.print("�������Ա�ţ�");
											temp = input.nextInt();
											if(temp <1000 ||temp>9999) {
												System.out.println("�ͻ���"+temp+"����Ч�Ļ�Ա�ţ�\n¼����Ϣʧ��");
												System.out.print("������ӻ�Ա��(y/n)");
												if(input.next().equals("n"))
													break;
												i--;
											} else {
												vipNum[i] = temp;
												System.out.print("�������Ա����(��/��<����λ����ʾ>)��");
												birthDay[i] = input.next();
												System.out.print("��������֣�");
												score[i] = input.nextInt();
												System.out.print("�»�Ա��ӳɹ���");
												System.out.print("������ӻ�Ա��(y/n)");
												if(input.next().equals("n"))
													break;
											}			
										}
									}
									System.out.print("�밴n������һ���˵�");
									input.next();
									break;
									
								//�޸Ŀͻ���Ϣ
								case "3":
									System.out.println("�������ع������ϵͳ> �ͻ���Ϣ����> ��ӿͻ���Ϣ");
									System.out.print("�������Ա�ţ�");
									temp = input.nextInt();
									for (int i = 0; i < vipNum.length; i++) {
										if(temp == vipNum[i]) {
											temp = i;
											System.out.println("��Ա��\t\t\t����\t\t\t����");
											System.out.println("---------------|------------------|-----------------|");
											System.out.println(vipNum[i]+"\t\t\t"+birthDay[i]+"\t\t\t"+score[i]);
											break;
										}
										System.out.println("�޴˻�Ա��");
									}
									System.out.println("************************************************************");
									System.out.println();
									System.out.println("\t\t\t1. �޸Ļ�Ա����");
									System.out.println();
									System.out.println("\t\t\t1. �޸Ļ�Ա����");
									System.out.println();
									System.out.println("************************************************************");
									String xgkhxxXZFlag; 
									do {
										System.out.print("��ѡ���������֣�");
										if(input.nextInt()==1) {
											System.out.print("�������޸ĺ�����գ�");
											birthDay[temp] = input.next();
											System.out.println("������Ϣ�Ѹ��ģ�");
										}else {
											System.out.print("�������޸ĺ�Ļ�Ա���֣�");
											score[temp] = input.nextInt();
											System.out.println("��Ա�����Ѹ��ģ�");
										}
										System.out.println("�Ƿ��޸���������(y/n):");
										xgkhxxXZFlag = input.next();
									} while(xgkhxxXZFlag.equals("y"));
									
									System.out.print("�밴n������һ���˵�");
									input.next();
									break;
									
								//��ѯ�ͻ���Ϣ
								case "4":
									System.out.println("�������ع������ϵͳ> �ͻ���Ϣ����> ��ѯ�ͻ���Ϣ");
									String jxcxFlag;
									do {
										System.out.print("�������Ա�ţ�");
										temp = input.nextInt();
										for (int i = 0; i < vipNum.length; i++) {
											if(temp == vipNum[i]) {
												System.out.println("��Ա��\t\t\t����\t\t\t����");
												System.out.println("---------------|------------------|-----------------|");
												System.out.println(vipNum[i]+"\t\t\t"+birthDay[i]+"\t\t\t"+score[i]);
												break;
											}
											System.out.println("�޴˻�Ա��");
										}
										System.out.print("Ҫ������ѯ��?(y/n)");
										jxcxFlag = input.next();
									}while(jxcxFlag.equals("y"));
									
									System.out.print("�밴n������һ���˵�");
									input.next();
									break;
									
								case "n":
									khxxglFlag = true;
									break;
								//�����ϼ��˵�
								default:
									System.out.println("This is a wrong choice!");
									break;
								}
							}while(khxxglFlag == false);
					
						//�������(���ڲ�ѡ��)
						case "2": 
							//������Ʒ��Ϣ�洢����
							String[] allGoods = {"addidas�˶�Ь","Kappa����ȹ","������","addidasT��","Nike�˶�Ь","Kappa����","KappaT��"};//ȫ����Ʒ
							double[] priceOfGoods = {300,200,300,500,900,50,150};  //������Ʒ����
							
							//�����û������嵥�洢����
							String[] goods = new String[10];  //��Ʒ����
							double[] eachPrice = new double[10];  //����
							int[] numbers = new int[10];  //����
							double[] sumPrice = new double[10];  //���
									
							double discount = 0.95;  //�ۿ�		
							
							//�����Ʒ�б���Ϣ
							System.out.println("***************************************************");
							System.out.println("��ѡ�������Ʒ��ţ�");
							System.out.println("1. addidas�˶�Ь");
							System.out.println("2. Kappa����ȹ");
							System.out.println("3. ������");
							System.out.println("4. addidasT��");
							System.out.println("5. Nike�˶�Ь");
							System.out.println("6. Kappa����");
							System.out.println("7. KappaT��");
							System.out.println("***************************************************");
							System.out.println();
							
							//�û�¼�빺�������Ϣ
							int vipNumForPurchase;
							
							String ifBuy = "";//�Ƿ���������־λ
							
							System.out.print("�������Ա�ţ�");
							vipNumForPurchase = input.nextInt();
							int i = 0;
							int tempForGoodNum;
							do {
								System.out.print("��������Ʒ��ţ�");
								tempForGoodNum = input.nextInt();
								goods[i] = allGoods[tempForGoodNum-1];
								eachPrice[i] = priceOfGoods[tempForGoodNum-1];
								System.out.print("��������Ŀ��");
								numbers[i] = input.nextInt();
								sumPrice[i] = eachPrice[i] * numbers[i];  //������
								
								i++;
								
								System.out.print("�Ƿ����(y/n)��");
								ifBuy=input.next();
							}while(ifBuy.equals("y"));
							
							double sumOfsumPrice = 0.0;  //�����ܼ�
							int points = 36; //����
							
							System.out.println("*****************�����嵥*****************");
							System.out.println("��Ʒ\t\t����\t\t����\t\t���");
							for (int j = 0; j < goods.length; j++) {
								if(goods[j] != null) {
									System.out.println(goods[j] + "\t\t��" + eachPrice[j] + "\t\t" + numbers[j] + "\t\t" + sumPrice[j]);
									sumOfsumPrice += sumPrice[j];
								} else
									break;
							}
							System.out.println("�ۿۣ�" + discount);
							System.out.println("����ܼƣ���" + sumOfsumPrice*discount);
							System.out.print("ʵ�ʽ��ѣ���");
							
							double payment = input.nextDouble();  //ʵ����
							
							System.out.println("��Ǯ����" + (payment-sumOfsumPrice*discount));
							
							System.out.println("���ι�������Ļ����ǣ�" + points);
							System.out.println("�밴n������һ���˵�");
							//input.hasNext();  //��ֱ����������ԭ��
							input.next();
							break;
							
						//�������
						case "3":
							do {
								System.out.println("�������ع������ϵͳ> �������");
								System.out.println("");
								System.out.println("********************************************************************************");
								System.out.println("");
								System.out.println("\t\t\t1. �� �� �� �� ��");
								System.out.println("");
								System.out.println("\t\t\t2. �� �� �� ��");
								System.out.println("");
								System.out.println("\t\t\t3. �� �� �� ��");
								System.out.println("");
								System.out.println("********************************************************************************");
								
								System.out.println("");
								System.out.println("��ѡ���������ֻ�n������һ���˵���");
								String choiceThirdForzqhk = input.next();
								
								switch(choiceThirdForzqhk){
								//���˴����
								case "1":
									System.out.println("�������ع������ϵͳ> �������>���˴����");
									//�һ������Ŀͻ�
									int max = score[0];
									for (int j = 1; j < score.length; j++) {
										max = max>score[j]?max:score[j];
									}
									int theMark = Arrays.binarySearch(score,max);
									
									System.out.println("������߻��ֵĻ�Ա�ǣ�" + vipNum[theMark] + "\t" + birthDay[theMark] + "\t" + score[theMark]);
									if(Math.random()<0.5)
										System.out.println("��ϲ�������Ʒ��һ����ֵ12000Ԫ��ƻ���ʼǱ����ԣ�");
									else
										System.out.println("��ϲ�������Ʒ��һ����ֵ3000Ԫ��С�׵��ӣ�");
									break;
								//���˳齱	
								case "2":
									System.out.println("�������ع������ϵͳ> �������>���˳齱");
									System.out.print("�Ƿ�ʼ(y/n):");
									if(input.next().equals("y")) {
										int randomForLottery;
										for (int j = 0; j < vipNum.length; j++) {
											if(vipNum[j] / 100 % 10 == (int)Math.random())
												System.out.println("���˿ͻ�����MP3��" + vipNum[j]);
										}
									}
										
									break;
								//�����ʺ�
								case "3":
									System.out.println("�������ع������ϵͳ> �������>�����ʺ�");
									System.out.print("��������������(��/��<����λ��ʾ>)��");
									String tempForBirthday = input.next();
									boolean isFound = false;
									for (int j = 0; j < birthDay.length; j++) {
										if(tempForBirthday == birthDay[j]) {
											isFound = true;
											System.out.println("�����յĻ�Ա�ǣ�" + vipNum[j] + "\n��ϲ������MP3һ����");
										}
									}
									if(isFound == false)
										System.out.println("����û�й����յĻ�Ա��");

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
						//ע��
						case "4":
							System.out.println("�˴�Ϊע������");
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
				System.out.println("���Ĺ���Ա������ع���");  //ִ�й���2(���Ĺ���Ա����)
				break;
			case 3:
				System.out.println("Welcome the next usage.");  //ִ�й���3(�˳�)
				break;
			default:
				System.out.println("This is a wrong choice!");
				break;
			}
		} while (choiceFirst!=3);
		
	}
}

