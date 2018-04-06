package io.github.cstaudigel.dal;

import io.github.cstaudigel.domain.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class DataDAOImpl implements DataDAO {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DataDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * create a new posting password
     *
     * @param password
     * @return
     */
    @Override
    public boolean createPassword(String password) {
        String sql = "INSERT INTO PASSWORDS (P_TEXT) VALUE (?)";

        jdbcTemplate.update(sql, password);
    }

    /**
     * delete posting password
     *
     * @param password
     * @return
     */
    @Override
    public boolean deletePassword(String password) {
        String sql = "DELETE FROM PASSWORD WHERE T_TEXT = ?";

        jdbcTemplate.update(sql, password);
    }

    /**
     * verify password is in database
     *
     * @param password
     * @return
     */
    @Override
    public boolean checkPassword(String password) {
        String sql = "SELECT * FROM PASSWORD WHERE T_TEXT = ?";

        List<Password> results = jdbcTemplate.query(sql,
                (rs, rowNum) ->
                    new Password("T_TEXT"));

        return !results.isEmpty();
    }

    /**
     * create a new post
     *
     * @param title
     * @param content
     * @param creationTime
     * @return
     */
    @Override
    public boolean createPost(String title, String content, Date creationTime) {
        return false;
    }

    /**
     * delete post from database
     *
     * @param id
     * @return
     */
    @Override
    public boolean deletePost(String id) {
        return false;
    }
}
