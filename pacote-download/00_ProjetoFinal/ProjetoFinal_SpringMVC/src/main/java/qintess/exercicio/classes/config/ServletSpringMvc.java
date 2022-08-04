package qintess.exercicio.classes.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMvc extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {			//
		// TODO Auto-generated method stub
		return new Class[] { AppWebConfiguration.class, JdbcSecurityConfiguration.class };		//arquivo de configuração da aplicação web entre {}. Estava no método abaixo e foi movido para cá pois precisa ser executado antes do security deste primeiro método.
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {		
		return new Class[] { };
	}	//injeção de dependência, controla o ciclo de vida do objeto, similar ao Repositório. O Spring vai chamar esse método quando a aplicação for inicializada. 

	@Override
	protected String[] getServletMappings() {				//a aplicação será controlada pelo Spring
		return new String[] { "/"};     //Ele (o Spring) fará o mapeamento da aplicação inteira através desse método. Desde a raíz. Com isso o Spring vai controlar a aplicação inteira.
	}	//na inicilização do Servlet, ele vai executar este método e o enterior.

}
