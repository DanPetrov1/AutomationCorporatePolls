package system.service;

import org.hibernate.Query;
import org.hibernate.Session;
import system.dao.UserDAO;
import system.entity.User;
import system.hibernate.SessionUtil;

import java.sql.SQLException;
import java.util.List;

public class UserService extends SessionUtil implements UserDAO {
    public void add(User user) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(user);
        closeTransactionSession();
    }

    public List<User> getUser() throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM users";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        List<User> users = query.list();
        closeTransactionSession();
        return users;
    }

    public void update(User user) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(user);
        closeTransactionSession();
    }

    public void remove(User user) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.delete(user);
        closeTransactionSession();
    }

    public User findUserById(int id) {
        openTransactionSession();
        String sql = "SELECT * FROM users WHERE id =" + id;
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        List<User> userList = query.list();
        closeTransactionSession();
        return userList.get(0);
    }
}
