package io.github.cstaudigel.service;

import io.github.cstaudigel.dal.DataDAO;
import io.github.cstaudigel.domain.models.InvolvementRequest;
import io.github.cstaudigel.domain.models.Note;
import io.github.cstaudigel.domain.models.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public boolean createNote(String title, String content, String password) {
        if (checkNotePassword(password)) {
            return dataDAO.createNote(title, content, Date.valueOf(LocalDate.now()));
        } else return false;
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

    /**
     * returns all passwords in database
     *
     * @param admin
     * @return
     */
    @Override
    public List<Password> getPasswords(String admin) {

        if (checkAdminPassword(admin)) return dataDAO.getAllPasswords();
        else return new ArrayList<Password>(Arrays.asList(new Password("Incorrect Admin Password")));
    }

    /**
     * save database to disk
     *
     * @return
     */
    @Override
    public boolean saveDatabase() {
        return dataDAO.saveDatabase();
    }

    /**
     * create a new 'get involved' request
     * @param name
     * @param email
     * @param phone
     * @param message
     * @return
     */
    @Override
    public boolean createInvolvementRequest(String name, String email, String phone, String message) {
        return dataDAO.createNewGetInvolved(name, email, phone, message, Date.valueOf(LocalDate.now()));
    }

    /**
     * returns all get involved submissions
     *
     * @param admin
     * @return
     */
    @Override
    public List<InvolvementRequest> getAllGetInvolved(String admin) {
//        if (checkAdminPassword(admin)) {
//            return dataDAO.getAllGetInvolved();
//        } else {
//            return new ArrayList<>();
//        }

        return checkAdminPassword(admin) ? dataDAO.getAllGetInvolved() : new ArrayList<>(Arrays.asList(new InvolvementRequest("","","","Incorrect Admin Password", null, 0)));
    }

    /**
     * returns all notes
     *
     * @return
     */
    @Override
    public List<Note> getAllNotes() {
        return dataDAO.getAllNotes();
    }

    /**
     * return note
     *
     * @param id
     * @return
     */
    @Override
    public Note getNote(int id) {
        return dataDAO.getNote(id);
    }
}
