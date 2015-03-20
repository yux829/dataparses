<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>financequery_list</title>
<link href="../jslibs/zui1.2/css/zui.min.css" rel="stylesheet">
<script src="../jslibs/zui1.2/lib/jquery/jquery.js"></script>
<script src="../jslibs/zui1.2/js/zui.min.js"></script>
</head>

<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<form class="form-horizontal form-condensed" role="form"
				method='post' action="listdo.html">
				<legend>查询条件</legend>


				<div class="form-group">
					<label class="col-md-2 control-label">查询时期</label>
					<div class='col-md-4'>
						<select name='dates_suffix' id='dates_suffix' class='form-control'>
							<option value='1231' selected='selected'>年报</option>
							<option value='0930'>三季度</option>
							<option value='0630'>半年报</option>
							<option value='0331'>一季度</option>
						</select>
					</div>
					<div id='copyBox'>
						<div class='col-md-2'>
							<input type='text' name='symbol' id='symbol' value=''
								class='form-control' placeholder='代码' />
						</div>
						<div class='col-md-3'>
							<input type='submit' id='submit' class='btn btn-primary'
								value='查询' data-loading='稍候...' />
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-9">
			<legend>查询结果</legend>
			<table class="table datatable">
				<thead>
					<tr>
						<th>时期</th>
						<c:forEach items="${list}" var="fqvo">

							<th>${fqvo.curdate}</th>

						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td>主营收入</td>
						<c:forEach items="${list}" var="fqvo">
							<td><fmt:formatNumber value="${fqvo.income}" /></td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>

	</div>

</body>
<script>
	$('table.datatable').datatable({
		sortable : false
	});
	var symbol = '${symbol}';
	$("#symbol").val(symbol);
	$("#dates_suffix").val('${dates_suffix}');
</script>
</html>