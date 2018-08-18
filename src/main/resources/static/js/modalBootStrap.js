$(document).ready(function(){
	$(".modal").draggable({
	    handle: ".modal-header"
	});
});

function modal31Save() {
	  $('.modal31CodeLabel').val($('#modal31Code').val());
	  $('#modal31').modal('hide');
}
