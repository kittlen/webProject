$(document).ready(function(){
	FirstLoadcols();
});

function FirstLoadcols(){
$.ajax({
		url : "TeachTask/ArrangeSelect",
		type : "post",
		dataType : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				$("#Course").append(
						"<option value='" + data[i].courseID + "'>"
								+ data[i].course + "</option>");
			}
			table();
		},
		error : function() {
			alert("所开课程数据请求失败");
		}
	})
	
}

function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var CourseID=$("#Course").find("option:selected").val();
	$.ajax({
				url : "OptCourseSchedule/Tselect",
				type : "post",
				dataType : "json",
				data:{"CourseID":CourseID},
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
							Thtml += "</td><td><input type='button' value='成绩录入/修改' onclick=\"OnSuccess(";
							Thtml += i+1+",'"+data[i].courseScheduleID+"'";//中文传递异常 用''包起来处理
							Thtml += ")\"></td></tr>";
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
							Thtml += "</td><td><input type='button' value='成绩录入/修改' onclick=\"OnSuccess(";
							Thtml += i+1+",'"+data[i].courseScheduleID+"'";//中文传递异常 用''包起来处理
							Thtml += ")\"></td></tr>";
						}
					}

					$("#SuccessTable").append(Thtml);

				},

				error : function() {
					alert("课程数据请求失败！");
				}
			})
}
function conf(){
	if(!confirm("确认录入次成绩?")){
		return false;
	}
}
function OnSuccess(index,CourseScheduleID) {
	var table = document.getElementById("Success");
	$("#StudentName").val(table.rows[index].cells[2].innerHTML);
	$("#Stu_ID").val(table.rows[index].cells[3].innerHTML);
	$("#ScoreOne").val(table.rows[index].cells[7].innerHTML);
	$("#ScoreTwo").val(table.rows[index].cells[8].innerHTML);
	$("#ScoreThree").val(table.rows[index].cells[9].innerHTML);
	$("#CourseScheduleID").val(CourseScheduleID);
	$("#StudentName").attr("readOnly", true);
	$("#Stu_ID").attr("readOnly", true);
}
function inputreset() {
	$("#StudentName]").val();
	$("#Stu_ID]").val();
	$("#ScoreOne]").val();
	$("#ScoreTwo]").val();
	$("#ScoreThree]").val();
	$("#CourseScheduleID]").val();
	$("#StudentName").attr("readOnly", false);
	$("#Stu_ID").attr("readOnly", false);
	
}