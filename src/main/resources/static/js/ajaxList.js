$(function() {
    // Ajax通信テスト ボタンクリック
    $("#ajax_btn").click(function() {
        $.ajax({
            type : "GET",
            url : "/Ajax/search",
            dataType : "json",
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
    // グリッドを削除
    $('#griddiv').empty();
    // グリッドを再挿入
    $('#griddiv').append('<table class="table table-sm table-hover" id="grid"></table>');
    // グリッドの表示
    $('#grid').jqGrid( {
        data : data,
        rowNum : 99999999,
        datatype : 'local',
        width : '800',
        shrinkToFit : false, // カラム幅の自動調整をしない
        cmTemplate : { sortable : false }, // ソートを無効化
        colNames : [ 'ID', '名前', 'メールアドレス', '年齢', 'メモ' ],
        colModel : [
            { name : 'id', index : 'id', align : 'left', width : 50 },
            { name : 'name', index : 'name', align : 'left', width : 200 },
            { name : 'mail', index : 'mail', align : 'left', width : 200 },
            { name : 'age', index : 'age', align : 'left', width : 50 },
            { name : 'memo', index : 'memo', align : 'left', width : 500 },
            ],
    });
    // グリッドの高さ
    $('#grid').parents('div.ui-jqgrid-bdiv').css('min-height', '330px');
    $('#grid').parents('div.ui-jqgrid-bdiv').css('max-height', '330px');
    
    $('#griddiv thead tr').addClass('table-primary');  // ヘッダを青に
    $('#griddiv .ui-jqgrid-sortable').css('height', '34px');  // ヘッダの高さ
    $('#griddiv tr, td').css('font-size', '20px');  // フォントサイズ
    $('#griddiv .ui-jqgrid-htable').attr('border', '1');  // 枠線
    $('#grid').attr('border', '1');  // 枠線
    
}

