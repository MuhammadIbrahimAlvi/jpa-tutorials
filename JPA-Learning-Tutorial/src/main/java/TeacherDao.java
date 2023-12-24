import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TeacherDao {

    private final EntityManager entityManager;

    public TeacherDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Teacher teacher) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(teacher);
        entityTransaction.commit();
    }

    public Teacher findTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public List<Teacher> findAll() {
        TypedQuery<Teacher> query = entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class);
        return query.getResultList();
    }

    public void update(Teacher teacher) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(teacher);
        entityTransaction.commit();
    }

    public void delete(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Teacher teacher = entityManager.find(Teacher.class, id);
        if (teacher != null) {
            entityManager.remove(teacher);
        }
        entityTransaction.commit();
    }
}
