package user.logiccompute;

import java.util.Timer;

import javax.servlet.http.HttpServlet;


public class AutoTime extends HttpServlet {
	
	public void init() {
		System.out.println("这样在web容器启动的时候，就会执行这句话了！");
		Timer time = new Timer();
		time.schedule(new MyTask(),7*24*60*60*1000,  7*24*60*60*1000);
		//time.schedule(new MyTask(), 5*1000,  7*24*60*60*1000);
	}
	

}

