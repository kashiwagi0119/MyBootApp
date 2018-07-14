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
	    	success : function(data) {
	    		alert(data[0]);
	    	},
	    	error : function() {
	    		alertify.alert('システムエラー', 'システムエラーが発生しました。');
	    	}
		});
	});
	
});

