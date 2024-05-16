document.addEventListener('DOMContentLoaded', function () {
    CargarTabla();
});

function CargarTabla() {
    let ruta = "http://localhost:8080/SistemaGestionCalificaciones(SGC)/api/gestion/getall";
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

                    const telefonoCell = nuevaFila.insertCell(5); // Nueva celda para telefono
                    telefonoCell.textContent = fila.telefono;

                    const nombreGrupoCell = nuevaFila.insertCell(6);
                    nombreGrupoCell.textContent = fila.nombreGrupo;

                    const nombreMateriaCell = nuevaFila.insertCell(7);
                    nombreMateriaCell.textContent = fila.nombreMateria;

                    const calificacionCell = nuevaFila.insertCell(8);
                    calificacionCell.textContent = fila.calificacion;

                    const promedioCell = nuevaFila.insertCell(9);
                    promedioCell.textContent = fila.promedio;
                });

            })
            .catch(function (error) {
                console.error("Error al cargar la tabla: " + error);
            });
}