package za.ac.cput.service.userInfo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.repository.userInfo.INameRepository;
import za.ac.cput.service.userInfo.INameService;

import java.util.Optional;

@Service
public class NameService implements INameService {

    private final INameRepository repository;

    @Autowired
    public NameService(INameRepository repository) {
        this.repository = repository;
    }

    @Override
    public Name save(Name name) {
        return this.repository.save(name);
    }

    @Override
    public Optional<Name> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Name name) {
        this.repository.delete(name);
    }
}
