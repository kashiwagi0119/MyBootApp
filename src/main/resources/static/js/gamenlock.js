$(document).ready(function() {

	$('#lockbtn').on('click', function(e) {
	    e.preventDefault();
	    lockScreen()
	    $.ajax({
	        url : "/gamenlocksleep",
	        method: 'post',
	        dataType : "json",

	    }).done(function(json){
	        if (!isJsonError(json)) {
	        }
	        unLockScreen()
	    }).fail(function(jqXHR, textStatus, errorThrown){
	        alertSystemError();
	        unLockScreen()
	    });
	});


});

 //引数にはミリ秒を指定します。（例：5秒の場合は5000）
function sleep(a){
  var dt1 = new Date().getTime();
  var dt2 = new Date().getTime();
  while (dt2 < dt1 + a){
    dt2 = new Date().getTime();
  }
  return;
}


