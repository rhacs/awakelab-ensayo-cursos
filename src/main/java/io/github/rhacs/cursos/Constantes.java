package io.github.rhacs.cursos;

public class Constantes {

    // Tablas
    // -----------------------------------------------------------------------------------------

    /**
     * Nombre de la tabla que contiene la información de los {@link Curso}s
     */
    public static final String TABLA_CURSOS = "curso";

    /**
     * Nombre de la tabla que contiene la información de los {@link Alumno}s
     */
    public static final String TABLA_ALUMNOS = "alumno";

    // Columnas
    // -----------------------------------------------------------------------------------------

    /**
     * Nombre de la columna que representa la llave primaria de la tabla
     * {@value #TABLA_CURSOS}
     */
    public static final String CURSO_ID = "idcurso";

    /**
     * Nombre de la columna que representa la llave primaria de la tabla
     * {@value #TABLA_ALUMNOS}
     */
    public static final String ALUMNO_ID = "idalumno";

    // Constructores
    // -----------------------------------------------------------------------------------------

    private Constantes() {
        // Constructor privado para esconder el constructor público implícito
    }

}
