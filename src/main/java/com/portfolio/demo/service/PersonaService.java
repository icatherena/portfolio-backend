package com.portfolio.demo.service;

import com.portfolio.demo.model.Persona;
import com.portfolio.demo.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    PersonaRepository personaRepositorio;
    
    @Override
    public List<Persona> getPersona() {
        List <Persona> persona = personaRepositorio.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepositorio.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepositorio.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = personaRepositorio.findById(id).orElse(null);
        return persona;
    }
    
}
