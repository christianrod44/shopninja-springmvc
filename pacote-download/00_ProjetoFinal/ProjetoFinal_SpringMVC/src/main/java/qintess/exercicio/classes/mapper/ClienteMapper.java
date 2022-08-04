package qintess.exercicio.classes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import qintess.exercicio.classes.model.Cliente;

public class ClienteMapper implements RowMapper<Cliente>{
	
	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt("ID"));
		cliente.setNome(rs.getString("NOME"));
		cliente.setCpf(rs.getLong("CPF"));
		cliente.setCep(rs.getLong("CEP"));
		cliente.setLogradouro(rs.getString("LOGRADOURO"));
		cliente.setNumero(rs.getInt("NUMERO"));
		cliente.setBairro(rs.getString("BAIRRO"));
		cliente.setCidade(rs.getString("CIDADE"));
		cliente.setUf(rs.getString("UF"));
		
		return cliente;
	}


}
