import jakarta.persistence.EntityManager;

import java.util.Arrays;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        CourseDao courseDao = new CourseDao(entityManager);
        StudentDao studentDao = new StudentDao(entityManager);
        TeacherDao teacherDao = new TeacherDao(entityManager);

        Teacher teacher = new Teacher();
        teacher.setName("Ibrahim Alvi");
        teacherDao.save(teacher);

        Course course = new Course();
        course.setName("Computer Science");
        course.setTeacher(teacher);
        courseDao.save(course);

        Student student = new Student();
        student.setName("Muhammad Ibrahim");
        student.setAge(25);
        studentDao.save(student);

        course.setStudentsList((Arrays.asList(student)));
        courseDao.update(course);


        List<Course> courses = courseDao.findAll();
        System.out.println("Courses: " +courses);


        List<Student> students = studentDao.findAll();
        System.out.println("Stundents: " +students);


        List<Teacher> teachers = teacherDao.findAll();
        System.out.println("Teachers: " +teachers);

        JPAUtil.shutdown();


    }
}
