$(document).ready(function() {

	var date = [
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:1,name:"nakagawa",age:20,local:"Japan",hobby:"Tennis"},
		{no:2,name:"nakayama",age:20,local:"Japan",hobby:"Soccer"}
	];
	//列の設定
	var colModelSettings= [	
		{name:"no",index:"no",width:70,align:"center",classes:"no_class"},
		{name:"name",index:"name",width:200,align:"center",classes:"name_class"},
		{name:"age",index:"age",width:200,align:"center",classes:"age_class"},
		{name:"local",index:"local",width:200,align:"center",classes:"local_class"},
		{name:"hobby",index:"hobby",width:200,align:"center",classes:"hobby_class"}
	]
	//列の表示名
	var colNames = ["No.","name","age","local","hobby"];
	//テーブルの作成
	$("#grid").jqGrid({
		data:date,  //表示したいデータ
		datatype : "local",            //データの種別 他にjsonやxmlも選べます。
	                                       //しかし、私はlocalが推奨です。
		colNames : colNames,           //列の表示名
		colModel : colModelSettings,   //列ごとの設定
		rowNum : 10,                   //一ページに表示する行数
		rowList : [1, 10, 20],         //変更可能な1ページ当たりの行数
		height : 200,                  //高さ
		width : 800,                   //幅
		pager : 'pager1',              //footerのページャー要素のid
		shrinkToFit : true,　　        //画面サイズに依存せず固定の大きさを表示する設定
		viewrecords: true              //footerの右下に表示する。
	});
	


	
});
