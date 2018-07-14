$(document).ready(function(){
  // ファイル選択
  $('.custom-file-input').on('change',function(){
    $(this).next('.custom-file-label').html($(this)[0].files[0].name);
  });
  // ツールチップ
  $('[data-toggle="tooltip"]').tooltip();
  // カレンダー
  $(function () {
    $('.date').datepicker({
      language: 'ja',
      format: 'yyyy/mm/dd',
      autoclose: true,
      todayHighlight : true
    });
  });
});

function alertSystemError() {
	alertify.alert('システムエラー', 'システムエラーが発生しました。');
}

/**
 * エラー確認 メッセージ表示
 * エラーの場合、trueを返す
 */
function isJsonError(json) {
	
	if (json.errorList.length > 0) {
		alertify.alert('メッセージ', json.errorList.join('<br/>'));
		return true;
	}
	if (json.messageList.length > 0) {
		alertify.alert('メッセージ', json.messageList.join('<br/>'));
	}
	return false;
}


