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

import com.mopaas.sturgeon.dataparses.domain.BalanceDomain;
import com.mopaas.sturgeon.dataparses.domain.IncomeDomain;

public class IncomeLoadDataService extends BaseLoadDataService {
	private final static String URL_Seg_ANNU = "http://vip.stock.finance.sina.com.cn/usstock/income.php?s=${CODE}&t=annual";
	private final static String URL_Seg_QUAR = "http://vip.stock.finance.sina.com.cn/usstock/income.php?s=${CODE}&t=quarter";
	public static List<IncomeDomain> parse(String symbol) {
		Segment URL = new CharSegment(URL_Seg_ANNU);
		URL.set("CODE", symbol);
		List<IncomeDomain> bdlist = parseDoc(getURLContent(URL.toString()),REPORT_TYPE_ANNU);
		URL = new CharSegment(URL_Seg_QUAR);
		URL.set("CODE", symbol);
		bdlist.addAll(parseDoc(getURLContent(URL.toString()),REPORT_TYPE_QUAR));
		return bdlist;

	}
	private static List<IncomeDomain> parseDoc(Document doc,String reporttype) {
		Element table = doc.getElementsByClass("data_tbl").get(1);
		Elements trlist = table.getElementsByTag("tr");
		Assert.assertEquals(50, trlist.size());
		Element tr_curdate = trlist.get(0);
		Element tr_income = trlist.get(3);
		Element tr_gross_profit = trlist.get(5);
		Element tr_operating_costs = trlist.get(12);
		Element tr_operating_profits = trlist.get(13);
		Element tr_pretax_profits = trlist.get(17);
		Element tr_net_profit = trlist.get(25);
		Element tr_net_profit_exclude = trlist.get(27);
		Element tr_per_share = trlist.get(49);

		return transIncomeDomain(tr_curdate, tr_income, tr_gross_profit,
				tr_operating_costs, tr_operating_profits, tr_pretax_profits,
				tr_net_profit, tr_net_profit_exclude, tr_per_share,reporttype);

	}

	private static List<IncomeDomain> transIncomeDomain(Element tr_curdate,
			Element tr_income, Element tr_gross_profit,
			Element tr_operating_costs, Element tr_operating_profits,
			Element tr_pretax_profits, Element tr_net_profit,
			Element tr_net_profit_exclude, Element tr_per_share,String reporttype) {
		List<IncomeDomain> blist = new ArrayList<IncomeDomain>();
		String[] curdates = parseTdContentFromTr(tr_curdate);
		String unit="USD";
		if( parseThContentFromTr(tr_curdate).indexOf("人民币")>-1){
			unit="CNY";
		}
		String[] incomes = parseTdContentFromTr(tr_income);
		String[] gross_profits = parseTdContentFromTr(tr_gross_profit);
		String[] operating_costs = parseTdContentFromTr(tr_operating_costs);
		String[] operating_profits = parseTdContentFromTr(tr_operating_profits);
		String[] pretax_profits = parseTdContentFromTr(tr_pretax_profits);
		String[] net_profits = parseTdContentFromTr(tr_net_profit);
		String[] net_profit_excludes = parseTdContentFromTr(tr_net_profit_exclude);
		String[] per_shares = parseTdContentFromTr(tr_per_share);
		for (int i = 0; i < curdates.length; i++) {
			IncomeDomain bd = new IncomeDomain();
			bd.setUnit(unit);
			bd.setCurdate(curdates[i].substring(1));
			bd.setReporttype(reporttype);
			bd.setIncome(Castors.me().castTo(incomes[i], Double.class));
			bd.setGross_profit(Castors.me().castTo(gross_profits[i],
					Double.class));
			bd.setOperating_costs(Castors.me().castTo(operating_costs[i],
					Double.class));
			bd.setOperating_profits(Castors.me().castTo(operating_profits[i],
					Double.class));
			bd.setPretax_profits(Castors.me().castTo(pretax_profits[i],
					Double.class));
			bd.setNet_profit(Castors.me().castTo(net_profits[i], Double.class));
			bd.setNet_profit_exclude(Castors.me().castTo(
					net_profit_excludes[i], Double.class));
			bd.setPer_share(Castors.me().castTo(per_shares[i], Double.class));

			blist.add(bd);
		}
		return blist;
	}

	@Test
	public void testparse() {
		List<IncomeDomain> bdlist = parse("BIDU");
		System.out.println(Json.toJson(bdlist));
	}
}
