package com.ssdut.book;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;

public class BookMgr {
	//����ͼ�����
		BookSet book=new BookSet();
		
		//��ʼ��
		public void initial(){
			book.name[0]="���ݽṹ";
			book.state[0]=0;
			book.date[0]="2018-07-01";
			book.count[0]=15;
			
			book.name[1]="���ݿ�";
			book.state[1]=1;
			book.count[1]=2;
			
			book.name[2]="��ɢ��ѧ";
			book.state[2]=1;
			book.count[2]=30;
		}
		
		//��ʼ�˵�
		public void startMenu(){
			System.out.println("��ӭʹ��ͼ�����ϵͳ!");
			System.out.println("----------------");
			System.out.println("0.������а�");
			System.out.println("1.����ͼ��");
			System.out.println("2.�鿴ͼ��");
			System.out.println("3.ɾ��ͼ��");
			System.out.println("4.���ͼ��");
			System.out.println("5.�黹ͼ��");
			System.out.println("6.�˳�");
			System.out.println("----------------");
			System.out.print("��ѡ��: ");
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
				System.out.println("\nллʹ��!");
				break;
			}
		 }

        //�������˵�
		public void returnMain(){
			Scanner input=new Scanner(System.in);
			System.out.print("����0����:");
			if(input.nextInt()==0){
				startMenu();
			}else{
				System.out.println("��������쳣��ֹ��");
			}	
		}

        //������а�
		public void list(){
			//���������鴢���ŷź����Ϣ
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
			System.out.println("---> ���а�");
			System.out.println("****************");
			System.out.println("����\t����");
			
			for(int i=newname.length-1;i>=0;i--){
				if(newname[i]!=null){
					System.out.println(newcount[i]+"\t<<"+newname[i]+">>");
				}
			}
			System.out.println("****************");
			returnMain();
		}

		//����ͼ��
		public void add(){
			Scanner input= new Scanner(System.in); 
			System.out.print("������:");
			String name=input.nextLine();
	        for(int i=0;i<book.name.length;i++){
	        	if(book.name[i]==null){//Ѱ�ҿհ׵�ַ�����ͼ����Ϣ
	        		book.name[i]=name;
	        		book.state[i]=1;
	        		System.out.println("������"+name+"���ɹ�");
	        		break;
	        	}
	        }
	        System.out.println("****************");
			returnMain();
		}
		
		//�鿴ͼ��
		public void search(){
			System.out.println("---> �鿴ͼ��");
			System.out.println("���\t״̬\t����\t�������");
			for(int i=0,k=1;i<book.name.length;i++){
				if(book.name[i]!=null){//��Ϊ�����г�
						System.out.print(k+"\t");
						k++;
						if(book.state[i]==1){
							System.out.print("�ɽ�\t");
							System.out.print(book.name[i]+"\t\n");
						}else{
							System.out.print("�ѽ��\t");
							System.out.print(book.name[i]+"\t");
							System.out.print(book.date[i]+"\n");
						}//else
				
					}//for
			}
			System.out.println("****************");
		    returnMain();
			}
				
		//ɾ��ͼ��
		public void delete(){
			System.out.println("---> ɾ��ͼ��");
			int flag=0;//�ж�ͼ���Ƿ����
			Scanner input= new Scanner(System.in); 
			System.out.print("������Ҫɾ����ͼ����:");
			String name=input.nextLine();
			
	        for(int i=0;i<book.name.length && book.name[i]!=null;i++){
	        	if(book.name[i].equals(name)){
	        		if(book.state[i]==0){//�ж��Ƿ񱻽��
	        			System.out.println("��"+name+"��Ϊ���״̬������ɾ��!");
	        			flag++;
	        			break;
	                    }
	        		book.name[i]=null;
	        		book.state[i]=0;
	        		book.date[i]=null;
	        		book.count[i]=0;
	        		System.out.println("ɾ����"+name+"���ɹ�!");
	        		flag++;
	        		break;
	        	}//if
	        }//for
	       
	        if(flag==0){//?
	        	System.out.println("û��ƥ����Ϣ!");
	        }
	        System.out.println("****************");
			returnMain();
		}
		
		//���ͼ��
		public void lend(){
			System.out.println("---> ���ͼ��");
			int flag=0;//�ж�ͼ���Ƿ����
			Scanner input= new Scanner(System.in); 
			System.out.print("������Ҫ�����ͼ����:");
			String name=input.nextLine();
	        for(int i=0;i<book.name.length && book.name[i]!=null;i++){
	        	if(book.name[i].equals(name)){
	        		if(book.state[i]==0){
	        			System.out.println("��"+name+"���ѽ��!");
	        			flag=1;
	        			break;
	                    }
	        		book.state[i]=0;
	        		SimpleDateFormat tempdate=new SimpleDateFormat("yyyy-MM-dd");  
	        		Date currentTime = new Date();
	        	    book.date[i]=tempdate.format(currentTime);//��ȡ���ʱ��  
	        		System.out.println("�����"+name+"���ɹ�!");
	        		flag=1;
	        		break;
	        	}//if
	        }//for
	        if(flag==0){//?
	        	System.out.println("û��ƥ����Ϣ!");
	        }
	        System.out.println("****************");
			returnMain();
			
		}
		//�黹ͼ��
		public void returnbook(){
			System.out.println("---> �黹ͼ��");
			Scanner input= new Scanner(System.in); 
			System.out.print("������Ҫ�黹��ͼ����:");
			int k=book.name.length;
			String name=input.nextLine();
			System.out.print("������黹����:");
			String date=input.nextLine();
			for(int i=0;i<book.name.length;i++){
	        	if(book.name[i].equals(name)){
	        		book.state[i]=1;
	        		System.out.println("�黹��"+name+"���ɹ�!");
	        		System.out.println("�������Ϊ:"+book.date[i]);
	        		System.out.println("�黹����Ϊ:"+date);
	        		
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

	        		System.out.println("Ӧ�����:"+days);
	        		break;
	        		
	        	}
	        }
	        System.out.println("****************");
			returnMain();
		}
}
