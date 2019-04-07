package user.dto;

import org.springframework.stereotype.Component;

@Component
public class UserInforDTO {
	private String sno;
	private String role;
	private String inform;
	public String getInform() {
		return inform;
	}
	public void setInform(String inform) {
		this.inform = inform;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
