package com.foro.alura.challengue.foro.alura.operations.topicos;

import com.foro.alura.challengue.foro.alura.operations.cursos.Curso;

import java.time.LocalDateTime;

public record DatosMostrarTopico(

        Long id,

        String titulo,

        String mensaje,

        LocalDateTime fechaCreacion,

        Estado status,

        DatosTopicoYUsuario autor,

        Curso curso
) {
    public DatosMostrarTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                new DatosTopicoYUsuario(topico.getAutor().getId(), topico.getAutor().getNombre(), topico.getAutor().getEmail(),
                topico.getAutor().getPerfil()),topico.getCurso());
    }
}
