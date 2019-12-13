$(document).ready(function(){
	table();
});

function table() {
	$.ajax({
		url : "CourseScheduleMgrServlet?judge=TTse",
		type : "post",
		dataType : "json",
		success : function(data) {
			var Thtml = "";
			for (var i = 0, t = 0; i < data.length; i++) {
				var Classfestival,ClassTime=0;
				switch (data[i].classfestival){
				case '星期一': Classfestival=0;break;
				case '星期二': Classfestival=1;break;
				case '星期三': Classfestival=2;break;
				case '星期四': Classfestival=3;break;
				case '星期五': Classfestival=4;break;
				}
				switch (data[i].classTime){
				case '一、二节': ClassTime=0;break;
				case '三、四节': ClassTime=1;break;
				case '五、六节': ClassTime=2;break;
				case '七、八节': ClassTime=3;break;
				case '九、十节': ClassTime=4;break;
				case '十一、十二节': ClassTime=5;break;
				}
				var Thtml=$("#TimeTablesTable tr").eq(ClassTime).find("td").eq(Classfestival).html();
				if(Thtml!=''){
				$("#TimeTablesTable tr").eq(ClassTime).find("td").eq(Classfestival).html(Thtml+'</br>'+data[i].course+" "+data[i].classRoomName); // 将表格第m+1行第n+1列的内容设置为s
			}else{
				$("#TimeTablesTable tr").eq(ClassTime).find("td").eq(Classfestival).html(data[i].course+" "+data[i].classRoomName); // 将表格第m+1行第n+1列的内容设置为s
			}}
			
		},

		error : function() {
			alert("课程表获取失败！");
		}
	})
}