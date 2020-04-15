package model.dao;

import model.entity.User;

public interface UserDao extends GenericDao<User> {
    public static final String SQL_FIND_ALL = "select * from users";
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where user_id = ?";
    public static final String SQL_INSERT = "insert into users (username, password) values (?, ?)";
    public static final String SQL_UPDATE = "update users set password where user_id = ?";
    public static final String SQL_DELETE = "delete from users where user_id = ?";
}
