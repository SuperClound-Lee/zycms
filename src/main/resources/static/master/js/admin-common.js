$(document).ready(function(){
    $('#validate').click(function () {
        $(this)[0].src ='/createImg?'+Math.random();
    });
})
