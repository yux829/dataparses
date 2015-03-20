<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>record_list</title>
<link href="../jslibs/zui1.2/css/zui.min.css" rel="stylesheet">
<script src="../jslibs/zui1.2/lib/jquery/jquery.js"></script>
<script src="../jslibs/zui1.2/js/zui.min.js"></script>
<script src="../jslibs/zui1.2/lib/chartjs/Chart.js"></script>
</head>

<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<h3><strong>净值走势：</strong>[${ curtime}]</h3>
			<h5><font color="#FF0000" >L账号</font> <font color="#FF00FF" >B账号</font>  <font color="#00FF00" >沪深300指数</font> (以100为起点)   <font color="#FF0000" >总资产:${ totalassert} </font> </h5>
			<div>
				<canvas id="netvalue" height="300" width="900"></canvas>
			</div>

		</div>
		<div class="col-md-2"></div>
	</div>

	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<h3><strong>净资产走势</h3>
			<div>
				<canvas id="stats_netassert" height="300" width="900"></canvas>
			</div>

		</div>
		<div class="col-md-2"></div>
	</div>
	
	<script>
		var lineavgprice = ${netvalue};
		var ctx1 = $("#netvalue").get(0).getContext("2d");
		var myavgprice = new Chart(ctx1).Line(lineavgprice, {
			responsive : true,
			datasetFill : false
		});
		
		var stats_netassert=${stats_netassert};
		var ctx2 = $("#stats_netassert").get(0).getContext("2d");
		var mystats_netassert = new Chart(ctx2).Line(stats_netassert, {
			responsive : true,
			datasetFill : false
		});
		
	
		
		
	</script>
</body>
</html>