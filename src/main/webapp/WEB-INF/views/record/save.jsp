<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>record_save</title>
<link href="../jslibs/zui1.2/css/zui.min.css" rel="stylesheet">
<script src="../jslibs/zui1.2/lib/jquery/jquery.js"></script>
<script src="../jslibs/zui1.2/js/zui.min.js"></script>
<script src="../jslibs/zui1.2/lib/chartjs/Chart.js"></script>
</head>

<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<h3><strong>总体指标：</strong>[${ curtime}]</h3>
			<h5>成交均价[单位:元]</h5>
			<div>
				<canvas id="avgprice" height="300" width="900"></canvas>
			</div>
			<h5>成交总金额/总成交量[单位:亿元]</h5>
			<div>
				<canvas id="statsdata" height="300" width="900"></canvas>
			</div>
			<h3><strong>指数占比：[${ curtime}]</strong></h3>
			
			<div>
				<canvas id="pietagdata" height="300" width="300"></canvas>
			</div>
			
		</div>
		<div class="col-md-2"></div>
	</div>

	<script>
		var lineavgprice = ${avgprice};
		var ctx1 = $("#avgprice").get(0).getContext("2d");
		var myavgprice = new Chart(ctx1).Line(lineavgprice, {
			responsive : true,
			datasetFill : false
		});
		var barstatsdata = ${statsdata	};
		var ctx2 = $("#statsdata").get(0).getContext("2d");
		var mystatsdata = new Chart(ctx2).Bar(barstatsdata);
		
		var pietagdata=${pietagdata};
		var ctx3 = $("#pietagdata").get(0).getContext("2d");
		var mypietagdata = new Chart(ctx3).Pie(pietagdata);
	
		
		
	</script>
</body>
</html>