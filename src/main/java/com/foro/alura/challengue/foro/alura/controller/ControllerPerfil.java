package com.foro.alura.challengue.foro.alura.controller;

import com.foro.alura.challengue.foro.alura.operations.perfiles.DatosMostrarPerfil;
import com.foro.alura.challengue.foro.alura.operations.perfiles.DatosRegistroPerfil;
import com.foro.alura.challengue.foro.alura.operations.perfiles.Perfil;
import com.foro.alura.challengue.foro.alura.operations.perfiles.PerfilRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/perfil")
@SecurityRequirement(name = "bearer-key")
public class ControllerPerfil {

    @Autowired
    PerfilRepository perfilRepository;


    @PostMapping
    @Transactional
    public ResponseEntity crearPerfil(@RequestBody @Valid DatosRegistroPerfil datosRegistroPerfil,
                                      UriComponentsBuilder uriComponentsBuilder){

        var perfil = new Perfil(datosRegistroPerfil);
        perfilRepository.save(perfil);
        var uri = uriComponentsBuilder.path("/perfiles/{id}").buildAndExpand(perfil.getId()).toUri();

        return ResponseEntity.created(uri).body(perfil);
    }

    @GetMapping
    public ResponseEntity<Page<DatosMostrarPerfil>> mostrarPerfil(@PageableDefault(page = 0, size = 5)Pageable pageable){

        var page = perfilRepository.findAll(pageable).map(DatosMostrarPerfil::new);

        return ResponseEntity.ok(page);
    }

}
