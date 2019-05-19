package user.action;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import user.model.UserInfor;
import user.service.IndivMatchService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Component()
@Scope("prototype")
public class Individual extends ActionSupport {
	private IndivMatchService service;
	
	@RequestMapping(value="/checkCondition",method = RequestMethod.GET,produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public  List<UserInfor> checkCondition(@RequestParam String sno){
			//标签是否存在，不存在就创建，存在就更新
			boolean flag=service.checkCondition(sno);
			//聚类分析
			service.getClusterAnaly();
			//拿到标签里的同类好友
			return service.getFriend(sno);
	}
	
	
	public IndivMatchService getService() {
		return service;
	}
	@Resource(name="indivMatchServiceImpl")
	public void setService(IndivMatchService service) {
		this.service = service;
	}
}
