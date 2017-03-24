$(document).ready(function() {
    $(".entryImage").each(function() {
        // Calculate aspect ratio and store it in HTML data- attribute
        var aspectRatio = $(this).width()/$(this).height();
        $(this).data("aspect-ratio", aspectRatio);

        // Conditional statement
        if(aspectRatio > 1) {
            // Image is landscape
            $(this).css({
                width: "100%",
                height: "auto"
            });
        } else if (aspectRatio < 1) {
            // Image is portrait
            $(this).css({
                maxWidth: "50%", float: "left", margin: "0 10px 10px 0"
            });
        } else {
            // Image is square
            $(this).css({
                maxWidth: "50%", float: "left", margin: "0 10px 10px 0"

            });            
        }
    });
});