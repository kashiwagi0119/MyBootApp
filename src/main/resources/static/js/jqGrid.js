jQuery(document).ready(function()
{
	var mydata = [
		{xid:"10", comp_name:"株式会社シー", comp_kana:"カブシキカイシャシー"},
		{xid:"11", comp_name:"ビー株式会社", comp_kana:"ビーカブシキカイシャ"},
		{xid:"12", comp_name:"有限会社エー", comp_kana:"ユウゲンガイシャエー"},
	];

	for(var i=0; i<1000; i++){
		mydata.push({xid:"12", comp_name:"有限会社エー", comp_kana:"ユウゲンガイシャエー"});
	}
	
	jQuery("#grid").jqGrid({
		data: mydata,
		rowNum : 99999999,
		datatype: "local",
		colNames:['コード', '会社名', 'カナ'],
		colModel:[
			{index:'xid', name:'xid', width:'60px'},
			{index:'comp_name', name:'comp_name', width:'150px'},
			{index:'comp_kana', name:'comp_kana', width:'500px', editable:true},
		],
		height: '300px',
		multiselect: true,
        cellEdit: true,
        cellsubmit: 'clientArray',
	});	
	
	// テスト1
	$('#jqGridTest1').on('click', function(e) {
		event.preventDefault();
//		// 単一行の選択行の取得
//		var rowId = $('#grid').jqGrid('getGridParam', 'selrow');
//		if (rowId) {
//			alert(rowId);
//		} else {
//			alert('行未選択');
//		}
		
//		// 複数行の選択行の取得
//		var selrows = $('#grid').getGridParam('selarrrow');
//		var msg = "";
//		if (selrows.length > 0) {
//			for (var i = 0; i < selrows.length; i++) {
//				// 選択行
//				var row = $('#grid').getRowData(selrows[i]);
//				msg += row.comp_kana;
//				msg += "\n";
//			}
//		} else {
//			msg = "行未選択";
//		}
//		alert(msg);
		
//		var wk = $('#grid').getRowData(2);
//		alert(wk);
		
//		var wk = $('#grid').editRow(2);
//		var wk = $('#grid').restoreRow(2);
//		var wk = $('#grid').saveRow(2, testfunc);
		
//		$('#grid').setCell(2, 'comp_kana', 'あいうえお');
//		$('#grid').setCell(2, 'comp_kana', '', {'background-color':'red'});
		
//	    $('#grid').setGridHeight('300px');
//      $('#grid').setGridHeight($(window).height() * 0.8);
	    
//	    $('#grid').setGridWidth('300px');
//	    $('#grid').setGridWidth($(window).width() * 0.9);
		
//		$('#grid').setLabel('comp_kana', 'あいうえお');
//		$('#grid').setLabel('comp_kana', '', {'background-color':'red'});
		
//		$('#grid').setRowData(2, {comp_name : 'あいうえお', comp_kana : 'かきくけこ'});
//		$('#grid').setRowData(2, '', {'background-color':'red'});
		
//		$('#grid').setSelection(3);
//		$('#grid').setSelection(3, testfunc());
		
		
//		$('#grid').hideCol(['comp_name','comp_kana']);
		
//		$('#grid')[0].updateColumns();
		
//		$('#grid').clearGridData();
//		$('#grid').GridUnload();
		
//		var colNames = $("#grid").getGridParam("colNames");
//		var colNames = $("#grid").getGridParam("colModel");
		
		var wk = $('#grid').getRowData(2);
	    var a = $('#grid').getGridParam("data"); //グリッドのデータを取得する
	    alert(a);
	    
	    
//	    var recCnt = $('#grid').getGridParam('records');
//	    var b = $('#grid').getGridParam('records');
//	    var b = $('#grid').getGridParam('userData');
//		var b = $('#grid').getGridParam('multiselect');
//		var b = $('#grid').setGridParam({height: '400px'});
	    
//		$("#grid").jqGrid('setGridParam', {cellEdit: false});
//		$("#grid").jqGrid('setGridParam', {height: '200px'});

//		var b = $('#grid').getCell(2, 'comp_kana');
//		var b = $('#grid').getCol('comp_kana');
//		var b = $('#grid')[0].addJSONData(mydata);
		
//		alert(b);
	});
	
	// テスト2
	$('#jqGridTest2').on('click', function(e) {
		event.preventDefault();
//		var wk = $('#grid').restoreRow(2);
//		$('#grid').showCol(['comp_name','comp_kana']);
	});
	
	
});
	
function testfunc() {
	
	alert('aaa');
}

