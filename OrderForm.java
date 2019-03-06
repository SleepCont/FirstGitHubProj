package test01;

import java.util.Scanner;

/**
 * 吃货联盟订餐系统
 * 
 * @param args
 */
public class OrderForm {

	public static void main(String[] args) {
		// 数据主体:一组订餐信息
		String[] names = new String[4];// 订餐人
		String[] dishMegs = new String[4];// 所订餐品信息
		int[] times = new int[4];// 订餐时间
		String[] addresses = new String[4];// 送餐地址
		int[] states = new int[4];// 订餐状态 0:已预订;1:已完成
		double[] sumPrices = new double[4];// 总金额

		// 初始化两条订单信息
		names[0] = "张晴";
		dishMegs[0] = "鱼香肉丝1份";
		times[0] = 12;
		addresses[0] = "天成路207";
		states[0] = 0;
		sumPrices[0] = 24.0;

		names[1] = "张晴";
		dishMegs[1] = "红烧带鱼2份";
		times[1] = 12;
		addresses[1] = "天成路207";
		states[1] = 1;
		sumPrices[1] = 76.0;

		// 数组主体:一组餐品信息
		String[] dishNames = { "红烧带鱼", "鱼香肉丝", "时令蔬菜" };
		double[] prices = { 38.0, 18.0, 10.0 };
		int[] praiseNums = new int[3];
		/*
		 * 循坏(do-while)
		 */
		Scanner sc = new Scanner(System.in);
		int num = -1; // 记录用户输入的数字

		do {
			// 循环操作
			// 显示主菜单

			System.out.println("*****************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("*****************");
			// 提示用户输入标号,并执行相应功能
			System.out.println("请选择:");
			int choose = sc.nextInt();
			boolean isAdd = false;// true:记录找到一个为空的位置,可以插入 false:没有找到
			switch (choose) {
			case 1:
				// 1.我要订餐
				System.out.println("****我要订餐****");
				// 1.查找要插入的位置
				for (int i = 0; i < names.length; i++) {
					// 如果找到为空的位置记录下来
					if (names[i] == null) {
						isAdd = true;// 记录已找到一个为空的位置
						// 执行插入操作
						// a.显示所有可供选择的餐品信息
						System.out.println("序号" + "\t" + "菜名" + "\t" + "单价"
								+ "\t" + "点赞数");
						for (int j = 0; j < dishNames.length; j++) {
							String price = prices[j] + "元";
							String praise = praiseNums[j] + "赞";
							System.out.println((j + 1) + "\t" + dishNames[j]
									+ "\t" + price + "\t" + praise);

						}
						// 输入所选餐品编号以及份数
						System.out.print("请选择所订餐品序号:");
						int chooseDish = sc.nextInt();
						System.out.print("请选择所订份数:");
						int number = sc.nextInt();
						String dishMeg = dishNames[chooseDish - 1] + " "
								+ number + "份";

						// b.输入订餐人姓名
						System.out.print("请输入订餐人姓名:");
						String name = sc.next();

						// c.输入送餐时间
						System.out.println("请输入送餐时间(10~20整点送餐):");
						int time = sc.nextInt();
						// 如果输入错误,重复输入
						while (time < 10 || time > 20) {
							System.out.println("对不起,您的输入有误,请输入10~20间的整数:");
							time = sc.nextInt();

						}
						// d.输入送餐地址
						System.out.print("请输入送餐地址:");
						String address = sc.next();

						// e.计算餐费
						double sumPrice = prices[chooseDish - 1] * number;
						// 送餐费,当餐费达到50元时,免6元餐费
						double deliCharge = sumPrice > 50 ? 0.0 : 6.0;

						// 显示订单信息
						System.out.println("订餐成功!");
						System.out.println("您订的是:" + dishMeg);
						System.out.println("订餐人:" + name);
						System.out.println("送餐时间:" + time + "点");
						System.out.println("送餐地址:" + address);
						System.out.println("餐费:" + sumPrice + ",送餐费:"
								+ deliCharge + "元");
						System.out.println("总金额:" + (sumPrice + deliCharge)
								+ "元");
						
						// 保存数据
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice + deliCharge;

						break;
					}
				}

				// 如果没有找到为空的位置,则提示信息
				if (!isAdd) {
					System.out.println("对不起,您的餐袋已满!");
					break;
				}
			case 2:
				// 2.查看餐带
				System.out.println("****查看餐袋****");
				System.out.println("序号\t订餐人\t所订餐品信息\t送餐时间\t送餐地址\t\t总金额\t订单状态");
				// 遍历数组
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String time = times[i] + "点";
						String sumPrice = sumPrices[i] + "元";
						String state = states[i] == 0 ? "已预订" : "已完成";
						System.out.println((i + 1) + "\t" + names[i] + "\t"
										+ dishMegs[i] + "\t" + time + "\t"
										+ addresses[i] + "\t" + sumPrice + "\t"
										+ state);
					}
				}

				break;
			case 3:
				// 3.签收订单
				System.out.println("****签收订单****");
				//要求用户输入一个签收的订单序号
				System.out.print("请输入要签收的订单序号:");
				int signOrderId=sc.nextInt();
				boolean isFind=false;//记录是否找到了这条订单true：已找到	false:没有找到
				//查找这条订单(遍历循环)
				for(int i=0;i<names.length;i++){
					//1、找到,状态是已完成(已经签收完毕):提示不能再签收
					//2、找到,状态是已预订(么有完成签收)：可以签收
					if(names[i]!=null && states[i]==1 && signOrderId==i+1) {
						System.out.println("对不起,您选择的订单已完成签收,不能再次签收!");
						isFind=true;
						break;
					}else if(names[i]!=null && states[i]==0 && signOrderId==i+1){
						states[i]=1;//状态值改为已完成状态
						System.out.println("订单签收成功!");
						isFind=true;
						break;
					}
				}
				//条件判断:如果没有找到这条订单,才去提示没有找到
				//3、没找到:提示信息没找到
				if(!isFind){
					System.out.println("对不起,此订单不存在!");
				}
				break;
			case 4:
				// 4.删除订单
				//1.输入要删除的订单序号(从1开始)
				System.out.println("****删除订单****");
				System.out.print("请输入要删除的订单序号:");
				int delId=sc.nextInt();
				int delIndex=-1;//删除订单下标
				boolean isDelFind=false;//记录是否找到此条订单		true:找到了	false:没找到
				//2.循环查找这条订单
				for(int i=0;i<names.length;i++){
					//	找到此订单,已签收:执行删除操作(先记录要删除的订单序号)
					//	找到此处订单,切且未签收:提示信息
					if(names[i]!=null && states[i]==1 && delId==i+1){
						delIndex=i;
						isDelFind=true;
						break;
					}else if(names[i]!=null && states[i]==0 && delId==i+1){
						System.out.println("您选择的订单未签收,不能删除");
						isDelFind=true;
						break;
					}
				}
				//	未找到此订单:提示信息
				if(!isDelFind){
					System.out.println("对不起,此条订单不存在");
				}
				//执行删除操作
				if(delIndex!=-1){
					//删除操作(循环移位)
				//从要删除的元素后面一个开始,到数组最后一个元素依次向前移动一位
					for(int j=delIndex+1;j<=names.length-1;j++){
						names[j-1]=names[j];
						dishMegs[j-1]=dishMegs[j];
						times[j-1]=times[j];
						addresses[j-1]=addresses[j];
						states[j-1]=states[j];
					}
					//最后一位清空
					names[names.length-1]=null;
					dishMegs[names.length-1]=null;
					times[names.length-1]=0;
					addresses[names.length-1]=null;
					states[names.length-1]=0;
					System.out.println("订单删除成功!");
				}
				break;
			case 5:
				// 5.我要点赞
				System.out.println("****我要点赞****");
				//	1.显示供点赞的餐品列表
				System.out.println("序号" + "\t" + "菜名" + "\t" + "单价"+"\t"+"点赞数");
				for (int j = 0; j < dishNames.length; j++) {
					String price = prices[j] + "元";
					String praise = praiseNums[j] + "赞";
					System.out.println((j + 1) + "\t" + dishNames[j]
							+ "\t" + price + "\t" + praise);

				}
				//	2.输入要点赞的餐品序号
				System.out.print("请输入要点赞的餐品序号:");
				int dishId=sc.nextInt();
				//	3.该序号的餐品点赞数加1
				praiseNums[dishId-1]++;
				//	4.显示
				System.out.println("点赞成功!");
				System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"赞");
				break;
			case 6:
				// 6.退出系统
			default:
				break;
			}
			// 当用户输入的功能编号为1~5之外的数字是,退出循环,否则提示输入0返回
			if (choose < 1 || choose > 5) {
				break;
			} else {
				// 提示输入0返回
				System.out.println("输入0返回:");
				num = sc.nextInt();
			}
		} while (num == 0);
		System.out.println("谢谢使用,欢迎下次光临!");
	}
}
