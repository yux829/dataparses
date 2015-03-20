package com.mopaas.sturgeon.dataparses.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;
import org.nutz.castor.Castors;
import org.nutz.json.Json;
import org.nutz.lang.Strings;
import org.nutz.lang.segment.CharSegment;
import org.nutz.lang.segment.Segment;

import com.mopaas.sturgeon.dataparses.domain.SummaryInfo;

public class SummaryLoadDataService extends BaseLoadDataService {
	public static List<SummaryInfo> parse(String code) {
		Segment URL = new CharSegment(SummaryInfo.URL_SEG_ALL);
		URL.set("CODE", code);
		List<SummaryInfo> silist = parseDoc(getURLContent(URL.toString()),code);
		return silist;

	}

	private static List<SummaryInfo> parseDoc(Document doc,String code) {
		List<SummaryInfo> slist = new ArrayList<SummaryInfo>();
		Element table = doc.getElementById("FundHoldSharesTable");
		Elements trlist = table.getElementsByTag("tr");
		log("" + trlist.size());
		Assert.assertEquals(0, (trlist.size() - 1) % 14);
		for (int i = 1; i < trlist.size(); i = i + 14) {
			Element endtime = trlist.get(i);
			Element publictime = trlist.get(i + 1);
			Element nav = trlist.get(i + 2);
			Element eps = trlist.get(i + 3);
			Element cps = trlist.get(i + 4);
			Element ecr = trlist.get(i + 5);
			Element noliquidasset = trlist.get(i + 6);
			Element liquidasset = trlist.get(i + 7);
			Element asset = trlist.get(i + 8);
			Element longdebt = trlist.get(i + 9);
			Element income = trlist.get(i + 10);
			Element financialcost = trlist.get(i + 11);
			Element netprofit = trlist.get(i + 12);
			slist.add(SummaryLoadDataService.transDomain(endtime, publictime,
					nav, eps, cps, ecr, noliquidasset, liquidasset, asset,
					longdebt, income, financialcost, netprofit,code));

		}
		return slist;
	}

	private static SummaryInfo transDomain(Element endtime, Element publictime,
			Element nav, Element eps, Element cps, Element ecr,
			Element noliquidasset, Element liquidasset, Element asset,
			Element longdebt, Element income, Element financialcost,
			Element netprofit,String code) {
		SummaryInfo s = new SummaryInfo();
		s.setCode(code);
		s.setEndtime(DateUtils.string2Date(parseTdContentFromTr(endtime)[1],
				DateUtils.DATE_FORMAT_DAY));
		s.setPublictime(parseTdContentFromTr(publictime)[1]);
		String nav_str = ingoreYuan(parseTdContentFromTr(nav)[1]);
		s.setNav(Castors.me().castTo(nav_str, Double.class));
		String eps_str = ingoreYuan(parseTdContentFromTr(eps)[1]);
		s.setEps(Castors.me().castTo(eps_str, Double.class));
		String cps_str = ingoreYuan(parseTdContentFromTr(cps)[1]);
		s.setCps(Castors.me().castTo(cps_str, Double.class));
		String ecr_str = ingoreYuan(parseTdContentFromTr(ecr)[1]);
		s.setEcr(Castors.me().castTo(ecr_str, Double.class));
		String noliquidasset_str = ingoreYuan(parseTdContentFromTr(noliquidasset)[1]);
		s.setNoliquidasset(Castors.me().castTo(noliquidasset_str, Double.class));
		String liquidasset1 = ingoreYuan(parseTdContentFromTr(liquidasset)[1]);
		s.setLiquidasset(Castors.me().castTo(liquidasset1, Double.class));
		String asset1 = ingoreYuan(parseTdContentFromTr(asset)[1]);
		s.setAsset(Castors.me().castTo(asset1, Double.class));
		String longdebt1 = ingoreYuan(parseTdContentFromTr(longdebt)[1]);
		s.setLongdebt(Castors.me().castTo(longdebt1, Double.class));
		String income1 = ingoreYuan(parseTdContentFromTr(income)[1]);
		s.setIncome(Castors.me().castTo(income1, Double.class));
		String financialcost1 = ingoreYuan(parseTdContentFromTr(financialcost)[1]);
		s.setFinancialcost(Castors.me().castTo(financialcost1, Double.class));
		String netprofit1 = ingoreYuan(parseTdContentFromTr(netprofit)[1]);
		s.setNetprofit(Castors.me().castTo(netprofit1, Double.class));
		return s;
	}

	private static String ingoreYuan(String s) {

		if (s.lastIndexOf("元") > 0) {
			s = s.substring(0, s.lastIndexOf("元"));
		}
		if (s.lastIndexOf("万") > 0) {
			s = s.substring(0, s.lastIndexOf("万"));
		}
		if(Strings.isEmpty(s)||Strings.isBlank(s)||" ".equalsIgnoreCase(s)){
			return "0";
		}
		return s;
	}

	private static void log(String s) {
		System.out.println(s);
	}

	@Test
	public void testparse() {
		List<SummaryInfo> bdlist = SummaryLoadDataService.parse("000001");
		System.out.println(Json.toJson(bdlist));
	}
}
