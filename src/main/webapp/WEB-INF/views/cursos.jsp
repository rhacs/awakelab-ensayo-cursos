<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Juego de caracteres -->
        <meta charset="utf-8">
        <!-- Configuración de ancho y escala inicial para los dispositivos -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Hojas de Estilo -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha512-MoRNloxbStBcD8z3M/2BmnT+rg4IsMxPkXaGh2zD6LGNNFE80W3onsAhRcMAMrSoyWL9xD7Ert0men7vR8LUZg==" crossorigin="anonymous" />

        <!-- Título -->
        <title>Cursos</title>
    </head>

    <body>
        <div class="container my-5">
            <div class="row">
                <div class="col-md-6 mb-5">
                    <h2 class="pb-2 border-bottom mb-4">Listado de Cursos</h2>

                    <core:if test="${not empty error}">
                        <div class="alert alert-danger mb-4">${error}</div>
                    </core:if>

                    <div class="table-responsive">
                        <table class="table table-hover table-striped">
                            <thead>
                                <tr>
                                    <th scope="col" class="text-nowrap">#</th>
                                    <th scope="col" class="text-nowrap">Nombre</th>
                                    <th scope="col" class="text-nowrap text-right">Alumnos</th>
                                </tr>
                            </thead>

                            <tbody>
                                <core:choose>
                                    <core:when test="${cursos != null && cursos.size() > 0}">
                                        <core:forEach items="${cursos}" var="curso">
                                            <tr role="button" data-action="listar" data-id="${curso.getId()}">
                                                <th scope="row" class="text-nowrap">${curso.getId()}</th>
                                                <td>${curso.getNombre()}</td>
                                                <td class="text-right text-nowrap">${curso.getAlumnos().size()}</td>
                                            </tr>
                                        </core:forEach>
                                    </core:when>
                                    <core:otherwise>
                                        <tr>
                                            <th scope="row" class="text-center" colspan="3">No hay registros</th>
                                        </tr>
                                    </core:otherwise>
                                </core:choose>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="col-md-6">
                    <h2 class="pb-2 border-bottom mb-4">Listado de Alumnos</h2>

                    <div class="table-responsive">
                        <table class="table table-hover table-striped">
                            <thead>
                                <tr>
                                    <th scope="col" class="text-nowrap">#</th>
                                    <th scope="col" class="text-nowrap">Nombre</th>
                                </tr>
                            </thead>

                            <tbody>
                                <core:choose>
                                    <core:when test="${alumnos != null && alumnos.size() > 0}">
                                        <core:forEach items="${alumnos}" var="alumno">
                                            <tr>
                                                <th scope="row" class="text-nowrap">${alumno.getId()}</th>
                                                <td>${alumno.getNombre()}</td>
                                            </tr>
                                        </core:forEach>
                                    </core:when>
                                    <core:when test="${alumnos.size() == 0}">
                                        <tr>
                                            <th scope="row" colspan="2" class="text-center">No hay registros para el Curso seleccionado</th>
                                        </tr>
                                    </core:when>
                                    <core:otherwise>
                                        <tr>
                                            <th scope="row" colspan="2" class="text-center">Seleccione un Curso</th>
                                        </tr>
                                    </core:otherwise>
                                </core:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- Dependencias JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js" integrity="sha512-ubuT8Z88WxezgSqf3RLuNi5lmjstiJcyezx34yIU2gAHonIi27Na7atqzUZCOoY4CExaoFumzOsFQ2Ch+I/HCw==" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha512-M5KW3ztuIICmVIhjSqXe01oV2bpe248gOxqmlcYrEzAvws7Pw3z6BK0iGbrwvdrUQUhi3eXgtxp5I8PDo9YfjQ==" crossorigin="anonymous"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/script.js"></script>
    </body>
</html>
