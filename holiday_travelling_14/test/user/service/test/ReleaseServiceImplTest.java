package user.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.model.City;
import user.model.Province;
import user.model.UserPlan;
import user.service.impl.ReleaseServiceImpl;
import user.service.impl.UserInforImpl;

public class ReleaseServiceImplTest {

	@Test
	public void testGetProvince() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ReleaseServiceImpl service= (ReleaseServiceImpl) ctx.getBean("releaseServiceImpl");
		List<Province>  list=service.getProvince();
		System.out.println(list.size());
	}
	
	@Test
	public void testGetCity() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ReleaseServiceImpl service= (ReleaseServiceImpl) ctx.getBean("releaseServiceImpl");
		List<City>  list=service.getCity("450000");
		System.out.println(list.size());
	}
	
	@Test
	public void testgetMatchPlany() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ReleaseServiceImpl service= (ReleaseServiceImpl) ctx.getBean("releaseServiceImpl");
		UserPlan plan=new UserPlan();
		plan.setProvince("430000");
		plan.setCompanysex(3);
		plan.setSelfsex(2);
		service.getMatchPlan(plan);
	}

}
