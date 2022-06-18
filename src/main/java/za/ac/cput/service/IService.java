package za.ac.cput.service;

import java.util.Optional;

public interface IService<T, Id> {
    T save(T t);
    Optional<T> read(Id id);
    void delete(T t);
}
