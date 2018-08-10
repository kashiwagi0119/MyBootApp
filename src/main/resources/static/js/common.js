$(document).ready(function(){
  // ファイル選択
  $('.custom-file-input').on('change',function(){
	  $(this).next('.custom-file-label').html($(this)[0].value);
//	  var filepath = $(this)[0].value;
//	  filepath = filepath.replace('\','¥');
//    $(this).next('.custom-file-label').html(filepath);
//    $(this).next('.custom-file-label').html($(this)[0].files[0].name);
    var tmppath = URL.createObjectURL($(this)[0].files[0]);
    var bbb = $('#customFile')[0].files[0].name
//    var fName  = document.form.customFile.value;
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
function alertSystemError(err) {
	alertify.alert('システムエラー', 'システムエラーが発生しました。<br/>' + err.responseJSON);
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


