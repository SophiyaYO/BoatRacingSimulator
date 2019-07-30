package repositories;

import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;
import models.interfaces.Model;

import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl<T extends Model> implements Repository<T> {

    private Map<String, T> entities;

    public RepositoryImpl() {
        this.entities = new HashMap<>();
    }

    @Override
    public void add(T entity) throws DuplicateModelException {
        if (this.entities.containsKey(entity.getModel())) {
            throw new DuplicateModelException();
        }

        this.entities.put(entity.getModel(), entity);
    }

    @Override
    public T get(String model) throws NonExistantModelException {

        if (this.entities.containsKey(model)) {
            throw new NonExistantModelException();
        }

        return this.entities.get(model);
    }


}
