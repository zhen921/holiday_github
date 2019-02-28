package user.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import user.dao.PersonInforDao;
import user.model.UserInfor;
import user.service.PersonInforService;


@Component
public class PersonInforServiceImpl implements PersonInforService{
private PersonInforDao   dao;

public PersonInforDao getDao() {
	return dao;
}

@Resource(name="personInforDaoImpl")
public void setDao(PersonInforDao dao) {
	this.dao = dao;
}

@Override
public UserInfor getPersonalInforBySno(String parameter) {
	return dao.getPersonalInforBySno(parameter);
}
	
}
