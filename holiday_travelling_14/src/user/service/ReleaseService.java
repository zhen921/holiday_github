package user.service;

import java.util.List;


import user.model.City;
import user.model.Province;
import user.model.UserPlan;

public interface ReleaseService {

	public List<Province> getProvince();

	public boolean releasePlan(UserPlan userPlan);

	public List<City> getCity(String code);

	public List<UserPlan>  getMatchPlan(UserPlan userPlan);

	public List<UserPlan> getRecom(List<String> lists);

}
