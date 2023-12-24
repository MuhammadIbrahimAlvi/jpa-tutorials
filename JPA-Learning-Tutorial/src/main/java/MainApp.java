import jakarta.persistence.EntityManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainApp {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        // Create Course with Collections
        Course course = new Course();
        course.setName("Java Programming");
        course.getStudents().addAll(Arrays.asList("Alice", "Bob", "Charlie"));
        course.getTags().addAll(Arrays.asList("Java", "Programming", "Hibernate"));
        Map<String, String> schedule = new HashMap<>();
        schedule.put("Monday", "10:00 AM");
        schedule.put("Wednesday", "02:00 PM");
        schedule.put("Friday", "04:30 PM");
        course.getSchedule().putAll(schedule);

        // Save Course
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();

        // Retrieve and Display Course
        Course retrievedCourse = entityManager.find(Course.class, course.getId());
        System.out.println("Retrieved Course: " + retrievedCourse);

        JPAUtil.shutdown();
    }
}
