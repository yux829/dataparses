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
import org.nutz.lang.segment.CharSegment;
import org.nutz.lang.segment.Segment;
import org.springframework.stereotype.Component;

import com.mopaas.sturgeon.dataparses.domain.BalanceDomain;

@Component
public class BalanceLoadDataService extends BaseLoadDataService {
	private final static String URL_Seg_ANNU = "http://vip.stock.finance.sina.com.cn/usstock/balance.php?s=${CODE}&t=annual";
	private final static String URL_Seg_QUAR = "http://vip.stock.finance.sina.com.cn/usstock/balance.php?s=${CODE}&t=quarter";

	public static List<BalanceDomain> parse(String symbol) {
		Segment URL = new CharSegment(URL_Seg_ANNU);
		URL.set("CODE", symbol);
		List<BalanceDomain> bdlist = parseDoc(getURLContent(URL.toString()),REPORT_TYPE_ANNU);
		URL = new CharSegment(URL_Seg_QUAR);
		URL.set("CODE", symbol);
		bdlist.addAll(parseDoc(getURLContent(URL.toString()),REPORT_TYPE_QUAR));
		return bdlist;

	}

	private static List<BalanceDomain> parseDoc(Document doc,String reporttype) {

		Element table = doc.getElementsByClass("data_tbl").get(1);
		Elements trlist = table.getElementsByTag("tr");
		Assert.assertEquals(43, trlist.size());
		Element tr_curdate = trlist.get(0);
		Element tr_cash_shortinvest = trlist.get(3);
		Element tr_receivables = trlist.get(6);
		Element tr_stock = trlist.get(7);
		Element tr_assets_current = trlist.get(10);
		Element tr_assets_total = trlist.get(17);
		Element tr_debts_current = trlist.get(23);
		Element tr_debts_total = trlist.get(31);
		Element tr_shareholders = trlist.get(39);
		Element tr_stocks_numbers = trlist.get(42);
		return transBalanceDomain(tr_curdate, tr_cash_shortinvest,
				tr_receivables, tr_stock, tr_assets_current, tr_assets_total,
				tr_debts_current, tr_debts_total, tr_shareholders,
				tr_stocks_numbers,reporttype);
	}

	private static List<BalanceDomain> transBalanceDomain(Element tr_curdate,
			Element tr_cash_shortinvest, Element tr_receivables,
			Element tr_stock, Element tr_assets_current,
			Element tr_assets_total, Element tr_debts_current,
			Element tr_debts_total, Element tr_shareholders,
			Element tr_stocks_numbers,String reporttype) {
		List<BalanceDomain> blist = new ArrayList<BalanceDomain>();
		String[] curdates = parseTdContentFromTr(tr_curdate);
		String[] cash_shortinvests = parseTdContentFromTr(tr_cash_shortinvest);
		String[] receivables = parseTdContentFromTr(tr_receivables);
		String[] stocks = parseTdContentFromTr(tr_stock);
		String[] assets_currents = parseTdContentFromTr(tr_assets_current);
		String[] assets_totals = parseTdContentFromTr(tr_assets_total);
		String[] debts_currents = parseTdContentFromTr(tr_debts_current);
		String[] debts_totals = parseTdContentFromTr(tr_debts_total);
		String[] shareholders = parseTdContentFromTr(tr_shareholders);
		String[] stocks_numbers = parseTdContentFromTr(tr_stocks_numbers);
		for (int i = 0; i < curdates.length; i++) {
			BalanceDomain bd = new BalanceDomain();
			bd.setCurdate(curdates[i].substring(1));
			bd.setReporttype(reporttype);
			bd.setCash_shortinvest(Castors.me().castTo(cash_shortinvests[i],
					Double.class));
			bd.setReceivables(Castors.me().castTo(receivables[i], Double.class));
			bd.setStock(Castors.me().castTo(stocks[i], Double.class));
			bd.setAssets_current(Castors.me().castTo(assets_currents[i],
					Double.class));
			bd.setAssets_total(Castors.me().castTo(assets_totals[i],
					Double.class));
			bd.setDebts_current(Castors.me().castTo(debts_currents[i],
					Double.class));
			bd.setDebts_total(Castors.me()
					.castTo(debts_totals[i], Double.class));
			bd.setShareholders(Castors.me().castTo(shareholders[i],
					Double.class));
			bd.setStocks_numbers(Castors.me().castTo(stocks_numbers[i],
					Double.class));

			blist.add(bd);
		}
		return blist;
	}

	@Test
	public void testparse() {
		List<BalanceDomain> bdlist = BalanceLoadDataService.parse("sina");
		System.out.println(Json.toJson(bdlist));
	}
}
