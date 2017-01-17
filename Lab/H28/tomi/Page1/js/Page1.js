$(function(){
 $("C1").css("color","green");
 $("C2").css("color","red");
 $("C3").css("color","blue");
});


$(function(){
    $('#menu li').hover(function(){
        $("ul:not(:animated)", this).slideDown();
    }, function(){
        $("ul.child",this).slideUp();
    });
});

$(function() {
  $('#main-menu').smartmenus();
});

$(document).ready(function(){
            $('.bxslider').bxSlider({
                auto: true,
		mode:'fade',
		pause:4000,
            });
        });

$(document).ready(function() {
  var pagetop = $('.pagetop');
    $(window).scroll(function () {
       if ($(this).scrollTop() > 100) {
            pagetop.fadeIn();
       } else {
            pagetop.fadeOut();
            }
       });
       pagetop.click(function () {
           $('body, html').animate({ scrollTop: 0 }, 500);
              return false;
   });
});