package io.github.rhacs.cursos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.cursos.modelos.Alumno;
import io.github.rhacs.cursos.modelos.Curso;

@Repository
public interface AlumnosRepositorio extends JpaRepository<Alumno, Long> {

    /**
     * Busca un listado de {@link Alumno}s en el repositorio que están vinculados a
     * un {@link Curso} en particular
     * 
     * @param curso {@link Curso} a buscar
     * @return un objeto {@link List} con el resultado
     */
    public List<Alumno> findByCurso(Curso curso);

}
