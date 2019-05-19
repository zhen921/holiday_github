package user.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import user.action.Register;
import user.dao.ReleaseDao;
import user.dto.userAndPlan;
import user.logiccompute.ComputeMatch;
import user.logiccompute.SendInformEmail;
import user.model.City;
import user.model.Province;
import user.model.UserPlan;
import user.service.ReleaseService;

@Component
public class ReleaseServiceImpl implements ReleaseService {
	ReleaseDao dao;
	ComputeMatch match=new ComputeMatch();
	SendInformEmail sendEmail=new SendInformEmail();
	
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

	@Override
	public List<UserPlan> checkRepeatPlan(String sno) {
		return dao.checkRepeatPlan(sno);
	}

	@Override
	@Transactional
	public List<UserPlan> getMatchPlan(UserPlan userPlan) {
		List<UserPlan> list=dao.getMatchPlan(userPlan);
		//遍历去除匹配到的自己的计划
		Iterator<UserPlan> iterator = list.iterator(); 
		while (iterator.hasNext()){ 
			UserPlan obj = iterator.next(); 
			if(userPlan.getSno()==obj.getSno())
				iterator.remove();
		}
		if(list!=null&&list.size()>0){
			//计算了匹配度,目前存放在hot里，但是还缺一个排序，和限制人数
			return match.getMatchResult(userPlan, list);
		}else{
			//无匹配
			return  list;  
		}
	}

	@Override
	public List<UserPlan> getRecom(List<String> lists) {
		return dao.getRecom(lists);
	}

	@Override
	@Transactional
	public void saveReleasePlan(UserPlan plan) {
		dao.saveReleasePlan(plan);
	}

	// 给匹配人发送匹配通知
	@Transactional
	@Override
	public void sendEmaiToMatch(List<UserPlan> matchList, String sno) {
			for (Iterator iterator = matchList.iterator(); iterator.hasNext();) {
				UserPlan type = (UserPlan) iterator.next();
				if(type.getHot()>80){
					String email=dao.informMatch(type.getSno(),sno);
					if(email!=null)
						sendEmail.sendEmai(email,false,"");
				}
			}
	}
	
	

	@Override
	public List<userAndPlan> getLatestPlan(String college,int index) {
		return dao.getLatestPlan(college,index);
	}

}
