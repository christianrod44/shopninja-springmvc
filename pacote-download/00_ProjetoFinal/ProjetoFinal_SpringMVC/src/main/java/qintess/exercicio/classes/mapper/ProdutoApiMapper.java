package qintess.exercicio.classes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import qintess.exercicio.classes.model.ProdutoApi;

public class ProdutoApiMapper implements RowMapper<ProdutoApi> {

	@Override
	public ProdutoApi mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProdutoApi produto = new ProdutoApi(); // ID, NOME, DESCRICAO, VALOR
		produto.setId(rs.getInt("ID"));
		produto.setNome(rs.getString("NOME"));
		produto.setDescricao(rs.getString("DESCRICAO"));
		produto.setValor(rs.getDouble("VALOR"));

		return produto;
	}
}
