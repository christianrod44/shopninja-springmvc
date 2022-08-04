package qintess.exercicio.classes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import qintess.exercicio.classes.dao.ClienteDao;
import qintess.exercicio.classes.model.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteDao clienteDao;
	
	@GetMapping("/cliente/inicio")
	public ModelAndView iniciar() {
		return new ModelAndView("cliente/index");
	}
	
	@GetMapping("/cliente/incluir")
	public String incluir(Model model) {
		try {
			return "cliente/novoCliente";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	@PostMapping("/cadcliente")
	public String incluir(Cliente cliente, Model model) {
		try {
			
			clienteDao.incluirCliente(cliente);
			return "redirect:/cliente/listar";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	@GetMapping("/cliente/listar") 
	public ModelAndView listar(Model model) { 
		try {
			List<Cliente> cliente = clienteDao.listarCliente();		
			model.addAttribute("clientes", cliente);				
			return new ModelAndView("cliente/listaCliente");		
		} catch (Exception e) {
			model.addAttribute("mensagem",e.getMessage());			
			return new ModelAndView("erro");			
		}
	}
	
	//Alteração Cliente
	@GetMapping("/cliente/alterar/{idCliente}")		//entre chaves é o parametro de entrada na rota. A rota do ID que será alterado
	public String alterar(@PathVariable("idCliente") int id, Model model) {     //o primeiro parametro puxa a rota do ID que sera carregado na pagina jsp o model permite enviar informações para o jsp
		try {
			Cliente cliente = clienteDao.buscarCliente(id);
			if(cliente == null) {
				throw new Exception("Nenhum cliente com o id informado.");
			}
			model.addAttribute("cl", cliente);
			return "cliente/alterarCliente";
			
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	@PostMapping("/alteracliente")
	public String alterar(Cliente cliente, Model model) {
		try {
			
			clienteDao.alterarCliente(cliente);
			return "redirect:/cliente/listar";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	@GetMapping("/cliente/remover/{id}")
	public String excluir(@PathVariable("id") int id, Model model) {
		try {
			clienteDao.excluirCliente(id);
			return "redirect:/cliente/listar";
		} catch (Exception e) {
			model.addAttribute("mensagem",e.getMessage());			
			return "erro";
		}
	}
	
}
