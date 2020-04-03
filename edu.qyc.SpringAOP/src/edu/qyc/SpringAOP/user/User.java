package edu.qyc.SpringAOP.user;

import org.aspectj.lang.ProceedingJoinPoint;



public class User {

	public void print() {
		System.out.println("开始进行");
		
	}
	public void print2(){
		System.out.println("结束");
	}
	
	public Object print3(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("环绕开始");
		Object[] args=joinPoint.getArgs();
		Object object=joinPoint.proceed(args);
		System.out.println("环绕结束");
		return object;
	}
}
