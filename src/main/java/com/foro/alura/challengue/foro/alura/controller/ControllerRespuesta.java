package com.foro.alura.challengue.foro.alura.controller;

import com.foro.alura.challengue.foro.alura.operations.respuestas.DatosCreacionRespuesta;
import com.foro.alura.challengue.foro.alura.operations.respuestas.DatosMostarRespuesta;
import com.foro.alura.challengue.foro.alura.operations.respuestas.RespuestaRepository;
import com.foro.alura.challengue.foro.alura.operations.respuestas.validaciones.ValidarPublicarRespuestaDuplicada;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respuesta")
@SecurityRequirement(name = "bearer-key")
public class ControllerRespuesta {

    @Autowired
    private ValidarPublicarRespuestaDuplicada validarPublicarRespuesta;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity publicarRespuesta(@RequestBody @Valid DatosCreacionRespuesta datosCreacionRespuesta,
                                            UriComponentsBuilder uriComponentsBuilder){

       var crearRespuesta = validarPublicarRespuesta.publicarRespuesta(datosCreacionRespuesta);
       var uri = uriComponentsBuilder.path("/respuesta/{id}").buildAndExpand(crearRespuesta.id()).toUri();

       return ResponseEntity.created(uri).body(crearRespuesta);
   }

   @GetMapping
    public ResponseEntity<Page<DatosMostarRespuesta>> mostarRepuesta(@PageableDefault(size = 1)Pageable pageable){

       return ResponseEntity.ok(respuestaRepository.findAll(pageable).map(DatosMostarRespuesta::new));
   }

    @GetMapping("/{id}")
    public ResponseEntity buscarRespuestaPorId(@PathVariable Long id){
        var respuestaOptional = respuestaRepository.findById(id);
        if(respuestaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO se encontro una respuesta con ese ID");
        }
        var respuesta = respuestaOptional.get();

        return ResponseEntity.ok(new DatosMostarRespuesta(respuesta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarRespuesta(@PathVariable Long id){

       var respuestaOptional = respuestaRepository.findById(id);
       if(respuestaOptional.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO se encontro una respuesta con ese ID");
       }

       var respuesta = respuestaOptional.get();
       respuestaRepository.delete(respuesta);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Respuesta eliminada correctamente");

    }
}
