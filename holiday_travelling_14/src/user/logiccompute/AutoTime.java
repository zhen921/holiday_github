package user.logiccompute;

import java.util.Date;
import java.util.Timer;

import javax.servlet.http.HttpServlet;


public class AutoTime extends HttpServlet {
	
	public void init() {
		Timer time = new Timer();
		//延迟时间执行
		int day=7-new Date().getDay();
		time.schedule(new MyTask(),day*24*60*60*1000,  7*24*60*60*1000);
	}
	

}

