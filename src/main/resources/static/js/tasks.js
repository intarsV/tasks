$(document).ready(function () {
    $("#submit").click(function () {
        $.ajax({
            type: 'post',
            url: '/api/v1/tasks',
            data: JSON.stringify($('#taskTitle').val()),
            contentType: "application/json"
        })
            .done(function (data) {
                $('#error_screen').empty();
                var markup = "<tr id='" + data + "'><td>" + data + "</td><td>" + $('#taskTitle').val() + "</td><td>" + "ACTIVE"
                    + "</td><td><a onClick=\"DeleteRow(" + data + ");\"> <img src=\"/images/trash.png\" width=\"25\"/> </a></td>";
                $('#table_body').append(markup);
                $('#taskTitle').val("")
            })
            .fail(function (xhr) {
                var myData = JSON.parse(xhr.responseText);
                $('#error_screen').empty().append(myData.errors[0].defaultMessage)
            });
    });
});


function DeleteRow(id) {
    var confirmation = confirm("YOU Monster! You want to KILL the task?");
    if (confirmation) {
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/tasks/' + id
        })
            .done(function () {
                var rowToDelete = document.getElementById(id);
                rowToDelete.remove();
            })
    }
}









