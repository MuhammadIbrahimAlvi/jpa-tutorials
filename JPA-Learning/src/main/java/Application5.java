import configuration.JPAUtil;
import dao.StudentDao;
import entities.Student;
import jakarta.persistence.EntityManager;

public class Application5 {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        StudentDao studentDao = new StudentDao(entityManager);

        Student student = studentDao.findStudentById(202L);

        studentDao.delete(student.getId());

        entityManager.close();
    }
}
