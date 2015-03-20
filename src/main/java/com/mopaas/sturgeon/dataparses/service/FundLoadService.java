package com.mopaas.sturgeon.dataparses.service;

import org.junit.Test;
import org.nutz.json.Json;
import com.mopaas.sturgeon.dataparses.domain.Fund;

public class FundLoadService extends BaseLoadDataService {
	public static Fund[] parse() {

		String doc = getJsonString(Fund.URL, "GBK");
		if(doc!=null &&doc.length()>0){
			doc =doc.substring(doc.indexOf("[{"),doc.lastIndexOf("}]")+2);
		}
		
		return Json.fromJsonAsArray(Fund.class, doc);

	}

	@Test
	public void testparse() {
		Fund[] bdlist = FundLoadService.parse();
		System.out.println(Json.toJson(bdlist));
	}
}
