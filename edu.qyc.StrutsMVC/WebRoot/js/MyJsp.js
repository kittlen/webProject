$(document).ready(function(){
	table();
});
function table(){
	$.ajax({
		url:"select",
		data:"post",
		dataType:"json",
		success:function(data){
			$("#MyTable tbody").html();
			var Thtml="";
			for (var i = 0; i < data.length; i++) {
				Thtml+="<tr><th>" +data[i].name+"</th>";
				Thtml+="<td>"+data[i].password+"</td>";
				Thtml+="<td>"+data[i].remark+"</td></tr>";
			}
			$("#MyTable tbody").html(Thtml);
			table2();
		},
		error:function(){
			alert("表1获取失败")
		}
		
	})
}
function table2(){
	$.ajax({
		url:"select2",
		data:"post",
		dataType:"json",
		success:function(data){
			$("#MyTable2 tbody").html();
			var Thtml="";
			for (var i = 0; i < data.jsonString.length; i++) {
				Thtml+="<tr><th>" +data.jsonString[i].name+"</th>";
				Thtml+="<td>"+data.jsonString[i].password+"</td>";
				Thtml+="<td>"+data.jsonString[i].remark+"</td></tr>";
			}
			$("#MyTable2 tbody").html(Thtml);
		},
		error:function(){
			alert("表2获取失败")
		}
		
	})
}