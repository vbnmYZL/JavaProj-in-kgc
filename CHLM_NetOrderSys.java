package com.yzl;
/**
 * �Ի����˶���ϵͳ
 * @author YZL
 */
import java.util.Scanner;

public class CHLM_NetOrderSys {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean isExit = false; //���������־λ
		int mainMenuR = -1; //�������˵���־λ
		
		//�����������ڴ洢���ṩ�Ĳ�Ʒ��Ϣ
		String[] dishName = {"������","������","����"};          //��Ʒ����
		double[] price = new double[] {48.0, 33.0, 14.0};   //��Ʒ�۸�
		int[] praiseNums = new int[3];                      //������
		
		//�����������ڴ洢�ͻ��Ķ�����Ϣ(10��)
		String[] names = new String[10];   //�ͻ�����   
		int[][] dishMegs = new int[10][2]; // ��ά�������ڴ洢�����Ʒ�����Ӧ�ķ���,dishMegs[x][0]Ϊ��Ʒ��ţ�dishMegs[x][1]Ϊ����
		int[] times = new int[10];
		String[] address = new String[10];
		int[] states = new int[10];  //���涩��״̬��0��ʾ��Ԥ����1��ʾ�����
		double[] sumPrices = new double[10];  //ÿ�ʶ����ܼ�
		
//		int currentLoc = 0; //���ڶ�λ��ǰ�����Ķ���λ��
		
		System.out.println("��ӭʹ�á��Ի����˶���ϵͳ��");
		
