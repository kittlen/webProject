$(function() {

	// 动态计算新闻列表文字样式
	auto_resize();
	$(window).resize(function() {
		auto_resize();
	});
	$('.am-list-thumb img').load(function() {
		auto_resize();
	});
	$('.pet_article_like li:last-child').css('border', 'none');
	function auto_resize() {
		$('.pet_list_one_nr').height($('.pet_list_one_img').height());
		// alert($('.pet_list_one_nr').height());
	}
	$('.pet_article_user').on(
			'click',
			function() {
				if ($('.pet_article_user_info_tab').hasClass(
						'pet_article_user_info_tab_show')) {
					$('.pet_article_user_info_tab').removeClass(
							'pet_article_user_info_tab_show').addClass(
							'pet_article_user_info_tab_cloes');
				} else {
					$('.pet_article_user_info_tab').removeClass(
							'pet_article_user_info_tab_cloes').addClass(
							'pet_article_user_info_tab_show');
				}
			});

	$('.pet_head_gd_ico').on('click', function() {
		$('.pet_more_list').addClass('pet_more_list_show');
	});
	$('.pet_more_close').on('click', function() {
		$('.pet_more_list').removeClass('pet_more_list_show');
	});
});