document.addEventListener('DOMContentLoaded', function () {
    CargarTabla();
});

function CargarTabla() {
    let ruta = "http://localhost:8080/SistemaGestionCalificaciones/api/gestion/getall";
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
                    const ApellidoPCell = nuevaFila.insertCell(0);
                    ApellidoPCell.textContent = fila.ApellidoP;
                    const ApellidoMCell = nuevaFila.insertCell(1);
                    ApellidoMCell.textContent = fila.ApellidoM;
                    const NombresCell = nuevaFila.insertCell(2);
                    NombresCell.textContent = fila.Nombres;
                    const GrupoCell = nuevaFila.insertCell(3);
                    GrupoCell.textContent = fila.Grupo;
                    const PromedioCell = nuevaFila.insertCell(4);
                    PromedioCell.textContent = fila.Promedio;
                    const Materias_ReprobadasCell = nuevaFila.insertCell(5);
                    Materias_ReprobadasCell.textContent = fila.MR;
                    const MateriasCell = nuevaFila.insertCell(6);
                    MateriasCell.textContent = fila.Materias;
                });
            })
            .catch(function (error) {
                console.error("Error al cargar la tabla: " + error);
            });
}

