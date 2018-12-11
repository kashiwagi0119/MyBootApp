function alertSystemError() {
	alertify.alert('システムエラー', 'システムエラーが発生しました。');
}
function alertSystemError(err) {
	alertify.alert('システムエラー', 'システムエラーが発生しました。<br/>' + err.responseJSON);
}


$(document).ready(function() {

	// ファイル選択
	$('.custom-file-input').on('change', function() {
		// フルパス
		var result = $(this)[0].value.replace( /\\/g, '&yen;' );
		$(this).next('.custom-file-label').html(result);
		// ファイル名のみ
		// $(this).next('.custom-file-label').html($(this)[0].files[0].name);
	});

	// ツールチップ
	$('[data-toggle="tooltip"]').tooltip();

	// カレンダー（yyyy/mm/dd）
	$(function() {
		$('.dateyyyymmdd').datepicker({
			language : 'ja',
			format : 'yyyy/mm/dd',
			autoclose : true,
			todayHighlight : true,  // 当日をハイライトする
			forceParse : false,  // 入力値の解析をしない
			showOnFocus : false,  // 入力フィールドフォーカス時にカレンダー表示しない
		});
	});

	// カレンダー（yymmdd）
	$(function() {
		$('.dateyymmdd').datepicker({
			language : 'ja',
			format : 'yymmdd',
			autoclose : true,
			todayHighlight : true,  // 当日をハイライトする
			forceParse : false,  // 入力値の解析をしない
			showOnFocus : false,  // 入力フィールドフォーカス時にカレンダー表示しない
		});
	});

	// モーダル画面を移動可能にする
	$(document).ready(function(){
		$(".modal").draggable({
		    handle: ".modal-header"
		});
	});

});

function alertSystemError() {
	formSubmit('/sendErrorPage');
	//alert('システムエラーが発生しました。');
}

/**
 * エラー確認 メッセージ表示 エラーの場合、trueを返す
 */
function isJsonError(json) {

	if (json.errorList.length > 0) {
		alert(json.errorList.join('\n'));
		return true;
	}
	if (json.messageList.length > 0) {
		alert(json.messageList.join('\n'));
	}
	return false;
}

/**
 * 画面ロック
 */
function lockScreen() {
	$.blockUI({
		message : '処理中です。お待ちください。',
		css: {'z-index': 99999999},
		overlayCSS: {'z-index': 99999999},
	});
}

/**
 * 画面ロック解除
 */
function unLockScreen() {
	$.unblockUI();
}

/**
 * フォームサブミット
 */
function formSubmit(url) {
	// 元のアクションを退避
	var beforeAction = $('#form').attr('action');

    $('#form').attr('action', '/' + applicationCode +  url);
    $('#form').submit();

    // アクションを戻しておく
    $('#form').attr('action', beforeAction);
    return false;
}




