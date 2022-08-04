package qintess.exercicio.classes.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity		//para carregar a classe e "saber" o que fazer com ela
public class JdbcSecurityConfiguration extends WebSecurityConfigurerAdapter{

	private String usersQuery="SELECT username, password, enabled from users where username = ?";
	private String authoritiesQuery = 
			"SELECT u.username, a.authority " +
		            "FROM user_authorities a, users u " +
		            "WHERE u.username = ? " +
		            "AND u.id = a.user_id";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()							//autentica��o baseada no mecanismo JDBC
			.dataSource(dataSource)							//usando o banco de dados definido no dataSouce
			.passwordEncoder(new BCryptPasswordEncoder())	//o password vai usar criptografia BCrypt
			.usersByUsernameQuery(usersQuery)
			.authoritiesByUsernameQuery(authoritiesQuery);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()	//a ordem das linhas abaixo s�o importantes. Da mais espec�fica para a mais geral. E n�o deve haver ambiguidades.
			.antMatchers("/produtos/**").authenticated()		//para incluir um evento o usu�rio vai precisar estar autenticado
			.antMatchers("/cliente/**").authenticated()
			.antMatchers("/api/**").permitAll()						//todo mundo pode acessar
			.antMatchers("/**").permitAll()							//todo mundo pode acessar. N�o h� nessecidade do de cima.
			.anyRequest().authenticated()
			.and().csrf().disable()			//se a autentica��o partir do mesmo browser, da mesma sess�o do usu�rio, da mesma vers�o. Ele deixara acessar. Evita que a sess�o se estiver n a url seja copiada e colada para acessar sem autenticar. Precisa configurar, n�o � simples mas n�o � dif�cil tamb�m. Esse csrf verifica frontend, n�o interage com backend, � puramente JS. Com .disable desabilitamos ele.
			.formLogin();	//quando tentar acessar uma rota que exije autentica��o, ele n�o deixa acessar sem permiss�o. Gera tela de login. SE colocar o .loginPage � caso j� tenha uma tela e queira usar, a� tem que dizer aonde est�.
	}

	
}
