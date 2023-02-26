package com.portfolio.demo.controller;

import com.portfolio.demo.dto.HabilidadDto;
import com.portfolio.demo.model.Habilidad;
import com.portfolio.demo.security.controller.Mensaje;
import com.portfolio.demo.service.HabilidadService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/* @CrossOrigin(origins = "https://argprogramaiawfront.web.app") */
@RequestMapping("/habilidad")
public class HabilidadController {
    
    @Autowired
    HabilidadService habilidadServicio;
    
    @GetMapping ("/lista")
    public ResponseEntity <List <Habilidad> > list() {
        List <Habilidad> list = habilidadServicio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping ("/detalle/{id]")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        if (!habilidadServicio.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se ha encontrado la habilidad"), HttpStatus.NOT_FOUND);
        }
        Habilidad habilidad = habilidadServicio.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @PostMapping ("/crear")
    public ResponseEntity<?> crear(@RequestBody HabilidadDto habilidadDto) {
        if (StringUtils.isBlank(habilidadDto.getNombre())) {
            return new ResponseEntity(new Mensaje("Debe completar el campo"), HttpStatus.BAD_REQUEST);
        }
        if (habilidadServicio.existsByNombre(habilidadDto.getNombre())) {
            return new ResponseEntity(new Mensaje("Esta habilidad ya ha sido creada"), HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = new Habilidad(habilidadDto.getNombre(), habilidadDto.getNivel());
        habilidadServicio.save(habilidad);

        return new ResponseEntity(new Mensaje("Se ha guardado como una nueva habilidad"), HttpStatus.OK);
    }

    @PutMapping ("/actualidad/{id]")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long id, @RequestBody HabilidadDto habilidadDto) {
        if (!habilidadServicio.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se ha encontrado la habilidad"), HttpStatus.BAD_REQUEST);
        }

        if (habilidadServicio.existsByNombre(habilidadDto.getNombre()) && habilidadServicio.getByNombre(habilidadDto.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La habilidad ya ha sido guardada"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(habilidadDto.getNombre())) {
            return new ResponseEntity(new Mensaje("Debe completar el campo"), HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = habilidadServicio.getOne(id).get();
        habilidad.setNombre(habilidadDto.getNombre());
        habilidad.setNivel(habilidadDto.getNivel());
        habilidadServicio.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> borrar(@PathVariable("id") Long id) {
        if (!habilidadServicio.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se ha encontrado la habilidad"), HttpStatus.BAD_GATEWAY);
        }
        habilidadServicio.delete(id);
        return new ResponseEntity(new Mensaje("La habilidad ha sido eliminada con éxito"), HttpStatus.OK);
    }
    
}
