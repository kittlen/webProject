$(document).ready(table());

function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var Curricula = $("[name=Curricula]").val();
	$
			.ajax({
				url : "TeachTaskMgrServlet?judge=se",
				type : "post",
				dataType : "json",
				data : {
					"Curricula" : Curricula
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
							Thtml += "</td></tr>";
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
							Thtml += "</td></tr>";
						}
					}

					$("#CourseTable").append(Thtml);

				},

				error : function() {
					alert("开课查询失败")
				}
			})
}