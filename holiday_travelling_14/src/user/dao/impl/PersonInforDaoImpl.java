package user.dao.impl;


import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import user.dao.PersonInforDao;
import user.model.UserInfor;

@Component
public class PersonInforDaoImpl implements PersonInforDao{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public UserInfor getPersonalInforBySno(String parameter) {
		return (UserInfor)(hibernateTemplate.find("from UserInfor u where u.sno='"+parameter+"'").get(0));
	}
}
