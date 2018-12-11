$(document).ready(function(){
	// bootStrapモーダルを移動可能にする	
	$(".modal").draggable({
	    handle: ".modal-header"
	});
	
	
	
	// bootboxアラート
	$('#bootboxAlert').click(function() {
		bootbox.alert("アラートメッセージの内容");
		// ダイアログを移動可能にする
		$(".bootbox").draggable({
			handle: ".modal-body"
		});
	});
	
	// bootboxコンフォーム
	$('#bootboxConfirm').click(function() {
		bootbox.confirm("本当によろしいですか?", function(result) {
			if (result) {
				alert("OKがクリックされました");
			} else {
				alert("キャンセルがクリックされました");
			}
		});
		// ダイアログを移動可能にする
		$(".bootbox").draggable({
			handle: ".modal-body"
		});
	});
	
	// bootbox入力　×が前に来ていまいちかな
	$('#bootboxPrompt').click(function() {
		bootbox.prompt("名前を入力してください", function(result) {                
			  if (result === null) {                                             
				  alert("未入力");                              
			  } else {
				  alert("名前が「"+result+"」と入力されました");                          
			  }
			});
		// ダイアログを移動可能にする
		$(".bootbox").draggable({
			handle: ".modal-body"
		});
	});
	
	// テスト
	$('#test').click(function() {
	});

});

function modal31Save() {
	  $('.modal31CodeLabel').val($('#modal31Code').val());
	  $('#modal31').modal('hide');
}
