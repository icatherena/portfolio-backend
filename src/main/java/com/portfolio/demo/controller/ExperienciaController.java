package com.portfolio.demo.controller;

import com.portfolio.demo.dto.ExperienciaDto;
import com.portfolio.demo.model.Experiencia;
import com.portfolio.demo.security.controller.Mensaje;
import com.portfolio.demo.service.ExperienciaService;
/* import com.portfolio.demo.security.controller.Mensaje; */
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/* import org.springframework.web.bind.annotation.CrossOrigin; */
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
@RequestMapping("/experiencia")
public class ExperienciaController {
    
    @Autowired
    ExperienciaService experienciaServicio;
    
    @GetMapping("/lista")
    public ResponseEntity <List <Experiencia> > list() {
        List <Experiencia> list = experienciaServicio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        if(!experienciaServicio.existsById(id))
            return new ResponseEntity(new Mensaje ("La experiencia no existe"),HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaServicio.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity <?> crear(@RequestBody ExperienciaDto experienciaDto) {
        if (StringUtils.isBlank(experienciaDto.getCargo())) {
            return new ResponseEntity(new Mensaje("Debe completar el campo"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaServicio.existsByCargo(experienciaDto.getCargo())) {
            return new ResponseEntity(new Mensaje("Esta experiencia ya ha sido creada"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(experienciaDto.getCargo(), experienciaDto.getEmpleador(), experienciaDto.getDescripcion(), experienciaDto.getFechaInicio(), experienciaDto.getFechaFin());
        experienciaServicio.save(experiencia);

        return new ResponseEntity(new Mensaje("Se ha guardado como una nueva experiencia"), HttpStatus.OK);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long id, @RequestBody ExperienciaDto expDto) {
        if (!experienciaServicio.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se ha encontrado la ID"), HttpStatus.BAD_REQUEST);
        }

        if (experienciaServicio.existsByCargo(expDto.getCargo()) && (experienciaServicio.getByCargo(expDto.getCargo()).get().getId()) != id) {
            return new ResponseEntity(new Mensaje("La experiencia ya ha sido guardada"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(expDto.getCargo())) {
            return new ResponseEntity(new Mensaje("Debe completar el campo"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = experienciaServicio.getOne(id).get();
        experiencia.setCargo(expDto.getCargo());
        experiencia.setEmpleador(expDto.getEmpleador());
        experiencia.setDescripcion(expDto.getDescripcion());
        experiencia.setFechaInicio(expDto.getFechaInicio());
        experiencia.setFechaFin(expDto.getFechaFin());
        experienciaServicio.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity <?> borrar(@PathVariable("id") Long id) {
        if (!experienciaServicio.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se ha encontrado la ID"), HttpStatus.BAD_REQUEST);
        }
        experienciaServicio.delete(id);
        return new ResponseEntity(new Mensaje("La experiencia ha sido eliminada con éxito"), HttpStatus.OK);
    }
    
}
