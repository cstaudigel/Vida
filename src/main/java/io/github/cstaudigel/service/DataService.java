package io.github.cstaudigel.service;

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
    boolean deleteNote(String id);

    /**
     * create a posting password
     * @param password
     * @return
     */
    boolean createPassword(String password);

    /**
     * delete a posting password
     * @param password
     * @return
     */
    boolean deletePassword(String password);
}
