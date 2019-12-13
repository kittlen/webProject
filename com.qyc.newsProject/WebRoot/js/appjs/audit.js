function show() {
	var am = $("#am");
	$
			.ajax({
				url : "adm/auditInfo",
				type : "post",
				dataType : "json",
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
						Thtml += "<div><select id='Auditing";
						Thtml += (i + 1) + "'>";
						Thtml += "<option value='审核通过'>审核通过</option>";
						Thtml += "<option value='审核未通过'>审核未通过</option>";
						Thtml += "</select><input type='button' onclick='conf(";
						Thtml += (i + 1) + "," + data[i].nID
						Thtml += ")' value='修改'></div>";
						Thtml += "<div class='pet_list_tag pet_list_tag_xxs'>"
								+ data[i].nType.name + "</div>";
						Thtml += "</div></div>";
						Thtml += "<div class=' am-u-sm-8 am-list-main pet_list_one_nr' style='height: 140px;'>";
						Thtml += "<h3 class='am-list-item-hd pet_list_one_bt'>";
						Thtml += "<a target='_blank' href='not/noticecont?notice.nID="
								+ data[i].nID
								+ "' class=''>"
								+ data[i].noticeTitle + "</a>";
						Thtml += "</h3><div class='am-list-item-text pet_list_one_text'>";
						Thtml += data[i].noticeBrief + "</div></div>";
						Thtml += "<div class='am-u-sm-4 am-list-thumb'>";
						Thtml += "<a target='_blank' href='not/noticecont?notice.nID="
								+ data[i].nID
								+ "' class=''> <img src='"
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
function conf(index,nID){
	var s='#Auditing'+index;
	var d=$(s).val();
	if(confirm("确认修改状态为:"+d)){
		location='adm/auditup?notice.nID='+nID+'&notice.audit='+d;
	}
}