$(document).ready(function(){
    $("#alertbtn").click(function() {
    	alertify.alert('メッセージタイトル', 'メッセージの内容');
    });
    $("#confirmbtn").click(function() {
    	alertify.confirm('確認メッセージ', '実行しますか？'
    	, function(){ 
    		alertify.success('Ok') 
    	}
        , function(){ 
        	alertify.error('Cancel')
        });
    });
    $("#inputbtn").click(function() {
    	alertify.prompt("入力", "名前を入力してください。", "デフォルト文字列"
    	,　function(evt, value){
    		alertify.success('Ok: ' + value);
    	}
    	,　function(){
    		alertify.error('Cancel');
    	});
    });
    
    
});

