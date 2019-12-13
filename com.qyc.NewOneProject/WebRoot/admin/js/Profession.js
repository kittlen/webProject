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
			table()
		},
		error : function() {
			alert("系部数据请求失败");
		}
	})
}

function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var id = $("#DepartmentID").find("option:selected").val();
	$.ajax({
				url : "Profession/ProfessionInfo",
				type : "post",
				dataType : "json",
				data : {
					"DepartmentID" : id
				},
				success : function(data) {
					$("#ProfessionTable").html("");
					var Thtml = "";
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].professionID;
							Thtml += "</td><td>"
							Thtml += data[i].professionName;
							Thtml += "</td><td>";
							Thtml += $("#CollegeID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("#DepartmentID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'"+data[i].professionID+"\'";
							Thtml += ")\" ></td></tr>";
							t++;
							if (t > 3) {
								t = 0;
							}
						} else {
							Thtml += "<tr><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].professionID;
							Thtml += "</td><td>"
							Thtml += data[i].professionName;
							Thtml += "</td><td>";
							Thtml += $("#CollegeID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("#DepartmentID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'"+data[i].professionID+"\'";
							Thtml += ")\" ></td></tr>";
						}
					}
					$("#ProfessionTable").append(Thtml);
					
				},

				error : function() {
					alert("专业数据请求失败！");
				}
			})
}

function conf(ProfessionID){
	if(confirm("确认删除此条信息?")){
		location='Profession/delete?ProfessionID='+ProfessionID;
	}
}

function update(index) {
	var table = document.getElementById("Profession");
	$("[name=ProfessionID]").val(table.rows[index].cells[1].innerHTML);
	$("[name=ProfessionName]").val(table.rows[index].cells[2].innerHTML);
	$("[name=Remark]").val(table.rows[index].cells[5].innerHTML);
	$("[name=ProfessionID]").attr("readOnly", true);
	document.forms.action = "Profession/update";
}
function inputreset() {
	$("[name=ProfessionID]").val();
	$("[name=ProfessionName]").val();
	$("[name=Remark]").val();
	$("[name=ProfessionID]").attr("readOnly", false);
	document.forms.action = "Profession/insert";
	
}