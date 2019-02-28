package user.dao;

import java.util.List;

import user.model.HistoryPlan;
import user.model.PersonalTag;
import user.model.UserInfor;

public interface IndivMatchDao {

	public List<HistoryPlan>  checkCondition(String sno);

	public void  saveTag(PersonalTag pt);

	public List<PersonalTag> getPersonalTagList();

	public void setTag(List<PersonalTag> list);

	public List<UserInfor> getFriend(String sno);

}
