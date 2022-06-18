package za.ac.cput.service.userInfo.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.service.userInfo.INameService;

import java.util.Optional;

@Service
public class NameService implements INameService {
    @Override
    public Name save(Name name) {
        return null;
    }

    @Override
    public Optional<Name> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(Name name) {

    }
}
