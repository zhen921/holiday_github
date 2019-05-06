package user.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import user.dao.ReleaseDao;
import user.hibernate.util.HibernateUtil;
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
			String str=user.getInform()+","+sno2;
			user.setInform(str);
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


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
