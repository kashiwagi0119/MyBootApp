$(document).ready(function(){
    $("#alertbtn").click(function() {
    	alertify.alert('メッセージタイトル', 'メッセージの内容');
    });
    $("#confirmbtn").click(function() {
    	alertify.confirm('確認メッセージ', '実行しますか？'
    	, function(){ alertify.success('Ok') }
        , function(){ alertify.error('Cancel')});
    });
    
    
});

