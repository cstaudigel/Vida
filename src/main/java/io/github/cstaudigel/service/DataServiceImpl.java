package io.github.cstaudigel.service;

import org.springframework.stereotype.Component;

@Component
public class DataServiceImpl implements DataService {

    /**
     * verify admin password
     *
     * @param password
     * @return true if password is valid
     */
    @Override
    public boolean checkAdminPassword(String password) {
        return false;
    }

    /**
     * check for password in database
     *
     * @param password
     * @return
     */
    @Override
    public boolean checkNotePassword(String password) {
        return false;
    }

    /**
     * create new note
     *
     * @param title
     * @param content
     * @return true if note was created
     */
    @Override
    public boolean createNote(String title, String content) {
        return false;
    }

    /**
     * delete a note
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteNote(String id) {
        return false;
    }

    /**
     * create a posting password
     *
     * @param password
     * @return
     */
    @Override
    public boolean createPassword(String password) {
        return false;
    }

    /**
     * delete a posting password
     *
     * @param password
     * @return
     */
    @Override
    public boolean deletePassword(String password) {
        return false;
    }
}
