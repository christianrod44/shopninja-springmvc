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
		auth.jdbcAuthentication()							//autenticação baseada no mecanismo JDBC
			.dataSource(dataSource)							//usando o banco de dados definido no dataSouce
			.passwordEncoder(new BCryptPasswordEncoder())	//o password vai usar criptografia BCrypt
			.usersByUsernameQuery(usersQuery)
			.authoritiesByUsernameQuery(authoritiesQuery);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()	//a ordem das linhas abaixo são importantes. Da mais específica para a mais geral. E não deve haver ambiguidades.
			.antMatchers("/produtos/**").authenticated()		//para incluir um evento o usuário vai precisar estar autenticado
			.antMatchers("/cliente/**").authenticated()
			.antMatchers("/api/**").permitAll()						//todo mundo pode acessar
			.antMatchers("/**").permitAll()							//todo mundo pode acessar. Não há nessecidade do de cima.
			.anyRequest().authenticated()
			.and().csrf().disable()			//se a autenticação partir do mesmo browser, da mesma sessão do usuário, da mesma versão. Ele deixara acessar. Evita que a sessão se estiver n a url seja copiada e colada para acessar sem autenticar. Precisa configurar, não é simples mas não é difícil também. Esse csrf verifica frontend, não interage com backend, é puramente JS. Com .disable desabilitamos ele.
			.formLogin();	//quando tentar acessar uma rota que exije autenticação, ele não deixa acessar sem permissão. Gera tela de login. SE colocar o .loginPage é caso já tenha uma tela e queira usar, aí tem que dizer aonde está.
	}

	
}
