$(document).ready(FirstLoadcols());
// 一级下拉列表
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
// 二级下拉列表
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
// 三级下拉列表
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
// 表格数据获取
function table() {
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var id = $("[name=Class_ID]").find("option:selected").val();
	$
			.ajax({
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
							Thtml += "</th><td>";
							Thtml += data[i].stu_ID;
							Thtml += "</td><td>";
							Thtml += data[i].name;
							Thtml += "</td><td>";
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
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"location='StudentMgrServlet?judge=de&Stu_ID=";
							Thtml += data[i].stu_ID;
							Thtml += "'\" >|<input type='button' value='密码重置' onclick=\"location='StudentMgrServlet?judge=Reset&Stu_ID=";
							Thtml += data[i].stu_ID;
							Thtml += "'\" ></td></tr>";
							t++;
							if (t > 3) {
								t = 0;
							}
						} else {
							Thtml += "<tr><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>";
							Thtml += data[i].stu_ID;
							Thtml += "</td><td>";
							Thtml += data[i].name;
							Thtml += "</td><td>";
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
							Thtml += ")' value='修改'>|<input type='button' value='删除' onclick=\"location='StudentMgrServlet?judge=de&Stu_ID=";
							Thtml += data[i].stu_ID;
							Thtml += "'\" >|<input type='button' value='密码重置' onclick=\"location='StudentMgrServlet?judge=Reset&Stu_ID=";
							Thtml += data[i].stu_ID;
							Thtml += "'\" ></td></tr>";
						}
					}

					$("#StudentTable").append(Thtml);

				},

				error : function() {
					alert("班级数据请求失败！");
				}
			})
}
function sctable() {// 已经配置完成的课程
	var Sclass = [ "table-warning", "table-success", "table-danger",
			"table-info" ];
	var CourseID = $("[name=Course]").find("option:selected").val();
	$
			.ajax({
				url : "CourseScheduleMgrServlet?judge=Tse",
				type : "post",
				dataType : "json",
				data : {
					"CourseID" : CourseID
				},
				success : function(data) {
					$("#ScheduleTable").html("");
					var Thtml = "";
					for (var i = 0, t = 0; i < data.length; i++) {
						if (i % 2 == 1) {
							Thtml += "<tr class='" + Sclass[t]
									+ "'><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].course;
							Thtml += "</td><td>";
							Thtml += data[i].classfestival;
							Thtml += "</td><td>";
							Thtml += data[i].classTime;
							Thtml += "</td><td>";
							Thtml += data[i].classRoomName;
							Thtml += "</td><td><input type='button' value='取消本节课' onclick=\"OffSchedule(";
							Thtml += "'" + data[i].scheduleID + "'";// 中文传递异常
																	// 用''包起来处理
							Thtml += ")\"></td></tr>";
							t++;
							if (t > 3) {
								t = 0;
							}
						} else {
							Thtml += "<tr><th scope='row'>";
							Thtml += i + 1;
							Thtml += "</th><td>"
							Thtml += data[i].course;
							Thtml += "</td><td>";
							Thtml += data[i].classfestival;
							Thtml += "</td><td>";
							Thtml += data[i].classTime;
							Thtml += "</td><td>";
							Thtml += data[i].classRoomName;
							Thtml += "</td><td><input type='button' value='取消本节课' onclick=\"OffSchedule(";
							Thtml += "'" + data[i].scheduleID + "'";// 中文传递异常
																	// 用''包起来处理
							Thtml += ")\"></td></tr>";
						}
					}

					$("#ScheduleTable").append(Thtml);

				},

				error : function() {
					alert("课程数据请求失败！");
				}
			})
}
// 表单提交
function conf() {
	if (!confirm("确认添加信息")) {
		return false;
	}
}
// 表格数据提交至输入框
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
// 取消输入框
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
function OnDevelop(index) {// 开课
	var table = document.getElementById("Course");
	var tableID = table.rows[index].cells[1].innerHTML;
	var tableState = table.rows[index].cells[11].innerHTML;
	if (tableState == "未开课") {
		location = 'TeachTaskMgrServlet?judge=in&CourseID=' + tableID
				+ '&State=' + tableState;
	} else {
		alert("您已经开展过本门课");
	}
}
function OffDevelop(index) {// 取消开课
	var table = document.getElementById("Course");
	var tableID = table.rows[index].cells[1].innerHTML;
	var tableState = table.rows[index].cells[11].innerHTML;
	if (tableState == "已开课") {
		location = 'TeachTaskMgrServlet?judge=de&CourseID=' + tableID
				+ '&State=' + tableState;
	} else {
		alert("您尚未开展过本门课");
	}
}
// CKeditor使用
function CKeditor() {
	CKEDITOR
			.replace(
					'NoticeContent',
					{
						filebrowserImageUploadUrl : '/com.qyc.OneProject/NoticeMgrServlet?judge=Upload',// 图片处理对象路径
						image_previewText : '&nbsp',// 图片原预览内容
						width : '100%',
						height : '50%'
					});

}
function inputreset() {
	$("[name=NoticeTitle]").val();
	CKEDITOR.instances.NoticeContent.setData("");// 清理CKeditor为本区内容
													// NoticeContent为文本id
}
$("#TimeTablesTable tr").eq(2).find("td").eq(3).html("s"); // 将表格第m+1行第n+1列的内容设置为s

