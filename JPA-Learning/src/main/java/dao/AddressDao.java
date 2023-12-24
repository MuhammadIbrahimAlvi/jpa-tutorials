package dao;

import entities.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AddressDao {

    private final EntityManager entityManager;

    public AddressDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Address address) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(address);
        entityTransaction.commit();
    }

    public Address findAddressById(Long id) {
        return entityManager.find(Address.class, id);
    }

    public List<Address> findAll() {
        TypedQuery<Address> query = entityManager.createQuery("SELECT s FROM Address s", Address.class);
        return query.getResultList();
    }

    public void update(Address address) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(address);
        entityTransaction.commit();
    }

    public void delete(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Address address = entityManager.find(Address.class, id);
        if (address != null) {
            entityManager.remove(address);
        }
        entityTransaction.commit();
    }
}
