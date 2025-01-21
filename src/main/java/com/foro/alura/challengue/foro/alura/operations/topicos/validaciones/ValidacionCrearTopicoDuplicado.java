package com.foro.alura.challengue.foro.alura.operations.topicos.validaciones;

import com.foro.alura.challengue.foro.alura.operations.ValidacionException;
import com.foro.alura.challengue.foro.alura.operations.cursos.Curso;
import com.foro.alura.challengue.foro.alura.operations.cursos.CursoRepository;
import com.foro.alura.challengue.foro.alura.operations.topicos.DatosCreacionTopico;
import com.foro.alura.challengue.foro.alura.operations.topicos.DatosMostrarTopico;
import com.foro.alura.challengue.foro.alura.operations.topicos.Topico;
import com.foro.alura.challengue.foro.alura.operations.topicos.TopicoRepository;
import com.foro.alura.challengue.foro.alura.operations.usuarios.Usuario;
import com.foro.alura.challengue.foro.alura.operations.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacionCrearTopicoDuplicado {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DatosMostrarTopico registrar(DatosCreacionTopico datosCreacionTopico){
        boolean existeDuplicado = topicoRepository.existsByTitulo(datosCreacionTopico.titulo());
        if(existeDuplicado){
            throw new IllegalArgumentException("Ya existe un tópico con el mismo titulo");
        }

        Usuario autor = usuarioRepository.findById(datosCreacionTopico.idUsuario())
                .orElseThrow(() -> new ValidacionException("Autor No encontrado"));

        Curso curso = cursoRepository.findById(datosCreacionTopico.idCurso())
                .orElseThrow(() -> new ValidacionException("Curso no encontrado"));

        Topico topico = new Topico(datosCreacionTopico, autor, curso);
        topicoRepository.save(topico);

        return new DatosMostrarTopico(topico);
    }
}
