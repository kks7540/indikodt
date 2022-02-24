$(document).ready(function() {
  //gnb
  $('#gnb .nav')
    .on('mouseenter focusin', function() {
      $('#gnb').addClass('active');
    })
    .on('mouseleave focusout', function() {
      $('#gnb').removeClass('active');
    });

  //패밀리사이트
  $('.familysite > a').on('click', function() {
    $(this)
      .parent()
      .toggleClass('active')
      .find('.list')
      .stop()
      .slideToggle();
  });

  //말줄임
  $('.eps2').ellipsis({ lines: 2, responsive: true });
  $('.eps3').ellipsis({ lines: 3, responsive: true });

  //select
  $('select').niceSelect();

  //tab
  $('.tab').each(function() {
    var tab = $(this);
    tab.find('li').each(function() {
      var tabLi = $(this),
        tabLiIdx = tabLi.index();
      tabLi.find('a').on('click', function(e) {
        if ($(this).attr('href') == '#') {
          e.preventDefault();
        }
        tabLi
          .addClass('active')
          .siblings()
          .removeClass('active');

        if (tab.parent('div').hasClass('tab_area')) {
          tab
            .siblings('.tab_cont')
            .find('.cont')
            .eq(tabLiIdx)
            .addClass('active')
            .siblings()
            .removeClass('active');
        }
      });
    });
  });

  //이메일폼 직접입력
  $('.email_form').each(function() {
    $(this)
      .find('select')
      .on('change', function() {
        if ($(this).val() == '직접입력') {
          $(this)
            .parents('.email_form')
            .find('.email_inp')
            .addClass('active')
            .val('')
            .focus();
        } else {
          $(this)
            .parents('.email_form')
            .find('.email_inp')
            .removeClass('active')
            .val('');
        }
      });
  });
});

//글자수 제한
function maxLengthCheck(object) {
  if (object.value.length > object.maxLength) {
    object.value = object.value.slice(0, object.maxLength);
  }
}

//레이어 팝업 열기
function layerShow(ele) {
  $('#' + ele).addClass('active');
}
//레이어 팝업 닫기
function layerHide(ele) {
  $('#' + ele).removeClass('active');
}
//윈도우 팝업
function winPop(url, title, w, h) {
  var top = screen.height / 2 - h / 2,
    left = screen.width / 2 - w / 2;
  return window.open(
    url,
    title,
    'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=no, width=' +
      w +
      ', height=' +
      h +
      ', top=' +
      top +
      ', left=' +
      left
  );
}
