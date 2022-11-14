package db.dao;

import db.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class FilmDAO extends DAO<Film> {
    public FilmDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Film obj) {
        return false;
    }

    @Override
    public Film read(Object id) {
        Film film = null;

        try (PreparedStatement lesFilms = conn.prepareStatement("SELECT * FROM LESFILMS WHERE IDFILM = ?")) {
            lesFilms.setInt(1, (Integer)id);
            ResultSet resultSet = lesFilms.executeQuery();

           film = new Film();
            if (resultSet.next()) {
                film.setId(resultSet.getInt(1));
                film.setTitle(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public boolean update(Film obj) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("UPDATE LESFILMS SET FILMTITLE = ? WHERE IDFILM = ?")) {
            preparedStatement.setString(1, obj.getTitle());
            preparedStatement.setLong(2, obj.getId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Film obj) {
        return false;
    }
}

