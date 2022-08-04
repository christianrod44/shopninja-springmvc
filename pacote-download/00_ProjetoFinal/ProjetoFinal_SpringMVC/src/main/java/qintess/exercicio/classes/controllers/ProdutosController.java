package qintess.exercicio.classes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import qintess.exercicio.classes.dao.ProdutosDao;
import qintess.exercicio.classes.model.Produto;

@Controller   //...para que seja um controller para o Spring
public class ProdutosController {
	
	@Autowired   //para avisar para o Spring que nesse controller tem uma vari�vel do tipo Bean que ele precisa gerenciar. O Bean de ProdutosDao � um reposit�rio. Sem o Bean esse Autowired n�o funciona � uma liga��o entre os dois.
	private ProdutosDao produtosDao;	//nao precisa instanciar, o Spring far� isso.
	
	@GetMapping("/produtos/inicio")    //essa barra n�o vai dar conflito porque t�cnicamente vem depois de "/produtps"
	public ModelAndView iniciar() {
		return new ModelAndView("produtos/index");  //index.jsp na pasta produtos
	}
	
	@GetMapping("/produtos/listar")	//o complemento para "/produtos". Garantia de exclusividade de mapeamento.
	public ModelAndView listar(Model model) {    //ModelAndView apontando para um .jsp   //Model � utilizado para trasferir uma informa��o para o .jsp
		try {
			List<Produto> lista = produtosDao.listarProdutos();		//vai ser transferida para a lista .jsp
			model.addAttribute("produtos", lista);			//o atributo a ser enviado para a lista no .jsp
			return new ModelAndView("produtos/listaProdutos");			//nome da View
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return new ModelAndView("erro");				//o erro vai ser direcionado para a p�gina de erro.jsp
		}
	}

	//inclus�o de Produtos - usaremos o retorno do tipo String nestes actions pq o objetivo � retornar o arquivo sem o parametro nenhum.
	@GetMapping("/produtos/incluir")		//rota para incluir um novo produto   //PRODUZ O FORMUL�RIO
	public String incluir(Model model) {
		try {
			return "/produtos/novoProduto";		//novoProduto.jsp
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	@PostMapping("/cadproduto") //n�o ser� executado pela URL e sim pelo formul�rio			//RECEBE OS DADOS DO FORMUL�RIO
	public String incluir(Produto produto, Model model) {
		try {
			produtosDao.incluirProduto(produto);
			return "redirect:/produtos/listar";		// vai retornar uma rota. O redirect vai retornar um redirecionamento para uma rota.
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	//Altera��o Produto
	@GetMapping("/produtos/alterar/{idProduto}")		//entre chaves � o parametro de entrada na rota. A rota do ID que ser� alterado
	public String alterar(@PathVariable("idProduto") int id, Model model) {     //o primeiro parametro puxa a rota do ID que sera carregado na pagina jsp o model permite enviar informa��es para o jsp. O PathVariabe extrai o valor da roda acima, deve ser identico.
		try {
			Produto produto = produtosDao.buscarProduto(id);
			if (produto == null) {
				throw new Exception("Nenhum produto com o id informado.");
			}
			model.addAttribute("pdt", produto);
			return "produtos/alterarProduto";
			
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	@PostMapping("/alteraproduto")
	public String alterar(Produto produto, Model model) {
		try {
			produtosDao.alterarProduto(produto);
			return "redirect:/produtos/listar";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	@GetMapping("/produtos/remover/{id}")
	public String remover(@PathVariable("id") int id, Model model) {
		try {
			produtosDao.excluirProduto(id);
			return "redirect:/produtos/listar";
		} catch (Exception e) {									
			model.addAttribute("mensagem",e.getMessage());			
			return "erro";
		}
	}
	
	
	//action para incluir novos produtos via API
	@GetMapping("/produtos/incluirapi")
	public String incluirProdutoApi(Model model) {
		try {
			return "produtos/novoProdutoApi";				
		} catch (Exception e) {
			model.addAttribute("mensagem",e.getMessage());			
			return "erro";
		}
	}
	
}




