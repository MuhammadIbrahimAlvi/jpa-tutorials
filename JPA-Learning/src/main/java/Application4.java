import configuration.JPAUtil;
import dao.StudentDao;
import entities.IdCard;
import entities.Student;
import jakarta.persistence.EntityManager;

public class Application4 {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        StudentDao studentDao = new StudentDao(entityManager);

        Student student = new Student();
        student.setName("Alvi");

        IdCard idCard = new IdCard();
        idCard.setName("AlviId");

        student.setIdCard(idCard);

        studentDao.save(student);

        entityManager.close();


    }
}
