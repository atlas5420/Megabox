$(document).ready(function(){

    //next_slide();
    slide_next_btn();
})

function slide_next_btn(){
    $("#slide_next").click(next_slide
    );
}

function next_slide(){
    var slider=$(".customslider");
    slider.find('div').first().appendTo(slider);

}