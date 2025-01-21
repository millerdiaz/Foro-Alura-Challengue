package com.foro.alura.challengue.foro.alura.operations.respuestas.validaciones;

import com.foro.alura.challengue.foro.alura.operations.ValidacionException;
import com.foro.alura.challengue.foro.alura.operations.respuestas.DatosCreacionRespuesta;
import com.foro.alura.challengue.foro.alura.operations.respuestas.DatosMostarRespuesta;
import com.foro.alura.challengue.foro.alura.operations.respuestas.Respuesta;
import com.foro.alura.challengue.foro.alura.operations.respuestas.RespuestaRepository;
import com.foro.alura.challengue.foro.alura.operations.topicos.Topico;
import com.foro.alura.challengue.foro.alura.operations.topicos.TopicoRepository;
import com.foro.alura.challengue.foro.alura.operations.usuarios.Usuario;
import com.foro.alura.challengue.foro.alura.operations.usuarios.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidarPublicarRespuestaDuplicada {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosMostarRespuesta publicarRespuesta(DatosCreacionRespuesta creacionRespuesta){

        boolean existeRespuestaDuplicada = respuestaRepository.existsByMensaje(creacionRespuesta.mensaje());
        if(existeRespuestaDuplicada){
            throw new ValidacionException("Ya existe una respuesta con el mismo mensaje");
        }

        Topico topico = topicoRepository.findById(creacionRespuesta.idTopico())
                .orElseThrow(() -> new ValidacionException("No se encontró el topico con el id " + creacionRespuesta.idTopico()));

        Usuario usuario = usuarioRepository.findById(creacionRespuesta.idAutor())
                .orElseThrow(()-> new EntityNotFoundException("No se encontró el usuario"));

        Respuesta respuesta = new Respuesta(creacionRespuesta, topico, usuario);
        respuestaRepository.save(respuesta);

        return new DatosMostarRespuesta(respuesta);
    }

}