		do {
			System.out.println("*********************************");
			System.out.println("1����Ҫ����");
			System.out.println("2���鿴�ʹ�");
			System.out.println("3��ǩ�ն���");
			System.out.println("4��ɾ������");
			System.out.println("5����Ҫ����");
			System.out.println("6���˳�ϵͳ");
			System.out.println("*********************************");
			
			System.out.print("��ѡ��");
			int choice1lev = input.nextInt();
		
			switch (choice1lev) {
			case 1:
				//����ϵͳ
				System.out.println("***��Ҫ����***");
				boolean isAdd = false;  //��¼�Ƿ���Զ���(�Ƿ��ж��Ϳ�λ)
				
				//�û����붩����Ϣ
				for (int i = 0; i < names.length; i++) {
					if(names[i] == null) {
						isAdd = true;
						System.out.print("�����붩����������");
						names[i]=input.next();
						System.out.println("���\t����\t����\t������");
						for (int j = 0; j < dishName.length; j++) {
							System.out.println((j+1) + "\t" + dishName[j]+"\t"+ price[j] + "\t" + praiseNums[j]);
						}
						System.out.print("��ѡ����Ҫ��Ĳ�Ʒ��ţ�");
						dishMegs[i][0]=input.nextInt();
						System.out.print("��ѡ������Ҫ�ķ�����");
						dishMegs[i][1]=input.nextInt();
						//�����ܽ��(���Ͳͷ�)
						//�����Ͳͷ�
						if(price[dishMegs[i][0]-1] * dishMegs[i][0]>=50)
							sumPrices[i] = price[dishMegs[i][0]-1] * dishMegs[i][0];
						//	System.out.println("�ͷѣ�" + sumPrices[i] + "���Ͳͷ�0.0Ԫ���ܼƣ�" + sumPrices[i] + "Ԫ��");
						else
							sumPrices[i] = price[dishMegs[i][0]-1] * dishMegs[i][0] + 5;
						//	System.out.println("�ͷѣ�" + sumPrices[i] + "���Ͳͷ�5Ԫ���ܼƣ�" + (sumPrices[i]+5) + "Ԫ��");
						sumPrices[i] = price[dishMegs[i][0]-1] * dishMegs[i][0];
						System.out.print("�������Ͳ�ʱ��(�Ͳ�ʱ��Ϊ10����20��������Ͳ�)");
						while(!input.hasNextInt()) {
							System.out.println("���������������");
							input = new Scanner(System.in);
						}
						int time=input.nextInt();
						while (time<10||time>20) {
							System.out.println("������������������10��20������");
							time = input.nextInt();
						}
						times[i] = time;
						System.out.print("�������Ͳ͵�ַ��");
						address[i] = input.next();
						states[i] = 0;
						System.out.println("���ͳɹ�");
						System.out.println("�������ǣ�" + dishName[dishMegs[i][0]-1] + dishMegs[i][0] + "��");
						System.out.println("�Ͳ�ʱ�䣺" + times[i] + "��");
						//�����ܽ��(���Ͳͷ�)
						//�����Ͳͷ�
						if(price[dishMegs[i][0]-1] * dishMegs[i][0]>=50)
							System.out.println("�ͷѣ�" + sumPrices[i] + "���Ͳͷ�0.0Ԫ���ܼƣ�" + sumPrices[i] + "Ԫ��");
						else
							System.out.println("�ͷѣ�" + (sumPrices[i] - 5) + "���Ͳͷ�5Ԫ���ܼƣ�" + sumPrices[i] + "Ԫ��");
						break;
					}
				}
				if(!isAdd) {
					System.out.println("�Բ������Ĳʹ�����");
				}				
				break;
			case 2:
				//�鿴�ʹ�ϵͳ
				System.out.println("***�鿴�ʹ�***");
				System.out.println("���\t������\t��Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
				for (int currentRecord = 0; names[currentRecord] != null && currentRecord < names.length; currentRecord++) {
					System.out.println((currentRecord+1) + "\t" + names[currentRecord] + "\t" + dishName[dishMegs[currentRecord][0]-1] 
							+ dishMegs[currentRecord][0] + "��\t" + times[currentRecord] + "��\t" + address[currentRecord] + "\t" +
							sumPrices[currentRecord] + "\t" + (states[currentRecord]==0?"��Ԥ��":"�����"));
				}
				if(names[0] == null)
					System.out.println("�޶�����¼");
				break;
			case 3:
				//ǩ�ն���ϵͳ
				System.out.println("***ǩ�ն���***");
				System.out.print("��ѡ��Ҫǩ�յĶ�����ţ�");
				int signNum = input.nextInt();
				boolean isSignFound = false;
				for (int currentRecord = 0; names[currentRecord] != null && currentRecord < names.length; currentRecord++) {
					if(currentRecord == (signNum-1)) {
						states[currentRecord] = 1;
						System.out.println("����ǩ�ճɹ���");
						isSignFound = true;
						break;
					}
				}
				if(isSignFound == false)
					System.out.println("��ѡ��Ķ��������ڣ�");
				break;
			case 4:
				//ɾ������ϵͳ������ɾ��������ɡ�״̬�µĶ�����
				System.out.println("***ɾ������***");
				System.out.print("��ѡ��Ҫɾ���Ķ�����ţ�");
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
							System.out.println("ɾ�������ɹ�");
						}else
							System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
						isDeleteFound = true;
						break;	
					}
				}
				if(isDeleteFound == false)
					System.out.println("��ѡ��Ķ��������ڣ�");
				break;
			case 5:
				//����ϵͳ
				System.out.println("***��Ҫ����***");
				//��ʾ��Ʒ�б�
				System.out.println("���\t����\t����\t������");
				for (int j = 0; j < dishName.length; j++) {
					System.out.println((j+1) + "\t" + dishName[j]+"\t"+ price[j] + "\t" + praiseNums[j]);
				}
				System.out.print("��ѡ����Ҫ���޵Ĳ�Ʒ��ţ�");
				int praiseNum = input.nextInt();
				praiseNums[praiseNum-1]++;
				System.out.println("���޳ɹ���");
				break;
			case 6:
				//�˳�ϵͳ
				isExit =true;
				break;
			default:
				System.out.println("¼��ѡ������������¼��");
				continue;
			}
			if(!isExit) {
				System.out.print("����0���أ�");
				mainMenuR=input.nextInt();
				while(mainMenuR!=0) {
					System.out.println("������0�����ϼ��˵�");
					mainMenuR=input.nextInt();
				}		
			} else {
				break;
			}
		} while(mainMenuR==0);
		
		input.close();
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
			
		
	}
}
