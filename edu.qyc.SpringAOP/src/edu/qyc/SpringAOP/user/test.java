package edu.qyc.SpringAOP.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext aContext=new ClassPathXmlApplicationContext("beans.xml");
		userA a=(userA) aContext.getBean("a");
		userB b=(userB) aContext.getBean("b");
		userC c=(userC) aContext.getBean("c");
		a.print();
		b.print();
		c.print();
	}

}
