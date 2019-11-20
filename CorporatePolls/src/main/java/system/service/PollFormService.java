package system.service;

import org.hibernate.Query;
import org.hibernate.Session;
import system.dao.PollFormDAO;
import system.entity.PollForm;
import system.hibernate.SessionUtil;

import java.sql.SQLException;
import java.util.List;

public class PollFormService extends SessionUtil implements PollFormDAO {
    public void add(PollForm pollForm) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(pollForm);
        closeTransactionSession();
    }

    public List<PollForm> getAll() throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM poll_form";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(PollForm.class);
        List<PollForm> pollFormList = query.list();
        closeTransactionSession();
        return pollFormList;
    }

    public void update(PollForm pollForm) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(pollForm);
        closeTransactionSession();
    }

    public void remove(PollForm pollForm) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.delete(pollForm);
        closeTransactionSession();
    }
}
