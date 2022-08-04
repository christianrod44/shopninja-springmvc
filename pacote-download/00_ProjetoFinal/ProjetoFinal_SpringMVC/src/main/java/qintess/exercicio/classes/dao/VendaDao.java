package qintess.exercicio.classes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import qintess.exercicio.classes.mapper.VendaMapper;
import qintess.exercicio.classes.model.Venda;

public class VendaDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public VendaDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//método para incluir uma venda
	public void incluirVenda(Venda venda) throws Exception {
		try {
			
			String sql = "INSERT INTO TB_VENDAS (DATAATUAL, PRODUTOS_ID, CLIENTE_ID, TOTAL)" 
					+ " VALUES (?, ?, ?, ?)";
			this.jdbcTemplate.update(sql,
					new java.sql.Date(venda.getDataatual().getTime()),
					venda.getProduto().getId(),
					venda.getCliente().getId(),
					venda.getTotal());
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	//metodo para listar as vendas
	public List<Venda> listaVenda() throws Exception {
		List<Venda> vendas = new ArrayList<Venda>();
		try {
			String sql = "SELECT * FROM TB_VENDAS";
			vendas = this.jdbcTemplate.query(sql, new VendaMapper());
			
		} catch (Exception e) {
			throw e;
		}
		return vendas;
	}
	
	//Excluir uma venda
	public int excluirVenda(int id) throws Exception{
		int registros = 0;
		try {
			String sql = "DELETE FROM TB_VENDAS WHERE ID = ?";
			registros = jdbcTemplate.update(sql, id);
		} catch (Exception e) {
			throw e;
		}
		return registros;
	}
}
