package qintess.exercicio.classes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import qintess.exercicio.classes.model.Role;

public class RoleMapper implements RowMapper<Role>{

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		role.setId(rs.getInt("id"));
		role.setRole(rs.getString("authority"));
		role.setUserid(rs.getInt("user_id"));
		
		return role;
	}

}
