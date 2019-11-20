package system.service;

import org.hibernate.Query;
import org.hibernate.Session;
import system.dao.CompilerDAO;
import system.entity.Compiler;
import system.hibernate.SessionUtil;

import java.sql.SQLException;
import java.util.List;

public class CompilerService extends SessionUtil implements CompilerDAO {
    public void add(Compiler compiler) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(compiler);
        closeTransactionSession();
    }

    public List<Compiler> getAll() throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM compiler";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Compiler.class);
        List<Compiler> compilerList = query.list();
        closeTransactionSession();
        return compilerList;
    }

    public void update(Compiler compiler) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(compiler);
        closeTransactionSession();
    }

    public void remove(Compiler compiler) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.delete(compiler);
        closeTransactionSession();
    }
}
