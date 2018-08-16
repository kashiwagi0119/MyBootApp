jQuery(document).ready(function()
{
	var mydata = [
		{xid:"10", comp_name:"株式会社シー", comp_kana:"180102"},
		{xid:"11", comp_name:"ビー株式会社", comp_kana:"180102"},
		{xid:"12", comp_name:"有限会社エー", comp_kana:"180102"},
	];

//	for(var i=0; i<1000; i++){
//		mydata.push({xid:"12", comp_name:"有限会社エー", comp_kana:"2018/01/02"});
//	}
	
	// 開始
	$('#aaa').text(new Date());

	// クリア
	// なにもなし6秒
	// clearGridData 6秒のまま
//		$("#grid").jqGrid('clearGridData');
//    // グリッドを削除 // グリッドを再挿入 6秒のまま
//    $('#griddiv').empty();
//    $('#griddiv').append('<table class="table-striped" id="grid"></table>');
	
	// ■サマリー　　結論はeditableでカレンダーをつけるべし
	// カレンダーJqueryUI IE=17秒。2000件＝42秒。 datepは英語で出た
	// カレンダー IE=20秒、2000件＝55秒
	// inputtextを１つでIE=2秒、2000件＝6秒
	// editableは1000件 IE=1~2秒、2000件＝5秒
	// editableなしは1000件 IE=1~2秒、2000件＝4から5秒
	
	// editableは1000件 IE=1~2秒、2000件＝5秒
	jQuery("#grid").jqGrid({
		data: mydata,
		rowNum : 99999999,
		datatype: "local",
		colNames:['コード', '会社名', '日付'],
		colModel:[
			{index:'xid', name:'xid', width:'60px'},
			{index:'comp_name', name:'comp_name', width:'150px', editable:true},
			{name:'comp_kana', index:'comp_kana', width:'120px', editable:true, edittype:'custom', editoptions:{custom_element:elmDate, custom_value:valDate}},
			],
			height: '300px',
			multiselect: true,
			cellEdit: true,
			cellsubmit: 'clientArray',
	});	


	
//	// カレンダーJqueryUI IE=17秒。2000件＝42秒。 datepは英語で出た。functionで時間がかかっている
//	$(function() {
////		$.datepicker.setDefaults( $.datepicker.regional[ "ja" ] );
//		$(".datepicker").datepicker();
//		// 終了
//		$('#bbb').text(new Date());
//	});
//	jQuery("#grid").jqGrid({
//		data: mydata,
//		rowNum : 99999999,
//		datatype: "local",
//		colNames:['コード', '会社名', 'カナ'],
//		colModel:[
//			{index:'xid', name:'xid', width:'60px'},
//			{index:'comp_name', name:'comp_name', width:'150px'},
//			{index:'comp_kana', name:'comp_kana', width:'500px',
//				formatter : function(cellvalue, options, rowObject) {
//					var result = '<input type="text" class="datepicker" >';
//					return result;
//				}
//			},
//			],
//			height: '300px',
//			multiselect: true,
//			cellEdit: true,
//			cellsubmit: 'clientArray',
//	});	

//	// カレンダー IE=20秒、2000件＝55秒
//	jQuery("#grid").jqGrid({
//		data: mydata,
//		rowNum : 99999999,
//		datatype: "local",
//		colNames:['コード', '会社名', 'カナ'],
//		colModel:[
//			{index:'xid', name:'xid', width:'60px'},
//			{index:'comp_name', name:'comp_name', width:'150px'},
//			{index:'comp_kana', name:'comp_kana', width:'500px',
//				formatter : function(cellvalue, options, rowObject) {
//					/*var result = '<input type="text" id="comp_kana" name="comp_kana" value="' + cellvalue + '"';*/
//					var result = '<div class="input-group date" >';
//					result = result + '<input type="text" class="form-control" id="comp_kana" name="comp_kana" style="flex:none; width:110px" />';
//					result = result + '<span class="input-group-addon"><i class="fas fa-calendar-alt fa-2x ml-1"></i></span>';
//					result = result + '</div>';
//					
//					return result;
//				}
//			},
//			],
//			height: '300px',
//			multiselect: true,
//			cellEdit: true,
//			cellsubmit: 'clientArray',
//	});	
	
//	// inputtextを１つでIE=2秒、2000件＝6秒
//	jQuery("#grid").jqGrid({
//		data: mydata,
//		rowNum : 99999999,
//		datatype: "local",
//		colNames:['コード', '会社名', 'カナ'],
//		colModel:[
//			{index:'xid', name:'xid', width:'60px'},
//			{index:'comp_name', name:'comp_name', width:'150px'},
//			{index:'comp_kana', name:'comp_kana', width:'150px',
//				formatter : function(cellvalue, options, rowObject) {
//					var result = '<input type="text" id="comp_kana" name="comp_kana" value="' + cellvalue + '"';
//					return result;
//				}
//			},
//			],
//			height: '300px',
//			multiselect: true,
//			cellEdit: true,
//			cellsubmit: 'clientArray',
//	});	
	
//	// editableは1000件 IE=1~2秒、2000件＝5秒
//	jQuery("#grid").jqGrid({
//		data: mydata,
//		rowNum : 99999999,
//		datatype: "local",
//		colNames:['コード', '会社名', 'カナ'],
//		colModel:[
//			{index:'xid', name:'xid', width:'60px'},
//			{index:'comp_name', name:'comp_name', width:'150px'},
//			{index:'comp_kana', name:'comp_kana', width:'150px', editable:true},
//			
//			],
//			height: '300px',
//			multiselect: true,
//			cellEdit: true,
//			cellsubmit: 'clientArray',
//	});	
	
//	// editableなしは1000件 IE=1~2秒、2000件＝4から5秒
//	jQuery("#grid").jqGrid({
//		data: mydata,
//		rowNum : 99999999,
//		datatype: "local",
//		colNames:['コード', '会社名', 'カナ'],
//		colModel:[
//			{index:'xid', name:'xid', width:'60px'},
//			{index:'comp_name', name:'comp_name', width:'150px'},
//			{index:'comp_kana', name:'comp_kana', width:'150px'},
//			
//			],
//			height: '300px',
//			multiselect: true,
//	});	
	
	// 終了
	$('#bbb').text(new Date());
	
	// テスト1
//	$('#jqGridTest1').on('click', function(e) {
//		event.preventDefault();
////		// 単一行の選択行の取得
////		var rowId = $('#grid').jqGrid('getGridParam', 'selrow');
////		if (rowId) {
////			alert(rowId);
////		} else {
////			alert('行未選択');
////		}
//		
////		// 複数行の選択行の取得
////		var selrows = $('#grid').getGridParam('selarrrow');
////		var msg = "";
////		if (selrows.length > 0) {
////			for (var i = 0; i < selrows.length; i++) {
////				// 選択行
////				var row = $('#grid').getRowData(selrows[i]);
////				msg += row.comp_kana;
////				msg += "\n";
////			}
////		} else {
////			msg = "行未選択";
////		}
////		alert(msg);
//		
////		var wk = $('#grid').getRowData(2);
////		alert(wk);
//		
////		var wk = $('#grid').editRow(2);
////		var wk = $('#grid').restoreRow(2);
////		var wk = $('#grid').saveRow(2, testfunc);
//		
////		$('#grid').setCell(2, 'comp_kana', 'あいうえお');
////		$('#grid').setCell(2, 'comp_kana', '', {'background-color':'red'});
//		
////	    $('#grid').setGridHeight('300px');
////      $('#grid').setGridHeight($(window).height() * 0.8);
//	    
////	    $('#grid').setGridWidth('300px');
////	    $('#grid').setGridWidth($(window).width() * 0.9);
//		
////		$('#grid').setLabel('comp_kana', 'あいうえお');
////		$('#grid').setLabel('comp_kana', '', {'background-color':'red'});
//		
////		$('#grid').setRowData(2, {comp_name : 'あいうえお', comp_kana : 'かきくけこ'});
////		$('#grid').setRowData(2, '', {'background-color':'red'});
//		
////		$('#grid').setSelection(3);
////		$('#grid').setSelection(3, testfunc());
//		
//		
////		$('#grid').hideCol(['comp_name','comp_kana']);
//		
////		$('#grid')[0].updateColumns();
//		
////		$('#grid').clearGridData();
////		$('#grid').GridUnload();
//		
////		var colNames = $("#grid").getGridParam("colNames");
////		var colNames = $("#grid").getGridParam("colModel");
//		
//		var wk = $('#grid').getRowData(2);
//	    var a = $('#grid').getGridParam("data"); //グリッドのデータを取得する
//	    alert(a);
//	    
//	    
////	    var recCnt = $('#grid').getGridParam('records');
////	    var b = $('#grid').getGridParam('records');
////	    var b = $('#grid').getGridParam('userData');
////		var b = $('#grid').getGridParam('multiselect');
////		var b = $('#grid').setGridParam({height: '400px'});
//	    
////		$("#grid").jqGrid('setGridParam', {cellEdit: false});
////		$("#grid").jqGrid('setGridParam', {height: '200px'});
//
////		var b = $('#grid').getCell(2, 'comp_kana');
////		var b = $('#grid').getCol('comp_kana');
////		var b = $('#grid')[0].addJSONData(mydata);
//		
////		alert(b);
//	});
//	
	// テスト2
	$('#jqGridTest2').on('click', function(e) {
		event.preventDefault();
//		var wk = $('#grid').restoreRow(2);
//		$('#grid').showCol(['comp_name','comp_kana']);
		$('#inputdate').focus();
	});
	
});


