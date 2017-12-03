$(document).ready(function(){
	CorrigeAltura();
	
	
	$('.rateYoCadastro').rateYo({
		 starWidth: "25px",
		 ratedFill: "#DD270E",
		 halfStar: true,
	});
	
	
	
	

 $('.todo-pop-avaliacao a').magnificPopup({
  type:'inline',
  midClick: true,
	 overflowY:"scroll" 
});
	
		
	
});
	
	
$(window).resize(function(){
	CorrigeAltura();
});

$(window).scroll(function(){
	CorrigeAltura();
});

$(window).on('load',function(){
	CorrigeAltura();
});
	

	
function CorrigeAltura(){
	
	 altcont = $("#conteudo").height();
	 altsidebar = $(".sidebar").height();
     $(".sidebar").css("height",altcont);
}

function Enviaform(){
	alert("Comentário cadastrado com sucesso!")
}