$(document).ready(table());
function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	$
			.ajax({
				url : "ClassRoom/ClassRoomInfo",
				type : "post",
				dataType : "json",
				success : function(data) {
					$("#ClassRoomTable").html("");
					var Thtml = "";
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].ID;
							Thtml += "</td><td>";
							Thtml += data[i].classRoomName;
							Thtml += "</td><td>";
							Thtml += data[i].classRoomCategory;
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'"+data[i].ID+"\'";
							Thtml += ")\" ></td></tr>";
							t++;
							if (t > 3) {
								t = 0;
							}
						} else {
							Thtml += "<tr><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].ID;
							Thtml += "</td><td>";
							Thtml += data[i].classRoomName;
							Thtml += "</td><td>";
							Thtml += data[i].classRoomCategory;
							Thtml += "</td><td>";
							Thtml += data[i].remark;
							Thtml += "</td><td><input type='button' onclick='update(";
							Thtml += i + 1;
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
							Thtml += "\'"+data[i].ID+"\'";
							Thtml += ")\" ></td></tr>";
						}
					}
					$("#ClassRoomTable").append(Thtml);
				},

				error : function() {
					alert("分院数据请求失败！");
				}
			})
}

function conf(ID){
	if(confirm("确认删除此条信息?")){
		location='ClassRoom/delete?ID='+ID;
	}
}

function update(index) {
	var table = document.getElementById('ClassRoom');
	$("[name=ID]").val(table.rows[index].cells[1].innerHTML);
	$("[name=ClassRoomName]").val(table.rows[index].cells[2].innerHTML);
	$("[name=ClassRoomCategory]").val(table.rows[index].cells[3].innerHTML);
	$("[name=Remark]").val(table.rows[index].cells[4].innerHTML);
	$("[name=ID]").attr("readOnly", true);
	document.forms.action="ClassRoom/update";		
}
function inputreset() {
	$("[name=ID]").val();
	$("[name=ClassRoomName]").val();
	$("[name=ClassRoomCategory]").val();
	$("[name=Remark]").val();
	$("[name=ID]").attr("readOnly", false);
	document.forms.action="ClassRoom/insert";	
}