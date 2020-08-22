// Esperar a que la página termine de cargar
$(function() {
    // Asignar el método click a los elementos marcados con data-action
    $('[data-action]').on('click', function(event) {
        // Prevenir la acción por defecto
        event.preventDefault();

        // Obtener data
        let accion = $(this).data('action');
        let id = $(this).data('id');

        // Filtrar acción
        if(accion === 'listar') {
            // Limpiar contenido de la tabla
            $("#alumnos").empty();

            // Realizar una petición GET a la API
            $.get('http://localhost/cursos/api/alumnos/curso/' + id, function(data) {
                // Depuración
                console.log(data);

                // Por cada objeto del listado
                $.each(data, function() {
                    // Crear nueva fila
                    let fila = $('<tr />')
                            .append('<th class="text-nowrap">' + this.id + '</th>')
                            .append('<td>' + this.nombre + '</td>');

                    // Agregar fila a la tabla
                    $('#alumnos').append(fila);
                });
            });
        }
    });
});
