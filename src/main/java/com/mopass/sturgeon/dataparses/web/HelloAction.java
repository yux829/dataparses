package com.mopass.sturgeon.dataparses.web;

import java.util.HashMap;
import java.util.Map;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mopaas.sturgeon.dataparses.service.BalanceLoadDataService;
import com.mopaas.sturgeon.dataparses.service.BaseLoadDataService;
import com.mopaas.sturgeon.dataparses.service.HelloService;

@Controller
@RequestMapping({ "/hello" })
public class HelloAction {

	@Autowired
	private BalanceLoadDataService s;

	@RequestMapping({ "/list" })
	public String list() {
		System.out.println("list....");
		return "hello/list";
	}

	@RequestMapping({ "/listDo" })
	@ResponseBody
	public Object listDo() {
		System.out.println("list do....");
		Map p = new HashMap();
		this.s.testparse();
		p.put("page", Integer.valueOf(1));

		String value = Json.toJson(p);
		return value;
	}
}
