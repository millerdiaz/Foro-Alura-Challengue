package com.foro.alura.challengue.foro.alura.operations.respuestas;

import com.foro.alura.challengue.foro.alura.operations.topicos.DatosMostrarTopico;
import com.foro.alura.challengue.foro.alura.operations.topicos.DatosTopicoYUsuario;

import java.time.LocalDateTime;

public record DatosMostarRespuesta(Long id,
                                   String mensaje,
                                   DatosMostrarTopico idTopico,
                                   LocalDateTime fecha,
                                   DatosTopicoYUsuario idAutor,
                                   boolean solucion

) {
    public DatosMostarRespuesta(Respuesta datos){
        this(
                datos.getId(),
                datos.getMensaje(),
                new DatosMostrarTopico(
                        datos.getTopico().getId(),
                        datos.getTopico().getTitulo(),
                        datos.getTopico().getMensaje(),
                        datos.getTopico().getFechaCreacion(),
                        datos.getTopico().getEstado(),
                        new DatosTopicoYUsuario(
                                datos.getTopico().getAutor().getId(),
                                datos.getTopico().getAutor().getNombre(),
                                datos.getTopico().getAutor().getEmail(),
                                datos.getTopico().getAutor().getPerfil()
                        ),
                        datos.getTopico().getCurso()
                ),
                datos.getFechaCreacion(),
                new DatosTopicoYUsuario(
                        datos.getUsuario().getId(),
                        datos.getUsuario().getNombre(),
                        datos.getUsuario().getEmail(),
                        datos.getUsuario().getPerfil()
                ),
                datos.isSolucion()
        );
    }
}
