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

@EnableWebMvc							//esta será uma aplicação MVC, e essa classe é a configuração mínima para utilizar o Spring.	//o framework será o Spring
@ComponentScan(basePackages = "qintess.exercicio.classes.controllers")	//todos os controllers tem que estar nesse pacote ou abaixo dele
public class AppWebConfiguration {
	//os .jsp ficaram na pasta configurada no método abaixo. Esse método é para específicar a localização das páginas, das views.
	@Bean		//(grão, feijão) com o Bean o Spring vai carregar a definição desse objeto na memória, e quando precisar vai chamá-lo. O Spring vai precisar criar um objeto para representar a localização das páginas, com isso ele sabe o que fazer. É um método que retorna o InternalResourceViewResolver usado pelo Spring para configurar a parte de views
	public InternalResourceViewResolver internalViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");			//pasta aonde ficarão as jsp
		resolver.setSuffix(".jsp");						//como as páginas irão terminar
		return resolver;
	}	//quem vai chamar esse método será o Spring, somente quando for necessário.
	
	@Bean   //para avisar o Spring para usar ele, não adianta apenas escrever o método
	public DataSource dataSource() { //retorna um dataSource, aponta para o driver do mysql
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");		//componente de conexão com mysql
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_artigosninja?useSSL=false&allowPublicKeyRetrieval=true");   //como se fosse a String de conexão				   
		dataSource.setUsername("root");
		dataSource.setPassword("p@ssword");
		
		return dataSource;
	}
	
	@Bean   //tá nas mãos do Spring também, afinal, é gerenciado pelo Spring também
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
