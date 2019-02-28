package user.service.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.model.UserInfor;
import user.service.impl.UserInforImpl;

public class UserInforImplTest {

	@Test
	public void testQueryExist() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserInforImpl service= (UserInforImpl) ctx.getBean("userservice");
		UserInfor u=new UserInfor();
		u.setSno("按时");
		u.setPwd("数据分析");
		boolean abc=service.queryExist(u);
		Assert.assertEquals(true, abc);
	}

	@Test
	public void testAddUser() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserInforImpl service= (UserInforImpl) ctx.getBean("userInforImpl");
		UserInfor u=new UserInfor();
		u.setSno("数据分析");
		u.setPwd("asdf");
		service.addUser(u);
	}

	@Test
	public void testLoginCheck(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserInforImpl service= (UserInforImpl) ctx.getBean("userInforImpl");
		UserInfor u=new UserInfor();
		u.setSno("123");
		u.setPwd("456");
		u.setSex(2);
		Assert.assertEquals(true, service.loginCheck(u));
	}
	
	@Test
	public void testgetSelfInfor() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserInforImpl service= (UserInforImpl) ctx.getBean("userInforImpl");
		UserInfor u=new UserInfor();
		u.setSno("2001");
		u.setPwd("123");
		UserInfor user=service.getSelfInfor(u);
		System.out.println(user.getSno());
	}
}
