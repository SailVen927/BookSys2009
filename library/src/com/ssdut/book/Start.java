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
	 * 构造方法
	 */
	public ReflectionDemo(){
		String classInfo=JOptionPane.showInputDialog(null,"输入类全路径");//要求用户输入类的全路径
		try{
			Class cla=Class.forName(classInfo);//根据类的全路径进行类加载，返回该类的Class对象
			
			Method[] method=cla.getDeclaredMethods();//利用得到的class对象的自审，返回方法对象集合
			
			for(Method me:method){//遍历该类方法的集合
				System.out.println(me.toString());//打印方法信息
			}
			
			System.out.println("############");
			
			Field[] field=cla.getDeclaredFields();//利用得到的class对象的自审，返回属性对象集合
			for(Field me:field){//遍历该类方法的集合
				System.out.println(me.toString());//打印属性信息
			}
			
		}catch(ClassNotFoundException e){//使用Class的forName方法获取Class对象时，该方法可能抛出一个ClassNotFoundException，所以我们要捕获这个异常。
			e.printStackTrace();
		}
	}
	
	/**
	 * 演示使用Class类的forName获取Class对象
	 * @param str
	 
	public ReflectionDemo(String str){
		try{
			Class cla=Class.forName(str);//根据类的全路径进行类加载，返回该类的Class对象
			
			Method[] method=cla.getDeclaredMethods();//利用得到的class对象的自审，返回方法对象集合
			
			for(Method me:method){//遍历该类方法的集合
				System.out.println(me.toString());//打印方法信息
			}
			
			System.out.println("############");
			
			Field[] field=cla.getDeclaredFields();//利用得到的class对象的自审，返回属性对象集合
			for(Field me:field){//遍历该类方法的集合
				System.out.println(me.toString());//打印属性信息
			}
			
		}catch(ClassNotFoundException e){//使用Class的forName方法获取Class对象时，该方法可能抛出一个ClassNotFoundException，所以我们要捕获这个异常。
			e.printStackTrace();
		}
	}
	*/
	/**
	 * 演示调用某个对象的getClass()方法获取对象
	 * @param p
	 
	public ReflectionDemo(Person p){
			Class cla=p.getClass();//根据类的全路径进行类加载，返回该类的Class对象
			
			Method[] method=cla.getDeclaredMethods();//利用得到的class对象的自审，返回方法对象集合
			
			for(Method me:method){//遍历该类方法的集合
				System.out.println(me.toString());//打印方法信息
			}
			
			System.out.println("############");
			
			Field[] field=cla.getDeclaredFields();//利用得到的class对象的自审，返回属性对象集合
			for(Field me:field){//遍历该类方法的集合
				System.out.println(me.toString());//打印属性信息
			}
	}
	*/
	public static void main(String[] args){
		
		new ReflectionDemo();//演示测试反射API，利用用户输入类的全路径，找到该类所有的成员方法和成员属性
		

		
//		Person p = new Person();  //演示调用某个对象的getClass()方法获取对象
//		new ReflectionDemo(p);
		
		/**演示调用某个类Class属性来获取该类对应的Class对象
		Class cla = Person.class;
		Method[] method=cla.getDeclaredMethods();//利用得到的class对象的自审，返回方法对象集合
		
		for(Method me:method){//遍历该类方法的集合
			System.out.println(me.toString());//打印方法信息
		}
		
		System.out.println("############");
		
		Field[] field=cla.getDeclaredFields();//利用得到的class对象的自审，返回属性对象集合
		for(Field me:field){//遍历该类方法的集合
			System.out.println(me.toString());//打印属性信息
		}
		 */

		
//		new ReflectionDemo("java.lang.String");   //演示使用Class类的forName获取Class对象
	}
	
	
}
