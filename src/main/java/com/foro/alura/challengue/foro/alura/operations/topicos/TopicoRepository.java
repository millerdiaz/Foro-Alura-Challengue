package com.foro.alura.challengue.foro.alura.operations.topicos;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TopicoRepository extends JpaRepository<Topico,Long> {

    boolean existsByTitulo(@NotBlank String titulo);

    @Query("""
            SELECT t
            FROM Topico t
            WHERE t.curso.nombre = %:nombreCurso%
            """)
    Page<Topico> findTopicosByNombreCurso(String nombreCurso, Pageable pageable);
}
