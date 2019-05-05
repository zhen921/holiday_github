package user.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import user.action.Register;
import user.dao.ReleaseDao;
import user.logiccompute.ComputeMatch;
import user.logiccompute.SendInformEmail;
import user.model.City;
import user.model.Province;
import user.model.UserPlan;
import user.service.ReleaseService;

@Component
public class ReleaseServiceImpl implements ReleaseService {
	ReleaseDao dao;
	Register register;
	ComputeMatch match=new ComputeMatch();
	SendInformEmail sie=new SendInformEmail();
	
	@Override
	public List<Province> getProvince() {
		return dao.getProvince();
	}
	@Override
	public List<City> getCity(String code) {
		return dao.getCity(code);
	}

	public ReleaseDao getDao() {
		return dao;
	}
	@Resource(name = "releaseDaoImpl")
	public void setDao(ReleaseDao dao) {
		this.dao = dao;
	}

	public Register getRegister() {
		return register;
	}
	@Resource(name = "login")
	public void setRegister(Register register) {
		this.register = register;
	}

	@Override
	public boolean releasePlan(UserPlan userPlan) {
		return dao.releasePlan(userPlan);
	}

	@Override
	@Transactional
	public List<UserPlan> getMatchPlan(UserPlan userPlan) {
		
		 //从数据库查询符合基本条件的,并且存储数据是在查询之后做
		List<UserPlan> list=dao.getMatchPlan(userPlan);
		
		List<UserPlan>  matchlist=new  ArrayList<UserPlan>();
		if(list!=null&&list.size()>0){
			//匹配到有结果
			List<UserPlan> userlist=new ArrayList<UserPlan>();
			//计算了匹配度,目前存放在hot里，但是还缺一个排序，和限制人数
			userlist=match.getMatchResult(userPlan, list);
			
			/*
			 * 给匹配人发送匹配通知
			 */
			for (Iterator iterator = userlist.iterator(); iterator
					.hasNext();) {
				UserPlan type = (UserPlan) iterator.next();
				if(type.getHot()>80){
					String email=dao.informMatch(type.getSno(),userPlan.getSno());
					if(email!=null)
						sie.sendEmai(email);
				}
			}
			return userlist;
		}else{
			//无匹配
			return  matchlist;  
		}
	}

	@Override
	public List<UserPlan> getRecom(List<String> lists) {
		return dao.getRecom(lists);
	}

}
