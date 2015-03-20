package com.mopaas.sturgeon.dataparses.service;

import org.junit.Test;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.segment.CharSegment;
import org.nutz.lang.segment.Segment;
import org.springframework.stereotype.Component;

import com.mopaas.sturgeon.dataparses.domain.BaseInfoDomain;
@Component
public class BaseInfoLoadDataService extends BaseLoadDataService {
	private final static String URL_Seg = "http://stock.finance.sina.com.cn/usstock/api/jsonp.php/IO.XSRV2.CallbackList['doRC9iO10SZezYVc']/US_CategoryService.getList?page=${pageNo}&num=60&sort=&asc=0&market=&id=";
	public final static int PAGENO_MAX = 127;

	public static BaseInfoDomain[] getList(int pageNo) {
		Segment URL = new CharSegment(URL_Seg);
		URL.set("pageNo", pageNo);
		String doc = getJsonString(URL.toString(), "GBK");
		doc = doc.substring(doc.indexOf("data:") + 5, doc.lastIndexOf("]") + 1);
		return Json.fromJson(BaseInfoDomain[].class, Lang.inr(doc));
	}

	@Test
	public void testGetList() {
		BaseInfoDomain[]  blist=getList(1);
		for(BaseInfoDomain bd:blist){
			System.out.println(Json.toJson(bd));
		}
	}
}
