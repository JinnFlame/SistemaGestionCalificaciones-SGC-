function updateFileName(input) {
    var fileName = input.files[0].name;
    document.getElementById('file-name').innerText = fileName;
}

import tablecsv from "./tablecsv";

const tableRoot = document.querySelector("#csvRoot");
const tablecsv = new tablecsv(tableRoot);

tablecsv.update([
    [4500, "dom", 35],
    [800, "dcode", 67],
    [4500, "dom", 35]
])
