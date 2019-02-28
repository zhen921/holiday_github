package user.action;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import user.model.UserInfor;
import user.service.IndivMatchService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component()
@Scope("prototype")
public class Individual extends ActionSupport {
	private IndivMatchService service;
	List<UserInfor> users;
	public String checkCondition(){
		String sno=Register.getSnoid();
		//标签是否存在，不存在就创建，存在就更新
		boolean flag=service.checkCondition(sno);
		//聚类分析
		service.getClusterAnaly();
		//拿到标签里的同类好友
		users=service.getFriend(sno);
		return "friends";
	}

	public IndivMatchService getService() {
		return service;
	}
	@Resource(name="indivMatchServiceImpl")
	public void setService(IndivMatchService service) {
		this.service = service;
	}

	public List<UserInfor> getUsers() {
		return users;
	}
	public void setUsers(List<UserInfor> users) {
		this.users = users;
	}
}
