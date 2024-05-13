function updateFileName(input) {
    var fileName = input.files[0].name;
    document.getElementById('file-name').innerText = fileName;
}

import tablecsv from "./tablecsv.js";

const tableRoot = document.querySelector("csvRoot");
const tablecsv = new tablecsv(tableRoot);