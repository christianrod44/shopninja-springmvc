package qintess.exercicio.classes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import qintess.exercicio.classes.model.Venda;

public class VendaMapper implements RowMapper<Venda>{

	@Override
	public Venda mapRow(ResultSet rs, int rowNum) throws SQLException {		//ID DATAATUAL CLIENTE_ID PRODUTOS_ID TOTAL
		Venda venda = new Venda();
		venda.setId(rs.getInt("ID"));
		venda.setDataatual(rs.getDate("DATAATUAL"));
		venda.setTotal(rs.getDouble("TOTAL"));
		
		return venda;
	}
	
}
