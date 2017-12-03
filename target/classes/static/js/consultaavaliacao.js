$('document').ready(function(){
		$.ajax({
			  url: "controller.do?command=ConsultaAvaliacao",
			  dataType: "json",
			   contentType:"application/json",
			   success: function(data){
				   $.each(data,function(i,items) {	
					      
					 $('#estrela-'+items.idEstabelecimento).attr("title",items.mediaAvaliacao);
					 	 
				   });
				   
				   $(".rateYo").each(function(){
						 $(this).rateYo({
				    rating: parseFloat($(this).attr("title")),
					 starWidth: "25px",
							 halfStar: true,
							 readOnly: true,
							  ratedFill: "#DD270E"
				  });
					});
				   
			 },
			   error: function(data){
				   alert("Falha na comunicação com o banco de dados");
			   }
		});
		
		$(".mais").click(function(){
			a = $(this).attr("id");
			$.ajax({
				  url: "controller.do?command=ConsultaAvaliacaoCompleta&EstabId="+a,
				  dataType: "json",
				   contentType:"application/json",
				   success: function(data){
					   
					   $('#Conteudo-local-'+a+" .todoComentario").html("");
					   
					   $.each(data,function(i,items) {	
						   
						   
						   
						   
						   $('#Conteudo-local-'+a+" .todoComentario").append("<div class='itemComentario'> <h5>"+items.nomeUsuario+"</h5>"+ 
								   "<p class='pAvalia'>Acesso para cadeirantes:</p>"+
								   "<div class='rateYo' title='"+items.notaAcessoCadeirante+"'></div>" +
								   
								   "<p class='pAvalia'>Sanitários para cadeirantes11:</p>"+
								   "<div class='rateYo' title='"+items.notaSanitarioCadeirante+"'></div>" +
								   
								   "<p class='pAvalia'>Instruções para deficientes visuais em braile:</p>"+
								   "<div class='rateYo' title='"+items.notaInfoBraile+"'></div>" +
								   
								   
								   "<p class='pAvalia'>Sinalização de piso para deficientes visuais:</p>"+
								   "<div class='rateYo' title='"+items.notaSinaliPisoDef+"'></div>" +
								   
								   "<p class='pAvalia'>Informações Adicionais:</p>"+
								   "<p>"+items.comentarioUsusario+"</p></div>");

					   });   
					   
					   
					   $(".rateYo").each(function(){
							 $(this).rateYo({
					    rating: parseFloat($(this).attr("title")),
						 starWidth: "25px",
								 halfStar: true,
								 readOnly: true,
								  ratedFill: "#DD270E"
					  });
						});
					   
					   
				 },
				   error: function(data){
					   alert("Falha na comunicação com o banco de dados");
				   }
			});
		})
		
	});



	function Enviaform(){
		ValorCadeirante =  $("#id-cadeirante").rateYo("rating");
		$('#vCadeirante').val(ValorCadeirante);
		
		ValorSCadeirante =  $("#id-sanicadeirante").rateYo("rating");
		$('#vSCadeirante').val(ValorSCadeirante);
		
		ValorVisual =  $("#id-dvisual").rateYo("rating");
		$('#vVisual').val(ValorVisual);
		
		ValorPVisual =  $("#id-pisovisual").rateYo("rating");
		$('#vPVisual').val(ValorPVisual);		
	}