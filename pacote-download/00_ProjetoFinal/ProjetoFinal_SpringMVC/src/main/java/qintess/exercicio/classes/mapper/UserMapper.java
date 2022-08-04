package qintess.exercicio.classes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import qintess.exercicio.classes.model.UserInfo;

public class UserMapper implements RowMapper<UserInfo> {

	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo user = new UserInfo();
		user.setId(rs.getInt("id"));
		user.setLogin(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEnabled(rs.getBoolean("enabled"));
		
		return user;
	}

}
