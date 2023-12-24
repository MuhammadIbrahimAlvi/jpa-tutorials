
import jakarta.persistence.EntityManager;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        StudentDao studentDAO = new StudentDao(entityManager);

        // Create Student
        Student student = new Student();
        student.setName("Seregia");
        student.setAge(25);

        studentDAO.save(student);

        System.out.println("Find Student By ID:" + studentDAO.findStudentById(student.getId()));

        List<Student> students = studentDAO.findAll();
        System.out.println("All Students");
        students.forEach(System.out::println);

        student.setAge(24);
        studentDAO.update(student);
        System.out.println("Updated Student:" + studentDAO.findStudentById(student.getId()));


        studentDAO.delete(student.getId());
        List<Student> studentsList = studentDAO.findAll();
        System.out.println("All Students");
        studentsList.forEach(System.out::println);

    }
}
