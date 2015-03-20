package com.mopaas.sturgeon.dataparses.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.nutz.castor.Castors;
import org.nutz.json.Json;
import org.nutz.lang.segment.CharSegment;
import org.nutz.lang.segment.Segment;

import com.mopaas.sturgeon.dataparses.domain.CashflowDomain;


public class CashflowLoadDataService extends BaseLoadDataService {
	private final static String URL_Seg_ANNU = "http://vip.stock.finance.sina.com.cn/usstock/cash.php?s=${CODE}&t=annual";
	private final static String URL_Seg_QUAR = "http://vip.stock.finance.sina.com.cn/usstock/cash.php?s=${CODE}&t=quarter";

	public static List<CashflowDomain> parse(String symbol) {
		Segment URL = new CharSegment(URL_Seg_ANNU);
		URL.set("CODE", symbol);
		List<CashflowDomain> bdlist = parseDoc(getURLContent(URL.toString()),REPORT_TYPE_ANNU);
		URL = new CharSegment(URL_Seg_QUAR);
		URL.set("CODE", symbol);
		bdlist.addAll(parseDoc(getURLContent(URL.toString()),REPORT_TYPE_QUAR));
		return bdlist;

	}

	private static List<CashflowDomain> parseDoc(Document doc,String reporttype) {
		Element table = doc.getElementsByClass("data_tbl").get(1);
		Elements trlist = table.getElementsByTag("tr");
		Assert.assertEquals(20, trlist.size());
		Element tr_curdate = trlist.get(0);
		Element tr_operation_case = trlist.get(7);
		Element tr_invest_case = trlist.get(10);
		Element tr_financing_case = trlist.get(15);
		Element tr_net_case = trlist.get(17);
		return transCashflowDomain(tr_curdate, tr_operation_case,
				tr_invest_case, tr_financing_case, tr_net_case,reporttype);
	}

	private static List<CashflowDomain> transCashflowDomain(Element tr_curdate,
			Element tr_operation_case, Element tr_invest_case,
			Element tr_financing_case, Element tr_net_case,String reporttype) {
		List<CashflowDomain> blist = new ArrayList<CashflowDomain>();
		String[] curdates = parseTdContentFromTr(tr_curdate);
		String[] operation_cases = parseTdContentFromTr(tr_operation_case);
		String[] invest_cases = parseTdContentFromTr(tr_invest_case);
		String[] financing_cases = parseTdContentFromTr(tr_financing_case);
		String[] net_cases = parseTdContentFromTr(tr_net_case);
		for (int i = 0; i < curdates.length; i++) {
			CashflowDomain bd = new CashflowDomain();
			bd.setCurdate(curdates[i].substring(1));
			bd.setReporttype(reporttype);
			bd.setOperation_case(Castors.me().castTo(operation_cases[i],
					Double.class));
			bd.setInvest_case(Castors.me()
					.castTo(invest_cases[i], Double.class));
			bd.setFinancing_case(Castors.me().castTo(financing_cases[i],
					Double.class));
			bd.setNet_case(Castors.me().castTo(net_cases[i], Double.class));
			blist.add(bd);
		}
		return blist;
	}

	@Test
	public void testparse() {
		List<CashflowDomain> bdlist = parse("SINA");
		System.out.println(Json.toJson(bdlist));
	}
}
