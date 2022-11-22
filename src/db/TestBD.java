package db;

import db.dao.CardDAO;
import db.entities.Card;

public class TestBD {

    public static void main(String args[]) {
        CardDAO cardDAO =  new CardDAO();
        Card card =  new Card();
        cardDAO.save(card);
        card = cardDAO.get(123456784);
        System.out.println(card.getCardNumber());

    }

}


