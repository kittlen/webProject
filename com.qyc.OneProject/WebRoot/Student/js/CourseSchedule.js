$(document).ready(function(){
	FirstLoadcols();
});
function FirstLoadcols() {
	$.ajax({
		url : "CollegeMgrServlet?judge=se",
		type : "post",
		dataType : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				$("[name=CollegeID]").append(
						"<option value='" + data[i].collegeID + "'>"
								+ data[i].collegeName + "</option>");
			}
			SecondLoadcols();
		},
		error : function() {
			alert("分院数据请求失败");
		}
	})
}
function SecondLoadcols() {
	var id = $("[name=CollegeID]").find("option:selected").val();
	$.ajax({
		url : "DepartmentMgrServlet?judge=se",
		type : "post",
		dataType : "json",
		data : {
			"CollegeID" : id
		},
		success : function(data) {
			$("[name=DepartmentID] option").remove();
			for (var i = 0; i < data.length; i++) {
				$("[name=DepartmentID]").append(
						"<option value='" + data[i].departmentID + "'>"
								+ data[i].departmentName + "</option>");
			}
			ThirdLoadcols();
		},
		error : function() {
			alert("系部数据请求失败");
		}
	})
}
function ThirdLoadcols() {
	var id = $("[name=DepartmentID]").find("option:selected").val();
	$.ajax({
		url : "ProfessionMgrServlet?judge=se",
		type : "post",
		dataType : "json",
		data : {
			"DepartmentID" : id
		},
		success : function(data) {
			$("[name=ProfessionID] option").remove();
			for (var i = 0; i < data.length; i++) {
				$("[name=ProfessionID]").append(
						"<option value='" + data[i].professionID + "'>"
								+ data[i].professionName + "</option>");
			}
			table();
		},
		error : function() {
			alert("专业请求失败");
		}
	})
}

function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var id = $("[name=ProfessionID]").find("option:selected").val();
	$
			.ajax({
				url : "CourseScheduleMgrServlet?judge=se",
				type : "post",
				dataType : "json",
				data : {
					"ProfessionID" : id
				},
				success : function(data) {
					$("#CourseScheduleTable").html("");
					var Thtml = "";
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].course;
							Thtml += "</td><td>"
							Thtml += data[i].name;
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
							Thtml += $("[name=ProfessionID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' value='选择' onclick=\"OnDevelop(";
							Thtml += "'"+data[i].course+"','"+data[i].name+"','"+data[i].scheduleID+"'";//中文传递异常 用''包起来处理
							Thtml += ")\"> </td></tr>"
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
							Thtml += data[i].name;
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
							Thtml += $("[name=ProfessionID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' value='选择' onclick=\"OnDevelop(";
							Thtml += "'"+data[i].course+"','"+data[i].name+"','"+data[i].scheduleID+"'";
							Thtml += ")\"> </td></tr>"
						}
					}

					$("#CourseScheduleTable").append(Thtml);

				},

				error : function() {
					alert("课程数据请求失败！");
				}
			})
}
function OnDevelop(course,name,ScheduleID){//选课
	if(confirm('确认选择'+name+'教师的'+course+'课?')){
		location='CourseScheduleMgrServlet?judge=in&ScheduleID='+ScheduleID;
	}
}
