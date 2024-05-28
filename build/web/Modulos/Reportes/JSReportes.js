document.addEventListener('DOMContentLoaded', function () {
    // Cargar la tabla inicialmente
    CargarTabla();

    // Agregar un event listener para detectar cambios en los filtros
    const especialidadSelect = document.getElementById('especialidad');
    const semestreSelect = document.getElementById('semestre');
    const parcialSelect = document.getElementById('parcial');
    const periodoSelect = document.getElementById('generacion');

    especialidadSelect.addEventListener('change', function () {
        CargarTabla();
    });

    semestreSelect.addEventListener('change', function () {
        CargarTabla();
    });
    parcialSelect.addEventListener('change', function () {
        CargarTabla();
    });

    periodoSelect.addEventListener('change', function () {
        CargarTabla();
    });
});

function CargarTabla() {
    const idEspecialidad = document.getElementById('especialidad').value;
    const semestre = document.getElementById('semestre').value;
    const Parcial = document.getElementById('parcial').value;
    const periodo = document.getElementById('generacion').value;

    let ruta = `http://localhost:8080/SistemaGestionCalificaciones/api/reportes/getall?semestre=${semestre}&idEspecialidad=${idEspecialidad}&periodo=${periodo}&parcial=${Parcial}`;

    fetch(ruta)
            .then(response => response.json())
            .then(data => {
                // Obtener la tabla y su cuerpo
                const tablaRegistros = document.getElementById("tablaReportes").getElementsByTagName('tbody')[0];
                // Limpiar la tabla
                tablaRegistros.innerHTML = "";
                // Recorrer los datos y agregar filas a la tabla
                data.forEach(fila => {
                    const nuevaFila = tablaRegistros.insertRow(-1);
                    const especialidadCell = nuevaFila.insertCell(0);
                    especialidadCell.textContent = fila.especialidad;
                    const turnoCell = nuevaFila.insertCell(1);
                    turnoCell.textContent = fila.turno;
                    const grupoCell = nuevaFila.insertCell(2);
                    grupoCell.textContent = fila.nombreGrupo;
                    const noAlumnosCell = nuevaFila.insertCell(3);
                    noAlumnosCell.textContent = fila.cantidadAlumnos;
                    const ceroCell = nuevaFila.insertCell(4);
                    ceroCell.textContent = fila.Reprobados_0;
                    const unoCell = nuevaFila.insertCell(5);
                    unoCell.textContent = fila.Reprobados_1;
                    const dosCell = nuevaFila.insertCell(6);
                    dosCell.textContent = fila.Reprobados_2;
                    const tresCell = nuevaFila.insertCell(7);
                    tresCell.textContent = fila.Reprobados_3;
                    const cuatroCell = nuevaFila.insertCell(8);
                    cuatroCell.textContent = fila.Reprobados_4;
                    const cincoCell = nuevaFila.insertCell(9);
                    cincoCell.textContent = fila.Reprobados_5;
                    const aprovadosCell = nuevaFila.insertCell(10);
                    aprovadosCell.textContent = fila.aprobados + "%";
                    const reprovadosCell = nuevaFila.insertCell(11);
                    reprovadosCell.textContent = fila.reprobados + "%";
                });
            })
            .catch(error => {
                console.error("Error al cargar la tabla: " + error);
            });
}

// Llamar a la función para cargar la tabla cuando la página se cargue
document.addEventListener('DOMContentLoaded', CargarTabla);

