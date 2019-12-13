$(document).ready(table());
function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	$
			.ajax({
				url : "College/CollegeInfo",
				type : "post",
				dataType : "json",
				success : function(data) {
					$("#CollegeTable").html("");
					var Thtml = "";
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].collegeID;
							Thtml += "</td><td>";
							Thtml += data[i].collegeName;
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'" + data[i].collegeID + "\'";
							Thtml += ")\" ></td></tr>";
							t++;
							if (t > 3) {
								t = 0;
							}
						} else {
							Thtml += "<tr><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].collegeID;
							Thtml += "</td><td>";
							Thtml += data[i].collegeName;
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'" + data[i].collegeID + "\'";
							Thtml += ")\" ></td></tr>";
						}
					}
					$("#CollegeTable").append(Thtml);
				},

				error : function() {
					
					
					/*alert("分院数据请求失败！");*/
				}
			})
}

function conf(CollegeID) {
	if (confirm("确认删除此条信息?")) {
		location = 'College/delete?CollegeID=' + CollegeID;
	}
}

function update(index) {
	var table = document.getElementById('College');
	document.getElementsByName("CollegeID")[0].value = table.rows[index].cells[1].innerHTML;
	document.getElementsByName("CollegeName")[0].value = table.rows[index].cells[2].innerHTML;
	document.getElementsByName("Remark")[0].value = table.rows[index].cells[3].innerHTML;
	$("[name=CollegeID]").attr("readOnly", true);
	document.forms.action = "College/update";
}
function inputreset() {
	document.getElementsByName("CollegeID")[0].value = "";
	document.getElementsByName("CollegeName")[0].value = "";
	document.getElementsByName("Remark")[0].value = "";
	$("[name=CollegeID]").attr("readOnly", false);
	document.forms.action = "College/insert";
}