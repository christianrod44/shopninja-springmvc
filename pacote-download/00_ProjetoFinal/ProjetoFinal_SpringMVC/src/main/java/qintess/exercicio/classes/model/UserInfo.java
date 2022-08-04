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
	private List<Role> roles = new ArrayList<Role>();     //lista de todos os perfis de um usuário
	
	
	
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
	public Collection<? extends GrantedAuthority> getAuthorities() {  //um usuário pode ter vários roles(perfis) ele retorna todos os perfis de um usuário
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
	public boolean isAccountNonExpired() {		//não vai expirar conta
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {		//não vai bloquear
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {	//não vai expirar credencial
		return false;
	}

	@Override
	public boolean isEnabled() {				//Enable
		return enabled;
	}

}
