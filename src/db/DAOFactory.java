package db;

import java.sql.Connection;

import db.dao.*;
import fc.BlueRay;
import fc.Card;
import fc.Movie;
import fc.Rental;
import fc.SubscribeCard;
import fc.Subscriber;

public class DAOFactory{
    protected static final Connection conn = Session.getConnection();
    
    public static DAO<Movie> getMovieDAO(){
        return new MovieDAO(conn);
    }

    public static DAO<BlueRay> getBluRayDAO(){
        return new BluRayDAO(conn);
    }

    public static DAO<Card> getCardDAO(){
        return new CardDAO(conn);
    }

    public static DAO<Rental> getRentalDAO(){
        return new RentalDAO(conn);
    }

    public static DAO<SubscribeCard> getSubscribeCardDAO(){
        return new SubscribeCardDAO(conn);
    }

    public static DAO<Subscriber> getSubscriberDAO(){
        return new SubscriberDAO(conn);
    }
}
