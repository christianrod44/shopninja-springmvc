package qintess.exercicio.classes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller   //para dizer que � um controller
public class HomeController {     // nesta classe s� ser�o escritos os m�todos que v�o interagir com as views, com o framework.

	//Todos os m�todos escritos dentro dos controllers s�o denominados 'actions'.
	@GetMapping("/")    //barra que aparece no final da URL, a rota que est� sendo configurada nesse m�todo. S� � um action se tiver esse GetMapping
	public ModelAndView iniciar() {
		return new ModelAndView("menu");
	}   //ele retornar� o menu.jsp presente na pasta /WEB-INF/views/admin
	
}
