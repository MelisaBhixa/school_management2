package za.ac.cput.service;

import za.ac.cput.domain.location.Address;

import java.util.Optional;

public interface IService<T, Id> {
    T save(T t);
    Optional<T> read(Id id);
    void delete(T t);

}
