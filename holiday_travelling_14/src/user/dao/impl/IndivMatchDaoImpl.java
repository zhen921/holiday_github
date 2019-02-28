package user.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import user.dao.IndivMatchDao;
import user.model.HistoryPlan;
import user.model.PersonalTag;
import user.model.UserInfor;
import user.model.UserPlan;

@Component
public class IndivMatchDaoImpl implements IndivMatchDao{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//拿到历史数据为了检查是否够分析特征的
	@Override
	public List<HistoryPlan>  checkCondition(String sno) {
		List<HistoryPlan> list=hibernateTemplate.find("from HistoryPlan h where h.sno='"+sno+"'");
		return list;
	}
	
	//将从历史数据中分析出的特征存入
	@Override

	public void saveTag(PersonalTag pt) {
			hibernateTemplate.merge(pt);
	}
	//取出数据去聚类
	@Override
	public List<PersonalTag> getPersonalTagList() {
		return hibernateTemplate.find("from PersonalTag");
	}
	//将聚类算出的classtag存储
	@Override
	public void setTag(List<PersonalTag> list) {
		for(int i=0;i<list.size();i++){
			hibernateTemplate.update(list.get(i));
		}
		
	}
	@Override
	public List<UserInfor> getFriend(String sno) {
		PersonalTag tag=(PersonalTag) hibernateTemplate.find("from PersonalTag h where h.sno='"+sno+"'").get(0);
		List<PersonalTag> list;
		if(tag.getCompanysex()!=3){
				list=hibernateTemplate.find("from PersonalTag u where u.classtag = '" +tag.getClasstag()+ "' and u.companysex in ("+tag.getSelfsex()+",3)  and u.selfsex='"+tag.getCompanysex()+"'");
			}else{
				list=hibernateTemplate.find("from PersonalTag u where u.classtag = '" +tag.getClasstag()+ "' and u.companysex in ("+tag.getSelfsex()+",3)");
			}
		for(int i=0;i<list.size();i++){
			if(list.get(i).getSno().equals(tag.getSno())){
				list.remove(i);
			}
		}
		
		List<UserInfor> userlist = new ArrayList<UserInfor>();
		if(list.size()>0){
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				PersonalTag per = (PersonalTag) iterator.next();
				try {
					userlist.add((UserInfor) hibernateTemplate.find("from UserInfor h where h.sno='"+per.getSno()+"'").get(0));
				} catch (Exception e) {
					System.out.println("由于personal_tag表与user_infor不匹配导致");
				}
			
			}
		}
		return userlist ;
	}
	
}
