package repositories;

import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;
import models.interfaces.Model;

public interface Repository<T> extends Model {

    void add(T entity) throws DuplicateModelException;
    T get(String model) throws NonExistantModelException;
}
