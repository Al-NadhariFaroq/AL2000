package db;

import java.sql.Connection;

import db.dao.*;
import fc.BluRay;
import fc.Card;
import fc.Movie;
import fc.Rental;
import fc.SubscribeCard;
import fc.Subscriber;

public class DAOFactory{
    protected static final Connection conn = Session.getConnection();
    
    public static DAO1<Movie> getMovieDAO(){
        return new FilmDAO(conn);
    }

    public static DAO1<BluRay> getBluRayDAO(){
//        return new BluRayDAO();
        return null;
    }

    public static DAO1<Card> getCardDAO(){
//        return new CardDAO(conn);
        return null;
    }

    public static DAO1<Rental> getRentalDAO(){
        return new RentalDAO(conn);
    }

    public static DAO1<SubscribeCard> getSubscribeCardDAO(){
        return new SubscribeCardDAO(conn);
    }

    public static DAO1<Subscriber> getSubscriberDAO(){
//        return new SubscriberDAO(conn);
        return null;
    }
}
