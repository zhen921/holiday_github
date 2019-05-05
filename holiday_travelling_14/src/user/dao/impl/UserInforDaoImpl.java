package user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import user.dao.UserInforDao;
import user.dto.UserInforDTO;
import user.hibernate.util.SqlSet;
import user.model.AdminInfor;
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
	public UserInforDTO loginCheck(UserInfor userInfor) {
//		String query=SqlSet.checkLoginUser;
		List<UserInfor> users=new ArrayList<UserInfor>(); 
		List<AdminInfor> admin=new ArrayList<AdminInfor>(); 
		UserInforDTO loginInfor =new UserInforDTO();
		users=(List<UserInfor>) hibernateTemplate.find("from UserInfor u where u.sno = '" + userInfor.getSno() + "' "+"and u.pwd='"+ userInfor.getPwd()+"'");
		//如果是普通用户
		if(users != null && users.size() > 0) {
			loginInfor.setSno(users.get(0).getSno()) ;
			loginInfor.setInform(users.get(0).getInform());
			loginInfor.setSex((users.get(0).getSex()));
			return loginInfor;
		}else{
			admin=(List<AdminInfor>) hibernateTemplate.find("from AdminInfor u where u.name = '" + userInfor.getSno() + "' "+"and u.password='"+ userInfor.getPwd()+"'");
			if(admin != null && admin.size() > 0){
				loginInfor.setSno(admin.get(0).getName());
				loginInfor.setRole(admin.get(0).getRole());
				return loginInfor;
			}else{
				return loginInfor;
			}
		} 
	}


	@Override
	public UserInfor getSelfInfor(UserInfor userInfor) {
		return (UserInfor)hibernateTemplate.find("from UserInfor u where u.sno = '" + userInfor.getSno() + "'").get(0);
	}

}
