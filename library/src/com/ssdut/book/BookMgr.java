package com.ssdut.book;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;

public class BookMgr {
	//创建图书对象
		BookSet book=new BookSet();
		
		//初始化
		public void initial(){
			book.name[0]="数据结构";
			book.state[0]=0;
			book.date[0]="2018-07-01";
			book.count[0]=15;
			
			book.name[1]="数据库";
			book.state[1]=1;
			book.count[1]=2;
			
			book.name[2]="离散数学";
			book.state[2]=1;
			book.count[2]=30;
		}
		
		//开始菜单
		public void startMenu(){
			System.out.println("欢迎使用图书借阅系统!");
			System.out.println("----------------");
			System.out.println("0.借出排行榜");
			System.out.println("1.新增图书");
			System.out.println("2.查看图书");
			System.out.println("3.删除图书");
			System.out.println("4.借出图书");
			System.out.println("5.归还图书");
			System.out.println("6.退出");
			System.out.println("----------------");
			System.out.print("请选择: ");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			
			switch(choice){
			case 0:
				list();
				break;
			case 1:
				add();
				break;
			case 2:
				search();
				break;
			case 3:
				delete();
				break;
			case 4:
				lend();
				break;
			case 5:
				returnbook();
				break;
			case 6:
				System.out.println("\n谢谢使用!");
				break;
			}
		 }

        //返回主菜单
		public void returnMain(){
			Scanner input=new Scanner(System.in);
			System.out.print("输入0返回:");
			if(input.nextInt()==0){
				startMenu();
			}else{
				System.out.println("输入错误，异常终止！");
			}	
		}

        //借出排行榜
		public void list(){
			//定义新数组储存排放后的信息
			String[] newname=new String[1000];
			int[] newcount=new int[1000];
			
			for(int k=0;k<book.name.length;k++){
				newname[k]=book.name[k];
				newcount[k]=book.count[k];
			}
			
			for(int i=0;i<newname.length;i++){
				for(int j=i+1;j<newname.length;j++){
					if(newcount[i]>newcount[j]){
						String temp1=newname[i];
						newname[i]=newname[j];
						newname[j]=temp1;
						
						int temp2=newcount[i];
						newcount[i]=newcount[j];
						newcount[j]=temp2;
						
					}
				}
				
			}
			System.out.println("---> 排行榜");
			System.out.println("****************");
			System.out.println("次数\t名称");
			
			for(int i=newname.length-1;i>=0;i--){
				if(newname[i]!=null){
					System.out.println(newcount[i]+"\t<<"+newname[i]+">>");
				}
			}
			System.out.println("****************");
			returnMain();
		}

		//新增图书
		public void add(){
			Scanner input= new Scanner(System.in); 
			System.out.print("请输入:");
			String name=input.nextLine();
	        for(int i=0;i<book.name.length;i++){
	        	if(book.name[i]==null){//寻找空白地址存放新图书信息
	        		book.name[i]=name;
	        		book.state[i]=1;
	        		System.out.println("新增《"+name+"》成功");
	        		break;
	        	}
	        }
	        System.out.println("****************");
			returnMain();
		}
		
		//查看图书
		public void search(){
			System.out.println("---> 查看图书");
			System.out.println("序号\t状态\t名称\t借出日期");
			for(int i=0,k=1;i<book.name.length;i++){
				if(book.name[i]!=null){//不为空则列出
						System.out.print(k+"\t");
						k++;
						if(book.state[i]==1){
							System.out.print("可借\t");
							System.out.print(book.name[i]+"\t\n");
						}else{
							System.out.print("已借出\t");
							System.out.print(book.name[i]+"\t");
							System.out.print(book.date[i]+"\n");
						}//else
				
					}//for
			}
			System.out.println("****************");
		    returnMain();
			}
				
		//删除图书
		public void delete(){
			System.out.println("---> 删除图书");
			int flag=0;//判断图书是否存在
			Scanner input= new Scanner(System.in); 
			System.out.print("请输入要删除的图书名:");
			String name=input.nextLine();
			
	        for(int i=0;i<book.name.length && book.name[i]!=null;i++){
	        	if(book.name[i].equals(name)){
	        		if(book.state[i]==0){//判断是否被借出
	        			System.out.println("《"+name+"》为借出状态，不可删除!");
	        			flag++;
	        			break;
	                    }
	        		book.name[i]=null;
	        		book.state[i]=0;
	        		book.date[i]=null;
	        		book.count[i]=0;
	        		System.out.println("删除《"+name+"》成功!");
	        		flag++;
	        		break;
	        	}//if
	        }//for
	       
	        if(flag==0){//?
	        	System.out.println("没有匹配信息!");
	        }
	        System.out.println("****************");
			returnMain();
		}
		
		//借出图书
		public void lend(){
			System.out.println("---> 借出图书");
			int flag=0;//判断图书是否存在
			Scanner input= new Scanner(System.in); 
			System.out.print("请输入要借出的图书名:");
			String name=input.nextLine();
	        for(int i=0;i<book.name.length && book.name[i]!=null;i++){
	        	if(book.name[i].equals(name)){
	        		if(book.state[i]==0){
	        			System.out.println("《"+name+"》已借出!");
	        			flag=1;
	        			break;
	                    }
	        		book.state[i]=0;
	        		SimpleDateFormat tempdate=new SimpleDateFormat("yyyy-MM-dd");  
	        		Date currentTime = new Date();
	        	    book.date[i]=tempdate.format(currentTime);//获取借出时间  
	        		System.out.println("借出《"+name+"》成功!");
	        		flag=1;
	        		break;
	        	}//if
	        }//for
	        if(flag==0){//?
	        	System.out.println("没有匹配信息!");
	        }
	        System.out.println("****************");
			returnMain();
			
		}
		//归还图书
		public void returnbook(){
			System.out.println("---> 归还图书");
			Scanner input= new Scanner(System.in); 
			System.out.print("请输入要归还的图书名:");
			int k=book.name.length;
			String name=input.nextLine();
			System.out.print("请输入归还日期:");
			String date=input.nextLine();
			for(int i=0;i<book.name.length;i++){
	        	if(book.name[i].equals(name)){
	        		book.state[i]=1;
	        		System.out.println("归还《"+name+"》成功!");
	        		System.out.println("借出日期为:"+book.date[i]);
	        		System.out.println("归还日期为:"+date);
	        		
	        		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	                Calendar cal = Calendar.getInstance();  
	                try {
						cal.setTime(sdf.parse(book.date[i]));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
	                long time1 = cal.getTimeInMillis();               
	                try {
						cal.setTime(sdf.parse(date));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
	                long time2 = cal.getTimeInMillis();       
	                long days=(time2-time1)/(1000*3600*24);

	        		System.out.println("应付租金:"+days);
	        		break;
	        		
	        	}
	        }
	        System.out.println("****************");
			returnMain();
		}
}
