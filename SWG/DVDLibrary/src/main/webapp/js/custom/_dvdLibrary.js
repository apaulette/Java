// When the document is ready, populate our summary table
$(document).ready(function () {
    loadLibrarySummary();
    
    
    $('#add-button').click(function (event) {
        event.preventDefault();
//        setTimeout(function () {
//            window.location.reload();
//        }, 0);
        
        // need to submit this via AJAX
        $.ajax({
            type: 'POST',
            url: 'addDvd',
            // make the JSON contact
            data: JSON.stringify({
                title: $('#add-title').val(),
                ratingUS: $('#add-ratingUS').val(),
                releaseDate: $('#add-releaseDate').val(),
                directorName: $('#add-directorName').val(),
                studioName: $('#add-studioName').val(),
                userRating: $('#add-userRating').val(),
                userComment: $('#add-userComment').val(),
                coverArt: $('#add-coverArt').val()
            }),
            contentType: 'application/json; charset=utf-8',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function () {
            // removing data, status for a question on if we need them
            // realistically, if you are getting an object back from an endpoint
            // and you need to work with the data coming back, 
            // then you want to include the parameters in the anonymous function's signature
            // clear the form and reload the summary table
            $('#add-title').val(''),
            $('#add-ratingUS').val(''),
            $('#add-releaseDate').val(''),
            $('#add-directorName').val(''),
            $('#add-studioName').val(''),
            $('#add-userRating').val(''),
            $('#add-userComment').val(''),
            $('#add-coverArt').val('')

            // reload the summary table
            $('#validationErrors').empty();
            loadLibrarySummary();
        }).error(function (data, status) {
            $('#validationErrors').empty();
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });

    $('#edit-button').click(function (event) {
        event.preventDefault();
        // update our contact via AJAX
        $.ajax({
            type: 'PUT',
            url: 'dvd/' + $('#edit-entry-id').val(),
            data: JSON.stringify({
                contactId: $('#edit-entry-id').val(),
                title: $('#edit-entry-title').val(),
                ratingUS: $('#edit-entry-ratingUS').val(),
                releaseDate: $('#edit-entry-releaseDate').val(),
                directorName: $('#edit-entry-directorName').val(),
                studioName: $('#edit-entry-studioName').val(),
                userRating: $('#edit-entry-userRating').val(),
                userComment: $('#edit-entry-userComment').val(),
                coverArt: $('#edit-entry-coverArt').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadLibrarySummary();
        });
    });

    $('#delete-button').click(function (event) {
//        setTimeout(function () {
//            window.location.reload();
//        }, 0);

        $.ajax({
            type: 'DELETE',
            url: 'dvd/' + +$('#edit-entry-id').val()
        }).success(function () {
            // reload summary
            loadLibrarySummary();
        });

    });


    $('.modalClose').click(function (event) {
//        setTimeout(function () {
//            window.location.reload();
//        }, 0);
    });

});

// Load contacts into our summary table
function loadLibrarySummary() {
    //  Get our JSON object from the endpoint
    $.ajax({
        url: 'alldvds'
    }).success(function (data, status) {
        fillDVDShelves(data, status);
    });
    
}

function fillDVDShelves(allEntries, status) {
    $('#shelvesDiv').empty();
    
    var shelvesDiv = $('#shelvesDiv');
    $.each(allEntries, function (arrayPosition, entry) {
        if (entry.userRating === "" || entry.userRating === null) {
            entry.userRating = '0';
        }
        if (entry.coverArt === "" || entry.coverArt === null) {
            entry.coverArt = 'dvd-blank.jpg';
        }
        var dateRatingSeparator;
        if ((entry.releaseDate === "" || entry.releaseDate === null) || (entry.ratingUS === "" || entry.ratingUS === null)) {
            dateRatingSeparator = "";
        } else {
            dateRatingSeparator = " | ";
        }
            
    shelvesDiv
        .append($('<div>').attr({'class':'dvdWrapper'})
        .append($('<div>').attr({'class':'dvdCover'})
        .append($('<a>').attr({'data-entry-id': entry.libId, 'data-name': entry.title, 'data-toggle': 'modal', 'data-target': '#detailsModal'})
        .append($('<img>').attr({'src': '/DVDLibrarySpringMVC/img/covers/' + entry.coverArt, 'border':'0'}))))
        .append($('<div>').attr({'class':'dvdDetails'})
            .html('<span class="movie-title">' + entry.title + '</span><br>' + entry.releaseDate + dateRatingSeparator + entry.ratingUS + '<br>')
        .append($('<img>').attr({'src':'/DVDLibrarySpringMVC/img/stars-' + entry.userRating + '.png', 'class':'star-rating'})))
        );
    });
}


$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var libId = element.data('entry-id');
    var entryName = element.data('name');
    var editDetailsModalLabel = $('.modal-title');
    var modal = $(this);
    
    editDetailsModalLabel.html('<span style="color:\#2F4E60; font-size:22px;">Edit Details for</span> <i>' + entryName + '</i>');
    // get our object via AJAX
    $.ajax({
        type: 'GET',
        url: 'dvd/' + libId
    }).success(function (retrievedEntry) {
        modal.find('#edit-entry-id').val(retrievedEntry.libId);
        modal.find('#edit-entry-title').val(retrievedEntry.title);
        modal.find('#edit-entry-ratingUS').val(retrievedEntry.ratingUS);
        modal.find('#edit-entry-releaseDate').val(retrievedEntry.releaseDate);
        modal.find('#edit-entry-directorName').val(retrievedEntry.directorName);
        modal.find('#edit-entry-studioName').val(retrievedEntry.studioName);
        modal.find('#edit-entry-userRating').val(retrievedEntry.userRating);
        modal.find('#edit-entry-userComment').val(retrievedEntry.userComment);
        modal.find('#edit-entry-coverArt').val(retrievedEntry.coverArt);        
    });
});

// Run in response to the show.bs.modal event
// It gets the contact data and renders it to the dialog
$('#detailsModal').on('show.bs.modal', function (event) {
//    $('#editThis').empty();
    var element = $(event.relatedTarget);
    var libId = element.data('entry-id');
    var modal = $(this);
    // Get our object via AJAX
    $.ajax({
        type: 'GET',
        url: 'dvd/' + libId
    }).success(function (retrievedEntry) {
        if (retrievedEntry.userRating === "" || retrievedEntry.userRating === null) {
            retrievedEntry.userRating = '0';
        }
        if (retrievedEntry.coverArt === "" || retrievedEntry.coverArt === null) {
            retrievedEntry.coverArt = 'dvd-blank.jpg';
        }
        modal.find('#entry-title').html('<i>' + retrievedEntry.title + '</i>');
        modal.find('#entry-ratingUS').text(retrievedEntry.ratingUS);
        modal.find('#entry-releaseDate').text(retrievedEntry.releaseDate);
        modal.find('#entry-directorName').text(retrievedEntry.directorName);
        modal.find('#entry-studioName').text(retrievedEntry.studioName);
        modal.find('#entry-userRating').html('<img src="/DVDLibrarySpringMVC/img/stars-' + retrievedEntry.userRating + '.png">');
        modal.find('#entry-userComment').text(retrievedEntry.userComment);
        modal.find('#entry-coverArt').html('<img src="/DVDLibrarySpringMVC/img/covers/' + retrievedEntry.coverArt + '" class="img-responsive">');
        modal.find('#editThis').replaceWith('<button type="button" class="btn btn-default" data-entry-id="' + retrievedEntry.libId + '" data-name="' + retrievedEntry.title + '" data-toggle="modal" data-dismiss="modal" data-target="#editModal">Edit or Delete</button>');
    });
});


function deleteEntry(id) {
    var answer = confirm('Do you really want to delete this contact?');

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'dvd/' + id
        }).success(function () {
            // reload summary
            loadLibrarySummary();
        });
    }
}

$("#toggleSidebar").click(function() {
    $('#sidebar').toggle();
    $('#shelvesDiv').toggleClass('col-xs-12 col-xs-9');
});
