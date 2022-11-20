package db.dao;

import java.sql.Connection;
import java.sql.SQLException;

import fc.SubscribeCard;

public class SubscribeCardDAO extends DAO1<SubscribeCard> {

    public SubscribeCardDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(SubscribeCard obj) throws SQLException {
        return false;
    }

    @Override
    public SubscribeCard read(Object obj) throws SQLException {
        return null;
    }

    @Override
    public boolean update(SubscribeCard obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(SubscribeCard obj) throws SQLException {
        return false;
    }
    
}
