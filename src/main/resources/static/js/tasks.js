$(document).ready(function () {
    addTask();
});

function updateValue(sel) {
    var rowId = sel.closest('tr').getAttribute('id' );
    var title = $('#' + rowId).find('#activeTaskTitle').text();
    var requestData = {id: rowId, taskTitle: title, statusEnum: sel.value}
    $('#message_screen').empty();
    $.ajax({
        type: 'PUT',
        url: '/api/v1/tasks',
        data: JSON.stringify(requestData),
        contentType: 'application/json'
    })
        .done(function (data) {

            var msg = data.message;
            alert(msg);
        })
        .fail(function (data) {
            var msg = data.message;
            alert(msg);
        });
}

function addTask() {
    $('#submit').click(function () {
        $('#message_screen').empty();
        $.ajax({
            type: 'post',
            url: '/api/v1/tasks',
            data: JSON.stringify($('#taskTitle').val()),
            contentType: 'application/json'
        })
            .done(appendRow)
            .fail(function (xhr) {
                var myData = JSON.parse(xhr.responseText);
                $('#message_screen').append(myData.errors[0].defaultMessage)
            });
    });
}

function appendRow(data) {
    var newRow = $('#tmp_row').clone();
    newRow.attr('id', data);
    newRow.find('#rawId').html(data);
    var taskTitle = $('#taskTitle');
    newRow.find('#rawTitle').html(taskTitle.val());
    newRow.find('#rawTitle').attr('id', 'activeTaskTitle');
    var onClickData = 'deleteTask(' + data + ')';
    newRow.find('#delClick').attr('onClick', onClickData);
    newRow.attr('hidden', false);
    var $tableBody = $('#table_body');
    $tableBody.append(newRow);
    taskTitle.val("");
    console.log(newRow);
}

function deleteTask(id) {
    var confirmation = confirm('YOU Monster! You want to KILL the task?');
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








