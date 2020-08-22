package io.github.rhacs.cursos.controladores;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import io.github.rhacs.cursos.modelos.Alumno;
import io.github.rhacs.cursos.modelos.Curso;
import io.github.rhacs.cursos.repositorios.CursosRepositorio;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    // Constantes
    // -----------------------------------------------------------------------------------------

    /**
     * Objeto {@link Logger} que contiene los métodos de depuración
     */
    private static final Logger logger = LogManager.getLogger(HomeController.class);

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Objeto {@link CursosRepositorio} que contiene los métodos de manipulación y
     * consulta para la tabla de {@link Curso}s
     */
    @Autowired
    private CursosRepositorio cursosRepositorio;

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra el listado de cursos disponibles en el repositorio
     * 
     * @param id      identificador numérico del {@link Curso}
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le envía el cliente al servlet
     * @param modelo  objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} con el nombre de la vista
     */
    @GetMapping(path = { "/", "/{id:^[0-9]+$}" })
    public String listarCursos(@PathVariable Optional<Long> id, HttpServletRequest request, Model modelo) {
        // Depuración
        logger.info("[WEB] Solicitud {}: {}", request.getMethod(), request.getRequestURL());

        // Verificar si el id está presente en la url
        if (id.isPresent()) {
            // Inicializar el Rest Template
            RestTemplate rest = new RestTemplate();

            // Efectuar petición GET a la API
            ResponseEntity<Alumno[]> respuesta = rest
                    .getForEntity("http://localhost/cursos/api/alumnos/curso/" + id.get(), Alumno[].class);

            // Verificar estado de la respuesta
            if (respuesta.getStatusCode().equals(HttpStatus.OK)) {
                // Extraer objetos
                List<Alumno> alumnos = Arrays.asList(respuesta.getBody());

                // Agregar listado al modelo
                modelo.addAttribute("alumnos", alumnos);
            } else {
                // Agregar error al modelo
                modelo.addAttribute("error",
                        "No existe el Curso con el identificador numérico <strong>" + id.get() + "</strong>.");
            }
        }

        // Buscar listado de cursos
        List<Curso> cursos = cursosRepositorio.findAll();

        // Depuración
        logger.info("[WEB] Mostrando el listado de cursos: {}", cursos);

        // Agregar listado al modelo
        modelo.addAttribute("cursos", cursos);

        // Devolver vista
        return "cursos";
    }

}
