package com.foro.alura.challengue.foro.alura.operations.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCreacionTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,

        @NotNull
        Long idUsuario,

        @NotNull
        Long idCurso
) {
}
