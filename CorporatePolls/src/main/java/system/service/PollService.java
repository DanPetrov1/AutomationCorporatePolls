package system.service;

import org.hibernate.Query;
import org.hibernate.Session;
import system.dao.PollDAO;
import system.entity.Poll;
import system.entity.PollForm;
import system.hibernate.SessionUtil;

import java.sql.SQLException;
import java.util.List;

public class PollService extends SessionUtil implements PollDAO {
    public void add(Poll poll) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(poll);
        closeTransactionSession();
    }

    public List<Poll> getAll() throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM poll";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Poll.class);
        List<Poll> pollList = query.list();
        closeTransactionSession();
        return pollList;
    }

    public List<Poll> getAllByCategoryId(int id) throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM poll WHERE id_category =" + id;
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Poll.class);
        List<Poll> pollList = query.list();
        closeTransactionSession();
        return pollList;
    }

    public void update(Poll poll) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(poll);
        closeTransactionSession();
    }

    public void remove(Poll poll) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.delete(poll);
        closeTransactionSession();
    }

    public List<PollForm> getPollFormByUserId(int id) {
        openTransactionSession();
        String sql = "SELECT * FROM poll_form WHERE id_user =" + id;
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Poll.class);
        List<PollForm> pollFormList = query.list();
        closeTransactionSession();
        return pollFormList;
    }
}
