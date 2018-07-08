$(document).ready(function() {
	$('#myDataSearch').click( function(e) {
		event.preventDefault();  // デフォルト動作の抑止
	    $.ajax({
	    	type : "GET",	
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
        colNames : [ 'ID', '名前', 'メールアドレス', '年齢', 'メモ', 'ルーム', 'アイテム', '削除', '更新画面へ' ],
        colModel : [
            { name : 'id', index : 'id', align : 'left', width : 50 },
            { name : 'name', index : 'name', align : 'left', width : 100 },
            { name : 'mail', index : 'mail', align : 'left', width : 100 },
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
            { name : 'delete', index : 'delete', align : 'center', width : 70,
                formatter : function(cellvalue, options, rowObject) {
                    return '<input type="button" class="btn btn-primary delete" value="削除" data-rowid="' + options.rowId + '" >'
                }
            },
            { name : 'update', index : 'update', align : 'center', width : 100,
                formatter : function(cellvalue, options, rowObject) {
                    return '<input type="button" class="btn btn-info update" value="更新画面へ" data-rowid="' + options.rowId + '" >'
                }
            },
            ],
		pager : 'pager1',              //footerのページャー要素のid
		rowNum : 20,                   //一ページに表示する行数
		rowList : [1, 10, 20, 100],         //変更可能な1ページ当たりの行数
		viewrecords: true,              //ページャーのページ数表示
    });

}

