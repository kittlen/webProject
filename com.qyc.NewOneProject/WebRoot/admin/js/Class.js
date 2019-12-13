$(document).ready(FirstLoadcols());
function FirstLoadcols() {
	$.ajax({
		url : "College/CollegeInfo",
		type : "post",
		dataType : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				$("#CollegeID").append(
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
	var id = $("#CollegeID").find("option:selected").val();
	$.ajax({
		url : "Department/DepartmentInfo",
		type : "post",
		dataType : "json",
		data : {
			"CollegeID" : id
		},
		success : function(data) {
			$("#DepartmentID option").remove();
			for (var i = 0; i < data.length; i++) {
				$("#DepartmentID").append(
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
	var id = $("#DepartmentID").find("option:selected").val();
	$.ajax({
		url : "Profession/ProfessionInfo",
		type : "post",
		dataType : "json",
		data : {
			"DepartmentID" : id
		},
		success : function(data) {
			$("#ProfessionID option").remove();
			for (var i = 0; i < data.length; i++) {
				$("#ProfessionID").append(
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
	var id = $("#ProfessionID").find("option:selected").val();
	$.ajax({
				url : "Class/ClassInfo",
				type : "post",
				dataType : "json",
				data : {
					"ProfessionID" : id
				},
				success : function(data) {
					$("#ClassTable").html("");
					var Thtml = "";
					
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].class_ID;
							Thtml += "</td><td>"
							Thtml += data[i].yearName;
							Thtml += "</td><td>"
							Thtml += data[i].gradeName;
							Thtml += "</td><td>";
							Thtml += $("#CollegeID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("#DepartmentID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("#ProfessionID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'"+data[i].class_ID+"\'";
							Thtml += ")\" ></td></tr>";
							t++;
							if (t > 3) {
								t = 0;
							}
						} else {
							Thtml += "<tr><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].class_ID;
							Thtml += "</td><td>"
							Thtml += data[i].yearName;
							Thtml += "</td><td>"
							Thtml += data[i].gradeName;
							Thtml += "</td><td>";
							Thtml += $("#CollegeID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("#DepartmentID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("#ProfessionID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'"+data[i].class_ID+"\'";
							Thtml += ")\" ></td></tr>";
						}
					}
					
					$("#ClassTable").append(Thtml);
					
				},

				error : function() {
					alert("班级数据请求失败！");
				}
			})
}

function conf(Class_ID){
	if(confirm("确认删除此条信息?")){
		location='Class/delete?Class_ID='+Class_ID;
	}
}

function update(index) {
	var table = document.getElementById("Class");
	$("[name=Class_ID]").val(table.rows[index].cells[1].innerHTML);
	$("[name=YearName]").val(table.rows[index].cells[2].innerHTML);
	$("[name=GradeName]").val(table.rows[index].cells[3].innerHTML);
	$("[name=Remark]").val(table.rows[index].cells[7].innerHTML);
	$("[name=Class_ID]").attr("readOnly", true);
	document.forms.action = "Class/update";
}
function inputreset() {
	$("[name=Class_ID]").val();
	$("[name=YearName]").val();
	$("[name=GradeName]").val();
	$("[name=Remark]").val();
	$("[name=Class_ID]").attr("readOnly", false);
	document.forms.action = "Class/insert";
	
}