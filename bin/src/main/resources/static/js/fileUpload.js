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
	
	$('#fileDownloadAjax').on('click', function(e) {
		event.preventDefault();
		$.ajax({
			url: '/FileDownloadAjax',
			method: 'post',
			data: new FormData($('form')[0]),
			processData: false,
			contentType: false,
	    }).done(function(data, status, jqXHR) {
			  let downloadData = new Blob([data], {type: 'text/csv'});
			  let filename = 'users.csv'
			
			  if (window.navigator.msSaveOrOpenBlob) {
				  // IEの場合
			  window.navigator.msSaveOrOpenBlob(downloadData, filename); // IE用
			  } else {
				let downloadUrl  = (window.URL || window.webkitURL).createObjectURL(downloadData);
				let link = document.createElement('a');
				link.href = downloadUrl;
				link.download = filename;
				link.click();
				(window.URL || window.webkitURL).revokeObjectURL(downloadUrl);
	    	  }

		}).fail(function(){
			alertSystemError();
		});
	});
	
});

