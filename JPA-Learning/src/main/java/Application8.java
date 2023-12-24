import configuration.JPAUtil;
import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class Application8 {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

        Root<Student> studentRoot = criteriaQuery.from(Student.class);

        Predicate predicate = criteriaBuilder.equal(studentRoot.get("age"),25);

        criteriaQuery.where(predicate);

        criteriaQuery.orderBy(criteriaBuilder.asc(studentRoot.get("age")));

        CriteriaQuery<Student> studentCriteriaQuery = criteriaQuery.select(studentRoot);

        List<Student> studentList = entityManager.createQuery(studentCriteriaQuery).getResultList();

        System.out.println("Students Having Age 25");

        for (Student student: studentList
             ) {
            System.out.println(" Id : "+student.getId() +" Name : " +student.getName() + " Age : "+ student.getAge());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
