package io.github.rhacs.cursos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.cursos.modelos.Curso;

@Repository
public interface CursosRepositorio extends JpaRepository<Curso, Long> {

}
