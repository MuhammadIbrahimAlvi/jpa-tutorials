package dao;

import entities.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UniversityDao {

    private final EntityManager entityManager;

    public UniversityDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(University University) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(University);
        entityTransaction.commit();
    }

    public University findUniversityById(Long id) {
        return entityManager.find(University.class, id);
    }

    public List<University> findAll() {
        TypedQuery<University> query = entityManager.createQuery("SELECT s FROM University s", University.class);
        return query.getResultList();
    }

    public void update(University University) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(University);
        entityTransaction.commit();
    }

    public void delete(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        University University = entityManager.find(University.class, id);
        if (University != null) {
            entityManager.remove(University);
        }
        entityTransaction.commit();
    }
}
