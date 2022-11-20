package db.dao;

import java.sql.Connection;
import java.sql.SQLException;

import fc.Movie;

public class FilmDAO extends DAO1<Movie> {

    public FilmDAO(Connection conn){
        super(conn);
    }

    @Override
    public boolean create(Movie obj) throws SQLException {
        return false;
    }

    @Override
    public Movie read(Object obj) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Movie obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Movie obj) throws SQLException {
        return false;
    }


}
