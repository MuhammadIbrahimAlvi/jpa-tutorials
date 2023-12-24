import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class MainApplicationOperations {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TeacherDao teacherDao = new TeacherDao(entityManager);
        CourseDao courseDao = new CourseDao(entityManager);
        StudentDao studentDao = new StudentDao(entityManager);

        Teacher teacher = new Teacher();
        teacher.setName("Ibrahim");
        teacherDao.save(teacher);

        Course course = new Course();
        course.setName("Computer Science");
        course.setTeacher(teacher);

        courseDao.save(course);

        Student student = new Student();
        student.setName("Alvi");
        student.setAge(25);
        studentDao.save(student);

        course.getStudentsList().add(student);
        courseDao.update(course);

        entityManager.close();
        entityManagerFactory.close();
    }
}
