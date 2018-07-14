$(document).ready(function() {
	
	$('#fileUploadAjax').on('click', function(e) {
		event.preventDefault();
		$.ajax({
			url: '/FileUploadAjax',
			method: 'post',
			dataType: 'json',
			data: new FormData($('form')[0]),
			processData: false,
			contentType: false,
		}).done(function(data){
	    	alert(data[0]);
		}).fail(function(){
			alertSystemError();
		});
	});
	
});

