package com.foro.alura.challengue.foro.alura.operations.topicos;

public record DatosActualizarTopico(

        String titulo,
        String mensaje,
        Estado estado,
        Long autor,
        Long curso
) {
}
