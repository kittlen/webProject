$(document).ready(FirstLoadcols());
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
				url : "CourseMgrServlet?judge=Tse",
				type : "post",
				dataType : "json",
				data : {
					"ProfessionID" : id
				},
				success : function(data) {
					$("#CourseTable").html("");
					var Thtml = "";
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].courseID;
							Thtml += "</td><td>"
							Thtml += data[i].course;
							Thtml += "</td><td>"
							Thtml += data[i].studyTime;
							Thtml += "</td><td>"
							Thtml += data[i].crediy;
							Thtml += "</td><td>"
							Thtml += data[i].curriculumTime;
							Thtml += "</td><td>";
							Thtml += $("[name=CollegeID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("[name=DepartmentID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("[name=ProfessionID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' value='开课' onclick='OnDevelop(";
							Thtml += i+1;
							Thtml += ")'>|<input type='button' value='取消' onclick='OffDevelop(";
							Thtml += i+1;
							Thtml += ")'> </td><td>"
							Thtml += data[i].state 
							Thtml += "</td></tr>";
							t++;
							if (t > 3) {
								t = 0;
							}
						} else {
							Thtml += "<tr><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].courseID;
							Thtml += "</td><td>"
							Thtml += data[i].course;
							Thtml += "</td><td>"
							Thtml += data[i].studyTime;
							Thtml += "</td><td>"
							Thtml += data[i].crediy;
							Thtml += "</td><td>"
							Thtml += data[i].curriculumTime;
							Thtml += "</td><td>";
							Thtml += $("[name=CollegeID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("[name=DepartmentID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("[name=ProfessionID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' value='开课' onclick='OnDevelop(";
							Thtml += i+1;
							Thtml += ")'>|<input type='button' value='取消' onclick='OffDevelop(";
							Thtml += i+1;
							Thtml += ")'> </td><td>"
							Thtml += data[i].state 
							Thtml += "</td></tr>";
						}
					}

					$("#CourseTable").append(Thtml);

				},

				error : function() {
					alert("课程数据请求失败！");
				}
			})
}
function OnDevelop(index){//开课
	var table=document.getElementById("Course");
	var tableID=table.rows[index].cells[1].innerHTML;
	var tableState=table.rows[index].cells[11].innerHTML;
	if(tableState=="未开课"){
		location='TeachTaskMgrServlet?judge=in&CourseID='+tableID+'&State='+tableState;
	}else{
		alert("您已经开展过本门课");
	}
}
function OffDevelop(index){//取消开课
	var table=document.getElementById("Course");
	var tableID=table.rows[index].cells[1].innerHTML;
	var tableState=table.rows[index].cells[11].innerHTML;
	if(tableState=="已开课"){
		location='TeachTaskMgrServlet?judge=de&CourseID='+tableID+'&State='+tableState;
	}else{
		alert("您尚未开展过本门课");
	}
}