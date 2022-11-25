package db.dao;

import db.entities.SubscriberEntity;

import java.util.ArrayList;
import java.util.List;

import db.jpa.SubscriberJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SubscriberDAO implements DAO<SubscriberEntity> {

    private final List<SubscriberEntity> subscriberEntities = new ArrayList<>();
    public EntityManagerFactory emf;
    private final SubscriberJPA subscriberJPA;

    public SubscriberDAO() {
        emf = Persistence.createEntityManagerFactory("AL2000");
        subscriberJPA = new SubscriberJPA(emf.createEntityManager());
    }

    @Override
    public SubscriberEntity get(int id) {
        return subscriberJPA.get(id);
    }

    @Override
    public List<SubscriberEntity> getAll() {
        return subscriberJPA.getAll();
    }

    @Override
    public void save(SubscriberEntity subscriberEntity) {
        subscriberJPA.save(subscriberEntity);
    }

    @Override
    public void update(SubscriberEntity subscriberEntity) {
        subscriberJPA.update(subscriberEntity);
    }

    @Override
    public void delete(SubscriberEntity subscriberEntity) {
        subscriberJPA.delete(subscriberEntity);
    }
}
