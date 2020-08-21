----------------------------------------------------------------------------------------------------
-- Tabla: curso
----------------------------------------------------------------------------------------------------

CREATE TABLE curso (
    idcurso NUMBER NOT NULL,
    nombre NVARCHAR2(50) DEFAULT NULL,

    -- Llave primaria
    CONSTRAINT curso_pk PRIMARY KEY (idcurso)
);

----------------------------------------------------------------------------------------------------
-- Tabla: alumno
----------------------------------------------------------------------------------------------------

CREATE TABLE alumno (
    idalumno NUMBER NOT NULL,
    nombre NVARCHAR2(100) NOT NULL,
    idcurso NUMBER NOT NULL,

    -- Llave primaria
    CONSTRAINT alumno_pk PRIMARY KEY (idalumno),

    -- Llave foránea
    CONSTRAINT alumno_fk FOREIGN KEY (idcurso) REFERENCES curso (idcurso)
);
