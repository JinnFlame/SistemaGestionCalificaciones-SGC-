export default class {
    /**
     * 
     * @param {HTMLTableElement} root The table element which will display the CSV data
     */
    constructor(root) {
        this.root = root;
        console.log("I am constructed!");
    }

    update(data, headerColumns = []){
        this.clear();
        this.setHeader(headerColumns);
        this.setBody(data);
    }

    /**
     * Clears all contents of the table
     */
    clear(){
        this.root.innerHTML = "";
    }

    /**
     * Sets the table header.
     * 
     * @param {string[]} headerColumns list of headings to be used
     */
    setHeader(headerColumns) {
        this.root.insertAdjacentHTML("afterbegin", `
            <thead>
                <tr>
                    ${headerColumns.map(text => `<th>${text}</th>`).join("")}
                </tr>
            </thead>
        `);
    }

    /**
     * Sets the table body
     * 
     * @param {string[][]} data A 2D array of data to be used as the table body 
     */
    setBody(data) {
        const rowsHtml = data.map(row => {
            return `
                <tr>
                    ${row.map(text => `<td>${text}</td>)`).join("")}
                </tr>
            `;
        });

        console.log(rowsHtml);
        this.root.insertAdjacentHTML("beforeend", `
            <tbody>
                ${rowsHtml.join("")}
            </tbody>
        `)
    }
}