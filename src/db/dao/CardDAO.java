package db.dao;

import db.entities.Card;

import java.util.ArrayList;
import java.util.List;

import db.jpa.CardJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CardDAO implements DAO<Card> {

    private final List<Card> cards = new ArrayList<>();
    public EntityManagerFactory emf;
    private final CardJPA cardJPA;

    public CardDAO() {
        emf = Persistence.createEntityManagerFactory("AL2000");
        cardJPA = new CardJPA(emf.createEntityManager());
    }

    @Override
    public Card get(int id) {
        return cardJPA.get(id);
    }

    @Override
    public List<Card> getAll() {
        return cardJPA.getAll();
    }

    @Override
    public void save(Card card) {
        cardJPA.save(card);
    }

    @Override
    public void update(Card card) {
        cardJPA.update(card);
    }

    @Override
    public void delete(Card card) {
        cardJPA.delete(card);
    }
}
