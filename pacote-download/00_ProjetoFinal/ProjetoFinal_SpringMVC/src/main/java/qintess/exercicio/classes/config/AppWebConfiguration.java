package qintess.exercicio.classes.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import qintess.exercicio.classes.dao.ClienteDao;
import qintess.exercicio.classes.dao.ProdutosDao;
import qintess.exercicio.classes.dao.UsuariosDao;
import qintess.exercicio.classes.dao.VendaDao;

@EnableWebMvc							//esta ser� uma aplica��o MVC, e essa classe � a configura��o m�nima para utilizar o Spring.	//o framework ser� o Spring
@ComponentScan(basePackages = "qintess.exercicio.classes.controllers")	//todos os controllers tem que estar nesse pacote ou abaixo dele
public class AppWebConfiguration {
	//os .jsp ficaram na pasta configurada no m�todo abaixo. Esse m�todo � para espec�ficar a localiza��o das p�ginas, das views.
	@Bean		//(gr�o, feij�o) com o Bean o Spring vai carregar a defini��o desse objeto na mem�ria, e quando precisar vai cham�-lo. O Spring vai precisar criar um objeto para representar a localiza��o das p�ginas, com isso ele sabe o que fazer. � um m�todo que retorna o InternalResourceViewResolver usado pelo Spring para configurar a parte de views
	public InternalResourceViewResolver internalViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");			//pasta aonde ficar�o as jsp
		resolver.setSuffix(".jsp");						//como as p�ginas ir�o terminar
		return resolver;
	}	//quem vai chamar esse m�todo ser� o Spring, somente quando for necess�rio.
	
	@Bean   //para avisar o Spring para usar ele, n�o adianta apenas escrever o m�todo
	public DataSource dataSource() { //retorna um dataSource, aponta para o driver do mysql
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");		//componente de conex�o com mysql
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_artigosninja?useSSL=false&allowPublicKeyRetrieval=true");   //como se fosse a String de conex�o				   
		dataSource.setUsername("root");
		dataSource.setPassword("p@ssword");
		
		return dataSource;
	}
	
	@Bean   //t� nas m�os do Spring tamb�m, afinal, � gerenciado pelo Spring tamb�m
	public ProdutosDao getProdutosDao() {
		return new ProdutosDao(dataSource());
	}
	
	@Bean
	public ClienteDao getClienteDao() {
		return new ClienteDao(dataSource());
	}
 
	@Bean
	public VendaDao getVendaDao() {
		return new VendaDao(dataSource());
	}
	
	@Bean
	public UsuariosDao getUsuariosDao() {
		return new UsuariosDao(dataSource());
	}
}