function testfunc() {
	
	alert('aaa');
}

/**
 * edittype:customの要素を生成する関数
 * @param value 現在の値
 * @param options 要素のオプション
 */
function elmDate(value, options) {
//	var result = '';
//	var result = result + '<input type="text" id="inputdate" class="form-control date" style="width:200px" value="' + value + '"/>';
	
	var result = '';
	var result = result + '<div class="input-group date">';
	var result = result + '<input type="text" id="inputdate" class="form-control p-0"  value="' + value + '"/>';
	var result = result + '<span class="input-group-addon">';
	var result = result + '<i class="fas fa-calendar-alt fa-2x ml-1" style="font-size:20px;"></i>';
	var result = result + '</span></div>';
	
	var selectDate = "";
	if (value != "") {
		selectDate = "20" + value.substr(0, 2) + "/" + value.substr(2, 2) + "/" + value.substr(4, 2); 
	}
	var elm = $(result).datepicker({
		  language: 'ja',
		  format: 'yymmdd',
		  autoclose: true,
		  todayHighlight : true
	}).datepicker("setDate", selectDate);
	$('#inputdate').ready(function() {
		$('#inputdate').focus();
	});
    return elm;
}
/**
 * edittype:customの値確定時に送信する値
 * @param elem 編集中の要素
 * @param operation "get"or"set"
 * @param value ? operationがsetのときに何かくる
 */
function valDate(elem, operation, value) {
  return $('#inputdate').val();
}
