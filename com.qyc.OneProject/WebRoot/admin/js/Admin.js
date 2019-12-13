$(document).ready(table());
	function table() {
		var Sclass = [ "table-warning", "table-success", "table-danger",
				"table-info" ];
		$.ajax({
					url : "AdminMgrServlet?judge=se",
					type : "post",
					dataType : "json",
					success : function(data) {
						$("#AdminTable").html("");
						var Thtml = "";
						for (var i = 0, t = 0; i < data.length; i++) {
							if (i % 2 == 1) {
								Thtml += "<tr class='" + Sclass[t]
										+ "'><th scope='row'>";
								Thtml+=i+1;
								Thtml += "</th><td>"
								Thtml += data[i].adminID;
								Thtml += "</td><td>";
								Thtml += data[i].adminName;
								Thtml += "</td><td>";
								Thtml += data[i].power;
								Thtml += "</td><td>";
								Thtml += data[i].remark;
								Thtml += "</td><td><input type='button' onclick='update(";
								Thtml += i + 1;
								Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
								Thtml += "\'"+data[i].adminID+"\'";
								Thtml += ")\">|<input type='button' value='密码重置' onclick=\"confPwd(";
								Thtml += "\'"+data[i].adminID+"\'";
								Thtml += ")\" ></td></tr>";
								t++;
								if (t > 3) {
									t = 0;
								}
							}else{
								Thtml += "<tr><th scope='row'>";
								Thtml+=i+1;
								Thtml += "</th><td>"
								Thtml += data[i].adminID;
								Thtml += "</td><td>";
								Thtml += data[i].adminName;
								Thtml += "</td><td>";
								Thtml += data[i].power;
								Thtml += "</td><td>";
								Thtml += data[i].remark;
								Thtml += "</td><td><input type='button' onclick='update(";
								Thtml += i + 1;
								Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"conf(";
								Thtml += "\'"+data[i].adminID+"\'";
								Thtml += ")\">|<input type='button' value='密码重置' onclick=\"confPwd(";
								Thtml += "\'"+data[i].adminID+"\'";
								Thtml += ")\" ></td></tr>";
							}
						}
						$("#AdminTable").append(Thtml);
					},

					error:function(){
						alert("分院数据请求失败！");
					}
				}) 
	}

	function conf(AdminID){
		if(confirm("确认删除此条信息?")){
			location='AdminMgrServlet?judge=de&AdminID='+AdminID;
		}
	}
	function confPwd(AdminID){
		if(confirm("确认重置本账号密码?")){
			location='AdminMgrServlet?judge=Reset&AdminID='+AdminID;
		}
	}
	
	function update(index) {
		var table = document.getElementById("Admin");
		$("[name=AdminID]").val(table.rows[index].cells[1].innerHTML);
		$("[name=AdminName]").val(table.rows[index].cells[2].innerHTML);
		$("[name=power]").val(table.rows[index].cells[3].innerHTML);
		$("[name=Remark]").val(table.rows[index].cells[4].innerHTML);
		$("[name=judge]").val("up");
		$("[name=AdminID]").attr("readOnly", true);
	}
	function inputreset() {
		$("[name=AdminID]").val();
		$("[name=AdminName]").val();
		$("[name=power]").val();
		$("[name=Remark]").val();
		$("[name=judge]").val("in");
		$("[name=AdminID]").attr("readOnly", false);
		
	}