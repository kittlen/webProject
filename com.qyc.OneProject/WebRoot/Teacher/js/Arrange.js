$(document).ready(function(){
	FirstLoadcols();
	SecondLoadcols();
});
function FirstLoadcols() {
	var ClassRoomCategory = $("[name=ClassRoomCategory]").find(
			"option:selected").val();
	$.ajax({
		url : "ClassRoomMgrServlet?judge=Nse",
		type : "post",
		dataType : "json",
		data : {
			"ClassRoomCategory" : ClassRoomCategory
		},
		success : function(data) {
			$("[name=ClassRoomName] option").remove();
			for (var i = 0; i < data.length; i++) {
				$("[name=ClassRoomName]").append(
						"<option value='" + data[i].ID + "'>"
								+ data[i].classRoomName + "</option>")
			};
		},
		error : function() {
			alert("教室名称获取失败");
		}
	})
}
function SecondLoadcols(){
	$.ajax({
			url : "TeachTaskMgrServlet?judge=Ase",
			type : "post",
			dataType : "json",
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					$("[name=Course]").append(
							"<option value='" + data[i].courseID + "'>"
									+ data[i].course + "</option>");
				}
				table();
				sctable();
			},
			error : function() {
				alert("所开课程数据请求失败");
			}
		})
	}

function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var Curricula = $("[name=Curricula]").val();
	$.ajax({
		url : "TeachTaskMgrServlet?judge=Ase",
		type : "post",
		dataType : "json",
		success : function(data) {
			$("#ArrangeTable").html("");
			var Thtml = "";
			for (var i = 0, t = 0; i < data.length; i++) {
				if (i % 2 == 1) {
					Thtml += "<tr class='" + Sclass[t] + "'><th scope='row'>";
					Thtml += i + 1;
					Thtml += "</th><td>"
					Thtml += data[i].teachTaskID;
					Thtml += "</td><td>"
					Thtml += data[i].course;
					Thtml += "</td><td>"
					Thtml += data[i].studyTime;
					Thtml += "</td><td>"
					Thtml += data[i].crediy;
					Thtml += "</td><td>"
					Thtml += data[i].curriculumTime;
					Thtml += "</td><td>";
					Thtml += data[i].professionName;
					Thtml += "</td><td><input type='button' value='配置' onclick='update(";
					Thtml += i+1;
					Thtml += ")'>";
					Thtml += "</td></tr>";
					t++;
					if (t > 3) {
						t = 0;
					}
				} else {
					Thtml += "<tr><th scope='row'>";
					Thtml += i + 1;
					Thtml += "</th><td>"
					Thtml += data[i].teachTaskID;
					Thtml += "</td><td>"
					Thtml += data[i].course;
					Thtml += "</td><td>"
					Thtml += data[i].studyTime;
					Thtml += "</td><td>"
					Thtml += data[i].crediy;
					Thtml += "</td><td>"
					Thtml += data[i].curriculumTime;
					Thtml += "</td><td>";
					Thtml += data[i].professionName;
					Thtml += "</td><td><input type='button' value='配置' onclick='update(";
					Thtml += i+1;
					Thtml += ")'>";
					Thtml += "</td></tr>";
				}
			}
			$("#ArrangeTable").append(Thtml);
			FirstLoadcols();
		},

		error : function() {
			alert("课表获取失败！");
		}
	})
}
function sctable() {//已经配置完成的课程
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var CourseID=$("[name=Course]").find("option:selected").val();
	$.ajax({
				url : "CourseScheduleMgrServlet?judge=Tse",
				type : "post",
				dataType : "json",
				data:{"CourseID":CourseID},
				success : function(data) {
					$("#ScheduleTable").html("");
					var Thtml = "";
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].course;
							Thtml += "</td><td>";
							Thtml += data[i].classfestival;
							Thtml += "</td><td>";
							Thtml += data[i].classTime;
							Thtml += "</td><td>";
							Thtml += data[i].classRoomName;
							Thtml += "</td><td><input type='button' value='取消本节课' onclick=\"OffSchedule(";
							Thtml += "'"+data[i].scheduleID+"'";//中文传递异常 用''包起来处理
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
							Thtml += data[i].classfestival;
							Thtml += "</td><td>";
							Thtml += data[i].classTime;
							Thtml += "</td><td>";
							Thtml += data[i].classRoomName;
							Thtml += "</td><td><input type='button' value='取消本节课' onclick=\"OffSchedule(";
							Thtml += "'"+data[i].scheduleID+"'";//中文传递异常 用''包起来处理
							Thtml += ")\"></td></tr>";
						}
					}

					$("#ScheduleTable").append(Thtml);

				},

				error : function() {
					alert("课程数据请求失败！");
				}
			})
}
function conf(){
	if(!confirm("确认配置当前课表?")){
		return false;
	}
}
function OffSchedule(ScheduleID){
	if(confirm("确认取消本节课")){
		location='CourseScheduleMgrServlet?judge=de&ScheduleID='+ScheduleID;
	}
	
}
function update(index) {
	var table = document.getElementById("Arrange");
	$("[name=TeachTaskID]").val(table.rows[index].cells[1].innerHTML);
	$("[name=TeachTaskID]").attr("readOnly", true);
}
function inputreset() {
	$("[name=TeachTaskID]").val();
	$("[name=TeachTaskID]").attr("readOnly", false);
	
}