import configuration.JPAUtil;
import dao.CourseDao;
import dao.StudentDao;
import entities.Course;
import entities.Student;
import jakarta.persistence.EntityManager;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application3 {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        CourseDao courseDao = new CourseDao(entityManager);
        StudentDao studentDao = new StudentDao(entityManager);

        Student student = new Student();
        student.setName("Alvi");

        studentDao.save(student);

        Course course = new Course();
        course.setName("Computer Science");

        courseDao.save(course);

        Student student1 = studentDao.findStudentById(student.getId());
        Course course1 = courseDao.findCourseById(course.getId());

        // Create a Set<Course> with the single course
        Set<Course> coursesSet = new HashSet<>(Arrays.asList(course1));

        // Set the courses for the student
        student1.setCourses(coursesSet);

        studentDao.update(student1);

        entityManager.close();
    }
}
