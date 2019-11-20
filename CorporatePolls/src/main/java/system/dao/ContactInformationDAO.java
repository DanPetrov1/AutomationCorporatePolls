package system.dao;

import system.entity.ContactInformation;

import java.sql.SQLException;
import java.util.List;

public interface ContactInformationDAO {
    void add(ContactInformation contactInformation) throws SQLException;
    List<ContactInformation> getAll() throws SQLException;
    void update(ContactInformation contactInformation) throws SQLException;
    void remove(ContactInformation contactInformation) throws SQLException;
}
