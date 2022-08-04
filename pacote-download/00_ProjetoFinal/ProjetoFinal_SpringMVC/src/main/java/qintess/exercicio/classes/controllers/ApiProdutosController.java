package qintess.exercicio.classes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qintess.exercicio.classes.dao.ProdutosDao;
import qintess.exercicio.classes.model.ProdutoApi;

@RestController
@RequestMapping("/api")
public class ApiProdutosController {
	
	@Autowired
	private ProdutosDao produtosDao;
	
	@CrossOrigin
	@RequestMapping("/produtos")
	public List<ProdutoApi> listar() {
		try {
			return produtosDao.listarProdutosApi();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<ProdutoApi>();
		}
	}
	
	@CrossOrigin
	@RequestMapping("/produtos/{id}")
	public ProdutoApi buscar(@PathVariable("id") int id) {
		try {
			return produtosDao.buscarProdutoApi(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@CrossOrigin
	@RequestMapping(
			value = "/produtos",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ProdutoApi incluir(@RequestBody ProdutoApi produto) {
		try {
			produtosDao.incluirProduto(produto);
			return produto;
		} catch (Exception e) {
			e.printStackTrace();
			return new ProdutoApi();
		}
	}
	
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
	public int excluir(@PathVariable("id") int id) {
		try {
			return produtosDao.excluirProduto(id);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
