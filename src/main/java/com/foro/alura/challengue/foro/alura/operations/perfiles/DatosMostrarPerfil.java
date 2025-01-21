package com.foro.alura.challengue.foro.alura.operations.perfiles;

public record DatosMostrarPerfil(

        Long id,
        String nombre
) {
    public DatosMostrarPerfil(Perfil perfil){
        this(perfil.getId(), perfil.getNombre());
    }
}
