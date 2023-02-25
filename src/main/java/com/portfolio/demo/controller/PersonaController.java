package com.portfolio.demo.controller;

import com.portfolio.demo.model.Persona;
/* import java.util.ArrayList; */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/* import org.springframework.web.bind.annotation.ResponseBody; */
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.demo.service.IPersonaService;
/* import org.springframework.web.bind.annotation.CrossOrigin; */
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController 
/* @CrossOrigin(origins="https://catherena-beresovsky.web.app") */
public class PersonaController {
    
    /*
    List<Persona> listaPersonas = new ArrayList();    
    
    @GetMapping ("/hola/{nombre}")
    public String decirHola(@PathVariable String nombre) {
        return "Hola, " + nombre;
    }
    
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Persona pers) {
        listaPersonas.add(pers);
    }
    
    @GetMapping ("/ver/personas")
    public List<Persona> verPersonas() {
        return listaPersonas;
    } */
    
    @Autowired
    IPersonaService personaServicio;
    
    @GetMapping ("/personas/lista")
    /* @ResponseBody */
    public List <Persona> verPersona () {
        return personaServicio.getPersona();
    }
    
    /* @PreAuthorize("hasRole('ADMIN')") 
    @GetMapping ("/personas/ver/{id}")
    @ResponseBody
    public Persona buscarPersona (@PathVariable Long id) {
        return personaServicio.finPersona(id);
    }
    
    /* @PreAuthorize("hasRole('ADMIN')") */
    @PostMapping ("/personas/crear")
    public String agregarPersona (@RequestBody Persona persona) {
        personaServicio.savePersona(persona);
        return "Persona creada con éxito";
    }
        
    /* @PreAuthorize("hasRole('ADMIN')") */
    @DeleteMapping ("/personas/eliminar/{id}")
    public String borrarPersona (@PathVariable Long id) {
        personaServicio.deletePersona(id);
        return "Persona eliminada con éxito";
    }
    
    /* @PreAuthorize("hasRole('ADMIN')") */
    @PutMapping("personas/editar/{id}")
    public String modificarPersona(@PathVariable Long id, 
                                   @RequestParam("nombre") String nombreNuevo, 
                                   @RequestParam("apellido") String apellidoNuevo, 
                                   @RequestParam("titulo") String tituloNuevo,
                                   @RequestParam("descripcion") String descripcionNueva,
                                   @RequestParam("imagen") String fotoUrlNueva){
        Persona persona = personaServicio.findPersona(id);
        persona.setNombre(nombreNuevo);
        persona.setApellido(apellidoNuevo);
        persona.setTitulo(tituloNuevo);
        persona.setDescripcion(descripcionNueva);
        persona.setFotoUrl(fotoUrlNueva);
        personaServicio.savePersona(persona);
        return "Los campos han sido actualizados con éxito";
    }
}

