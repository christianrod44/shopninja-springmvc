package qintess.exercicio.classes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import qintess.exercicio.classes.mapper.ClienteMapper;
import qintess.exercicio.classes.model.Cliente;

public class ClienteDao {	

	private JdbcTemplate jdbcTemplate;
	
	public ClienteDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//incluir novo cliente
	public void incluirCliente(Cliente cliente) throws Exception{
		try {
			String sql = "INSERT INTO TB_CLIENTE (NOME, CPF, CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, UF)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			this.jdbcTemplate.update(sql, 
					cliente.getNome(), 
					cliente.getCpf(), 
					cliente.getCep(),
					cliente.getLogradouro(),
					cliente.getNumero(),
					cliente.getBairro(),
					cliente.getCidade(),
					cliente.getUf());
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	//alterar cliente
	public void alterarCliente(Cliente cliente) throws Exception {
		try {
			String sql = "UPDATE TB_CLIENTE SET NOME=?, CPF=?, CEP=?, LOGRADOURO=?, NUMERO=?, BAIRRO=?, CIDADE=?, UF=? WHERE ID=?";
			this.jdbcTemplate.update(sql,
					cliente.getNome(),
					cliente.getCpf(),
					cliente.getCep(),
					cliente.getLogradouro(),
					cliente.getNumero(),
					cliente.getBairro(),
					cliente.getCidade(),
					cliente.getUf(),
					cliente.getId());
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	//buscar cliente
	public Cliente buscarCliente(int id) throws Exception{
		Cliente cliente = null;
		try {
			String sql = "SELECT * FROM TB_CLIENTE WHERE  id = ?";
			cliente = jdbcTemplate.queryForObject(
					sql,
					new ClienteMapper(),
					new Object[] { id });
		} catch (Exception e) {
			throw e;
		}
		return cliente;
	}
	
	//método para listar os clientes
	public List<Cliente> listarCliente() throws Exception {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			String sql = "SELECT * FROM TB_CLIENTE";
			clientes = this.jdbcTemplate.query(sql, new ClienteMapper());
		} catch (Exception e) {
			throw e;
		}
		return clientes;
	}
	
	//Excluir um cliente
	public int excluirCliente(int id) throws Exception{
		int registros = 0;
		try {
			String sql = "DELETE FROM TB_CLIENTE WHERE ID = ?";
			registros = jdbcTemplate.update(sql, id);
		} catch (Exception e) {
			throw e;
		}
		return registros;
	}
	
}
