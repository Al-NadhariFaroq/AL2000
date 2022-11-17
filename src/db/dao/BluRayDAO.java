package db.dao;

import java.sql.Connection;
import java.sql.SQLException;

import fc.BluRay;

public class BluRayDAO extends DAO<BluRay>{

    public BluRayDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(BluRay obj) throws SQLException {
        return false;
    }

    @Override
    public BluRay read(Object obj) throws SQLException {
        return null;
    }

    @Override
    public boolean update(BluRay obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(BluRay obj) throws SQLException {
        return false;
    }
    
}
