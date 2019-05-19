package user.service;

import java.util.List;


import user.dto.userAndPlan;
import user.model.City;
import user.model.Province;
import user.model.UserPlan;

public interface ReleaseService {

	public List<Province> getProvince();

	public List<UserPlan> checkRepeatPlan(String sno);

	public List<City> getCity(String code);

	public List<UserPlan>  getMatchPlan(UserPlan userPlan);

	public List<UserPlan> getRecom(List<String> lists);

	/**
	 * @param plan
	 */
	public void saveReleasePlan(UserPlan plan);

	/**
	 * @param matchList
	 * @param sno
	 */
	public void sendEmaiToMatch(List<UserPlan> matchList, String sno);

	/**
	 * @param college 
	 * @return
	 */
	public List<userAndPlan> getLatestPlan(String college,int index);

}
