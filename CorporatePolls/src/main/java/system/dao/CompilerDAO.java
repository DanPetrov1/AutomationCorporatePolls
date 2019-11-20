package system.dao;

import system.entity.Compiler;

import java.sql.SQLException;
import java.util.List;

public interface CompilerDAO {
    void add(Compiler compiler) throws SQLException;
    List<Compiler> getAll() throws SQLException;
    void update(Compiler compiler) throws SQLException;
    void remove(Compiler compiler) throws SQLException;
}
