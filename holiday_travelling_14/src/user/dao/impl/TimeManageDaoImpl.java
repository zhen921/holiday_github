package user.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import user.dao.TimeManageDao;

public class TimeManageDaoImpl implements TimeManageDao{
	
	public void checkTime(){
		Connection conn = null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			String url = "jdbc:mysql://localhost:3306/personal_travel_db";
			String pwd = "root";
			String name = "root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, name, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			String str="select * from user_plan";
			ps=(PreparedStatement) conn.prepareStatement(str);
			rs=ps.executeQuery();
			while(rs.next()){
					int time=rs.getInt("startdate");
					//发布的时间是近期，不含节日
					if(time>1&&time<=4){
						ps=(PreparedStatement) conn.prepareStatement("UPDATE  user_plan    SET startdate=startdate-1 WHERE sno='"+rs.getString("sno")+"';");
						ps.execute();
					}else if(time<=1){
						str="INSERT INTO history_plan VALUES(NULL,'"+rs.getString("sno")+"','"+rs.getString("province")+"','"+rs.getString("city")+"','"+rs.getString("view")+"',"+rs.getInt("totalperson")+","+rs.getInt("totaltime")+","+rs.getInt("totalcost")+","+rs.getInt("companysex")+","+rs.getInt("selfsex")+");";
						ps=(PreparedStatement) conn.prepareStatement(str);
						ps.execute();
					}else{
						//特定日子还没想好
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
}