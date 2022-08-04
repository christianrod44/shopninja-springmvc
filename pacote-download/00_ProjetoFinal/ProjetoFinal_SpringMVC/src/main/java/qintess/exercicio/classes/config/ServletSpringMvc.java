package qintess.exercicio.classes.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMvc extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {			//
		// TODO Auto-generated method stub
		return new Class[] { AppWebConfiguration.class, JdbcSecurityConfiguration.class };		//arquivo de configura��o da aplica��o web entre {}. Estava no m�todo abaixo e foi movido para c� pois precisa ser executado antes do security deste primeiro m�todo.
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {		
		return new Class[] { };
	}	//inje��o de depend�ncia, controla o ciclo de vida do objeto, similar ao Reposit�rio. O Spring vai chamar esse m�todo quando a aplica��o for inicializada. 

	@Override
	protected String[] getServletMappings() {				//a aplica��o ser� controlada pelo Spring
		return new String[] { "/"};     //Ele (o Spring) far� o mapeamento da aplica��o inteira atrav�s desse m�todo. Desde a ra�z. Com isso o Spring vai controlar a aplica��o inteira.
	}	//na iniciliza��o do Servlet, ele vai executar este m�todo e o enterior.

}
