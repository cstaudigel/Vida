package io.github.cstaudigel.service;

import io.github.cstaudigel.domain.models.InvolvmentRequest;
import io.github.cstaudigel.domain.models.Password;

import java.util.List;

public interface DataService {

    /**
     * verify admin password
     *
     * @param password
     * @return true if password is valid
     */
    boolean checkAdminPassword(String password);

    /**
     * check for password in database
     *
     * @param password
     * @return
     */
    boolean checkNotePassword(String password);

    /**
     * create new note
     *
     * @param title
     * @param content
     * @return true if note was created
     */
    boolean createNote(String title, String content);

    /**
     * delete a note
     * @param id
     * @return
     */
    boolean deleteNote(int id, String password);

    /**
     * create a posting password
     * @param password
     * @return
     */
    boolean createPassword(String password, String adminPassword);

    /**
     * delete a posting password
     * @param password
     * @return
     */
    boolean deletePassword(String password, String adminPassword);

    /**
     * returns all passwords in database
     * @return
     */
    List<Password> getPasswords(String admin);

    /**
     * save database to disk
     * @return
     */
    boolean saveDatabase();

    /**
     * create a new 'get involved' request
     * @param name
     * @param email
     * @param phone
     * @param message
     * @return
     */
    boolean createInvolvementRequest(String name, String email, String phone, String message);

    /**
     * returns all get involved submissions
     * @param admin
     * @return
     */
    List<InvolvmentRequest> getAllGetInvolved(String admin);
}
