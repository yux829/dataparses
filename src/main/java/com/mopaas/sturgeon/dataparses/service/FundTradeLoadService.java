package com.mopaas.sturgeon.dataparses.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.nutz.castor.Castors;
import org.nutz.json.Json;
import org.nutz.lang.segment.CharSegment;
import org.nutz.lang.segment.Segment;
import com.mopaas.sturgeon.dataparses.domain.FundTrade;
import com.mopaas.sturgeon.dataparses.domain.FundTradeJisilu;

public class FundTradeLoadService extends BaseLoadDataService {

	public static List<FundTradeJisilu> parseFromjisulu() {
		Segment URL = new CharSegment(FundTrade.URL_FUN_SEG_JISILU);
		URL.set("TRADETIME", String.valueOf(DateUtils.getCurTime().getTime()));
		String doc = getJsonString(URL.toString(), "GBK");
		doc = doc.substring(doc.indexOf("cell") + 6, doc.lastIndexOf(","));
		String[] celllist = doc.split("cell");
		List<FundTradeJisilu> flist = new ArrayList<FundTradeJisilu>();
		for (String s : celllist) {
			s = s.substring(s.indexOf("{"), s.lastIndexOf("}"));
			FundTradeJisilu ftjl = Json.fromJson(FundTradeJisilu.class, s);
			flist.add(ftjl);
		}
		return flist;
	}

	public static FundTrade parse(String code) {
		Segment URL = new CharSegment(FundTrade.URL_FUN_SEG);
		URL.set("CODE", code);
		String doc = getJsonString(URL.toString(), "GBK");
		doc = doc.substring(doc.indexOf("=") + 2, doc.length() - 2);
//		System.out.println(doc);
		return transFundTrade(doc);

	}

	public static FundTrade parseHis(String code, String tradedate) {
		Segment URL = new CharSegment(FundTrade.URL_FUN_SEG_HIS);
		URL.set("CODE", code);
		URL.set("TRADETIME", tradedate);
		Document doc = getURLContent(URL.toString());
		return transFundTradeFromDoc(doc);

	}

	private static FundTrade transFundTradeFromDoc(Document doc) {
		Elements tbody = doc.getElementsByTag("tbody");
		// Assert.assertEquals(tbody.size() > 5, true);
		Elements fund_trlist = tbody.get(4).getElementsByTag("tr");
		FundTrade f = new FundTrade();
		f.setTrade(HelpUtils.str2Double(fund_trlist.get(0)
				.getElementsByTag("td").get(1).text()));
		String cp = fund_trlist.get(1).getElementsByTag("td").get(1).text();
		cp = cp.substring(0, cp.indexOf("%"));
		f.setChangepercent(HelpUtils.str2Double(cp));
		f.setSettlement(HelpUtils.str2Double(fund_trlist.get(2)
				.getElementsByTag("td").get(1).text()));
		f.setOpen(HelpUtils.str2Double(fund_trlist.get(3)
				.getElementsByTag("td").get(1).text()));
		f.setHigh(HelpUtils.str2Double(fund_trlist.get(4)
				.getElementsByTag("td").get(1).text()));
		f.setLow(HelpUtils.str2Double(fund_trlist.get(5).getElementsByTag("td")
				.get(1).text()));
		long vol = HelpUtils.double2long(HelpUtils.str2Double(fund_trlist
				.get(6).getElementsByTag("td").get(1).text()) * 100);
		long amo = HelpUtils.double2long(HelpUtils.str2Double(fund_trlist
				.get(7).getElementsByTag("td").get(1).text()) * 1000);
		f.setVolume(vol);
		f.setAmount(amo);
		f.setPricechange(HelpUtils.doubleSubtractDouble(f.getTrade(),
				f.getSettlement()));

		return f;
	}

	private static FundTrade transFundTrade(String doc) {
		String[] a = doc.split(",");
		// Assert.assertEquals(a.length > 11, true);
		FundTrade f = new FundTrade();
		f.setName(a[0]);
		f.setOpen(Castors.me().castTo(a[1], Double.class));
		f.setSettlement(Castors.me().castTo(a[2], Double.class));
		f.setTrade(Castors.me().castTo(a[3], Double.class));
		f.setHigh(Castors.me().castTo(a[4], Double.class));
		f.setLow(Castors.me().castTo(a[5], Double.class));
		f.setBuy(Castors.me().castTo(a[6], Double.class));
		f.setSell(Castors.me().castTo(a[7], Double.class));
		f.setVolume(Castors.me().castTo(a[8], Long.class));
		f.setAmount(Long.parseLong(a[9].substring(0, a[9].indexOf("."))));
		f.setTradetime(a[a.length - 3]);
		f.setPricechange(HelpUtils.doubleSubtractDouble(f.getTrade(),
				f.getSettlement()));
		f.setChangepercent(HelpUtils.DoubleDivideDouble(
				f.getPricechange() * 100, f.getSettlement(), 2));
		return f;

	}

	/*
	 * var hq_str_sz150195=" 互联网B, 1.500, 今开 1.515,昨收盘 1.456,现价 1.511,最高
	 * 1.420,最低 1.456,买一 1.457,卖一 36063596, 成交量 52620122.204, 成交金额 151673,
	 * 1.456, 184200,1.455, 40000,1.454, 82600,1.453, 44100,1.452, 37500,1.457,
	 * 35600,1.458, 7100,1.459, 35000,1.460, 2700,1.465,
	 * 2014-12-17,15:05:55,00";" + "" +
	 */

	@Test
	public void testparseFromjisulu() {
		List<FundTradeJisilu> bdlist = FundTradeLoadService.parseFromjisulu();
		System.out.println(Json.toJson(bdlist));
	}

	public void testparse() {
		FundTrade bdlist = FundTradeLoadService.parse("150172");
		System.out.println(Json.toJson(bdlist));
	}

	public void testparseHis() {
		FundTrade bdlist = FundTradeLoadService
				.parseHis("150195", "2014-12-13");
		System.out.println(Json.toJson(bdlist));
	}
}
