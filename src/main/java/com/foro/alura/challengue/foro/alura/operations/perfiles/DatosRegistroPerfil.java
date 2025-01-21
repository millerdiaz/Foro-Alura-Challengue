package com.foro.alura.challengue.foro.alura.operations.perfiles;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroPerfil(

        @NotBlank
        String nombre
) {
}
