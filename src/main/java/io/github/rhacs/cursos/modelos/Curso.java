package io.github.rhacs.cursos.modelos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.github.rhacs.cursos.Constantes;

@Entity
@Table(name = Constantes.TABLA_CURSOS)
public class Curso {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Identificador numérico del {@link Curso}
     */
    @Id
    @Column(name = Constantes.CURSO_ID)
    private Long id;

    /**
     * Nombre del {@link Curso}
     */
    private String nombre;

    /**
     * Listado de {@link Alumno}s que pertenecen al {@link Curso}
     */
    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    private Set<Alumno> alumnos;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía de la entidad {@link Curso}
     */
    public Curso() {
        alumnos = new HashSet<>();
    }

    /**
     * Crea una nueva instancia de la entidad {@link Curso}
     * 
     * @param id      identificador numérico
     * @param nombre  nombre
     * @param alumnos listado de {@link Alumno}s
     */
    public Curso(Long id, String nombre, Set<Alumno> alumnos) {
        this.id = id;
        this.nombre = nombre;
        this.alumnos = alumnos;
    }

    // Getters
    // -----------------------------------------------------------------------------------------

    /**
     * @return el identificador numérico
     */
    public Long getId() {
        return id;
    }

    /**
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el listado de {@link Alumno}s
     */
    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    // Setters
    // -----------------------------------------------------------------------------------------

    /**
     * @param id el identificador numérico a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param nombre el nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param alumnos el listado de {@link Alumno}s a establecer
     */
    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    // Herencias (Object)
    // -----------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return String.format("Curso [id=%s, nombre=%s, alumnos=%s]", id, nombre, alumnos);
    }

}
