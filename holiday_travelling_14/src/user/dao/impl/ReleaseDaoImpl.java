package user.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.Session;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import user.dao.ReleaseDao;
import user.dto.userAndPlan;
import user.model.City;
import user.model.HistoryPlan;
import user.model.Province;
import user.model.UserInfor;
import user.model.UserPlan;

@Component
public class ReleaseDaoImpl implements ReleaseDao {
	private HibernateTemplate hibernateTemplate;


	//get province list
	@Override
	public List<Province> getProvince() {
		return (List<Province>) hibernateTemplate.find("from Province");
	}

	//get city list 
	@Override
	public List<City> getCity(String code) {
		return (List<City>)hibernateTemplate.find("from City u where u.provincecode = '" + code + "'");
	}

	//检查计划是否重复
	@Override
	public List<UserPlan> checkRepeatPlan(String sno) {
		return (List<UserPlan>) hibernateTemplate.find("from UserPlan u where u.sno = '" + sno + "'");
	}

	//save plan
	@Override
	public void saveReleasePlan(UserPlan plan) {
		hibernateTemplate.save(plan);
	}
	
	  //此处做基本匹配，匹配必要要求，性别，省份，返回匹配列表
	@Override
	public List<UserPlan> getMatchPlan(UserPlan userPlan) {
		List<UserPlan> list;
		if(userPlan.getCompanysex()!=3){
				list=(List<UserPlan>) hibernateTemplate.find("from UserPlan u where u.province = '" +userPlan.getProvince()+ "' and u.companysex in ("+userPlan.getSelfsex()+",3)  and u.selfsex='"+userPlan.getCompanysex()+"'");
			}else{
				list=(List<UserPlan>) hibernateTemplate.find("from UserPlan u where u.province = '" +userPlan.getProvince()+ "' and u.companysex in ("+userPlan.getSelfsex()+",3)");
			}
		return list;
	}


	
	/**
	 * sno 是匹配者 sno2是当前计划的，此处获取匹配者的email,并给匹者留通知
	 */
	@Override
	public String informMatch(String sno, String sno2) {
		UserInfor user=(UserInfor) hibernateTemplate.find("from UserInfor u where u.sno = '" + sno + "'").get(0);
			user.setInform(1);
			this.hibernateTemplate.update(user);
		return user.getEmail();
	}

	@Override
	public List<UserPlan> getRecom(List<String> lists) {
		List<UserPlan> recom=new ArrayList<UserPlan>();
		for (Iterator iterator =lists.iterator(); iterator
				.hasNext();) {
			String type = (String) iterator.next();
		UserPlan user=	(UserPlan) hibernateTemplate.find("from UserPlan u where u.sno='"+type+"'").get(0);
		recom.add(user);
		}
		return recom;
	}

	//联表查询
		@Override
		public List<userAndPlan> getLatestPlan(String college,int index) {
			org.hibernate.classic.Session session= hibernateTemplate.getSessionFactory().openSession();
		    final Query query = session.createQuery("SELECT p.sno,p.view,p.title,p.startdate,p.introduce,u.depart,u.photopath,u.nickName,u.sex " +
					"FROM UserPlan as p , UserInfor as u where p.sno=u.sno and u.college='"+college+"' ORDER BY p.id DESC");
		    query.setMaxResults(3);
		    query.setFirstResult(index);
		    List<userAndPlan> list=query.list();
		    session.close();
		    return list;
		}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	

}
