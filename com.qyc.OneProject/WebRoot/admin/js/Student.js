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
			FourthLoadcols();
		},
		error : function() {
			alert("专业请求失败");
		}
	})
}

function FourthLoadcols() {
	var id = $("[name=ProfessionID]").find("option:selected").val();
	$.ajax({
		url : "ClassMgrServlet?judge=se",
		type : "post",
		dataType : "json",
		data : {
			"ProfessionID" : id
		},
		success : function(data) {
			$("[name=Class_ID] option").remove();
			for (var i = 0; i < data.length; i++) {
				$("[name=Class_ID]").append(
						"<option value='" + data[i].class_ID + "'>"
						+ data[i].yearName +"级"+ data[i].gradeName + "</option>");
			}
			table();
		},
		error : function() {
			alert("班级请求失败");
		}
	})
}
function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var id = $("[name=Class_ID]").find("option:selected").val();
	$.ajax({
				url : "StudentMgrServlet?judge=se",
				type : "post",
				dataType : "json",
				data : {
					"Class_ID" : id
				},
				success : function(data) {
					$("#StudentTable").html("");
					var Thtml = "";
				
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].stu_ID;
							Thtml += "</td><td>"
							Thtml += data[i].name;
							Thtml += "</td><td>"
							Thtml += data[i].sex;
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
							Thtml += $("[name=Class_ID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].birth;
							Thtml += "</td><td>";
							Thtml += data[i].phone;
							Thtml += "</td><td>";
							Thtml += data[i].family;
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'"+data[i].stu_ID+"\'";
							Thtml += ")\">|<input type='button' value='密码重置' onclick=\"confPwd(";
							Thtml += "\'"+data[i].stu_ID+"\'";
							Thtml += ")\" ></td></tr>";
							t++;
							if (t > 3) {
								t = 0;
							}
						} else {
							Thtml += "<tr><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].stu_ID;
							Thtml += "</td><td>"
							Thtml += data[i].name;
							Thtml += "</td><td>"
							Thtml += data[i].sex;
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
							Thtml += $("[name=Class_ID]").find(
									"option:selected").text();
							Thtml += "</td><td>";
							Thtml += data[i].birth;
							Thtml += "</td><td>";
							Thtml += data[i].phone;
							Thtml += "</td><td>";
							Thtml += data[i].family;
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'"+data[i].stu_ID+"\'";
							Thtml += ")\">|<input type='button' value='密码重置' onclick=\"confPwd(";
							Thtml += "\'"+data[i].stu_ID+"\'";
							Thtml += ")\" ></td></tr>";
						}
					}
					
					$("#StudentTable").append(Thtml);
					
				},

				error : function() {
					alert("班级数据请求失败！");
				}
			})
}
function conf(Stu_ID){
	if(confirm("确认删除此条信息?")){
		location='StudentMgrServlet?judge=de&Stu_ID='+Stu_ID;
	}
}
function confPwd(Stu_ID){
	if(confirm("确认重置本账号密码?")){
		location='StudentMgrServlet?judge=Reset&Stu_ID='+Stu_ID;
	}
}
function update(index) {
	var table = document.getElementById("Student");
	$("[name=Stu_ID]").val(table.rows[index].cells[1].innerHTML);
	$("[name=Name]").val(table.rows[index].cells[2].innerHTML);
	$("[name=Sex]").val(table.rows[index].cells[3].innerHTML);
	$("[name=Birth]").val(table.rows[index].cells[8].innerHTML);
	$("[name=Phone]").val(table.rows[index].cells[9].innerHTML);
	$("[name=Family]").val(table.rows[index].cells[10].innerHTML);
	$("[name=Remark]").val(table.rows[index].cells[11].innerHTML);
	$("[name=judge]").val("up");
	$("[name=Stu_ID]").attr("readOnly", true);
}
function inputreset() {
	$("[name=Stu_ID]").val();
	$("[name=Name]").val();
	$("[name=Sex]").val();
	$("[name=Birth]").val();
	$("[name=Phone]").val();
	$("[name=Family]").val();
	$("[name=Remark]").val();
	$("[name=judge]").val("in");
	$("[name=Stu_ID]").attr("readOnly", false);
	
}