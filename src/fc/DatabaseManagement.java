package fc;

import db.dao.DAOFactory;
import db.pojo.*;
import fc.movie.Movie;
import fc.movie.Rating;
import fc.support.BluRay;
import fc.support.BluRayRental;
import fc.user.NonSubscriber;
import fc.user.Subscriber;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DatabaseManagement {

    public static void createBluRay(BluRay bluRay, int position) {
        int bluRayId = DAOFactory.getBluRayDAO().getNextId();
        String title = bluRay.getMovie().getTitle();
        Date releaseDate = new Date(bluRay.getMovie().getReleaseDate().getTimeInMillis());
        MoviePOJO moviePOJO = DAOFactory.getMovieDAO().readFromTitleAndDate(title, releaseDate);

        BluRayPOJO bluRayPOJO = new BluRayPOJO(bluRayId, bluRay.getSerialNumber(), moviePOJO, position);
        DAOFactory.getBluRayDAO().create(bluRayPOJO);
    }

    public static Map<BluRay, Integer> readAllBluRays() {
        Map<BluRay, Integer> bluRays = new Hashtable<>();
        List<BluRayPOJO> bluRaysPOJO = DAOFactory.getBluRayDAO().readAll();

        bluRaysPOJO.forEach(bluRayPOJO -> {
            Movie movie = convertFromMoviePOJO(DAOFactory.getMovieDAO().read(bluRayPOJO.getMovie().getID()));
            BluRay bluRay = new BluRay(bluRayPOJO.getSerialNumber(), movie);
            bluRays.put(bluRay, bluRayPOJO.getPosition());
        });

        return bluRays;
    }

    public static void updateBluRay(BluRay bluRay, int position) {
        BluRayPOJO bluRayPOJO = DAOFactory.getBluRayDAO().readFromSerialNumber(bluRay.getSerialNumber());
        bluRayPOJO.setPosition(position);
        DAOFactory.getBluRayDAO().update(bluRayPOJO);
    }

    public static void deleteBluRay(BluRay bluRay) {
        BluRayPOJO bluRayPOJO = DAOFactory.getBluRayDAO().readFromSerialNumber(bluRay.getSerialNumber());
        DAOFactory.getBluRayDAO().delete(bluRayPOJO);
    }

    public static Set<Movie> readAllMovies() {
        Set<Movie> movies = new HashSet<>();
        List<MoviePOJO> moviesPOJO = DAOFactory.getMovieDAO().readAll();
        moviesPOJO.forEach(moviePOJO -> movies.add(convertFromMoviePOJO(moviePOJO)));
        return movies;
    }

    public static List<String> readAllThemes() {
        List<String> themes = new ArrayList<>();
        List<ThemePOJO> themesPOJO = DAOFactory.getThemeDAO().readAll();
        themesPOJO.forEach(themePOJO -> themes.add(themePOJO.getName()));
        return themes;
    }

    public static void createNonSubscriberBluRayRental(BluRayRental bluRayRental, NonSubscriber user) {
        String title = bluRayRental.getBluRay().getMovie().getTitle();
        Date releaseDate = new Date(bluRayRental.getBluRay().getMovie().getReleaseDate().getTimeInMillis());
        MoviePOJO moviePOJO = DAOFactory.getMovieDAO().readFromTitleAndDate(title, releaseDate);

        int serialNumber = bluRayRental.getBluRay().getSerialNumber();
        BluRayPOJO bluRayPOJO = DAOFactory.getBluRayDAO().readFromSerialNumber(serialNumber);

        int rentalId = DAOFactory.getRentalDAO().getNextId();
        Date rentalDate = new Date(bluRayRental.getRentalDate().getTimeInMillis());
        RentalPOJO rentalPOJO = new RentalPOJO(rentalId, moviePOJO, rentalDate);
        DAOFactory.getRentalDAO().create(rentalPOJO);

        int bluRayRentalId = DAOFactory.getBluRayDAO().getNextId();
        rentalPOJO = DAOFactory.getRentalDAO().readFromMovieAndDate(moviePOJO.getID(), rentalDate);
        BluRayRentalPOJO brRentalPOJO = new BluRayRentalPOJO(bluRayRentalId, rentalPOJO, bluRayPOJO, null);
        DAOFactory.getBluRayRentalDAO().create(brRentalPOJO);

        int nonSubRentalId = DAOFactory.getNonSubRentalDAO().getNextId();
        NonSubRentalPOJO nonSubRentalPOJO = new NonSubRentalPOJO(nonSubRentalId,
                                                                 rentalPOJO,
                                                                 user.getCreditCardNumber()
        );
        DAOFactory.getNonSubRentalDAO().create(nonSubRentalPOJO);
    }

    public static void createSubscriberRental(BluRayRental bluRayRental, Subscriber subscriber) {

    }

    public static void createSubscriber(Subscriber subscriber) {
        SubscriberPOJO subscriberPOJO = new SubscriberPOJO(DAOFactory.getSubscriberDAO().getNextId(),
                                                           DAOFactory.getSubscriberDAO()
                                                                     .readNextSubscriptionCardNumber(),
                                                           subscriber.getCreditCardNumber(),
                                                           subscriber.getFirstName(),
                                                           subscriber.getLastName(),
                                                           subscriber.getEmail(),
                                                           new Date(subscriber.getBirthDate().getTimeInMillis()),
                                                           subscriber.getBalance()
        );
        DAOFactory.getSubscriberDAO().create(subscriberPOJO);
    }

    private static Movie convertFromMoviePOJO(MoviePOJO moviePOJO) {
        Calendar date = Calendar.getInstance();
        date.setTime(moviePOJO.getReleaseDate());

        List<String> themes = new ArrayList<>();
        List<ThemePOJO> movieThemesPOJO = DAOFactory.getMovieThemeDAO().readFromMovieId(moviePOJO.getID());
        movieThemesPOJO.forEach(themePOJO -> themes.add(themePOJO.getName()));

        List<String> directors = new ArrayList<>();
        List<DirectorPOJO> directorsPOJO = DAOFactory.getDirectorDAO().readFromMovieId(moviePOJO.getID());
        directorsPOJO.forEach(actorPOJO -> directors.add(actorPOJO.getName()));

        Map<String, String> actors = new LinkedHashMap<>();
        List<ActorPOJO> actorsPOJO = DAOFactory.getActorDAO().readFromMovieId(moviePOJO.getID());
        actorsPOJO.forEach(actorPOJO -> actors.put(actorPOJO.getName(), actorPOJO.getCharacter()));

        float score = 0f;
        Set<ScorePOJO> scoresPOJO = DAOFactory.getScoreDAO().readFromMovieId(moviePOJO.getID());
        for (ScorePOJO scorePOJO : scoresPOJO) {
            score += (float) scorePOJO.getScore();
        }
        score /= (float) scoresPOJO.size();

        return new Movie(moviePOJO.getTitle(),
                         date,
                         moviePOJO.getRunningTime(),
                         Rating.valueOf(moviePOJO.getRating()),
                         score,
                         themes,
                         directors,
                         actors,
                         moviePOJO.getSynopsis(),
                         moviePOJO.getLinkURL(),
                         moviePOJO.getPosterURL()
        );
    }
}
