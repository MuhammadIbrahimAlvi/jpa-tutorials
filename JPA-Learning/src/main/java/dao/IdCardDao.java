package dao;

import entities.IdCard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class IdCardDao {

    private final EntityManager entityManager;

    public IdCardDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(IdCard IdCard) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(IdCard);
        entityTransaction.commit();
    }

    public IdCard findIdCardById(Long id) {
        return entityManager.find(IdCard.class, id);
    }

    public List<IdCard> findAll() {
        TypedQuery<IdCard> query = entityManager.createQuery("SELECT s FROM IdCard s", IdCard.class);
        return query.getResultList();
    }

    public void update(IdCard IdCard) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(IdCard);
        entityTransaction.commit();
    }

    public void delete(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        IdCard IdCard = entityManager.find(IdCard.class, id);
        if (IdCard != null) {
            entityManager.remove(IdCard);
        }
        entityTransaction.commit();
    }
}
