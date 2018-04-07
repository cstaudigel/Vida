package io.github.cstaudigel.dal;

import io.github.cstaudigel.domain.models.Note;
import io.github.cstaudigel.domain.models.Password;
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
        String sql = "INSERT INTO PASSWORDS (P_TEXT) VALUES (?);";

        if (jdbcTemplate.update(sql, password) == 1) {
            saveDatabase();
            return true;
        } else return false;
    }

    /**
     * delete posting password
     *
     * @param password
     * @return
     */
    @Override
    public boolean deletePassword(String password) {
        String sql = "DELETE FROM PASSWORDS WHERE T_TEXT = ?;";

        if (jdbcTemplate.update(sql, password) == 1) {
            saveDatabase();
            return true;
        } else return false;
    }

    /**
     * verify password is in database
     *
     * @param password
     * @return
     */
    @Override
    public boolean checkPassword(String password) {
        String sql = "SELECT * FROM PASSWORDS WHERE T_TEXT = ?;";

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
    public boolean createNote(String title, String content, Date creationTime) {
        String sql = "INSERT INTO NOTES (N_TITLE, N_CONTENT, N_DATE) VALUES (?, ?, ?);";

        if (jdbcTemplate.update(sql, new Object[] {title, content, creationTime}) == 1) {
            saveDatabase();
            return true;
        } else return false;
    }

    /**
     * delete post from database
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteNote(int id) {
        String sql = "DELETE FROM NOTES WHERE N_ID = ?;";

        if (jdbcTemplate.update(sql, id) == 1) {
            saveDatabase();
            return true;
        } else return false;
    }

    /**
     * return all notes in chronological order
     *
     * @return
     */
    @Override
    public List<Note> getAllNotes() {
        String sql = "SELECT * FROM NOTES ORDER BY N_DATE;";

        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new Note(
                        rs.getString("N_TITLE"),
                        rs.getString("N_CONTENT"),
                        rs.getDate("N_DATE"),
                        rs.getInt("N_ID")
                ));
    }

    /**
     * return note with specified ID
     *
     * @param ID
     * @return
     */
    @Override
    public Note getNote(int ID) {
        String sql = "SELECT * FROM NOTES WHERE N_ID = ?;";

        List<Note> results = jdbcTemplate.query(sql, (rs, rowNum) -> new Note(
                rs.getString("N_TITLE"),
                rs.getString("N_CONTENT"),
                rs.getDate("N_DATE"),
                rs.getInt("N_ID")
        ));

        if (!results.isEmpty()) return results.get(0);
        else return null;
    }

    /**
     * saves database to disk
     *
     * @return
     */
    @Override
    public boolean saveDatabase() {
        String sql = "SCRIPT TO 'src/main/resources/data.sql';";

        jdbcTemplate.execute(sql);

        return true;
    }

    /**
     * get all passwords from database
     *
     * @return
     */
    @Override
    public List<Password> getAllPasswords() {
        String sql = "SELECT * FROM PASSWORDS;";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new Password(
                rs.getString("P_TEXT")
        ));
    }
}
