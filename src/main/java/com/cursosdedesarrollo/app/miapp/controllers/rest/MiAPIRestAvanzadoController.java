package com.cursosdedesarrollo.app.miapp.controllers.rest;

import com.cursosdedesarrollo.app.miapp.domain.Alumno;
import com.cursosdedesarrollo.app.miapp.dto.AlumnoDevuelto;
import com.cursosdedesarrollo.app.miapp.dto.AlumnoSinID;
import com.cursosdedesarrollo.app.miapp.dto.ListadoAlumnoDevuelto;
import com.cursosdedesarrollo.app.miapp.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/alumnoavanzado")
public class MiAPIRestAvanzadoController {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping()
    public ResponseEntity<ListadoAlumnoDevuelto> index(){
        ListadoAlumnoDevuelto listadoAlumnoDevuelto = new ListadoAlumnoDevuelto();
        List<Alumno> listado = alumnoRepository.findAll();
        listadoAlumnoDevuelto.setError(false);
        listadoAlumnoDevuelto.setMessage("Alumnos finded!");
        listadoAlumnoDevuelto.setAlumnos(listado);
        return new ResponseEntity<>(listadoAlumnoDevuelto, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<AlumnoDevuelto> insert(@Valid @RequestBody AlumnoSinID alumnoSinID){
        Alumno alumno = new Alumno();
        alumno.setEdad(alumnoSinID.getEdad());
        alumno.setNombre(alumnoSinID.getNombre());
        alumno.setApellidos(alumnoSinID.getApellidos());
        alumnoRepository.save(alumno);
        AlumnoDevuelto alumnoDevuelto = new AlumnoDevuelto();
        alumnoDevuelto.setError(false);
        alumnoDevuelto.setMessage("Alumnno inserted");
        alumnoDevuelto.setAlumno(alumno);
        return new ResponseEntity<>(alumnoDevuelto,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDevuelto> showById(@PathVariable("id") Long id){
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        AlumnoDevuelto alumnoDevuelto = new AlumnoDevuelto();
        if (alumnoOptional.isPresent()){
            alumnoDevuelto.setError(false);
            alumnoDevuelto.setMessage("Alumno retreived");
            alumnoDevuelto.setAlumno(alumnoOptional.get());
        }else{
            alumnoDevuelto.setError(true);
            alumnoDevuelto.setMessage("Alumnos not found, incorrect ID");
        }
        return new ResponseEntity<>(alumnoDevuelto,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDevuelto> editById(
            @PathVariable("id") Long id,
            @Valid @RequestBody AlumnoSinID alumnoSinID
            ) {
        AlumnoDevuelto alumnoDevuelto = new AlumnoDevuelto();
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        if (alumnoOptional.isPresent()){
            Alumno alumno = new Alumno();
            alumno.setId(id);
            alumno.setEdad(alumnoSinID.getEdad());
            alumno.setNombre(alumnoSinID.getNombre());
            alumno.setApellidos(alumnoSinID.getApellidos());
            alumnoRepository.save(alumno);
            alumnoDevuelto.setError(false);
            alumnoDevuelto.setMessage("Alumno updated");
            alumnoDevuelto.setAlumno(alumno);
        }else {
            alumnoDevuelto.setError(true);
            alumnoDevuelto.setMessage("Alumno not found, incorrect ID");
        }
        return new ResponseEntity<>(alumnoDevuelto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<AlumnoDevuelto> deleteById(@PathVariable("id") Long id){
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        AlumnoDevuelto alumnoDevuelto = new AlumnoDevuelto();
        if (alumnoOptional.isPresent()){
            alumnoRepository.delete(alumnoOptional.get());
            alumnoDevuelto.setError(false);
            alumnoDevuelto.setMessage("Alumno deleted");
            alumnoDevuelto.setAlumno(alumnoOptional.get());
        }else{
            alumnoDevuelto.setError(true);
            alumnoDevuelto.setMessage("Alumnos not found, incorrect ID");
        }
        return new ResponseEntity<>(alumnoDevuelto,HttpStatus.OK);
    }

}
