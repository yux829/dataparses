package com.mopass.sturgeon.dataparses.web;

import java.util.List;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mopaas.sturgeon.dataparses.service.FinanceQueryService;
import com.mopaas.sturgeon.dataparses.vo.FinanceQueryVo;

@Controller
@RequestMapping({ "/financequery" })
public class FinanceQueryAction {
	@Autowired
	private FinanceQueryService s;

	@RequestMapping({ "/list" })
	public String list(ModelMap model) {
		System.out.println("enter FinanceQueryAction list....");
		return "financequery/list";
	}
	@RequestMapping({ "/listdo" })
	public String listdo(@RequestParam String symbol,
			@RequestParam String dates_suffix, ModelMap model) {
		System.out.println("enter FinanceQueryAction listdo....symbol:"+symbol+"..dates_suffix:"+dates_suffix);
		List<FinanceQueryVo> list = s.queryList(symbol, dates_suffix);
		model.addAttribute("list", list);
		model.addAttribute("symbol", symbol);
		model.addAttribute("dates_suffix", dates_suffix);
		for (FinanceQueryVo p : list) {
			System.out.println(Json.toJson(p));
		}
		return "financequery/list";
	}
}
