package fc;

import db.dao.DAOFactory;
import db.pojo.BluRayPOJO;
import db.pojo.MoviePOJO;
import db.pojo.ThemePOJO;
import fc.movie.Movie;
import fc.movie.Rating;
import fc.support.BluRay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class dbManagement {

    public static void createBluRay(BluRay bluRay, int position) {
        BluRayPOJO bluRayPOJO = new BluRayPOJO();
        bluRayPOJO.setSerialNumber(bluRay.getSerialNumber());
        bluRayPOJO.setMovieId(0);
        bluRayPOJO.setBluRayPosition(position);
        DAOFactory.getBluRayDAO().create(bluRayPOJO);
    }

    public static Map<BluRay, Integer> readAllBluRays() {
        Map<BluRay, Integer> bluRays = new Hashtable<>();
        Set<BluRayPOJO> bluRaysPOJO = DAOFactory.getBluRayDAO().readAll();

        bluRaysPOJO.forEach(bluRayPOJO -> {
            Movie movie = convertFromMoviePOJO(DAOFactory.getMovieDAO().read(bluRayPOJO.getMovieId()));
            BluRay bluRay = new BluRay(bluRayPOJO.getSerialNumber(), movie);
            bluRays.put(bluRay, bluRayPOJO.getBluRayPosition());
        });

        return bluRays;
    }

    public static void updateBluRay(BluRay bluRay, int position) {
        BluRayPOJO bluRayPOJO = DAOFactory.getBluRayDAO().readFromSerialNumber(bluRay.getSerialNumber());
        bluRayPOJO.setBluRayPosition(position);
        DAOFactory.getBluRayDAO().update(bluRayPOJO);
    }

    public static void deleteBluRay(BluRay bluRay) {
        BluRayPOJO bluRayPOJO = DAOFactory.getBluRayDAO().readFromSerialNumber(bluRay.getSerialNumber());
        DAOFactory.getBluRayDAO().delete(bluRayPOJO);
    }

    public static Set<Movie> readAllMovies() {
        Set<Movie> movies = new HashSet<>();
        Set<MoviePOJO> moviesPOJO = DAOFactory.getMovieDAO().readAll();
        moviesPOJO.forEach(moviePOJO -> movies.add(convertFromMoviePOJO(moviePOJO)));
        return movies;
    }

    public static List<String> readAllThemes() {
        List<String> themes = new ArrayList<>();
        List<ThemePOJO> themesPOJO = DAOFactory.getThemeDAO().readAll();
        themesPOJO.forEach(themePOJO -> themes.add(themePOJO.getTheme()));
        return themes;
    }

    private static Movie convertFromMoviePOJO(MoviePOJO moviePOJO) {
        Calendar date = Calendar.getInstance();
        date.setTime(moviePOJO.getReleaseDate());

        // read themes
        // read directors
        // read actors and roles
        // read and calculate score

        return new Movie(moviePOJO.getTitle(),
                         date,
                         null,
                         null,
                         null,
                         moviePOJO.getSynopsis(),
                         Rating.valueOf(moviePOJO.getRating()),
                         0f,
                         moviePOJO.getLinkURL(),
                         moviePOJO.getPosterURL()
        );
    }
}
