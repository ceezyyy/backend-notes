package dao;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtil;

import java.util.List;

public class UserDao {
    public User loginUser(User user) {

        // Create JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

        // Execute
        String sql = "select * from user where username = ? and password = ?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),
                user.getUsername(), user.getPassword());

        // Result
        if (users.size() != 0) {
            // Unique one
            return users.get(0);
        } else {
            return null;
        }
    }


}
