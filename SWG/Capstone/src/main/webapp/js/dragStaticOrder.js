$(document).ready(function () {
    
    $('tbody').sortable({
        axis: 'y',
        update: function (event, ui) {
            var data = $(this).sortable('serialize');
            // POST to server using $.post or $.ajax
            $.ajax({
                type: 'PUT',
                url: 'updateStaticPageDisplayOrder',
                data: JSON.stringify($("#sortable").sortable('toArray')),
                contentType: 'application/json; charset=utf-8',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                dataType: 'json'
            }).success (function(){
                location.reload();
            });
        }
    });
});

$(function() {
    $("#sortable").sortable();
    $("#sortable").disableSelection();
});

