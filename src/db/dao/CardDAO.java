package db.dao;

import db.entities.CardEntity;

import java.util.ArrayList;
import java.util.List;

import db.jpa.CardJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CardDAO implements DAO<CardEntity> {

    private final List<CardEntity> cardEntities = new ArrayList<>();
    public EntityManagerFactory emf;
    private final CardJPA cardJPA;

    public CardDAO() {
        emf = Persistence.createEntityManagerFactory("AL2000");
        cardJPA = new CardJPA(emf.createEntityManager());
    }

    @Override
    public CardEntity get(int id) {
        return cardJPA.get(id);
    }

    @Override
    public List<CardEntity> getAll() {
        return cardJPA.getAll();
    }

    @Override
    public void save(CardEntity cardEntity) {
        cardJPA.save(cardEntity);
    }

    @Override
    public void update(CardEntity cardEntity) {
        cardJPA.update(cardEntity);
    }

    @Override
    public void delete(CardEntity cardEntity) {
        cardJPA.delete(cardEntity);
    }
}
