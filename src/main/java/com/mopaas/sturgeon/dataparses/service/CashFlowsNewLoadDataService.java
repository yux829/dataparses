package com.mopaas.sturgeon.dataparses.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.nutz.json.Json;
import org.nutz.lang.segment.CharSegment;
import org.nutz.lang.segment.Segment;
import org.springframework.stereotype.Component;

import com.mopaas.sturgeon.dataparses.domain.CashFlows;
@Component
public class CashFlowsNewLoadDataService extends LoadDataForExcelService {
	private final static String URL_SEG = "http://money.finance.sina.com.cn/corp/go.php/vDOWN_CashFlow/displaytype/4/stockid/${CODE}/ctrl/all.phtml";

	public CashFlows[] get(String symbol) {
		Segment URL = new CharSegment(URL_SEG);
		URL.set("CODE", symbol);
		String[] data = this.filterDestValue(super.getFromSina(URL.toString()));
		return trans2Profits(data, symbol);
	}

	private String[] filterDestValue(String[] datalist) {
		/*
		@Column
		private String curdate;//
		@Column
		private double flow_business; // 经营现金流

		@Column
		private double flow_invest; // 投资现金流

		@Column
		private double flow_finance; // 筹资现金流

		@Column
		private double flow_netvalue; // 现金流量净额
		*/
		String[] data1 = new String[5];
		data1[0] = datalist[0];
		data1[1] = datalist[27];
		data1[2] = datalist[43];
		data1[3] = datalist[56];
		data1[4] = datalist[61];
		return data1;
	}

	private CashFlows[] trans2Profits(String[] datalist, String symbol) {
		int length = super.countSize(datalist);
		Date curdate = DateUtils.getCurTime();
		CashFlows[] blist = new CashFlows[length];
		for (int i = 0; i < length; i++) {
			blist[i] = new CashFlows();
			blist[i].setSymbol(symbol);
			blist[i].setLastUpdateTime(curdate);

		}
		List<String> curdatelist = this.parseValue(datalist[0]);
		for (int i = 0; i < curdatelist.size(); i++) {
			blist[i].setCurdate(curdatelist.get(i));
		}
		List<String> flow_business = this.parseValue(datalist[1]);
		for (int i = 0; i < flow_business.size(); i++) {
			blist[i].setFlow_business(HelpUtils.str2Double(flow_business.get(i)));
		}
		List<String> flow_invest = this.parseValue(datalist[2]);
		for (int i = 0; i < flow_invest.size(); i++) {
			blist[i].setFlow_invest(HelpUtils.str2Double(flow_invest.get(i)));
		}
		List<String> flow_finance = this.parseValue(datalist[3]);
		for (int i = 0; i < flow_finance.size(); i++) {
			blist[i].setFlow_finance(HelpUtils.str2Double(flow_finance.get(i)));
		}
		List<String> flow_netvalue = this.parseValue(datalist[4]);
		for (int i = 0; i < flow_netvalue.size(); i++) {
			blist[i].setFlow_netvalue(HelpUtils.str2Double(flow_netvalue.get(i)));
		}
		return blist;
	}

	@Test
	public void testGet() {
		CashFlows[] plist = this.get("300427");
		for (CashFlows b : plist) {
			System.out.println(Json.toJson(b));
		}
	}
}
