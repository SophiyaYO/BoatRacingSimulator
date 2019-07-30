package repositories;

import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl<T> implements Repository<T> {

    private Map<String , T> entities;

    public RepositoryImpl() {
        this.entities = new HashMap<>();
    }

    @Override
    public void add(T entity) {

    }

    @Override
    public T get(String model) {
        return null;
    }
}
