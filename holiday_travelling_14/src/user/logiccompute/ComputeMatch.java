package user.logiccompute;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import user.model.UserPlan;

public class ComputeMatch {
	/**
	 * 参数为个人旅游计划和list类型数据库存储计划，做匹配分析，结果储存在
	 * 一个特定类型list并返回
	 * @param userPlan
	 * @param list
	 * @return
	 */
	public List<UserPlan> getMatchResult(UserPlan userPlan,List<UserPlan> list){
		List<UserPlan> matchlist=new ArrayList<UserPlan>();
		KeyWordUtil kwu=new KeyWordUtil(null);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			int sum=0;
			UserPlan plan = (UserPlan) iterator.next();
			//城市
			if(userPlan.getCity().equals(plan.getCity())){
				sum=sum+2;
			}
			
		    //调用封装的函数匹配关键字
			if(kwu.getKeyWord(userPlan.getView(), plan.getView())){
				sum=sum+2; 	
			}
			
			// totalperson
			if(userPlan.getTotalperson()==plan.getTotalperson()){
				sum=sum+2; 
			}else{
				int num=Math.abs(userPlan.getTotalperson()-plan.getTotalperson());
				if(num==2){
					sum=sum+1;
				}else{
				}
				
			}
			
			//totaltime
			if(userPlan.getTotaltime()==plan.getTotaltime()){
				sum=sum+2; 
			}else{
				int num=Math.abs(userPlan.getTotaltime()-plan.getTotaltime());
				if(num==1){
					sum=sum+1;
				}else{
				}
			}
			
			/*
			 * totalcost
			 */
			if(userPlan.getTotalcost()==plan.getTotalcost()){
				sum=sum+2; 
			}else{
				int num=Math.abs(userPlan.getTotalcost()-plan.getTotalcost());
				if(num==2){
					sum=sum+1;
				}else{
				}
			}
						
			/*
			 * startdate
			 */
			if(userPlan.getStartdate()==plan.getStartdate()){
				sum=sum+2; 
			}else{
				int num=Math.abs(userPlan.getStartdate()-plan.getStartdate());
				if(num==1){
					sum=sum+1;
				}else{
				}
			}	
			int b=100*(sum+4)/16;
			plan.setHot(b);
			matchlist.add(plan);
		}
		return matchlist;
	}
}
