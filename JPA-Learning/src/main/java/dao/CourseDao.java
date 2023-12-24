package dao;

import entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CourseDao {
    private final EntityManager entityManager;

    public CourseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Course course) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(course);
        entityTransaction.commit();
    }

    public Course findCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public List<Course> findAll() {
        TypedQuery<Course> query = entityManager.createQuery("SELECT s FROM Course s", Course.class);
        return query.getResultList();
    }

    public void update(Course Course) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(Course);
        entityTransaction.commit();
    }

    public void delete(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Course Course = entityManager.find(Course.class, id);
        if (Course != null) {
            entityManager.remove(Course);
        }
        entityTransaction.commit();
    }
}
