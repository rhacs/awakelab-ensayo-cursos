package io.github.rhacs.cursos.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.github.rhacs.cursos.Constantes;

@Entity
@Table(name = Constantes.TABLA_ALUMNOS)
public class Alumno {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Identificador numérico del {@link Alumno}
     */
    @Id
    @Column(name = Constantes.ALUMNO_ID)
    private Long id;

    /**
     * Nombre del {@link Alumno}
     */
    private String nombre;

    /**
     * {@link Curso} del {@link Alumno}
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = Constantes.CURSO_ID, nullable = false)
    @JsonIgnore
    private Curso curso;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía de la entidad {@link Alumno}
     */
    public Alumno() {

    }

    /**
     * Crea una nueva instancia de la entidad {@link Alumno}
     * 
     * @param id     identificador numérico
     * @param nombre nombre
     * @param curso  {@link Curso} al que pertenece
     */
    public Alumno(Long id, String nombre, Curso curso) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
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
     * @return el {@link Curso} al que pertenece
     */
    public Curso getCurso() {
        return curso;
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
     * @param curso el {@link Curso} a establecer
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    // Herencias (Object)
    // -----------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return String.format("Alumno [id=%s, nombre=%s]", id, nombre);
    }

}
