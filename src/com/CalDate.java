package com;

import java.util.Scanner;

/*
 * 要求：计算输入日期具体为星期几。
 * 
 */

public class CalDate {
	public CalDate(){
		System.out.println("随便改改构造方法!");
	}
	
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year,month,day;
		//输入年份
		while(true){
			System.out.print("请输入年份:");
			year = sc.nextInt();
			if(year <= 0){
				 System.out.println("您年份输入有误，请重新运行输入！");
			 }else if(year > 2018){
				 System.out.println("你输入的年份超范围，请重新输入！");
			 }
			else{
				 break;
			 }
		}
		
		//输入月份
		while(true){
			System.out.print("请输入月份:");
			month = sc.nextInt();
			if(month <= 0 || month >12){
				 System.out.println("您月份输入有误，请重新运行输入！");
			 }else{
				 break;
			 }
		}

		//输入日期
		while(true){
			System.out.print("请输入日:");
			day = sc.nextInt();
			if(day <= 0){
				 System.out.println("您日期输入有误，请重新运行输入！");
			 }
			else if(((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day>31) || ((month == 4 || month == 6 || month ==9 || month ==11) && day>30) ){
				 System.out.println("当月没有改日期！");
			 }
			else if((date(year)&& month == 2 && day>29) || (!date(year) && month == 2 && day > 28)){
				System.out.println("2月日期出错，请重新输入");
			}
			else{
				 break;
			 }
		}
		
		judgeDate(year,month,day);
	}
	 
	 //判断日期为星期几
	 public static void judgeDate(int year, int month, int day){
		 //计算总天数
		 //1.公元1年到输入日期上一年年底天数
		 	int sumYear = 0;
		 	for(int i = 1; i < year; i ++){
		 		if(date(i)){
		 			sumYear += 366;
		 		}
		 		else
		 			sumYear += 365;
		 	}		 	
		 //2.输入年份的1月到上月月底天数
		 	
		 	int sumMonth = 0;
		 	for(int i = 1; i < month; i ++){
		 		if(i == 2){
		 			if(date(year)){
		 				sumMonth += 29;
		 			}
		 			else
		 				sumMonth += 28;
		 		}
		 		else if (i == 1 || i == 3 || i == 5 || i == 7 || i ==8 || i == 10 || i ==12){
		 			sumMonth += 31;
		 		}
		 		else
		 			sumMonth += 30;
		 	}
		 	
		 //3.输入日期的天数
		 //4.总天数
		 	int sum = 0;
		 	sum = sumYear + sumMonth + day;

		 //对七取余
		 	int result = sum % 7;
		 	
		 //返回星期几
		 switch(result){
		 case 0:
			 System.out.println("这天星期天");
			 break;
		 case 1:
			 System.out.println("这天星期一");
			 break;
		 case 2:
			 System.out.println("这天星期二");
			 break;
		 case 3:
			 System.out.println("这天星期三");
			 break;
		 case 4:
			 System.out.println("这天星期四");
			 break;
		 case 5:
			 System.out.println("这天星期五");
			 break;
		 case 6:
			 System.out.println("这天星期六");
			 break;
			
		 }
	 }
	 
	 
	 //判断是否闰年
	 public static boolean date(int year){
		 if(year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0))){
			 return true;
		 }
		 else
			 return false;
	 }
}
