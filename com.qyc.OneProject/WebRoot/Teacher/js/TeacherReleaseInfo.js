$(document).ready(function(){
	table();
})
function table(){
	var Sclass = [ "table-warning", "table-success", "table-danger",
	   			"table-info" ];
	$.ajax({
		url:"NoticeMgrServlet?judge=se",
		type:"post",
		dataType:"json",
		success:function(data){
			$("#noticetable").html("");
			var Thtml="";
			for (var i = 0, t = 0; i < data.length; i++) {
				if (i % 2 == 1) {
					Thtml += "<tr class='" + Sclass[t]
							+ "'><th scope='row'>";
					Thtml += i + 1;
					Thtml += "</th><td>";
					Thtml += "<a href='NoticeMgrServlet?judge=Nse&user=T&ID="
					Thtml += data[i].ID;
					Thtml += "'>";
					Thtml += data[i].noticeTitle;
					Thtml += "</a></td><td>";
					Thtml += data[i].releaseTime;
					Thtml += "</td></tr>";
					t++;
					if (t > 3) {
						t = 0;
					}
				} else {
					Thtml += "<tr><th scope='row'>";
					Thtml += i + 1;
					Thtml += "</th><td>";
					Thtml += "<a href='NoticeMgrServlet?judge=Nse&user=T&ID="
					Thtml += data[i].ID;
					Thtml += "'>";
					Thtml += data[i].noticeTitle;
					Thtml += "</a></td><td>";
					Thtml += data[i].releaseTime;
					Thtml += "</td></tr>";
					t++;
				}
			}
			$("#noticetable").append(Thtml);
		},
		error:function(){
			alert("公告获取失败");
		}
	})
}