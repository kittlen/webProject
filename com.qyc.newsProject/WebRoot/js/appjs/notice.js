
function CKeditor() {
	CKEDITOR.replace('NoticeContent', {
		filebrowserImageUploadUrl : '../not/imgUpload',
		image_previewText : '&nbsp',
		width : '100%',
		height : '50%'
	});

}
function show() {
	var opt = $("#id");
	$.ajax({
		url : "adm/nTypeInfo",
		type : "post",
		dataType : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				opt.append("<option value='" + data[i].nTID + "'>"
						+ data[i].name + "</option>");
			}
		},
		error : function() {
			alert("新闻类型获取失败")
		}
	})
}
function OnNotice() {
	if (!confirm("确认发布此新闻")) {
		return false;
	}
}
function inputreset() {
	if (confirm("确认重置?")) {
		$("#noticeTitle").val();
		$("#noticeBrief").val();
		CKEDITOR.instances.NoticeContent.setData("");
	}
}