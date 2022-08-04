package qintess.exercicio.classes.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 5033464704942423744L;
	
	private int id;
	private String role;
	private int userid;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	
	@Override
	public String getAuthority() {
		return role;
	}

}
