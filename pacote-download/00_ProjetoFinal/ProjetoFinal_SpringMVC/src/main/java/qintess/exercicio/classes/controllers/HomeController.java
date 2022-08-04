package qintess.exercicio.classes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller   //para dizer que é um controller
public class HomeController {     // nesta classe só serão escritos os métodos que vão interagir com as views, com o framework.

	//Todos os métodos escritos dentro dos controllers são denominados 'actions'.
	@GetMapping("/")    //barra que aparece no final da URL, a rota que está sendo configurada nesse método. Só é um action se tiver esse GetMapping
	public ModelAndView iniciar() {
		return new ModelAndView("menu");
	}   //ele retornará o menu.jsp presente na pasta /WEB-INF/views/admin
	
}
