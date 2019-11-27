package system.dao;

import system.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void add(User user) throws SQLException;
    List<User> getUser() throws SQLException;
    void update(User user) throws SQLException;
    void remove(User user) throws SQLException;
    User findUserById(int id);
}
