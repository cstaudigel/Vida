package io.github.cstaudigel.dal;

import java.sql.Date;

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
    boolean createPost(String title, String content, Date creationTime);

    /**
     * delete post from database
     * @param id
     * @return
     */
    boolean deletePost(String id);
}
