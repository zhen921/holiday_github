package user.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import user.dao.IndivMatchDao;
import user.logiccompute.CreateIndivTag;
import user.logiccompute.MultiCluster;
import user.model.HistoryPlan;
import user.model.PersonalTag;
import user.model.UserInfor;
import user.service.IndivMatchService;

@Component
public class IndivMatchServiceImpl implements IndivMatchService{
	private IndivMatchDao dao;
	private CreateIndivTag tag;
	private MultiCluster cluster;

	
	/**
	 * 获得一个学号，创建标签并保存，返回是否成功创建标签
	 */
	@Override
	@Transactional
	public boolean checkCondition(String sno) {
		 List<HistoryPlan> list=dao.checkCondition(sno);
		if(list.size()>=5){
			PersonalTag pt=tag.getIndivTag(list);
			dao.saveTag(pt);
			 return true;
		}else{
			return false;
		}
	}
	
	//拿到所有标签调用聚类分析算法分类
	@Override
	@Transactional
	public void getClusterAnaly() {
		//获得个人标签数据
		List<PersonalTag> list=dao.getPersonalTagList();
		//聚类算法拿到结果
		List<double []> data= MultiCluster.clusterCompute(list);
		for(int i=0;i<data.size();i++){
			list.get(i).setClasstag((int) data.get(i)[3]);
		}
		//把聚类结果存入
		MultiCluster.clearList();
		dao.setTag(list);
	}
	

	@Override
	public List<UserInfor> getFriend(String sno) {
		return dao.getFriend(sno);
	}
	
	
	public CreateIndivTag getTag() {
		return tag; 
	}
	@Resource(name="createIndivTag")
	public void setTag(CreateIndivTag tag) {
		this.tag = tag;
	}

	public MultiCluster getCluster() {
		return cluster;
	}
	@Resource(name="multiCluster")
	public void setCluster(MultiCluster cluster) {
		this.cluster = cluster;
	}

	public IndivMatchDao getDao() {
		return dao;
	}

	@Resource(name="indivMatchDaoImpl")
	public void setDao(IndivMatchDao dao) {
		this.dao = dao;
	}

	
}
