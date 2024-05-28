package com.API.RESTFULL.Person;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepo;

    public void createPersona(Person person) {
        personRepo.save(person);
    }

    public List<Person> listPersona() {
        return personRepo.findAll();
    }

    public void deletePersona(Integer id) {
        personRepo.deleteById(id);
    }

    public Optional<Person> findById(Integer id) {
        return personRepo.findById(id);
    }

    public void updatePersona(Person person) {
        personRepo.save(person);
    }
}
