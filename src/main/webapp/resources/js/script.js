// Esperar a que termine de cargar la página
$(function() {
    // Asignar el evento click a los elementos marcados con data-action
    $('[data-action]').on('click', function(event) {
        // Prevenir acción por defecto
        event.preventDefault();

        // Obtener data
        let accion = $(this).data('action');
        let id = $(this).data('id');

        // Filtrar acción
        if(accion === 'listar') {
            // Redireccionar
            $(location).attr('href', '/cursos/' + id);
        }
    });
});
