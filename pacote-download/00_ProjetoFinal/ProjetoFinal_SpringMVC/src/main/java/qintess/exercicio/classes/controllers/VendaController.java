package qintess.exercicio.classes.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import qintess.exercicio.classes.dao.ClienteDao;
import qintess.exercicio.classes.dao.ProdutosDao;
import qintess.exercicio.classes.dao.VendaDao;
import qintess.exercicio.classes.model.Cliente;
import qintess.exercicio.classes.model.Produto;
import qintess.exercicio.classes.model.Venda;

@Controller
public class VendaController {

	@Autowired
	private VendaDao vendaDao;

	@Autowired
	private ProdutosDao produtosDao;

	@Autowired
	private ClienteDao clienteDao;

	@GetMapping("/venda/inicio")
	public ModelAndView iniciar() {
		return new ModelAndView("venda/index");
	}

	@GetMapping("/venda/incluir")
	public String incluir(Model model) {
		try {

			return "venda/novaVenda";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}

	@PostMapping("/cadvenda")
	public String incluir(Venda venda, @RequestParam("dataVenda") String dataVenda
			, @RequestParam("cmbProduto") Integer Idproduto
			, @RequestParam("cmbCliente") Integer Idcliente
			, @RequestParam("tTotal") Double tTotal
			, Model model) {
		try {
			
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataVenda);
			venda.setDataatual(data);
			
			Produto produto = produtosDao.buscarProduto(Idproduto);
			Cliente cliente = clienteDao.buscarCliente(Idcliente);
			venda.setProduto(produto);
			venda.setCliente(cliente);
			
			venda.setTotal(tTotal);

			
			vendaDao.incluirVenda(venda);
			return "redirect:/venda/listar";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}

	}

	@GetMapping("/venda/listar")
	public ModelAndView listar(Model model) {
		try {
			List<Venda> lista = vendaDao.listaVenda();
			model.addAttribute("venda", lista);

			List<Produto> lista2 = produtosDao.listarProdutos();
			model.addAttribute("produtos", lista2);

			List<Cliente> lista3 = clienteDao.listarCliente();
			model.addAttribute("clientes", lista3);

			return new ModelAndView("venda/listaVenda");
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return new ModelAndView("erro");
		}
	}

	@GetMapping("/venda/remover/{id}")
	public String remover(@PathVariable("id") int id, Model model) {
		try {
			vendaDao.excluirVenda(id);
			return "redirect:/venda/listar";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}

}
