package test01;

import java.util.Scanner;

/**
 * �Ի����˶���ϵͳ
 * 
 * @param args
 */
public class OrderForm {

	public static void main(String[] args) {
		// ��������:һ�鶩����Ϣ
		String[] names = new String[4];// ������
		String[] dishMegs = new String[4];// ������Ʒ��Ϣ
		int[] times = new int[4];// ����ʱ��
		String[] addresses = new String[4];// �Ͳ͵�ַ
		int[] states = new int[4];// ����״̬ 0:��Ԥ��;1:�����
		double[] sumPrices = new double[4];// �ܽ��

		// ��ʼ������������Ϣ
		names[0] = "����";
		dishMegs[0] = "������˿1��";
		times[0] = 12;
		addresses[0] = "���·207";
		states[0] = 0;
		sumPrices[0] = 24.0;

		names[1] = "����";
		dishMegs[1] = "���մ���2��";
		times[1] = 12;
		addresses[1] = "���·207";
		states[1] = 1;
		sumPrices[1] = 76.0;

		// ��������:һ���Ʒ��Ϣ
		String[] dishNames = { "���մ���", "������˿", "ʱ���߲�" };
		double[] prices = { 38.0, 18.0, 10.0 };
		int[] praiseNums = new int[3];
		/*
		 * ѭ��(do-while)
		 */
		Scanner sc = new Scanner(System.in);
		int num = -1; // ��¼�û����������

		do {
			// ѭ������
			// ��ʾ���˵�

			System.out.println("*****************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("*****************");
			// ��ʾ�û�������,��ִ����Ӧ����
			System.out.println("��ѡ��:");
			int choose = sc.nextInt();
			boolean isAdd = false;// true:��¼�ҵ�һ��Ϊ�յ�λ��,���Բ��� false:û���ҵ�
			switch (choose) {
			case 1:
				// 1.��Ҫ����
				System.out.println("****��Ҫ����****");
				// 1.����Ҫ�����λ��
				for (int i = 0; i < names.length; i++) {
					// ����ҵ�Ϊ�յ�λ�ü�¼����
					if (names[i] == null) {
						isAdd = true;// ��¼���ҵ�һ��Ϊ�յ�λ��
						// ִ�в������
						// a.��ʾ���пɹ�ѡ��Ĳ�Ʒ��Ϣ
						System.out.println("���" + "\t" + "����" + "\t" + "����"
								+ "\t" + "������");
						for (int j = 0; j < dishNames.length; j++) {
							String price = prices[j] + "Ԫ";
							String praise = praiseNums[j] + "��";
							System.out.println((j + 1) + "\t" + dishNames[j]
									+ "\t" + price + "\t" + praise);

						}
						// ������ѡ��Ʒ����Լ�����
						System.out.print("��ѡ��������Ʒ���:");
						int chooseDish = sc.nextInt();
						System.out.print("��ѡ����������:");
						int number = sc.nextInt();
						String dishMeg = dishNames[chooseDish - 1] + " "
								+ number + "��";

						// b.���붩��������
						System.out.print("�����붩��������:");
						String name = sc.next();

						// c.�����Ͳ�ʱ��
						System.out.println("�������Ͳ�ʱ��(10~20�����Ͳ�):");
						int time = sc.nextInt();
						// ����������,�ظ�����
						while (time < 10 || time > 20) {
							System.out.println("�Բ���,������������,������10~20�������:");
							time = sc.nextInt();

						}
						// d.�����Ͳ͵�ַ
						System.out.print("�������Ͳ͵�ַ:");
						String address = sc.next();

						// e.����ͷ�
						double sumPrice = prices[chooseDish - 1] * number;
						// �Ͳͷ�,���ͷѴﵽ50Ԫʱ,��6Ԫ�ͷ�
						double deliCharge = sumPrice > 50 ? 0.0 : 6.0;

						// ��ʾ������Ϣ
						System.out.println("���ͳɹ�!");
						System.out.println("��������:" + dishMeg);
						System.out.println("������:" + name);
						System.out.println("�Ͳ�ʱ��:" + time + "��");
						System.out.println("�Ͳ͵�ַ:" + address);
						System.out.println("�ͷ�:" + sumPrice + ",�Ͳͷ�:"
								+ deliCharge + "Ԫ");
						System.out.println("�ܽ��:" + (sumPrice + deliCharge)
								+ "Ԫ");
						
						// ��������
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice + deliCharge;

						break;
					}
				}

				// ���û���ҵ�Ϊ�յ�λ��,����ʾ��Ϣ
				if (!isAdd) {
					System.out.println("�Բ���,���Ĳʹ�����!");
					break;
				}
			case 2:
				// 2.�鿴�ʹ�
				System.out.println("****�鿴�ʹ�****");
				System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t����״̬");
				// ��������
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String time = times[i] + "��";
						String sumPrice = sumPrices[i] + "Ԫ";
						String state = states[i] == 0 ? "��Ԥ��" : "�����";
						System.out.println((i + 1) + "\t" + names[i] + "\t"
										+ dishMegs[i] + "\t" + time + "\t"
										+ addresses[i] + "\t" + sumPrice + "\t"
										+ state);
					}
				}

				break;
			case 3:
				// 3.ǩ�ն���
				System.out.println("****ǩ�ն���****");
				//Ҫ���û�����һ��ǩ�յĶ������
				System.out.print("������Ҫǩ�յĶ������:");
				int signOrderId=sc.nextInt();
				boolean isFind=false;//��¼�Ƿ��ҵ�����������true�����ҵ�	false:û���ҵ�
				//������������(����ѭ��)
				for(int i=0;i<names.length;i++){
					//1���ҵ�,״̬�������(�Ѿ�ǩ�����):��ʾ������ǩ��
					//2���ҵ�,״̬����Ԥ��(ô�����ǩ��)������ǩ��
					if(names[i]!=null && states[i]==1 && signOrderId==i+1) {
						System.out.println("�Բ���,��ѡ��Ķ��������ǩ��,�����ٴ�ǩ��!");
						isFind=true;
						break;
					}else if(names[i]!=null && states[i]==0 && signOrderId==i+1){
						states[i]=1;//״ֵ̬��Ϊ�����״̬
						System.out.println("����ǩ�ճɹ�!");
						isFind=true;
						break;
					}
				}
				//�����ж�:���û���ҵ���������,��ȥ��ʾû���ҵ�
				//3��û�ҵ�:��ʾ��Ϣû�ҵ�
				if(!isFind){
					System.out.println("�Բ���,�˶���������!");
				}
				break;
			case 4:
				// 4.ɾ������
				//1.����Ҫɾ���Ķ������(��1��ʼ)
				System.out.println("****ɾ������****");
				System.out.print("������Ҫɾ���Ķ������:");
				int delId=sc.nextInt();
				int delIndex=-1;//ɾ�������±�
				boolean isDelFind=false;//��¼�Ƿ��ҵ���������		true:�ҵ���	false:û�ҵ�
				//2.ѭ��������������
				for(int i=0;i<names.length;i++){
					//	�ҵ��˶���,��ǩ��:ִ��ɾ������(�ȼ�¼Ҫɾ���Ķ������)
					//	�ҵ��˴�����,����δǩ��:��ʾ��Ϣ
					if(names[i]!=null && states[i]==1 && delId==i+1){
						delIndex=i;
						isDelFind=true;
						break;
					}else if(names[i]!=null && states[i]==0 && delId==i+1){
						System.out.println("��ѡ��Ķ���δǩ��,����ɾ��");
						isDelFind=true;
						break;
					}
				}
				//	δ�ҵ��˶���:��ʾ��Ϣ
				if(!isDelFind){
					System.out.println("�Բ���,��������������");
				}
				//ִ��ɾ������
				if(delIndex!=-1){
					//ɾ������(ѭ����λ)
				//��Ҫɾ����Ԫ�غ���һ����ʼ,���������һ��Ԫ��������ǰ�ƶ�һλ
					for(int j=delIndex+1;j<=names.length-1;j++){
						names[j-1]=names[j];
						dishMegs[j-1]=dishMegs[j];
						times[j-1]=times[j];
						addresses[j-1]=addresses[j];
						states[j-1]=states[j];
					}
					//���һλ���
					names[names.length-1]=null;
					dishMegs[names.length-1]=null;
					times[names.length-1]=0;
					addresses[names.length-1]=null;
					states[names.length-1]=0;
					System.out.println("����ɾ���ɹ�!");
				}
				break;
			case 5:
				// 5.��Ҫ����
				System.out.println("****��Ҫ����****");
				//	1.��ʾ�����޵Ĳ�Ʒ�б�
				System.out.println("���" + "\t" + "����" + "\t" + "����"+"\t"+"������");
				for (int j = 0; j < dishNames.length; j++) {
					String price = prices[j] + "Ԫ";
					String praise = praiseNums[j] + "��";
					System.out.println((j + 1) + "\t" + dishNames[j]
							+ "\t" + price + "\t" + praise);

				}
				//	2.����Ҫ���޵Ĳ�Ʒ���
				System.out.print("������Ҫ���޵Ĳ�Ʒ���:");
				int dishId=sc.nextInt();
				//	3.����ŵĲ�Ʒ��������1
				praiseNums[dishId-1]++;
				//	4.��ʾ
				System.out.println("���޳ɹ�!");
				System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"��");
				break;
			case 6:
				// 6.�˳�ϵͳ
			default:
				break;
			}
			// ���û�����Ĺ��ܱ��Ϊ1~5֮���������,�˳�ѭ��,������ʾ����0����
			if (choose < 1 || choose > 5) {
				break;
			} else {
				// ��ʾ����0����
				System.out.println("����0����:");
				num = sc.nextInt();
			}
		} while (num == 0);
		System.out.println("ллʹ��,��ӭ�´ι���!");
	}
}