package user.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import user.model.UserInfor;

import user.service.PersonInforService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component()
@Scope("prototype")
public class Personal extends ActionSupport implements ModelDriven{
	private PersonInforService service;
	
	UserInfor user;
	public  String getPersonInfor(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String sno=req.getParameter("sno");
		this.user=service.getPersonalInforBySno(sno);
		return "personal_infor";
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	public PersonInforService getService() {
		return service;
	}
	@Resource(name="personInforServiceImpl")
	public void setService(PersonInforService service) {
		this.service = service;
	}
	public UserInfor getUser() {
		return user;
	}
	public void setUser(UserInfor user) {
		this.user = user;
	}
}
