<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>淘宝商品表json测试11111</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	function getOne() {
		alert(111);
		var url= $("#one").val();
		alert(url);
		$.ajax({
	           	type: "post",
	          	url: url,
	          	dataType: "jsonp",
	          	success:function(data){
	          		alert(data);
	          	}
		});
	}	
	function getAll() {
		alert(000);
		var url= $("#all").val();
		alert(url);
		$.ajax({
	           	type: "post",
	          	url: url,
	          	dataType: "json",
	          	success:function(data){
	          		alert(data);
	          	}
		});
	}	
	</script>
</head>
<body>
	<input  type="button" value="一条数据" onclick="getOne()"/>
	<input type ="button" value="全部数据" onclick="getAll()"> 
	<input type="hidden" id="one" value="${ctx}/sub/pProductTb/get?id=111">
	<input type="hidden" id="all" value="${ctx}/sub/pProductTb/list">
</body>
</html>