package db.dao;

import db.pojo.POJO;

public class DAOFactory {
    public static final DAO<? extends POJO>[] ALL_DAO = new DAO<?>[]{getActorDAO(),
                                                                     getBluRayDAO(),
                                                                     getBluRayRentalDAO(),
                                                                     getCtrlSubDAO(),
                                                                     getDirectorDAO(),
                                                                     getMovieDAO(),
                                                                     getMovieThemeDAO(),
                                                                     getNonSubRentalDAO(),
                                                                     getRentalDAO(),
                                                                     getScoreDAO(),
                                                                     getSubRentalDAO(),
                                                                     getSubscriberDAO(),
                                                                     getThemeDAO()
    };

    public static ActorDAO getActorDAO() {
        return ActorDAO.getInstance();
    }

    public static BluRayDAO getBluRayDAO() {
        return BluRayDAO.getInstance();
    }

    public static BluRayRentalDAO getBluRayRentalDAO() {
        return BluRayRentalDAO.getInstance();
    }

    public static CtrlSubDAO getCtrlSubDAO() {
        return CtrlSubDAO.getInstance();
    }

    public static DirectorDAO getDirectorDAO() {
        return DirectorDAO.getInstance();
    }

    public static MovieDAO getMovieDAO() {
        return MovieDAO.getInstance();
    }

    public static MovieThemeDAO getMovieThemeDAO() {
        return MovieThemeDAO.getInstance();
    }

    public static NonSubRentalDAO getNonSubRentalDAO() {
        return NonSubRentalDAO.getInstance();
    }

    public static PreferenceDAO getRestrictionDAO() {
        return PreferenceDAO.getInstance();
    }

    public static RentalDAO getRentalDAO() {
        return RentalDAO.getInstance();
    }

    public static ScoreDAO getScoreDAO() {
        return ScoreDAO.getInstance();
    }

    public static SubRentalDAO getSubRentalDAO() {
        return SubRentalDAO.getInstance();
    }

    public static SubscriberDAO getSubscriberDAO() {
        return SubscriberDAO.getInstance();
    }

    public static ThemeDAO getThemeDAO() {
        return ThemeDAO.getInstance();
    }
}
