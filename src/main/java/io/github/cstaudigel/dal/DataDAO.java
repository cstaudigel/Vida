package io.github.cstaudigel.dal;

import io.github.cstaudigel.domain.models.Note;
import io.github.cstaudigel.domain.models.Password;

import java.sql.Date;
import java.util.List;

public interface DataDAO {

    /**
     * create a new posting password
     * @param password
     * @return
     */
    boolean createPassword(String password);

    /**
     * delete posting password
     * @param password
     * @return
     */
    boolean deletePassword(String password);

    /**
     * verify password is in database
     * @param password
     * @return
     */
    boolean checkPassword(String password);

    /**
     * create a new post
     * @param title
     * @param content
     * @param creationTime
     * @return
     */
    boolean createNote(String title, String content, Date creationTime);

    /**
     * delete post from database
     * @param id
     * @return
     */
    boolean deleteNote(int id);

    /**
     * return all notes in chronological order
     *
     * @return
     */
    List<Note> getAllNotes();

    /**
     * return note with specified ID
     * @param ID
     * @return
     */
    Note getNote(int ID);

    /**
     * saves database to disk
     * @return
     */
    boolean saveDatabase();

    /**
     * get all passwords from database
     * @return
     */
    List<Password> getAllPasswords();
}
