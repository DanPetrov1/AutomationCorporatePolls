package system.dao;

import system.entity.Poll;

import java.sql.SQLException;
import java.util.List;

public interface PollDAO {
    void add(Poll poll) throws SQLException;
    List<Poll> getAll() throws SQLException;
    void update(Poll poll) throws SQLException;
    void remove(Poll poll) throws SQLException;
}
