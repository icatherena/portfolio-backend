package com.portfolio.demo.controller;

import com.portfolio.demo.dto.ProyectoDto;
import com.portfolio.demo.model.Proyecto;
import com.portfolio.demo.security.controller.Mensaje;
import com.portfolio.demo.service.ProyectoService;
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
@RequestMapping("/proyecto")
public class ProyectoController {
 
    @Autowired
    ProyectoService proyectoServicio;
    
    @GetMapping ("/lista")
    public ResponseEntity <List <Proyecto> > list() {
        List <Proyecto> list = proyectoServicio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping ("/detalle/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        if (!proyectoServicio.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se ha encontrado el proyecto"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = proyectoServicio.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ProyectoDto proyectoDto) {
        if (StringUtils.isBlank(proyectoDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("Debe completar el campo"), HttpStatus.BAD_REQUEST);
        }
        if (proyectoServicio.existsByTitulo(proyectoDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("Este proyecto ya ha sido creado"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(proyectoDto.getTitulo(), proyectoDto.getDescripcion(), proyectoDto.getRepoUrl(), proyectoDto.getFotoUrl());
        proyectoServicio.save(proyecto);

        return new ResponseEntity(new Mensaje("Se ha guardado como un nuevo proyecto"), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long id, @RequestBody ProyectoDto proyectoDto) {
        if (!proyectoServicio.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se ha encontrado el proyecto"), HttpStatus.BAD_REQUEST);
        }

        if (proyectoServicio.existsByTitulo(proyectoDto.getTitulo()) && proyectoServicio.getByTitulo(proyectoDto.getTitulo()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Este proyecto ya ha sido creado"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(proyectoDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("Debe completar el campo"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = proyectoServicio.getOne(id).get();
        proyecto.setTitulo(proyectoDto.getTitulo());
        proyecto.setDescripcion(proyectoDto.getDescripcion());
        proyecto.setRepoUrl(proyectoDto.getRepoUrl());
        proyecto.setFotoUrl(proyectoDto.getFotoUrl());
        proyectoServicio.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable("id") Long id) {
        if (!proyectoServicio.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se ha encontrado el proyecto"), HttpStatus.BAD_GATEWAY);
        }
        proyectoServicio.delete(id);
        return new ResponseEntity(new Mensaje("El proyecto ha sido eliminada con éxito"), HttpStatus.OK);
    }
    
}
