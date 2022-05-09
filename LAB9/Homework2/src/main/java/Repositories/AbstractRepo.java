package Repositories;

public abstract class AbstractRepo<T> {
    protected abstract T findByName(String name);
    protected abstract String findById(int id);
}
