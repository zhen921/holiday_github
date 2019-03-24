package user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import user.dao.UserInforDao;
import user.model.UserInfor;

@Component 
public class UserInforDaoImpl implements UserInforDao{
	private HibernateTemplate hibernateTemplate;
	@Override
	public void addUser(UserInfor u) {
		hibernateTemplate.save(u);
	}

	@Override
	public boolean queryExist(UserInfor u) {
		List<UserInfor> users = (List<UserInfor>) hibernateTemplate.find("from UserInfor u where u.sno = '" + u.getSno() + "'");
		if(users != null && users.size() > 0) {
			return true;
		}
		return false;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean loginCheck(UserInfor userInfor) {
		List<UserInfor> users=new ArrayList<UserInfor>(); 
		if(userInfor.getSex()==1)
			users=(List<UserInfor>) hibernateTemplate.find("from UserInfor u where u.sno = '" + userInfor.getSno() + "' "+"and u.pwd='"+ userInfor.getPwd()+"'");
		else
			users=(List<UserInfor>) hibernateTemplate.find("from AdminInfor u where u.name = '" + userInfor.getSno() + "' "+"and u.password='"+ userInfor.getPwd()+"'");
		if(users != null && users.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public String getInform(UserInfor userInfor) {
		UserInfor user=(UserInfor) hibernateTemplate.find("from UserInfor u where u.sno = '" + userInfor.getSno() + "'").get(0);
		String str=user.getInform();
		//user.setInform("abc");
	//	this.hibernateTemplate.update(user);
		return str;
	}

	@Override
	public UserInfor getSelfInfor(UserInfor userInfor) {
		return (UserInfor)hibernateTemplate.find("from UserInfor u where u.sno = '" + userInfor.getSno() + "'").get(0);
	}

}
