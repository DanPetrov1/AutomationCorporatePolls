package system.dao;

import system.entity.PollForm;

import java.sql.SQLException;
import java.util.List;

public interface PollFormDAO {
    void add(PollForm pollForm) throws SQLException;
    List<PollForm> getAll() throws SQLException;
    void update(PollForm pollForm) throws SQLException;
    void remove(PollForm pollForm) throws SQLException;
}
