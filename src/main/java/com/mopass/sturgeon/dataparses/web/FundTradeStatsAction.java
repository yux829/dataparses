package com.mopass.sturgeon.dataparses.web;

import java.util.ArrayList;
import java.util.List;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mopaas.sturgeon.dataparses.domain.PieStatsVo;
import com.mopaas.sturgeon.dataparses.domain.StatTotalDatas;
import com.mopaas.sturgeon.dataparses.domain.StatsDetailVo;
import com.mopaas.sturgeon.dataparses.domain.StatsVo;
import com.mopaas.sturgeon.dataparses.service.BalanceLoadDataService;
import com.mopaas.sturgeon.dataparses.service.DateUtils;
import com.mopaas.sturgeon.dataparses.service.FundTradeQueryService;
import com.mopaas.sturgeon.dataparses.service.HelpUtils;

@Controller
@RequestMapping({ "/stats" })
public class FundTradeStatsAction {

	@Autowired
	private FundTradeQueryService s;

	@RequestMapping({ "/list" })
	public String list(ModelMap model) {
		System.out.println("enter FundTradeStatsAction list....");
		StatsVo statsdata =s.queryAllStats();
		model.addAttribute("statsdata", Json.toJson(statsdata));
		StatsVo avgprice=s.queryAvg_priceStats();
		model.addAttribute("avgprice", Json.toJson(avgprice));
		model.addAttribute("curtime", DateUtils.getCurTimeStr());
		List<PieStatsVo> pietagdata = s.queryPieTagStats(DateUtils.getCurTimeStr());
		model.addAttribute("pietagdata", Json.toJson(pietagdata));
		return "stats/list";
	}

	
}
