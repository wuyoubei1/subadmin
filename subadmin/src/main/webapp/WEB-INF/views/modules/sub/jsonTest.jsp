<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>json测试类</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	
	function tableOne(){
		var path=$("#path").val();
		$.ajax({
			type:"post",
			dataType:"json",
			url:path+"/sub/pProductTb/f_getTableOne?id=1",
			success:function(data){
			//	var dataObj=eval("("+data+")");//转换为json对象
				alert(data.id);
			}
		});
	}
	function tableAll(){
		var path=$("#path").val();
		$.ajax({
			type:"post",
			dataType:"json",
			url:path+"/sub/pProductTb/f_getTableAll",
			success:function(data){
				alert(data[0].id);
			}
		});
	}
	function apiOne(url){
		$.ajax({
			type:"post",
			dataType:"json",
			url:url,
			success:function(data){
				alert(data);
			}
		});
	}
	function apiAll(url){
		$.ajax({
			type:"post",
			dataType:"json",
			url:url,
			success:function(data){
				alert(data);
			}
		});
	}
</script>
</head>
<body>
	<input type="hidden" value="${ctx}" id="path"/>
	<input type="button" class="btn btn-primary" value="淘宝商品表--一条数据" onclick="tableOne()"/>
	<input type="button" class="btn btn-primary" value="淘宝商品表--全部数据" onclick="tableAll()"/>
	<input type="button" class="btn btn-primary" value="淘宝API--一条数据" onclick="apiOne(${ctx}'sub/pProductTb/getApiOne')"/>
	<input type="button" class="btn btn-primary" value="淘宝API--全部数据" onclick="apiAll(${ctx}'sub/pProductTb/getApiAll')"/>
</body>
</html>