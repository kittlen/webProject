function CKeditor(){
	CKEDITOR.replace('NoticeContent',{
		filebrowserImageUploadUrl:'/com.qyc.OneProject/NoticeMgrServlet?judge=Upload',
		image_previewText:'&nbsp',
		width:'100%',
		height:'50%'
	});
	
}

function OnNotice(){
	if(!confirm("确认发布此公告")){
		return false;
	}
}
function inputreset() {
	$("[name=NoticeTitle]").val();
	  CKEDITOR.instances.NoticeContent.setData("");
}