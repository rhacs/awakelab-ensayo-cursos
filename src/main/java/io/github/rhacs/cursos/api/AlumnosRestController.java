package io.github.rhacs.cursos.api;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rhacs.cursos.modelos.Alumno;
import io.github.rhacs.cursos.modelos.Curso;
import io.github.rhacs.cursos.repositorios.AlumnosRepositorio;
import io.github.rhacs.cursos.repositorios.CursosRepositorio;

@RestController
@RequestMapping(path = "/api/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlumnosRestController {

    // Constantes
    // -----------------------------------------------------------------------------------------

    /**
     * Objeto {@link Logger} que contiene los métodos de depuración
     */
    private static final Logger logger = LogManager.getLogger(AlumnosRestController.class);

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Objeto {@link AlumnosRepositorio} que contiene los métodos de manipulación y
     * consulta para la tabla de {@link Alumno}s
     */
    @Autowired
    private AlumnosRepositorio alumnosRepositorio;

    /**
     * Objeto {@link CursosRepositorio} que contiene los métodos de manipulación y
     * consulta para la tabla de {@link Curso}s
     */
    @Autowired
    private CursosRepositorio cursosRepositorio;

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra el listado de {@link Alumno}s asociados a un {@link Curso}
     * 
     * @param id      identificador numérico del {@link Curso}
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le envía el cliente al servlet
     * @return un objeto {@link List} con la respuesta a la solicitud
     */
    @GetMapping(path = "/curso/{id:^[0-9]+$}")
    public List<Alumno> buscarAlumnosPorCurso(@PathVariable Long id, HttpServletRequest request) {
        // Depuración
        logger.info("[API] Solicitud {}: {}", request.getMethod(), request.getRequestURL());

        // Buscar la información del Curso
        Optional<Curso> curso = cursosRepositorio.findById(id);

        // Verificar si existe
        if (curso.isPresent()) {
            // Depuración
            logger.info("[API] Buscando listado de alumnos para el curso {}", curso.get());

            // Buscar listado de alumnos
            List<Alumno> alumnos = alumnosRepositorio.findByCurso(curso.get());

            // Depuración
            logger.info("[API] Mostrando listado de alumnos: {}", alumnos);

            // Devolver listado
            return alumnos;
        }

        // Depuración
        logger.info("[API] Se solicitó el listado de alumnos de un curso que no existe: {}", id);

        // Lanzar excepción
        throw new NoSuchElementException(
                String.format("No existe un Curso para el identificador numérico proporcionado: %s", id));
    }

}
