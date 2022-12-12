package fc;

import db.dao.DAOFactory;
import db.pojo.*;
import fc.movie.Movie;
import fc.movie.Rating;
import fc.support.BluRay;
import fc.support.BluRayRental;
import fc.support.Rental;
import fc.user.Client;
import fc.user.NonSubscriber;
import fc.user.Subscriber;

import java.sql.Date;
import java.util.*;

public class DatabaseManagement {

    public static void createBluRay(BluRay bluRay, int position) {
        int bluRayId = DAOFactory.getBluRayDAO().getNextId();
        String title = bluRay.getMovie().getTitle();
        Date releaseDate = new Date(bluRay.getMovie().getReleaseDate().getTimeInMillis());
        MoviePOJO moviePOJO = DAOFactory.getMovieDAO().readFromTitleAndDate(title, releaseDate);

        BluRayPOJO bluRayPOJO = new BluRayPOJO(bluRayId, bluRay.getSerialNumber(), moviePOJO, position);
        DAOFactory.getBluRayDAO().create(bluRayPOJO);
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

    public static Map<BluRay, Integer> readAllBluRays() {
        Map<BluRay, Integer> bluRays = new Hashtable<>();
        List<BluRayPOJO> bluRaysPOJO = DAOFactory.getBluRayDAO().readAll();
        bluRaysPOJO.forEach(bluRayPOJO -> bluRays.put(convertFromBluRayPOJO(bluRayPOJO), bluRayPOJO.getPosition()));
        return bluRays;
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

    public static Client readNonSubscriber(int creditCardNumber) {
        BluRayRentalPOJO bluRayRentalPOJO = DAOFactory.getBluRayRentalDAO().readFromCreditCardNumber(creditCardNumber);
        return new NonSubscriber(creditCardNumber, convertFromBluRayRentalPOJO(bluRayRentalPOJO));
    }

    public static void createSubscriber(Subscriber subscriber) {
        int id = DAOFactory.getSubscriberDAO().getNextId();

        SubscriberPOJO subscriberPOJO = new SubscriberPOJO(id,
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

        final SubscriberPOJO newSubscriberPOJO = DAOFactory.getSubscriberDAO().read(id);
        subscriber.getExcludedThemes().forEach(theme -> {
            PreferencePOJO preferencePOJO = new PreferencePOJO(DAOFactory.getPreferenceDAO().getNextId(),
                                                               newSubscriberPOJO,
                                                               DAOFactory.getThemeDAO().readFromName(theme),
                                                               false
            );
            DAOFactory.getPreferenceDAO().create(preferencePOJO);
        });
        subscriber.getForbiddenThemes().forEach(theme -> {
            PreferencePOJO preferencePOJO = new PreferencePOJO(DAOFactory.getPreferenceDAO().getNextId(),
                                                               newSubscriberPOJO,
                                                               DAOFactory.getThemeDAO().readFromName(theme),
                                                               true
            );
            DAOFactory.getPreferenceDAO().create(preferencePOJO);
        });
    }

    public static Subscriber readSubscriber(int subscriptionCardNumber) {
        SubscriberPOJO subscriberPOJO = DAOFactory.getSubscriberDAO()
                                                  .readFromSubscriptionCardNumber(subscriptionCardNumber);

        Set<Subscriber> ctrlSubs = new HashSet<>();
        subscriberPOJO.getControlledSubscribers()
                      .forEach(ctrlSub -> ctrlSubs.add(convertFromSubscriberPOJO(ctrlSub.getSubscriber(), null)));

        return convertFromSubscriberPOJO(subscriberPOJO, ctrlSubs);
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

    private static Movie convertFromMoviePOJO(MoviePOJO moviePOJO) {
        Calendar date = Calendar.getInstance();
        date.setTime(moviePOJO.getReleaseDate());

        List<String> themes = new ArrayList<>();
        moviePOJO.getMovieThemes().forEach(movieThemePOJO -> themes.add(movieThemePOJO.getTheme().getName()));

        List<String> directors = new ArrayList<>();
        moviePOJO.getDirectors().forEach(actorPOJO -> directors.add(actorPOJO.getName()));

        Map<String, String> actors = new LinkedHashMap<>();
        moviePOJO.getActors().forEach(actorPOJO -> actors.put(actorPOJO.getName(), actorPOJO.getCharacter()));

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

    private static BluRay convertFromBluRayPOJO(BluRayPOJO bluRayPOJO) {
        Movie movie = convertFromMoviePOJO(DAOFactory.getMovieDAO().read(bluRayPOJO.getMovie().getID()));
        return new BluRay(bluRayPOJO.getSerialNumber(), movie);
    }

    private static Subscriber convertFromSubscriberPOJO(SubscriberPOJO subscriberPOJO, Set<Subscriber> ctrlSubs) {
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(subscriberPOJO.getBirthDate());

        CtrlSubPOJO ctrlSubPOJO = DAOFactory.getCtrlSubDAO().readFromControlledSubscriber(subscriberPOJO);

        Map<String, Integer> themes = new LinkedHashMap<>();
        Set<String> excludedThemes = new HashSet<>();
        Set<String> forbiddenThemes = new HashSet<>();
        subscriberPOJO.getPreferences().forEach(preference -> {
            if (preference.isForbidden()) {
                forbiddenThemes.add(preference.getTheme().getName());
            } else {
                excludedThemes.add(preference.getTheme().getName());
            }
        });
        readAllThemes().forEach(theme -> {
            if (forbiddenThemes.contains(theme)) {
                themes.put(theme, ThemeManagement.FORBIDDEN);
            } else if (excludedThemes.contains(theme)) {
                themes.put(theme, ThemeManagement.EXCLUDED);
            } else {
                themes.put(theme, ThemeManagement.INCLUDED);
            }
        });

        Set<BluRayRental> bluRayRentals = new HashSet<>();
        List<BluRayRentalPOJO> bluRayRentalsPOJO = DAOFactory.getBluRayRentalDAO().readFromSubscriber(subscriberPOJO);
        bluRayRentalsPOJO.forEach(bluRayRentalPOJO -> bluRayRentals.add(convertFromBluRayRentalPOJO(bluRayRentalPOJO)));

        return new Subscriber(subscriberPOJO.getSubscriptionCardNumber(),
                              subscriberPOJO.getCreditCardNumber(),
                              subscriberPOJO.getEmail(),
                              subscriberPOJO.getFirstName(),
                              subscriberPOJO.getLastName(),
                              birthDate,
                              subscriberPOJO.getBalance(),
                              ctrlSubPOJO.isControlled(),
                              ctrlSubs,
                              themes,
                              bluRayRentals
        );
    }

    private static Rental convertFromRentalPOJO(RentalPOJO rentalPOJO) {
        Calendar rentalDate = Calendar.getInstance();
        rentalDate.setTime(rentalPOJO.getRentalDate());
        return new Rental(convertFromMoviePOJO(rentalPOJO.getMovie()), rentalDate);
    }

    private static BluRayRental convertFromBluRayRentalPOJO(BluRayRentalPOJO bluRayRentalPOJO) {
        Calendar rentalDate = Calendar.getInstance();
        rentalDate.setTime(bluRayRentalPOJO.getRental().getRentalDate());

        Calendar returnDate = Calendar.getInstance();
        rentalDate.setTime(bluRayRentalPOJO.getReturnDate());

        return new BluRayRental(convertFromBluRayPOJO(bluRayRentalPOJO.getBluRay()), rentalDate, returnDate);
    }
}
