$(document).ready(table());

function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var Curricula = $("#Curricula").find("option:selected").val();
	$
			.ajax({
				url : "Audit/AuditInfo",
				type : "post",
				dataType : "json",
				data : {
					"Curricula" : Curricula
				},
				success : function(data) {
					$("#AuditTable").html("");
					var Thtml = "";
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].course;
							Thtml += "</td><td>"
							Thtml += data[i].professionName;
							Thtml += "</td><td>"
							Thtml += data[i].studyTime;
							Thtml += "</td><td>"
							Thtml += data[i].crediy;
							Thtml += "</td><td>"
							Thtml += data[i].curriculumTime;
							Thtml += "</td><td>";
							Thtml += data[i].name;
							Thtml += "</td><td>";
							Thtml += data[i].curricula;
							Thtml += "</td><td>";
							Thtml += data[i].auditing;
							Thtml += "</td><td>";
							Thtml += "<select id='Auditing"
							Thtml +=(i+1)+"'>";
							Thtml +="<option value='审核通过'>审核通过</option>";
							Thtml +="<option value='审核未通过'>审核未通过</option>";
							Thtml += "</select></td><td><input type='button' onclick='conf(";
							Thtml += (i + 1)+","+data[i].teachTaskID;
							Thtml += ")' value='修改'></td></tr>";
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
							Thtml += data[i].professionName;
							Thtml += "</td><td>"
							Thtml += data[i].studyTime;
							Thtml += "</td><td>"
							Thtml += data[i].crediy;
							Thtml += "</td><td>"
							Thtml += data[i].curriculumTime;
							Thtml += "</td><td>";
							Thtml += data[i].name;
							Thtml += "</td><td>";
							Thtml += data[i].curricula;
							Thtml += "</td><td>";
							Thtml += data[i].auditing;
							Thtml += "</td><td>";
							Thtml += "<select id='Auditing"
							Thtml +=(i+1)+"'>";
							Thtml +="<option value='审核通过'>审核通过</option>";
							Thtml +="<option value='审核未通过'>审核未通过</option>";
							Thtml += "</select></td><td><input type='button' onclick='conf(";
							Thtml += (i + 1)+","+data[i].teachTaskID;
							Thtml += ")' value='修改'></td></tr>";
						}
					}

					$("#AuditTable").append(Thtml);

				},

				error : function() {
					alert("课程审核获取失败")
				}
			})
}
function conf(index,TeachTaskID){
	var s='#Auditing'+index;
	var d=$(s).val();
	if(confirm("确认修改状态为:"+d)){
		location='Audit/update?ID='+TeachTaskID+'&Auditing='+d;
	}
}