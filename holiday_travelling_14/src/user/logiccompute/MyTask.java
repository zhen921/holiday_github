package user.logiccompute;

import java.util.TimerTask;

import javax.annotation.Resource;


import user.dao.TimeManageDao;
import user.dao.impl.TimeManageDaoImpl;
import user.service.ReleaseService;

public class MyTask extends TimerTask {
	TimeManageDao dao=new TimeManageDaoImpl();
	@Override
	public void run() {
		 dao.checkTime();
	}
}
