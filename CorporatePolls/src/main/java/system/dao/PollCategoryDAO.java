package system.dao;

import system.entity.PollCategory;

import java.sql.SQLException;
import java.util.List;

public interface PollCategoryDAO {
    void add(PollCategory pollCategory) throws SQLException;
    List<PollCategory> getAll() throws SQLException;
    void update(PollCategory pollCategory) throws SQLException;
    void remove(PollCategory pollCategory) throws SQLException;
    PollCategory findByCategoryName(String text);
}
