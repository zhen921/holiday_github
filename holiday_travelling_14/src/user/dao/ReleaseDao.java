package user.dao;

import java.util.List;

import user.model.City;
import user.model.Province;
import user.model.UserPlan;

public interface ReleaseDao {

	//填写计划用到的省份
	public List<Province> getProvince();

	//其实就检查了一下是不是重复发的
	public boolean releasePlan(UserPlan userPlan);

	//填写计划用到的城市
	public List<City> getCity(String code);

	public List<UserPlan> getMatchPlan(UserPlan userPlan);


	//匹配的计划要通知数据库里的人
	public String informMatch(String sno, String sno2);

	public List<UserPlan> getRecom(List<String> lists);

		
}
