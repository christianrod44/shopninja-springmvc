package qintess.exercicio.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import qintess.exercicio.classes.dao.UsuariosDao;
import qintess.exercicio.classes.model.UserInfo;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsuariosDao usuariosDao;

	@GetMapping("/incluir")
	public String incluir() {
		return "usuarios/incluirUsuario";
	}
	
	@PostMapping("/cadusuario")
	public String incluir(UserInfo user, Model model) {
		try {
			String senha = user.getPassword();
			String crypto = new BCryptPasswordEncoder().encode(senha);
			user.setPassword(crypto);
			user.setEnabled(true);
			usuariosDao.incluirUsuario(user);
			return "redirect:/";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
}
