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
	var id = $("[name=DepartmentID]").find("option:selected").val();
	$.ajax({
				url : "ProfessionMgrServlet?judge=se",
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
							Thtml += $("[name=CollegeID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("[name=DepartmentID]").find(
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
							Thtml += $("[name=CollegeID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += $("[name=DepartmentID]").find(
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
		location='ProfessionMgrServlet?judge=de&ProfessionID='+ProfessionID;
	}
}

function update(index) {
	var table = document.getElementById("Profession");
	$("[name=ProfessionID]").val(table.rows[index].cells[1].innerHTML);
	$("[name=ProfessionName]").val(table.rows[index].cells[2].innerHTML);
	$("[name=Remark]").val(table.rows[index].cells[5].innerHTML);
	$("[name=judge]").val("up");
	$("[name=ProfessionID]").attr("readOnly", true);
}
function inputreset() {
	$("[name=ProfessionID]").val();
	$("[name=ProfessionName]").val();
	$("[name=Remark]").val();
	$("[name=judge]").val("in");
	$("[name=ProfessionID]").attr("readOnly", false);
	
}