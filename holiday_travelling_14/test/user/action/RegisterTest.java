package user.action;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.model.UserInfor;

public class RegisterTest {

	@Test
	public void testLoginCheck() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Register act= (Register) ctx.getBean("login");
		UserInfor userInfor=new UserInfor();
		userInfor.setSno("2001");
		userInfor.setPwd("123");
		userInfor.setSex(1);
		assertEquals(true,act.loginCheck());
	}

}
