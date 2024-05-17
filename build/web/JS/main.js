function updateFileName(input) {
    var fileName = input.files[0].name;
    document.getElementById('file-name').innerText = fileName;
}

import tablecsv from "./tablecsv.js";

const tableRoot = document.querySelector("#csvRoot");
const csvFileInput = document.querySelector("#csvFileInput")
const Tablecsv = new tablecsv(tableRoot);

csvFileInput.addEventListener("change", e => {
    console.log(csvFileInput.files[0])
    Papa.parse(csvFileInput.files[0], {
        delimiter: ",",
        skipEmptyLines: true,
        complete: results => {
            console.log(results);
            Tablecsv.update(results.data.slice(1), results.data[0])
        }
    })
})
