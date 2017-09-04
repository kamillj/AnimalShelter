package pl.kamilj.animalShelter.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.kamilj.animalShelter.domain.Animal;
import pl.kamilj.animalShelter.hibernate.configuration.HibernateUtil;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public class AnimalHbmDAO {

    public void create(Animal animal) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(animal);
            transaction.commit();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException("Cannot create Animal.", exception);
        }
    }

    public List<Animal> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Animal> animals = session.createQuery("FROM Animal ", Animal.class).getResultList();
            session.getTransaction().commit();

            return animals;
        } catch (Exception exception) {
            throw new RuntimeException("Error when retrieving Animals.", exception);
        }
    }
}