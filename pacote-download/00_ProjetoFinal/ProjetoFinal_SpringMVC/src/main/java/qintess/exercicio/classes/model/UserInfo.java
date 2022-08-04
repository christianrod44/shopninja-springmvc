package qintess.exercicio.classes.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfo implements UserDetails {

	private static final long serialVersionUID = 2167177131726682837L;

	private int id;
	private String login;		//euivalente a username
	private String password;
	private boolean enabled;
	private List<Role> roles = new ArrayList<Role>();     //lista de todos os perfis de um usu�rio
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {  //um usu�rio pode ter v�rios roles(perfis) ele retorna todos os perfis de um usu�rio
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {		//n�o vai expirar conta
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {		//n�o vai bloquear
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {	//n�o vai expirar credencial
		return false;
	}

	@Override
	public boolean isEnabled() {				//Enable
		return enabled;
	}

}
