package db.dao;

import db.pojo.MovieThemePOJO;
import db.pojo.ThemePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MovieThemeDAO extends DAO<MovieThemePOJO> {

    protected MovieThemeDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public MovieThemePOJO read(int id) {
        MovieThemePOJO movieThemePOJO = entityManager.find(MovieThemePOJO.class, id);
        if (movieThemePOJO == null) {
            throw new EntityNotFoundException("Can't find movie theme for ID " + id);
        }
        return movieThemePOJO;
    }

    @Override
    public int getNextId() {
        Integer maxId = entityManager.createQuery("select max(movieThemeId) from Movies_Themes ", Integer.class).getSingleResult();
        if (maxId == null) {
            return 0;
        }
        return maxId + 1;
    }

    public List<ThemePOJO> readFromMovieId(int movieId) {
        List<ThemePOJO> themesPOJO = new ArrayList<>();
        // TODO find all themes from a movie ID order by theme_rank
        return themesPOJO;
    }
}
