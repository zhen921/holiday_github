package user.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import user.dao.UserInforDao;
import user.model.UserInfor;
import user.service.UserInforService;

@Component
public class UserInforImpl implements UserInforService{
	UserInforDao dao;
	
	@Override
	public boolean queryExist(UserInfor u) {
		return dao.queryExist(u);
	}

	@Override
	@Transactional   //进行写操作之前先加事务
	public void addUser(UserInfor u) {
		u.setInform("abc");
		dao.addUser(u);
	}

	public UserInforDao getDao() {
		return dao;
	}

	@Resource(name="userInforDaoImpl")
	public void setDao(UserInforDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean loginCheck(UserInfor userInfor) {
		return dao.loginCheck(userInfor);
	}

	@Override
	@Transactional
	public List<String> getInform(UserInfor userInfor) {
		List<String> list=new ArrayList<String >();
		String str=dao.getInform(userInfor);
		if(str.length()>5){
			String[] spliter = str.split(",");
			for(int i=1;i<spliter.length;i++){
				list.add(spliter[i]);
			}
		}
		return list;
	}

	@Override
	public UserInfor getSelfInfor(UserInfor userInfor) {
		return dao.getSelfInfor(userInfor);
	}

}
