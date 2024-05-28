document.addEventListener('DOMContentLoaded', function () {
    // Cargar la tabla inicialmente
    CargarTabla();

    // Agregar un event listener para detectar cambios en los filtros
    const especialidadSelect = document.getElementById('especialidad');
    const semestreSelect = document.getElementById('semestre');

    especialidadSelect.addEventListener('change', function () {
        // Recargar la tabla cuando cambie la especialidad
        CargarTabla();
    });

    semestreSelect.addEventListener('change', function () {
        // Recargar la tabla cuando cambie el semestre
        CargarTabla();
    });
});

function CargarTabla() {
    const idEspecialidad = document.getElementById('especialidad').value;
    const semestre = document.getElementById('semestre').value;

    let ruta = `http://localhost:8080/SistemaGestionCalificaciones/api/gestion/getall?idEspecialidad=${idEspecialidad}&semestre=${semestre}`;
    fetch(ruta)
            .then(function (data) {
                return data.json();
            })
            .then(function (data) {
                // Obtener la tabla y su cuerpo
                const tablaRegistros = document.getElementById("tablaRegistros").querySelector('tbody');
                // Limpiar la tabla
                tablaRegistros.innerHTML = "";

                data.forEach(function (fila) {
                    const nuevaFila = tablaRegistros.insertRow(-1);

                    const NocontrolCell = nuevaFila.insertCell(0);
                    NocontrolCell.textContent = fila.Nocontrol;

                    const ApellidoPCell = nuevaFila.insertCell(1);
                    ApellidoPCell.textContent = fila.ApellidoP;

                    const ApellidoMCell = nuevaFila.insertCell(2);
                    ApellidoMCell.textContent = fila.ApellidoM;

                    const NombreCell = nuevaFila.insertCell(3);
                    NombreCell.textContent = fila.Nombre;

                    const emailCell = nuevaFila.insertCell(4); // Nueva celda para email
                    emailCell.textContent = fila.email;

                    const emailInsCell = nuevaFila.insertCell(5); // Nueva celda para email institu
                    emailInsCell.textContent = fila.emailIns;

                    const telefonoCell = nuevaFila.insertCell(6); // Nueva celda para telefono
                    telefonoCell.textContent = fila.telefono;

                    const telefono2Cell = nuevaFila.insertCell(7); // Nueva celda para telefono2
                    telefono2Cell.textContent = fila.telefono2;

                    const nombreGrupoCell = nuevaFila.insertCell(8);
                    nombreGrupoCell.textContent = fila.nombreGrupo;

                    const promedioCell = nuevaFila.insertCell(9);
                    promedioCell.textContent = fila.promedio;

                    const materiasReprobadasCell = nuevaFila.insertCell(10);
                    materiasReprobadasCell.textContent = fila.materiasReprobadas;


                    // Agregar evento de clic a toda la fila
                    nuevaFila.addEventListener('click', function () {
                        // Obtener el ID del alumno
                        const idAlumno = fila.idAlumno;
                        // Obtener todas las materias y calificaciones del alumno
                        ObtenerMateriasCalificaciones(idAlumno);
                    });
                });


            })
            .catch(function (error) {
                console.error("Error al cargar la tabla: " + error);
            });
}

function ObtenerMateriasCalificaciones(idAlumno) {
    // Hacer una petición para obtener todas las materias y calificaciones del alumno
    let ruta = `http://localhost:8080/SistemaGestionCalificaciones/api/gestion/getmateriascalificaciones/${idAlumno}`;
    fetch(ruta)
            .then(function (data) {
                return data.json();
            })
            .then(function (data) {
                // Construir el contenido HTML de la tabla
                let tablaHTML = '<table class="table">';
                tablaHTML += '<thead><tr><th>Materias</th><th>Parcial 1</th><th>Parcial 2</th><th>Parcial 3</th><th>Promedio</th></tr></thead>';
                tablaHTML += '<tbody>';
                data.forEach(function (fila) {
                    // Calcular el promedio de los tres parciales
                    const promedioParciales = (fila.parcial1 + fila.parcial2 + fila.parcial3) / 3;
                    tablaHTML += `<tr><td>${fila.nombreMateria}</td><td>${fila.parcial1}</td><td>${fila.parcial2}</td><td>${fila.parcial3}</td><td>${promedioParciales.toFixed(2)}</td></tr>`;
                });
                tablaHTML += '</tbody></table>';
                // Mostrar el SweetAlert con la tabla
                Swal.fire({
                    title: 'Materias y Calificaciones',
                    html: tablaHTML,
                    confirmButtonText: 'Cerrar',
                    customClass: {
                        popup: 'my-swal-popup-class' // Aquí puedes definir el nombre de tu clase CSS
                    }
                });
            })
            .catch(function (error) {
                console.error("Error al obtener las materias y calificaciones: " + error);
            });
}
