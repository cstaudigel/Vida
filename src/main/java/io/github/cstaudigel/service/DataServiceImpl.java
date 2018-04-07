package io.github.cstaudigel.service;

import io.github.cstaudigel.dal.DataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class DataServiceImpl implements DataService {

    private DataDAO dataDAO;

    private final String adminPassword = "adminpassword";
    private final String superAdminPassword = "superadmin";

    @Autowired
    public DataServiceImpl(DataDAO dataDAO) {
        this.dataDAO = dataDAO;
    }

    /**
     * verify admin password
     *
     * @param password
     * @return true if password is valid
     */
    @Override
    public boolean checkAdminPassword(String password) {
        return adminPassword.equals(password);
    }

    /**
     * check for password in database
     *
     * @param password
     * @return
     */
    @Override
    public boolean checkNotePassword(String password) {
        return dataDAO.checkPassword(password);
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
        return dataDAO.createNote(title, content, Date.valueOf(LocalDate.now()));
    }

    /**
     * delete a note
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteNote(int id, String password) {
        if (checkAdminPassword(password)) return dataDAO.deleteNote(id);
        else return false;
    }

    /**
     * create a posting password
     *
     * @param password
     * @return
     */
    @Override
    public boolean createPassword(String password, String adminPassword) {
        if (checkAdminPassword(adminPassword)) return dataDAO.createPassword(password);
        else return false;
    }

    /**
     * delete a posting password
     *
     * @param password
     * @return
     */
    @Override
    public boolean deletePassword(String password, String adminPassword) {
        if (checkAdminPassword(adminPassword)) return dataDAO.deletePassword(password);
        else return false;
    }
}
