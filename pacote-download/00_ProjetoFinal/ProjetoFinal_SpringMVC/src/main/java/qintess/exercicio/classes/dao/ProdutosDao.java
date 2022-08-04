	package qintess.exercicio.classes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import qintess.exercicio.classes.mapper.ProdutoApiMapper;
import qintess.exercicio.classes.mapper.ProdutoMapper;
import qintess.exercicio.classes.model.Produto;
import qintess.exercicio.classes.model.ProdutoApi;

public class ProdutosDao {	//diferente de Java Web, não tem super classe. Nessa classe ficaram os métodos trabalhados com o JdbcTemplate
	
	private JdbcTemplate jdbcTemplate;		//variável responsável pela manipulação dos dados

	public ProdutosDao(DataSource dataSource) {		//construtor com parametro DataSource
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}	//só indicamos a criação, quem vai utilizar vai ser o próprio Spring

	//método para incluir um novo produto
	public void incluirProduto(Produto produto) throws Exception{	//vai receber um objeto da classe Produto
		try {
			String sql = "INSERT INTO TB_PRODUTOS (NOME, DESCRICAO, VALOR)" 
		+ " VALUES (?, ?, ?)";
			this.jdbcTemplate.update(sql,
					produto.getNome(),
					produto.getDescricao(),
					produto.getValor());

		} catch (Exception e) {
			throw e;
		}
	}  
	
	//método para alterar um produto
	public void alterarProduto(Produto produto) throws Exception {
		try {
			String sql = "UPDATE TB_PRODUTOS SET NOME=?, DESCRICAO=?, VALOR=? WHERE ID=?";
			this.jdbcTemplate.update(sql,
					produto.getNome(),
					produto.getDescricao(),
					produto.getValor(),
					produto.getId());
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	//método para listar todos os produtos
	public List<Produto> listarProdutos() throws Exception {  //o jdbc, o query, vai se responsabilizar pelo que seria a lista sem a necessidade de criá-la.
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			String sql = "SELECT * FROM TB_PRODUTOS";
			produtos = jdbcTemplate.query(sql, new ProdutoMapper()); //o mapper foi aplicado aqui
			
		} catch (Exception e) {
			throw e;
		}
		return produtos;
	}
	
	//método para buscar um produto pelo ID
	public Produto buscarProduto(int id) throws Exception {
		Produto produto = null;		//não instancia pq pode ser que o produto não seja encontrado com tal ID
		try {
			String sql = "SELECT * FROM TB_PRODUTOS WHERE ID= ?";
			produto = jdbcTemplate.queryForObject( 		 //queryForObject para buscar apenas 1 objeto.
					sql, 
					new ProdutoMapper(),		//especifica como será a consulta.
					new Object[] { id });		//um array de Object.
		} catch (Exception e) {
			throw e;
		}
		return produto;
	}
	
	//método para excluir um produto pelo ID
	public int excluirProduto(long id) throws Exception {
		int registros = 0;
		try {
			String sql = "DELETE FROM TB_PRODUTOS WHERE ID= ?";
			registros = this.jdbcTemplate.update(sql, id);
		} catch (Exception e) {
			throw e;
		}
		return registros;    //se for 0 significa que não excluiu nada, se retornar 1 é porque houve exclusão.
	}
	
	
	
	
	
	
	
	//API - método para incluir um novo produto
	public void incluirProduto(ProdutoApi produto) throws Exception{
		try {
			String sql = "INSERT INTO TB_PRODUTOS (NOME, DESCRICAO, VALOR)" + " VALUES (?, ?, ?)";
			this.jdbcTemplate.update(sql,
					produto.getNome(),
					produto.getDescricao(),
					produto.getValor());

		} catch (Exception e) {
			throw e;
		}
	}
	
	//método para listar todos os produtos
	public List<ProdutoApi> listarProdutosApi() throws Exception {  //o jdbc, o query, vai se responsabilizar pelo que seria a lista sem a necessidade de criá-la.
		List<ProdutoApi> produtos = new ArrayList<ProdutoApi>();
		try {
			produtos = this.jdbcTemplate.query("SELECT * FROM TB_PRODUTOS", new ProdutoApiMapper()); //o mapper foi aplicado aqui
			
		} catch (Exception e) {
			throw e;
		}
		return produtos;
	}
	
	//método para buscar um produto pelo ID
	public ProdutoApi buscarProdutoApi(long id) throws Exception {
		ProdutoApi produto = null;		//não instancia pq pode ser que o produto não seja encontrado com tal ID
		try {
			produto = this.jdbcTemplate.queryForObject( 		 //queryForObject para buscar apenas 1 objeto.
					"SELECT * FROM TB_PRODUTOS WHERE ID= ?", 
					new ProdutoApiMapper(),		//especifica como será a consulta.
					new Object[] { id });		//um array de Object.
		} catch (Exception e) {
			throw e;
		}
		return produto;
	}
}
