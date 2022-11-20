package db.dao;

import db.entities.Subscriber;

import java.util.ArrayList;
import java.util.List;
import db.jpa.SubscriberJPA;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SubscriberDAO implements Dao<Subscriber> {

    private final List<Subscriber> subscribers = new ArrayList<>();
    public EntityManagerFactory emf;
    private final SubscriberJPA subscriberJPA;
    public SubscriberDAO() {
        emf= Persistence.createEntityManagerFactory("AL2000");
        subscriberJPA = new SubscriberJPA(emf.createEntityManager());
    }

    @Override
    public Subscriber get(long id) {
        return subscriberJPA.get(id);
    }

    @Override
    public List<Subscriber> getAll() {
        return subscriberJPA.getAll();
    }

    @Override
    public void save(Subscriber subscriber) {
        subscriberJPA.save(subscriber);
    }

    @Override
    public void update(Subscriber subscriber) {
        subscriberJPA.update(subscriber);
    }

    @Override
    public void delete(Subscriber subscriber) {
        subscriberJPA.delete(subscriber);
    }
}
