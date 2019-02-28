package user.service.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.impl.IndivMatchServiceImpl;
import user.service.impl.ReleaseServiceImpl;

public class IndivMatchServiceImplTest {

	@Test
	public void testCheckCondition() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IndivMatchServiceImpl service= (IndivMatchServiceImpl) ctx.getBean("indivMatchServiceImpl");
		boolean flag=service.checkCondition("1234");
		Assert.assertEquals(true, flag);
	}
	@Test
	public void testGetIntro(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IndivMatchServiceImpl service= (IndivMatchServiceImpl) ctx.getBean("indivMatchServiceImpl");
		service.getClusterAnaly();
	}
	@Test
	public void testgetFriend(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IndivMatchServiceImpl service= (IndivMatchServiceImpl) ctx.getBean("indivMatchServiceImpl");
		service.getFriend("1234");
	}
}
