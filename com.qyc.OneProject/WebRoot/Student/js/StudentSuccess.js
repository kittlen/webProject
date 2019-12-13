$(document).ready(function(){
	table();
});

function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var CourseID=$("[name=Course]").find("option:selected").val();
	$.ajax({
				url : "VOptCourseScheduleMgrServlet?judge=Sse",
				type : "post",
				dataType : "json",
				success : function(data) {
					$("#SuccessTable").html("");
					var Thtml = "";
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].course;
							Thtml += "</td><td>";
							Thtml += data[i].studentName;
							Thtml += "</td><td>";
							Thtml += data[i].stu_ID;
							Thtml += "</td><td>";
							Thtml += data[i].classfestival;
							Thtml += "</td><td>";
							Thtml += data[i].classTime;
							Thtml += "</td><td>";
							Thtml += data[i].classRoomName;
							Thtml += "</td><td>";
							Thtml += data[i].scoreOne;
							Thtml += "</td><td>";
							Thtml += data[i].scoreTwo;
							Thtml += "</td><td>";
							Thtml += data[i].scoreThree;
							Thtml += "</td><td>";
							Thtml += data[i].totalScore;
							Thtml += "</td></tr>";
							t++;
							if (t > 3) {
								t = 0;
							}
						} else {
							Thtml += "<tr><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].course;
							Thtml += "</td><td>";
							Thtml += data[i].studentName;
							Thtml += "</td><td>";
							Thtml += data[i].stu_ID;
							Thtml += "</td><td>";
							Thtml += data[i].classfestival;
							Thtml += "</td><td>";
							Thtml += data[i].classTime;
							Thtml += "</td><td>";
							Thtml += data[i].classRoomName;
							Thtml += "</td><td>";
							Thtml += data[i].scoreOne;
							Thtml += "</td><td>";
							Thtml += data[i].scoreTwo;
							Thtml += "</td><td>";
							Thtml += data[i].scoreThree;
							Thtml += "</td><td>";
							Thtml += data[i].totalScore;
							Thtml += "</td></tr>";
						}
					}

					$("#SuccessTable").append(Thtml);

				},

				error : function() {
					alert("课程数据请求失败！");
				}
			})
}
