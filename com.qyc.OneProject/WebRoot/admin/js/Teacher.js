$(document).ready(loadcols());
	function loadcols(){
		$.ajax({
			url:"CollegeMgrServlet?judge=se",
			type:"post",
			dataType:"json",
			success:function(data){
				/*$("[name=CollegeID] option").remove();*/
				for(var i=0;i<data.length;i++){
					$("[name=CollegeID]").append("<option value='"+data[i].collegeID+"'>"+data[i].collegeName+"</option>");
				}
				table();
			},
			error:function(){
				alert("分院数据请求失败");
			}
		})
	}
	
	function table() {
		var Sclass = [ "table-warning", "table-success", "table-danger",
				"table-info" ];
		var id=$("[name=CollegeID]").find("option:selected").val();
		$.ajax({
					url : "TeacherMgrServlet?judge=se",
					type : "post",
					dataType : "json",
					data:{"CollegeID":id},
					success : function(data) {
						$("#TeacherTable").html("");
						var Thtml = "";
						for (var i = 0, t = 0; i < data.length; i++) {
							if (i % 2 == 1) {
								Thtml += "<tr class='" + Sclass[t]
										+ "'><th scope='row'>";
								Thtml+=i+1;
								Thtml += "</th><td>"
								Thtml += data[i].teacherID;
								Thtml += "</td><td>"
								Thtml += data[i].name;
								Thtml += "</td><td>";
								Thtml += $("[name=CollegeID]").find("option:selected").text();
								Thtml += "</td><td>";
								Thtml += data[i].sex;
								Thtml += "</td><td>";
								Thtml += data[i].birthday;
								Thtml += "</td><td>";
								Thtml += data[i].kulture;
								Thtml += "</td><td>";
								Thtml += data[i].home;
								Thtml += "</td><td>";
								Thtml += data[i].phone;
								Thtml += "</td><td>";
								Thtml += data[i].remark;
								Thtml += "</td><td><input type='button' onclick='update(";
								Thtml += i + 1;
								Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
								Thtml += "\'"+data[i].teacherID+"\'";
								Thtml += ")\">|<input type='button' value='密码重置' onclick=\"confPwd(";
								Thtml += "\'"+data[i].teacherID+"\'";
								Thtml += ")\" ></td></tr>";
								t++;
								if (t > 3) {
									t = 0;
								}
							}else{
								Thtml += "<tr><th scope='row'>";
								Thtml+=i+1;
								Thtml += "</th><td>"
								Thtml += data[i].teacherID;
								Thtml += "</td><td>"
								Thtml += data[i].name;
								Thtml += "</td><td>";
								Thtml += $("[name=CollegeID]").find("option:selected").text();
								Thtml += "</td><td>";
								Thtml += data[i].sex;
								Thtml += "</td><td>";
								Thtml += data[i].birthday;
								Thtml += "</td><td>";
								Thtml += data[i].kulture;
								Thtml += "</td><td>";
								Thtml += data[i].home;
								Thtml += "</td><td>";
								Thtml += data[i].phone;
								Thtml += "</td><td>";
								Thtml += data[i].remark;
								Thtml += "</td><td><input type='button' onclick='update(";
								Thtml += i + 1;
								Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
								Thtml += "\'"+data[i].teacherID+"\'";
								Thtml += ")\">|<input type='button' value='密码重置' onclick=\"confPwd(";
								Thtml += "\'"+data[i].teacherID+"\'";
								Thtml += ")\" ></td></tr>";
							}
						}
						$("#TeacherTable").append(Thtml);
					},

					error:function(){
						alert("系院数据请求失败！");
					}
				}) 
	}
	
	function conf(TeacherID){
		if(confirm("确认删除此条信息?")){
			location='TeacherMgrServlet?judge=de&TeacherID='+TeacherID;
		}
	}
	function confPwd(TeacherID){
		if(confirm("确认重置本账号密码?")){
			location='TeacherMgrServlet?judge=Reset&TeacherID='+TeacherID;
		}
	}
	
	function update(index) {
			var table= document.getElementById("Teacher");
			$("[name=TeacherID]").val(table.rows[index].cells[1].innerHTML);
			$("[name=Name]").val(table.rows[index].cells[2].innerHTML);
			$("[name=Sex]").val(table.rows[index].cells[4].innerHTML);
			$("[name=Birthday]").val(table.rows[index].cells[5].innerHTML);
			$("[name=Kulture]").val(table.rows[index].cells[6].innerHTML);
			$("[name=Home]").val(table.rows[index].cells[7].innerHTML);
			$("[name=Remark]").val(table.rows[index].cells[8].innerHTML);
			$("[name=judge]").val("up");
			$("[name=TeacherID]").attr("readOnly",true);
		}
	function inputreset() {
			$("[name=TeacherID]").val();
			$("[name=Name]").val();
			$("[name=Sex]").val();
			$("[name=Birthday]").val();
			$("[name=Kulture]").val();
			$("[name=Home]").val();
			$("[name=Remark]").val();
			$("[name=judge]").val("in");
			$("[name=TeacherID]").attr("readOnly", false);
			}