$(document).ready(loadcols());
function loadcols() {
	$.ajax({
		url : "College/CollegeInfo",
		type : "post",
		dataType : "json",
		success : function(data) {
			/* $("[name=CollegeID] option").remove(); */
			for (var i = 0; i < data.length; i++) {
				$("#CollegeID").append(
						"<option value='" + data[i].collegeID + "'>"
								+ data[i].collegeName + "</option>");
			}
			table();
		},
		error : function() {
			alert("分院数据请求失败");
		}
	})
}

function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var id = $("#CollegeID").find("option:selected").val();
	$
			.ajax({
				url : "Department/DepartmentInfo",
				type : "post",
				dataType : "json",
				data : {
					"CollegeID" : id
				},
				success : function(data) {
					$("#DepartmentTable").html("");
					var Thtml = "";
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].departmentID;
							Thtml += "</td><td>"
							Thtml += data[i].departmentName;
							Thtml += "</td><td>";
							Thtml += $("#CollegeID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'" + data[i].departmentID + "\'";
							Thtml += ")\" ></td></tr>";
							t++;
							if (t > 3) {
								t = 0;
							}
						} else {
							Thtml += "<tr><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].departmentID;
							Thtml += "</td><td>"
							Thtml += data[i].departmentName;
							Thtml += "</td><td>";
							Thtml += $("#CollegeID").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'" + data[i].departmentID + "\'";
							Thtml += ")\" ></td></tr>";
						}
					}
					$("#DepartmentTable").append(Thtml);
				},

				error : function() {
					alert("系院数据请求失败！");
				}
			})
}

function conf(DepartmentID) {
	if (confirm("确认删除此条信息?")) {
		location = 'Department/delete?DepartmentID=' + DepartmentID;
	}
}

function update(index) {
	var table = document.getElementById("Department");
	$("[name=DepartmentID]").val(table.rows[index].cells[1].innerHTML);
	$("[name=DepartmentName]").val(table.rows[index].cells[2].innerHTML);
	$("[name=Remark]").val(table.rows[index].cells[4].innerHTML);
	$("[name=DepartmentID]").attr("readOnly", true);
	document.forms.action = "Department/update";
}
function inputreset() {
	$("[name=DepartmentID]").val();
	$("[name=DepartmentName]").val();
	$("[name=Remark]").val();
	$("[name=DepartmentID]").attr("readOnly", false);
	document.forms.action = "Department/insert";
}