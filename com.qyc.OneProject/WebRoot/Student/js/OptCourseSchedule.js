$(document).ready(table());

function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	$.ajax({
				url : "VOptCourseScheduleMgrServlet?judge=se",
				type : "post",
				dataType : "json",
				success : function(data) {
					$("#OptCourseScheduleTable").html("");
					var Thtml = "";
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].course;
							Thtml += "</td><td>"
							Thtml += data[i].teacherName;
							Thtml += "</td><td>"
							Thtml += data[i].classfestival;
							Thtml += "</td><td>"
							Thtml += data[i].classTime;
							Thtml += "</td><td>"
							Thtml += data[i].classRoomName;
							Thtml += "</td><td>";
							Thtml += data[i].studyTime;
							Thtml += "</td><td>"
							Thtml += data[i].crediy;
							Thtml += "</td><td>"
							Thtml += data[i].curriculumTime;
							Thtml += "</td><td>";
							Thtml += data[i].professionName
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' value='取消本门课' onclick=\"OffDevelop(";
							Thtml += "'"+data[i].course+"','"+data[i].teacherName+"','"+data[i].courseScheduleID+"'";//中文传递异常 用''包起来处理
							Thtml += ")\"> </td></tr>";
							t++;
							if (t > 3) {
								t = 0;
							}
						} else {
							Thtml += "<tr><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].course;
							Thtml += "</td><td>"
							Thtml += data[i].teacherName;
							Thtml += "</td><td>"
							Thtml += data[i].classfestival;
							Thtml += "</td><td>"
							Thtml += data[i].classTime;
							Thtml += "</td><td>"
							Thtml += data[i].classRoomName;
							Thtml += "</td><td>";
							Thtml += data[i].studyTime;
							Thtml += "</td><td>"
							Thtml += data[i].crediy;
							Thtml += "</td><td>"
							Thtml += data[i].curriculumTime;
							Thtml += "</td><td>";
							Thtml += data[i].professionName
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' value='取消本门课' onclick=\"OffDevelop(";
							Thtml += "'"+data[i].course+"','"+data[i].teacherName+"','"+data[i].courseScheduleID+"'";//中文传递异常 用''包起来处理
							Thtml += ")\"> </td></tr>";
						}
					}

					$("#OptCourseScheduleTable").append(Thtml);

				},

				error : function() {
					alert("课程数据请求失败！");
				}
			})
}
function OffDevelop(course,teacherName,CourseScheduleID){//选课
	if(confirm('确认取消'+teacherName+'教师的'+course+'课?')){
		location='VOptCourseScheduleMgrServlet?judge=de&CourseScheduleID='+CourseScheduleID;
	}
}
