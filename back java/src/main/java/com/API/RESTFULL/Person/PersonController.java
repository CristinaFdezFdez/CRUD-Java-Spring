package com.API.RESTFULL.Person;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public void createPersona(@RequestBody Person person) {
        personService.createPersona(person);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/lista")
    public List<Person> listPersona() {
        return personService.listPersona();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Integer id) {
        personService.deletePersona(id);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/{id}")
    public Optional<Person> findPersonaById(@PathVariable Integer id) {
        return personService.findById(id);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping("/{id}")
    public void updatePersona(@PathVariable Integer id, @RequestBody Person updatedPerson) {
        // Busca la persona existente por su ID
        Person existingPerson = personService.findById(id)
            .orElseThrow(() -> new RuntimeException("Persona no encontrada con ID: " + id));
        
        // Actualiza los campos de la persona existente con los nuevos valores proporcionados
        existingPerson.setFirstName(updatedPerson.getFirstName());
        existingPerson.setLastname(updatedPerson.getLastname());
        existingPerson.setEmail(updatedPerson.getEmail());
        
        // Guarda la persona actualizada en la base de datos
        personService.updatePersona(existingPerson);
    }
}

