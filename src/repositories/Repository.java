package repositories;

public interface Repository<T> {

    void add(T entity);
    T get(String model);
}
