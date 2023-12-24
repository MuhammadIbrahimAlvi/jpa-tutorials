import configuration.JPAUtil;
import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class Application6 {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

//        Query query = entityManager.createQuery("select s.name from Student s");
//
//
//        List<String> studentNameList = query.getResultList();
//        System.out.println("Student Name: ");
//        for(String name : studentNameList) {
//            System.out.println(name);
//        }
//
//        Query query1 = entityManager.createQuery("select s from Student s");
//        List<Student> students = query1.getResultList();
//        System.out.println("All Data: ");
//        for(Student student : students) {
//            System.out.println(" Id: " + student.getId() +" Name:"+ student.getName());
//        }
//
//        Query updateQuery = entityManager.createQuery("update Student s set s.name = 'Ali' where s.id = 1");
//        updateQuery.executeUpdate();
//
//        entityManager.getTransaction().commit();
//        Query query1 = entityManager.createQuery("select s from Student s");
//
//        List<Student> studentss = query1.getResultList();
//        System.out.println("All Data: ");
//        for(Student student : studentss) {
//            System.out.println(" Id: " + student.getId() +" Name:"+ student.getName());
//        }
//
//        Query query = entityManager.createQuery("delete from Student s where s.id = 102");
//        query.executeUpdate();
//
//
//        List<Student> students = query1.getResultList();
//        System.out.println("All Data: ");
//        for(Student student : students) {
//            System.out.println(" Id: " + student.getId() +" Name:"+ student.getName());
//        }

        Query filterQuery = entityManager.createQuery("select s from Student s where s.name like '%Alvi%'");

        List<Student> studentList = filterQuery.getResultList();
        for (Student student: studentList
             ) {
            System.out.println(" Name of Student "+ student.getName()+" Id:"+ student.getId());
        }
        entityManager.close();

    }
}
