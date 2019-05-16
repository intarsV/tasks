$(document).ready(function () {
    var ajaxReq = $.ajax('/tasks', {
        dataType: 'json',
        timeout: 500
    }).done(function (data) {
        if (data !== null) {
            console.log(data.length);
            CreateTableFromJSON(data);
        }

    }).fail(function (jqXhr, textStatus, errorMessage) { // error callback
        $('p').append('Error: ' + errorMessage);
    })
});

function CreateTableFromJSON(data) {

    //element of table body
    var tbody = $('#table_body');

    //put column names to arrayList
    var col = [];
    for (var i = 0; i < data.length; i++) {
        for (var key in data[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    for (var i = 0; i < data.length; i++) {
        var markup = "<tr><td>" + data[i][col[0]] + "</td><td>" + data[i][col[1]] + "</td><td>" + data[i][col[2]] + "</td></tr>";
        tbody.append(markup);
    }
}
