package com.mopaas.sturgeon.dataparses.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.nutz.castor.Castors;
import org.nutz.castor.castor.String2Datetime;
import org.nutz.json.Json;

import com.mopaas.sturgeon.dataparses.domain.BalanceDomain;

public class BalanceLoadDataService {
	private final static String URL1 = "http://vip.stock.finance.sina.com.cn/usstock/balance.php?s=SINA&t=annual";
	private final static String URL = "http://vip.stock.finance.sina.com.cn/usstock/balance.php?s=SINA&t=quarter";

	private Document getBalanceContent(String URL) {
		try {
			return Jsoup.connect(URL).get();
		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;

	}

	public List<BalanceDomain> parse(Document doc) {

		Element table = doc.getElementsByClass("data_tbl").get(1);
		// System.out.println(table.toString());
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
		return this.transBalanceDomain(tr_curdate, tr_cash_shortinvest,
				tr_receivables, tr_stock, tr_assets_current, tr_assets_total,
				tr_debts_current, tr_debts_total, tr_shareholders,
				tr_stocks_numbers);
	}

	private List<BalanceDomain> transBalanceDomain(Element tr_curdate,
			Element tr_cash_shortinvest, Element tr_receivables,
			Element tr_stock, Element tr_assets_current,
			Element tr_assets_total, Element tr_debts_current,
			Element tr_debts_total, Element tr_shareholders,
			Element tr_stocks_numbers) {
		List<BalanceDomain> blist = new ArrayList<BalanceDomain>();
		String[] curdates = this.parseTdContentFromTr(tr_curdate);
		String[] cash_shortinvests = this
				.parseTdContentFromTr(tr_cash_shortinvest);
		String[] receivables = this.parseTdContentFromTr(tr_receivables);
		String[] stocks = this.parseTdContentFromTr(tr_stock);
		String[] assets_currents = this.parseTdContentFromTr(tr_assets_current);
		String[] assets_totals = this.parseTdContentFromTr(tr_assets_total);
		String[] debts_currents = this.parseTdContentFromTr(tr_debts_current);
		String[] debts_totals = this.parseTdContentFromTr(tr_debts_total);
		String[] shareholders = this.parseTdContentFromTr(tr_shareholders);
		String[] stocks_numbers = this.parseTdContentFromTr(tr_stocks_numbers);
		for (int i = 0; i < curdates.length; i++) {
			BalanceDomain bd = new BalanceDomain();
			bd.setCurdate(Castors.me().castTo(curdates[i].substring(1),
					java.util.Date.class));
			bd.setCash_shortinvest(Castors.me().castTo(cash_shortinvests[i],Double.class));
			bd.setReceivables(Castors.me().castTo(receivables[i],Double.class));
			bd.setStock(Castors.me().castTo(stocks[i],Double.class));
			bd.setAssets_current(Castors.me().castTo(assets_currents[i],Double.class));
			bd.setAssets_total(Castors.me().castTo(assets_totals[i],Double.class));
			bd.setDebts_current(Castors.me().castTo(debts_currents[i],Double.class));
			bd.setDebts_total(Castors.me().castTo(debts_totals[i],Double.class));
			bd.setShareholders(Castors.me().castTo(shareholders[i],Double.class));
			bd.setStocks_numbers(Castors.me().castTo(stocks_numbers[i],Double.class));

			blist.add(bd);
		}
		return blist;
	}

	private String[] parseTdContentFromTr(Element tr_content) {
		StringBuffer sb = new StringBuffer("");
		Elements td_list = tr_content.getElementsByTag("td");
		for (Element td : td_list) {
			sb.append(td.text()).append(";");
		}
		return sb.toString().split(";");
	}

	@Test
	public void testparse() {
		List<BalanceDomain> bdlist = this.parse(this.getBalanceContent(URL));
		System.out.println(Json.toJson(bdlist));
	}
}
