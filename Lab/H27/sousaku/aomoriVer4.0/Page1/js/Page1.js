alert("���̃y�[�W�ł͉��y������܂�(�L�E�ցE)");

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