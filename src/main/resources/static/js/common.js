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

//Ajax通信失敗時処理
function ajaxerror(XMLHttpRequest, textStatus, errorThrown) {
 alert("error:" + XMLHttpRequest);
 alert("status:" + textStatus);
 alert("errorThrown:" + errorThrown);
}
