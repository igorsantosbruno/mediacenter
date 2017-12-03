$('document').ready(function(){
	
	$.ajax({
		url: "controller.do?command=ListarEstado",
		  dataType: "json",
		   contentType:"application/json",
		   success: function(data){
			   
			   $('#estadoTodo').html("");
			   $('#estadoTodo').append("<option value='0'>Selecione</option>");
			   $.each(data,function(i,items) {	

					  
				   $('#estadoTodo').append("<option value='"+items.IdEstado+"'>"+items.NomeEstado+"</option>");
				  
			   });
		   }, error: function(data){
			   alert("Falha na comunicação com o banco de dados");
		   }
	});
	
	
					$('#estadoTodo').change(function(){
						
						a = $('#estadoTodo option:selected').val();
							$.ajax({
								url: "controller.do?command=ListarCidade&idEstado="+a,
								  dataType: "json",
								   contentType:"application/json",
								   success: function(data){
									   
									   $('#todaCidade').html("");
									   
									   $.each(data,function(i,items) {	
										   
										   $('#todaCidade').append("<option value='"+items.idCidade+"'>"+items.NomeCidade+"</option>");
										  
									   });
								   }, error: function(data){
									   alert("Falha na comunicação com o banco de dados");
								   }
							});
						
					}); 
	
	
});	
	
	
	