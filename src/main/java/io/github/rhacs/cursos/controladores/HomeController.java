package io.github.rhacs.cursos.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le envía el cliente al servlet
     * @param modelo  objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} con el nombre de la vista
     */
    @GetMapping
    public String listarCursos(HttpServletRequest request, Model modelo) {
        // Depuración
        logger.info("[WEB] Solicitud {}: {}", request.getMethod(), request.getRequestURL());

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
