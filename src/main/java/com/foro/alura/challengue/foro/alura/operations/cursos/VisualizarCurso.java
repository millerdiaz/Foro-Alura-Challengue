package com.foro.alura.challengue.foro.alura.operations.cursos;

public record VisualizarCurso(

        Long id,
        String nombre,
        Categoria categoria
) {

    public VisualizarCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
