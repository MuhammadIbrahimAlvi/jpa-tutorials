import jakarta.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @ManyToMany(mappedBy = "studentsList")
    private List<Course> courseList;

    @ElementCollection
    @CollectionTable(name = "student_subjects", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "subject")
    private List<String> subjects;

    @ElementCollection
    private Set<String> hobbies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(Map<String, String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    @ElementCollection
    @CollectionTable(name = "student_contact_numbers", joinColumns = @JoinColumn(name = "student_id"))
    @MapKeyColumn(name = "contact_type")
    @Column(name = "contact_number")
    private Map<String, String> contactNumbers;

    // getters and setters...

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + '}';
    }
}
