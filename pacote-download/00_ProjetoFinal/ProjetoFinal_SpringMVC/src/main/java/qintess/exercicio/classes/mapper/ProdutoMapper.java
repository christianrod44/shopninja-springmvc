package qintess.exercicio.classes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import qintess.exercicio.classes.model.Produto;

public class ProdutoMapper implements RowMapper<Produto>{ //essa classe representa como queremos obter o resultado da nossa consulta, a classe implementada é para Spring (observar, pois tem mais de um com o mesmo nome), parametrizar a classe que quer mapear

	@Override
	public Produto mapRow(ResultSet rs, int rowNum) throws SQLException { //esse método vai buscar os dados quando for feito uma consulta, seja listagem, ou uma simpes busca
		Produto produto = new Produto();   //ID, NOME, DESCRICAO, VALOR
		produto.setId(rs.getInt("ID"));
		produto.setNome(rs.getString("NOME"));
		produto.setDescricao(rs.getString("DESCRICAO"));
		produto.setValor(rs.getDouble("VALOR"));
		
		return produto;
	}		

}
