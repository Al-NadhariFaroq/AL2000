package db.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAO1<T> {
    protected Connection conn;

    protected DAO1(Connection conn) {
        this.conn = conn;
    }

    public abstract boolean create(T obj) throws SQLException;

    public abstract T read (Object obj) throws SQLException;

    public abstract boolean update (T obj) throws SQLException;

    public abstract boolean delete(T obj) throws SQLException;

}

