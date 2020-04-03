import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qyc.springdemo.Action.UserAction;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("user.xml");
		UserAction ua=ac.getBean(UserAction.class);
		ua.print();
		
	}

}
