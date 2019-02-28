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

	//发布计划的要填写自己的性别
	public int  getSex(String sno);

	//填写计划用到的省份
	public List<City> getCity(String code);

	public List<UserPlan> getMatchPlan(UserPlan userPlan);

	/*
	 * 为了让数据库储存的省市是中文
	 */
	public Province getProvinceName(String province);
	public City getCityName(String city);

	//匹配的计划要通知数据库里的人
	public String informMatch(String sno, String sno2);

	public List<UserPlan> getRecom(List<String> lists);

		
}
