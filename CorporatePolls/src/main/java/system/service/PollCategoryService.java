package system.service;

import org.hibernate.Query;
import org.hibernate.Session;
import system.dao.PollCategoryDAO;
import system.entity.PollCategory;
import system.hibernate.SessionUtil;

import java.sql.SQLException;
import java.util.List;

public class PollCategoryService extends SessionUtil implements PollCategoryDAO {
    public void add(PollCategory pollCategory) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(pollCategory);
        closeTransactionSession();
    }

    public List<PollCategory> getAll() throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM category";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(PollCategory.class);
        List<PollCategory> pollCategoryList = query.list();
        closeTransactionSession();
        return pollCategoryList;
    }

    public void update(PollCategory pollCategory) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(pollCategory);
        closeTransactionSession();
    }

    public void remove(PollCategory pollCategory) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.delete(pollCategory);
        closeTransactionSession();
    }
}
