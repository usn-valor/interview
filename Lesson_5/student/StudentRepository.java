package Interview.Lesson_5.student;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class StudentRepository implements AbstractRepository<Student> {

    private final EntityManagerFactory emFactory;

    public StudentRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public List<Student> findAll() {
        System.out.println("All Students in table");
        return emFactory.createEntityManager().createQuery("from Student", Student.class).getResultList();
    }

    public Student findById(long id) {
        return emFactory.createEntityManager().find(Student.class, id);
    }

    public void insert(Student student) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        em.persist(student);

        em.getTransaction().commit();

        em.close();
    }

    public void saveOrUpdate(Student student) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Student p = em.find(Student.class, student.getId());

        em.getTransaction().begin();

        p.setName("Some");

        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(long id) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        em.createQuery("delete from Student where id=:id")
                .setParameter("id", id).executeUpdate();

        em.getTransaction().commit();
        em.close();
    }
}
