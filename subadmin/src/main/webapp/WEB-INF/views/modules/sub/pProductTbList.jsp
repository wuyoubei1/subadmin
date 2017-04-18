<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存商品成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
		
		function onejson(url){
			$.ajax({
				type:"post",
				dataType:"jsonp",
				url:url,
				jsonp:"callback",
				success: function(data){
					alert(data.title);
				} 
			});
		}
		
		function alljson(url){
			$.ajax({
				type:"post",
				dataType:"jsonp",
				url:url,
				jsonp:"callback",
				success:function(data){
					alert(data[2].title);
				}
			});
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sub/pProductTb/">保存商品成功列表</a></li>
		<shiro:hasPermission name="sub:pProductTb:edit"><li><a href="${ctx}/sub/pProductTb/form">保存商品成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="pProductTb" action="${ctx}/sub/pProductTb/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>商品标题：</label>
 				<input path="title" htmlEscape="false" maxlength="255" class="input-medium" type="text"/>
 			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li><input id="btnSubmit" class="btn btn-primary" type="button" value="全部数据json" onclick="alljson('${ctx}/sub/pProductTb/alljson')" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>商品标题</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pProductTb">
			<tr>
				<td><a href="${ctx}/sub/pProductTb/form?id=${pProductTb.id}">
					${pProductTb.title}
				</a></td>
				<td>
    				<a href="${ctx}/sub/pProductTb/form?id=${pProductTb.id}">修改</a>
					<a href="${ctx}/sub/pProductTb/delete?id=${pProductTb.id}" onclick="return confirmx('确认要删除该保存商品成功吗？', this.href)">删除</a>
					<a href="#" onclick="onejson('${ctx}/sub/pProductTb/onejson?id=${pProductTb.id}')" >单条json</a>
					<!-- <input id="btnSubmit" class="btn btn-primary" type="submit" value="单条json" /> -->
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>