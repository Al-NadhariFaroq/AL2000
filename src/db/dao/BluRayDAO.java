package db.dao;

import java.sql.Connection;
import java.sql.SQLException;

import fc.BlueRay;

public class BluRayDAO extends DAO<BlueRay>{

    public BluRayDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(BlueRay obj) throws SQLException {
        return false;
    }

    @Override
    public BlueRay read(Object obj) throws SQLException {
        return null;
    }

    @Override
    public boolean update(BlueRay obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(BlueRay obj) throws SQLException {
        return false;
    }
    
}