/* 获取时间差 */
function GetDateTimeDiff(startTime, endTime) {
	var retValue = {};
	var date1 = new Date(startTime); // 开始时间
	var date2 = new Date(endTime); // 结束时间
	var date3 = date2.getTime() - date1.getTime(); // 时间差的毫秒数

	// 计算出相差天数
	var days = Math.floor(date3 / (24 * 3600 * 1000));
	retValue.Days = days;

	var years = Math.floor(days / 365);
	retValue.Years = years;

	var months = Math.floor(days / 30);
	retValue.Months = months;

	// 计算出小时数
	var leave1 = date3 % (24 * 3600 * 1000); // 计算天数后剩余的毫秒数
	var hours = Math.floor(leave1 / (3600 * 1000));
	retValue.Hours = hours;

	// 计算相差分钟数
	var leave2 = leave1 % (3600 * 1000); // 计算小时数后剩余的毫秒数
	var minutes = Math.floor(leave2 / (60 * 1000));
	retValue.Minutes = minutes;

	// 计算相差秒数
	var leave3 = leave2 % (60 * 1000); // 计算分钟数后剩余的毫秒数
	var seconds = Math.round(leave3 / 1000);
	retValue.Seconds = seconds;

	var strTime = "";
	if (years >= 1) {
		strTime = years + "年前";
	} else if (months >= 1) {
		strTime = months + "个月前";
	} else if (days >= 1) {
		strTime = days + "天前";
	} else if (hours >= 1) {
		strTime = hours + "小时前";
	} else {
		strTime = minutes + "分钟前";
	}
	retValue.PubTime = strTime; // 帖子,文章,博客发表时间的一种简短表示方法
	return strTime;
}
// 获取服务器时间
function getNowDate() {
	var xhr = null;
	if (window.XMLHttpRequest) {
		xhr = new window.XMLHttpRequest();
	} else {
		xhr = new ActiveObject("Microsoft")
	}

	xhr.open("GET", "/", false)
	xhr.send(null);
	var date = xhr.getResponseHeader("Date");
	date = new Date(date);
	return date;
}

// 获取当前时间

function getNowFormatDate() {
	var date = new Date();
	var char1 = "-";
	var char2 = ":";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentTime = date.getFullYear() + char1 + month + char1 + strDate
			+ " " + date.getHours() + char2 + date.getMinutes() + char2
			+ date.getSeconds();
	return currentTime;
}