tinymce.init({
    selector: 'textarea',
    height: 220,
    plugins: [
        'advlist autolink lists link image charmap print preview hr anchor pagebreak',
        'searchreplace wordcount visualblocks visualchars code',
        'insertdatetime media nonbreaking save table contextmenu directionality',
        'emoticons paste textcolor colorpicker textpattern imagetools codesample'
    ],
    menubar: "edit insert view format table tools",
    toolbar1: 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link unlink',
    toolbar2: 'preview | image media | forecolor backcolor | charmap',
    custom_undo_redo_levels: 10,
    image_caption: true,
    image_advtab: true,
    paste_as_text: false,
    color_picker_callback: function(callback, value) {
        callback('#FF00FF');
    },
    style_formats: [
        {title: 'Image Left', selector: 'img', styles: {
            'float' : 'left',
            'margin': '0 10px 0 10px'
        }},
        {title: 'Image Right', selector: 'img', styles: {
            'float' : 'right',
            'margin': '0 10px 0 10px'
        }}
    ],
    content_css: [
        '//fonts.googleapis.com/css?family=Lato:300,300i,400,400i',
        '//www.tinymce.com/css/codepen.min.css'
    ]
  
});