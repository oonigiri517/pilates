
// ロールオーバー
$(function() {
	$('#gloNav li a img').hover(function() {
		$(this).attr('src', $(this).attr('src').replace('-off', '-on'));
	}, function() {
		if (!$(this).hasClass('currentPage')) {
			$(this).attr('src', $(this).attr('src').replace('-on', '-off'));
		}
	});
});


// ナビゲーションクリック動作
$(function() {
	$('a[href^=#]').on('click', function() {
		var speed = 500;
		var href = $(this).attr('href');
		var target = $(href == '#' || href == '' ? 'html' : href);
		var position = target.offset().top - 10;
		$('html, body').animate({
			scrollTop: position
		}, speed, 'swing');
		return false;
	});
});


// ページトップへ
$(function() {
	$('#pageTop p a').click(function() {
		$('html,body').animate({
			scrollTop: 0
		}, 'swing');
		return false;
	});
});