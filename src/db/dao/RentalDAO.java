package db.dao;

import java.sql.Connection;
import java.sql.SQLException;

import fc.Rental;

public class RentalDAO extends DAO1<Rental> {

    public RentalDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Rental obj) throws SQLException {
        return false;
    }

    @Override
    public Rental read(Object obj) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Rental obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Rental obj) throws SQLException {
        return false;
    }
    
}
