<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" media="screen" href="../css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" media="screen" href="../css/jquery-ui-custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="../css/ui.jqgrid.css" />
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script  type="text/javascript" src="../js/jquery.jqGrid.min.js"></script>
<title>News_list</title>
<script type="text/javascript">
function query1() {
	alert("test");
jQuery("#list1").jqGrid({
   	url:'listDo.html',
	datatype: "json",
   	colNames:['id','name'],
   	colModel:[
   		{name:'id',index:'id'},
   		{name:'name',index:'name'},
   	],
   	autowidth:true,
    caption:"JSON Example"
});
}
</script>
</head>
<body>
	<p />
	<p />

	<div class="container" align="center">
		<form id="form1" class="form-inline" action="#">
			<button type="submit" class="btn  btn-primary" onclick="query1();">查询</button>
		</form>
	</div>
	<div class="span2"></div>
	<div class="span10">
		  <table id="list1"></table>
	</div>
</body>
</html>