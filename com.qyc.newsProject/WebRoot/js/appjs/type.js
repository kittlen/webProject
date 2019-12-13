function show(type,index) {
	var am = $("#am");
	$
			.ajax({
				url : "not/showType",
				type : "post",
				dataType : "json",
				data:{"typeIndex":type,"index":index},
				success : function(data) {
					var Thtml = "";

					for (var i = 0; i < data.length; i++) {
						Thtml += "<li class='am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block' >";
						Thtml += "<div class='pet_list_one_info'>";
						Thtml += "<div class='pet_list_one_info_l'>";
						Thtml += "<div class='pet_list_one_info_ico'>";
						Thtml += "<img src='user/userPhoto/"
								+ data[i].user.photo + data[i].user.photoType
								+ "' alt=''>";
						Thtml += "</div>";
						Thtml += "	<div class='pet_list_one_info_name'>"
								+ data[i].user.name + "</div>";
						Thtml += "</div>";
						Thtml += "<div class='pet_list_one_info_r'>";
						Thtml += "<div class='pet_list_tag pet_list_tag_xxs'>"
								+ data[i].nType.name + "</div>";
						Thtml += "</div></div>";
						Thtml += "<div class=' am-u-sm-8 am-list-main pet_list_one_nr' style='height: 140px;'>";
						Thtml += "<h3 class='am-list-item-hd pet_list_one_bt'>";
						Thtml += "<a href='not/noticecont?notice.nID="
								+ data[i].nID + "' class=''>"
								+ data[i].noticeTitle + "</a>";
						Thtml += "</h3><div class='am-list-item-text pet_list_one_text'>";
						Thtml += data[i].noticeBrief + "</div></div>";
						Thtml += "<div class='am-u-sm-4 am-list-thumb'>";
						Thtml += "<a href='not/noticecont?notice.nID="
								+ data[i].nID + "' class=''> <img src='"
								+ data[i].noticephoto1 + "'";
						Thtml += "class='pet_list_one_img' alt='' />";
						Thtml += "</a></div></li>";
					}
					am.append(Thtml);
				},
				error : function() {

				}
			})
}
function dele(nID) {
	if (confirm("确定删除此条新闻")) {
		location = 'not/delete?notice.nID='+nID;
	}
}