package Interview.Lesson_5;

import Interview.Lesson_5.student.Student;
import Interview.Lesson_5.student.StudentRepository;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;
import java.io.File;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Main05 {

    private static final String CONF_PATH = "/Users/Arsen/IdeaProjects/IdeaProjects/Training Java/GeekBrains/Interview/Lesson_5/resources/hibernate.cfg.xml";

    public static void main(String[] args) {
        File file = new File(CONF_PATH);
        Random random = new Random();

        EntityManagerFactory emFactory = new Configuration()
                .configure(file)
                .buildSessionFactory();

        StudentRepository repository = new StudentRepository(emFactory);

        for (int i = 0; i < 1000; i++) {
            repository.insert(
                    new Student(new BigInteger(64, new SecureRandom()).toString(36),
              random.nextInt(6) + 1)
            );
        }

        System.out.println(repository.findById(58));
    }
}
