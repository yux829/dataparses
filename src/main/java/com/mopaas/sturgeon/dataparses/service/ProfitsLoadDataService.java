package com.mopaas.sturgeon.dataparses.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.nutz.json.Json;
import org.nutz.lang.segment.CharSegment;
import org.nutz.lang.segment.Segment;
import org.springframework.stereotype.Component;

import com.mopaas.sturgeon.dataparses.domain.Profits;
@Component
public class ProfitsLoadDataService  extends LoadDataForExcelService {
	private final static String URL_SEG = "http://money.finance.sina.com.cn/corp/go.php/vDOWN_ProfitStatement/displaytype/4/stockid/${CODE}/ctrl/all.phtml";

	public Profits[] get(String symbol) {
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
		private double income; //营业收入
		@Column
		private double cost; //营业成本
		@Column
		private double profit; //净利润
		@Column
		private double current_income; //当期收入
		@Column
		private double current_cost; //当期收入
		@Column
		private double current_profit; //当期净利润
		*/
		String[] data1 = new String[4];
		data1[0] = datalist[0];
		data1[1] = datalist[2];
		data1[2] = datalist[9];
		data1[3] = datalist[42];
		return data1;
	}
	
	private Profits[] trans2Profits(String[] datalist, String symbol) {
		int length=super.countSize(datalist);
		Date curdate = DateUtils.getCurTime();
		Profits[] blist = new Profits[length];
		for (int i = 0; i < length; i++) {
			blist[i] = new Profits();
			blist[i].setSymbol(symbol);
			blist[i].setLastUpdateTime(curdate);

		}
		List<String> curdatelist = this.parseValue(datalist[0]);
		for (int i = 0; i < curdatelist.size(); i++) {
			blist[i].setCurdate(curdatelist.get(i));
		}
		List<String> income = this.parseValue(datalist[1]);
		for (int i = 0; i < income.size(); i++) {
			blist[i].setIncome(HelpUtils.str2Double(income.get(i)));
		}
		List<String> cost = this.parseValue(datalist[2]);
		for (int i = 0; i < cost.size(); i++) {
			blist[i].setCost(HelpUtils.str2Double(cost.get(i)));
		}
		List<String> profit = this.parseValue(datalist[3]);
		for (int i = 0; i < profit.size(); i++) {
			blist[i].setProfit(HelpUtils.str2Double(profit.get(i)));
		}
		return blist;
	}
	@Test
	public void testGet(){
		Profits[] plist=this.get("000001");
		for(Profits b:plist){
			System.out.println(Json.toJson(b));
		}
	}
	
}
