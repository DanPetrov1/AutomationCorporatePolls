package system.service;

import org.hibernate.Query;
import org.hibernate.Session;
import system.dao.ContactInformationDAO;
import system.entity.ContactInformation;
import system.hibernate.SessionUtil;

import java.sql.SQLException;
import java.util.List;

public class ContactInformationService extends SessionUtil implements ContactInformationDAO {
    public void add(ContactInformation contactInformation) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(contactInformation);
        closeTransactionSession();
    }

    public List<ContactInformation> getAll() throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM contactinformation";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ContactInformation.class);
        List<ContactInformation> contactInformationList = query.list();
        closeTransactionSession();
        return contactInformationList;
    }

    public void update(ContactInformation contactInformation) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(contactInformation);
        closeTransactionSession();
    }

    public void remove(ContactInformation contactInformation) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.delete(contactInformation);
        closeTransactionSession();
    }
}
