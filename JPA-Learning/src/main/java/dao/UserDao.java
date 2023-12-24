package dao;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserDao {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();
    }

    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT s FROM User s", User.class);
        return query.getResultList();
    }

    public void update(User user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(user);
        entityTransaction.commit();
    }

    public void delete(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
        entityTransaction.commit();
    }
}
