import configuration.JPAUtil;
import dao.StudentDao;
import dao.UniversityDao;
import entities.Student;
import entities.University;
import jakarta.persistence.EntityManager;

public class Application2 {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        UniversityDao universityDao = new UniversityDao(entityManager);

        University university = new University();
        university.setName("UOK");
        universityDao.save(university);

        StudentDao studentDao = new StudentDao(entityManager);

        Student student = new Student();
        student.setName("Alvi");

        studentDao.save(student);

        University university1 = universityDao.findUniversityById(university.getId());

        student.setUniversity(university1);

        entityManager.close();

    }
}
