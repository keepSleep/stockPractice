<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="${pageContext.request.contextPath}/css/base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/jquery.dataTables.min.css"
	rel="stylesheet">
<link
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<body>
	<table class="table table-bordered">
		<tr>
			<td>
				<div class="col-md-12">
					<fieldset class="fieldsetbase">
						<legend>查詢結果(利用el)</legend>
						<table id="table" class="table table-bordered">
							<tbody>
								<c:forEach var="stock" items="${tablelist}">
									<tr>
										<td>${stock.id}</td>
										<td>${stock.name}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</fieldset>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div class="col-md-12">
					<fieldset class="fieldsetbase">
						<legend>查詢結果(利用dataTable內建)</legend>
						<table id="table1" class="table table-bordered">
						</table>
					</fieldset>
				</div>
			</td>
		</tr>
	</table>




	<script>
		//中文化的註解
		var opt = {
			"oLanguage" : {
				"sProcessing" : "處理中...",
				"sLengthMenu" : "顯示 _MENU_ 項結果",
				"sZeroRecords" : "沒有匹配結果",
				"sInfo" : "顯示第 _START_ 至 _END_ 項結果，共 _TOTAL_ 項",
				"sInfoEmpty" : "顯示第 0 至 0 項結果，共 0 項",
				"sInfoFiltered" : "(從 _MAX_ 項結果過濾)",
				"sSearch" : "搜索:",
				"oPaginate" : {
					"sFirst" : "首頁",
					"sPrevious" : "上頁",
					"sNext" : "下頁",
					"sLast" : "尾頁"
				}
			},
			"aoColumns" : [ {
				"sTitle" : "股票號碼"
			}, {
				"sTitle" : "股票名稱"
			} ],
			"bPaginate" : true, //翻頁功能	
			"bLengthChange" : true, //改變每頁顯示數據數量
			"bAutoWidth" : true,//自動寬度
			"bFilter" : true, //過濾功能
			"bSort" : true, //排序功能
			"bInfo" : true,//頁腳信息
			"bDestroy" : false,
		};

		$(document).ready(function() {
			$("#table").dataTable(opt);

			$("#table1").dataTable({
				"oLanguage" : {
					"sProcessing" : "處理中...",
					"sLengthMenu" : "顯示 _MENU_ 項結果",
					"sZeroRecords" : "沒有匹配結果",
					"sInfo" : "顯示第 _START_ 至 _END_ 項結果，共 _TOTAL_ 項",
					"sInfoEmpty" : "顯示第 0 至 0 項結果，共 0 項",
					"sInfoFiltered" : "(從 _MAX_ 項結果過濾)",
					"sSearch" : "搜索:",
					"oPaginate" : {
						"sFirst" : "首頁",
						"sPrevious" : "上頁",
						"sNext" : "下頁",
						"sLast" : "尾頁"
					}
				},
				"bPaginate" : true, //翻頁功能
				"bLengthChange" : true, //改變每頁顯示數據數量
				"bProcessing" : true,
				"sAjaxSource" : "json",//url
				"fnServerData" : function(sSource, aoData, fnCallback) {
					$.ajax({
						"dataType" : "json",
						"type" : "POST",
						"url" : sSource,
						"data" : aoData,
						"success" : fnCallback
					})
				},
				aoColumns : [ {
					"sTitle" : "股票號碼",
					"mData" : "id"
				}, {
					"sTitle" : "股票名稱",
					"mData" : "name"
				} ]
			})

			//   $.getJSON( "json", function( data ) {
			//   var items = [];
			//   $.each( data, function( key, val ) {
			//    console.log(val)
			//   });  
			//   });  

		});
	</script>
</body>
</html>