package user.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.model.UserInfor;
import user.service.impl.PersonInforServiceImpl;
import user.service.impl.ReleaseServiceImpl;

public class PersonInforServiceImplTest {

	@Test
	public void testGetPersonalInforBySno() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		PersonInforServiceImpl service= (PersonInforServiceImpl) ctx.getBean("personInforServiceImpl");
		UserInfor list=service.getPersonalInforBySno("2003");
	}

}
