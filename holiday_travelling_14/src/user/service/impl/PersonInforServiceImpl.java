package user.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	
	/* (non-Javadoc)
	 * @see user.service.PersonInforService#saveProfileBySno(user.model.UserInfor)
	 */
	@Override
	@Transactional
	public void saveProfileBySno(UserInfor profile) {
		dao.saveProfileBySno(profile);
		// TODO Auto-generated method stub
	}
	
}
