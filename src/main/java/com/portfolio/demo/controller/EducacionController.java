package com.portfolio.demo.controller;

/* import org.springframework.web.bind.annotation.CrossOrigin; */
import com.portfolio.demo.dto.EducacionDto;
import com.portfolio.demo.model.Educacion;
import com.portfolio.demo.security.controller.Mensaje;
import com.portfolio.demo.service.EducacionService;
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
@RequestMapping("/educacion")
public class EducacionController {
    
    @Autowired
    EducacionService educacionServicio;
    
    @GetMapping ("/lista")
    public ResponseEntity <List <Educacion> > list() {
        List <Educacion> list = educacionServicio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        if(!educacionServicio.existsById(id))
            return new ResponseEntity(new Mensaje ("No se ha encontrado el estudio"),HttpStatus.NOT_FOUND);
        Educacion educacion = educacionServicio.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody EducacionDto educacionDto) {
        if (StringUtils.isBlank(educacionDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("Debe completar el campo"), HttpStatus.BAD_REQUEST);
        }
        if (educacionServicio.existsByTitulo(educacionDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("Este estudio ya ha sido creado"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(educacionDto.getTitulo(), educacionDto.getInstitucionEd(), educacionDto.getDescripcion(), educacionDto.getFechaInicio(), educacionDto.getFechaFin()); /*REVISAR*/
        educacionServicio.save(educacion);

        return new ResponseEntity(new Mensaje("Se ha guardado como un nuevo estudio"), HttpStatus.OK);

    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long id, @RequestBody EducacionDto educacionDto) {
        if (!educacionServicio.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se ha encontrado el estudio"), HttpStatus.BAD_REQUEST);
        }

        if (educacionServicio.existsByTitulo(educacionDto.getDescripcion()) && (educacionServicio.getByTitulo(educacionDto.getDescripcion()).get().getId()) != id) { /*REVISAR*/
            return new ResponseEntity(new Mensaje("El estudio ya ha sido guardado"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(educacionDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("Debe completar el campo"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = educacionServicio.getOne(id).get();
        educacion.setTitulo(educacionDto.getTitulo());
        educacion.setInstitucionEd(educacionDto.getInstitucionEd());
        educacion.setDescripcion(educacionDto.getDescripcion());
        educacion.setFechaInicio(educacionDto.getFechaInicio()); 
        educacion.setFechaFin(educacionDto.getFechaFin());
        educacionServicio.save(educacion);
        return new ResponseEntity(new Mensaje("Estudios actualizados"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable("id") Long id) {
        if (!educacionServicio.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se ha encontrado el estudio"), HttpStatus.BAD_REQUEST);
        }
        educacionServicio.delete(id);
        return new ResponseEntity(new Mensaje("El estudio ha sido eliminada con éxito"), HttpStatus.OK);
    }
    
}
