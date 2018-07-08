$(document).ready(function() {
	$('#myDataSearch').click( function(e) {
		event.preventDefault();  // デフォルト動作の抑止
	    $.ajax({
	    	type : "GET",
<<<<<<< HEAD
	    	url : "/MyData/search",
	    	dataType : "json",
	    	data : $('form').serialize(),
	    	async : false,
	    	success : function(data) {
	    		displayGrid(data);
	    	},
	    	error : function(XMLHttpRequest, textStatus, errorThrown) {
	    		ajaxerror(XMLHttpRequest, textStatus, errorThrown);
	    	}
	    });
	});
});

/**
 * グリッド表示
 */
function displayGrid(data) {

	　$("#grid").GridUnload(); // グリッドをクリア
	
    // グリッドの表示
    $('#grid').jqGrid( {
        data : data,
        rowNum : 99999999,
        datatype : 'local',
        width : '1000',
        shrinkToFit : true, // カラム幅の自動調整をしない
        cmTemplate : { sortable : false }, // ソートを無効化
        colNames : [ 'ID', '名前', 'メールアドレス', '年齢', 'メモ' ],
        colModel : [
            { name : 'id', index : 'id', align : 'left', width : 50 },
            { name : 'name', index : 'name', align : 'left', width : 200 },
            { name : 'mail', index : 'mail', align : 'left', width : 200 },
            { name : 'age', index : 'age', align : 'left', width : 50 },
            { name : 'memo', index : 'memo', align : 'left', width : 500 },
            ],
		pager : 'pager1',              //footerのページャー要素のid
		rowNum : 20,                   //一ページに表示する行数
		rowList : [1, 10, 20, 100],         //変更可能な1ページ当たりの行数
		viewrecords: true,              //ページャーのページ数表示
    });

}

