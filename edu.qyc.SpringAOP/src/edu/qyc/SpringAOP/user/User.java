package edu.qyc.SpringAOP.user;

import org.aspectj.lang.ProceedingJoinPoint;



public class User {

	public void print() {
		System.out.println("��ʼ����");
		
	}
	public void print2(){
		System.out.println("����");
	}
	
	public Object print3(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("���ƿ�ʼ");
		Object[] args=joinPoint.getArgs();
		Object object=joinPoint.proceed(args);
		System.out.println("���ƽ���");
		return object;
	}
}
