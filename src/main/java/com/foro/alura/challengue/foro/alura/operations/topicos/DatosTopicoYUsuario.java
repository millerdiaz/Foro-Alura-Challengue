package com.foro.alura.challengue.foro.alura.operations.topicos;

import com.foro.alura.challengue.foro.alura.operations.perfiles.Perfil;
import com.foro.alura.challengue.foro.alura.operations.usuarios.Usuario;

public record DatosTopicoYUsuario(

        Long id,
        String nombre,
        String correoElectronico,
        Perfil perfil
) {
    public DatosTopicoYUsuario(Usuario datos){
        this(datos.getId(), datos.getNombre(), datos.getEmail(), datos.getPerfil());
    }
}

