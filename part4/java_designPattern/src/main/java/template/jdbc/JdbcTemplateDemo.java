package template.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplateDemo {
    private JdbcTemplate jdbcTemplate;

    public User queryUser(long id) {
        String sql = "select * from user where id=" + id;
//        return jdbcTemplate.query(sql, (RowCallbackHandler) new UserRowMapper());
        return null;
    }

    class UserRowMapper implements RowMapper {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setTelephone(rs.getString("telephone"));
            return user;
        }

    }
}
