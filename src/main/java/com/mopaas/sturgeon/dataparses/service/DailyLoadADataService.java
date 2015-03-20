package com.mopaas.sturgeon.dataparses.service;

import org.junit.Test;
import org.nutz.json.Json;

import com.mopaas.sturgeon.dataparses.domain.DailyInfo;

public class DailyLoadADataService extends BaseLoadDataService {
	public static DailyInfo[] parse() {

		String doc = getJsonString(DailyInfo.URL_DailyInfo, "GBK");
		DailyInfo[] dilist= Json.fromJsonAsArray(DailyInfo.class, doc);
		for(DailyInfo d:dilist) {
			d.setMktcap(d.getMktcap()/10000);
			d.setNmc(d.getNmc()/10000);
		}
		return dilist;

	}

	@Test
	public void testparse() {
		DailyInfo[] bdlist = DailyLoadADataService.parse();
		System.out.println(Json.toJson(bdlist));
	}
}
