package com.foro.alura.challengue.foro.alura.operations.cursos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(

        long id,

        @NotBlank
        String nombre,

        @NotNull
        Categoria categoria

) {
}
