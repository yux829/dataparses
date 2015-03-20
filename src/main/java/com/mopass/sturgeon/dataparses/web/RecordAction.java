package com.mopass.sturgeon.dataparses.web;

import java.util.List;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mopaas.sturgeon.dataparses.domain.PieStatsVo;
import com.mopaas.sturgeon.dataparses.domain.StatsVo;
import com.mopaas.sturgeon.dataparses.service.DateUtils;
import com.mopaas.sturgeon.dataparses.service.RecordCURDService;
import com.mopaas.sturgeon.dataparses.service.RecordStatService;

@Controller
@RequestMapping({ "/record" })
public class RecordAction {
	@Autowired
	private RecordStatService s;

	@RequestMapping({ "/save" })
	public String save() {
		System.out.println("save....");
		return "record/save";
	}

	@RequestMapping({ "/savedo" })
	public String savedo() {
		System.out.println("savedo....");
		return "record/list";
	}

	@RequestMapping({ "/list" })
	public String list(ModelMap model) {
		System.out.println("list....");
		String today=DateUtils.getCurTimeStrByFormate(DateUtils.DATE_FORMAT_DAY_SHORT);
		StatsVo statsdata =s.queryNetValue();
		model.addAttribute("netvalue", Json.toJson(statsdata));
		model.addAttribute("curtime",today);
		model.addAttribute("totalassert",s.queryTotalAsset(today));
		
		StatsVo stats_netassert =s.queryNetAsset();
		model.addAttribute("stats_netassert", Json.toJson(stats_netassert));
		return "record/list";
	}
	
	

}
