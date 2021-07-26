package Interview.Lesson_5.student;

public interface AbstractRepository<T> {

    void insert(T t);

    void saveOrUpdate(T t);

    T findById(long id);

    void deleteById(long id);
}
