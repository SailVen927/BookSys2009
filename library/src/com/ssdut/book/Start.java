package com.ssdut.book;

package com.pb.jadv.reflection;

import java.lang.reflect.Method;

public class Person {
	
	private String name;
	private String gender;
	private int age;
	
	/**
	 * @return the name
	 */
	private String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		return "Person name is "+name+", age is "+age;
	}
	
	
}

public class ReflectionDemo {
	
	/**
	 * ���췽��
	 */
	public ReflectionDemo(){
		String classInfo=JOptionPane.showInputDialog(null,"������ȫ·��");//Ҫ���û��������ȫ·��
		try{
			Class cla=Class.forName(classInfo);//�������ȫ·����������أ����ظ����Class����
			
			Method[] method=cla.getDeclaredMethods();//���õõ���class��������󣬷��ط������󼯺�
			
			for(Method me:method){//�������෽���ļ���
				System.out.println(me.toString());//��ӡ������Ϣ
			}
			
			System.out.println("############");
			
			Field[] field=cla.getDeclaredFields();//���õõ���class��������󣬷������Զ��󼯺�
			for(Field me:field){//�������෽���ļ���
				System.out.println(me.toString());//��ӡ������Ϣ
			}
			
		}catch(ClassNotFoundException e){//ʹ��Class��forName������ȡClass����ʱ���÷��������׳�һ��ClassNotFoundException����������Ҫ��������쳣��
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ʾʹ��Class���forName��ȡClass����
	 * @param str
	 
	public ReflectionDemo(String str){
		try{
			Class cla=Class.forName(str);//�������ȫ·����������أ����ظ����Class����
			
			Method[] method=cla.getDeclaredMethods();//���õõ���class��������󣬷��ط������󼯺�
			
			for(Method me:method){//�������෽���ļ���
				System.out.println(me.toString());//��ӡ������Ϣ
			}
			
			System.out.println("############");
			
			Field[] field=cla.getDeclaredFields();//���õõ���class��������󣬷������Զ��󼯺�
			for(Field me:field){//�������෽���ļ���
				System.out.println(me.toString());//��ӡ������Ϣ
			}
			
		}catch(ClassNotFoundException e){//ʹ��Class��forName������ȡClass����ʱ���÷��������׳�һ��ClassNotFoundException����������Ҫ��������쳣��
			e.printStackTrace();
		}
	}
	*/
	/**
	 * ��ʾ����ĳ�������getClass()������ȡ����
	 * @param p
	 
	public ReflectionDemo(Person p){
			Class cla=p.getClass();//�������ȫ·����������أ����ظ����Class����
			
			Method[] method=cla.getDeclaredMethods();//���õõ���class��������󣬷��ط������󼯺�
			
			for(Method me:method){//�������෽���ļ���
				System.out.println(me.toString());//��ӡ������Ϣ
			}
			
			System.out.println("############");
			
			Field[] field=cla.getDeclaredFields();//���õõ���class��������󣬷������Զ��󼯺�
			for(Field me:field){//�������෽���ļ���
				System.out.println(me.toString());//��ӡ������Ϣ
			}
	}
	*/
	public static void main(String[] args){
		
		new ReflectionDemo();//��ʾ���Է���API�������û��������ȫ·�����ҵ��������еĳ�Ա�����ͳ�Ա����
		

		
//		Person p = new Person();  //��ʾ����ĳ�������getClass()������ȡ����
//		new ReflectionDemo(p);
		
		/**��ʾ����ĳ����Class��������ȡ�����Ӧ��Class����
		Class cla = Person.class;
		Method[] method=cla.getDeclaredMethods();//���õõ���class��������󣬷��ط������󼯺�
		
		for(Method me:method){//�������෽���ļ���
			System.out.println(me.toString());//��ӡ������Ϣ
		}
		
		System.out.println("############");
		
		Field[] field=cla.getDeclaredFields();//���õõ���class��������󣬷������Զ��󼯺�
		for(Field me:field){//�������෽���ļ���
			System.out.println(me.toString());//��ӡ������Ϣ
		}
		 */

		
//		new ReflectionDemo("java.lang.String");   //��ʾʹ��Class���forName��ȡClass����
	}
	
	
}
