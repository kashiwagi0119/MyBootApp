$(document).ready(function() {
	searchData();
	// 検索ボタン
	$('#myDataSearch').click( function(e) {
		event.preventDefault();  // デフォルト動作の抑止
		searchData();
	});
	// 送信ボタン
	$('#myDataSend').click( function(e) {
		event.preventDefault();  // デフォルト動作の抑止
        // 複数行
        var rowIds = jQuery("#grid").jqGrid('getDataIDs');
        var dataList = new Array();
        for (var i = 0; i < rowIds.length; i++) {
            var row = $('#grid').getRowData(rowIds[i]);
            row.name = $(row.name).val();
            dataList.push(row);
        }
        var json = JSON.stringify(dataList);
        
//        // 1行
//        var rowIds = jQuery("#grid").jqGrid('getDataIDs');
//        var dataList = new Array();
//        for (var i = 0; i < rowIds.length; i++) {
//            var row = $('#grid').getRowData(rowIds[i]);
//            row.name = $(row.name).val();
//            var json = JSON.stringify(row);
//        }
        
        $.ajax({
        	url : "/MyData/myDataGridSend",
        	dataType : "json",
        	   data : {
        		    "orderStatus": "aaa",
        		    "json": json
        		   },
        	async : false,
    	}).done(function(json){
    		if (!isJsonError(json)) {
//    			displayGrid(json.dataList);
    		}
    	}).fail(function(){
    		alertSystemError();
    	});
	});
});

/**
 * 検索
 */
function searchData() {
    $.ajax({
    	url : "/MyData/searchDSL",
    	dataType : "json",
    	data : $('form').serialize(),
    	async : false,
	}).done(function(json){
		if (!isJsonError(json)) {
			displayGrid(json.dataList);
		}
	}).fail(function(){
		alertSystemError();
	});
}
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
        colNames : [ 'ID', '名前', 'メールアドレス', '年齢', 'メモ', 'ルーム', 'アイテム' ],
        colModel : [
            { name : 'id', index : 'id', align : 'left', width : 50 },
            { name : 'name', index : 'name', align : 'left', width : 100 ,
                formatter : function(cellvalue, options, rowObject) {
                    var result = '<input type="text" class="form-control p-0" value="' + cellvalue + '" />';
                    return result;
                }
            },
            { name : 'mail', index : 'mail', align : 'left', width : 100 , editable:true},
            { name : 'age', index : 'age', align : 'left', width : 50 },
            { name : 'memo', index : 'memo', align : 'left', width : 100 },
            { name : 'room', index : 'room', align : 'left', width : 70,
                formatter : function(cellvalue, options, rowObject) {
                    var result = "";
                    if (rowObject.room != null && rowObject.room.name != null) {
                        result = result + rowObject.room.name
                    }
                    return result;
                }
            },
            { name : 'item', index : 'item', align : 'left', width : 80,
                formatter : function(cellvalue, options, rowObject) {
                    var result = "";
                    if (rowObject.room != null && rowObject.room.item != null) {
                        result = result + rowObject.room.item.itemName
                    }
                    return result;
                }
            },
            ],
		pager : 'pager1',              //footerのページャー要素のid
		rowNum : 20,                   //一ページに表示する行数
		rowList : [1, 10, 20, 100],         //変更可能な1ページ当たりの行数
		viewrecords: true,              //ページャーのページ数表示
		cellEdit: true,
    });

}
