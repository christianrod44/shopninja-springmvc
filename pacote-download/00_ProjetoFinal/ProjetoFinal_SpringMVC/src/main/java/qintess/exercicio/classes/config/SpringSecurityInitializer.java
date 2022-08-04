package qintess.exercicio.classes.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer{

	/*não escrevemos nada. Essa classe que extend AbstractSecurityWebApplicationInitializer, funciona como um gatilho.
	 * Assim como serializable que marca os objetos como serializados.
	 * No caso aqui, basta essa classe estar presente para que o Spring Security funciona. Essa classe funciona como um botão que ativa o Spring Security.
	 */
}
