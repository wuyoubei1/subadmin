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
	<form action="${ctx}/sub/pTb/spsx">
		<input type="hidden" value="num_iid,title,pict_url,small_images,reserve_price,zk_final_price,
		user_type,provcity,item_url,seller_id,volume,nick" id="req.fields"/>
		<input type="text" value="女装" id="req.q"/>
		<input type="text" value="杭州" id="req.itemloc"/>
		<input type="text" value="1" id="req.page_no"/>
		<input type="text" value="20" id="req.page_size"/>
		<input  type="submit" value="测试淘宝"/>
	</form>
</body>
</html>