$(document).ready(function(){
	// モーダル１の設定
    $("#mdl1").dialog({
    	autoOpen: false,
    	modal: true,
    	width: 500,
    	buttons: {
    		'確定': function() {
    			$('#resultText').val('確定がクリックされました。');
    			$(this).dialog('close');
    		},
    		'キャンセル': function() {
    			$('#resultText').val('キャンセルがクリックされました。');
    			$(this).dialog('close');
    		}
    	}
    });
    // モーダル１ボタンクリック
    $("#btn1").click(function() {
    	$("#mdl1").dialog("open");
    });
    
});

