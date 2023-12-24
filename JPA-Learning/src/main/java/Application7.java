import configuration.JPAUtil;
import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class Application7 {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

        Root<Student> studentRoot = criteriaQuery.from(Student.class);

        CriteriaQuery<Student> studentCriteriaQuery = criteriaQuery.select(studentRoot);

        Query query = entityManager.createQuery(studentCriteriaQuery);

        List<Student> studentList = query.getResultList();

        for (Student students : studentList
             ) {
            System.out.println("Id: " + students.getId() + " Name: " + students.getName());
        }
    }
}
