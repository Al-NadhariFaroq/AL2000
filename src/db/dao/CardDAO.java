package db.dao;

import java.sql.Connection;
import java.sql.SQLException;

import fc.Card;

public class CardDAO extends DAO<Card>{

    public CardDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Card obj) throws SQLException {
        return false;
    }

    @Override
    public Card read(Object obj) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Card obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Card obj) throws SQLException {
        return false;
    }
    
}
