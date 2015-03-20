package com.mopaas.sturgeon.dataparses.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.json.Json;
import org.nutz.lang.segment.CharSegment;
import org.nutz.lang.segment.Segment;
import org.springframework.stereotype.Component;

import com.mopaas.sturgeon.dataparses.domain.Balances;

@Component
public class BalancesNewLoadDataService extends LoadDataForExcelService {
	private final static String URL_SEG = "http://money.finance.sina.com.cn/corp/go.php/vDOWN_BalanceSheet/displaytype/4/stockid/${CODE}/ctrl/all.phtml";

	public Balances[] get(String symbol) {
		Segment URL = new CharSegment(URL_SEG);
		URL.set("CODE", symbol);
		String[] data = this.trans1(super.getFromSina(URL.toString()));
		return trans(data, countSize(data), symbol);
	}

	private String[] trans1(String[] datalist) {
		/*
		 * private String curdate; // 
		 * private double assets_total; //总资产 
		 * private double assets_flow;//流动资产 
		 * private double assets_fixed;//固定资产
		 *  private double owners_equity;//所有者权益 
		 * private double salary;//职工薪水
		 *  private double stock;//存货 
		 * private double willpaymoney;//应收款项
		 */
		String[] data1 = new String[8];
		data1[0] = datalist[0];
		data1[1] = datalist[55];
		data1[2] = datalist[27];
		data1[3] = datalist[54];
		data1[4] = datalist[112];
		data1[5] = datalist[68];
		data1[6] = datalist[22];
		data1[7] = datalist[9];
		return data1;
	}

	private String searchFromSList(String[] datalist, String key) {
		for (String s : datalist) {
			if (s.indexOf(key) > -1) {
				return s;
			}
		}
		return "";
	}




	private Balances[] trans(String[] datalist, int length, String symbol) {
		Date curdate = DateUtils.getCurTime();
		Balances[] blist = new Balances[length];
		for (int i = 0; i < length; i++) {
			blist[i] = new Balances();
			blist[i].setSymbol(symbol);
			blist[i].setLastUpdateTime(curdate);

		}
		/*
		 * private String curdate;// private double assets_total; //总资产 private
		 * double assets_flow;//流动资产 private double assets_fixed;//固定资产 private
		 * double owners_equity;//所有者权益 private double salary;//职工薪水 private
		 * double stock;//存货 private double willpaymoney;//应收款项
		 */
		List<String> curdatelist = this.parseValue(datalist[0]);
		for (int i = 0; i < curdatelist.size(); i++) {
			blist[i].setCurdate(curdatelist.get(i));
		}
		List<String> assets_totallist = this.parseValue(datalist[1]);
		for (int i = 0; i < assets_totallist.size(); i++) {
			blist[i].setAssets_total(HelpUtils.str2Double(assets_totallist
					.get(i)));
		}
		List<String> assets_flow = this.parseValue(datalist[2]);
		for (int i = 0; i < assets_flow.size(); i++) {
			blist[i].setAssets_flow(HelpUtils.str2Double(assets_flow.get(i)));
		}
		List<String> assets_fixed = this.parseValue(datalist[3]);
		for (int i = 0; i < assets_fixed.size(); i++) {
			blist[i].setAssets_fixed(HelpUtils.str2Double(assets_fixed.get(i)));
		}
		List<String> owners_equity = this.parseValue(datalist[4]);
		for (int i = 0; i < owners_equity.size(); i++) {
			blist[i].setOwners_equity(HelpUtils.str2Double(owners_equity.get(i)));
		}
		List<String> salary = this.parseValue(datalist[5]);
		for (int i = 0; i < salary.size(); i++) {
			blist[i].setSalary(HelpUtils.str2Double(salary.get(i)));
		}
		List<String> stock = this.parseValue(datalist[6]);
		for (int i = 0; i < stock.size(); i++) {
			blist[i].setStock(HelpUtils.str2Double(stock.get(i)));
		}
		List<String> willpaymoney = this.parseValue(datalist[7]);
		for (int i = 0; i < willpaymoney.size(); i++) {
			blist[i].setWillpaymoney(HelpUtils.str2Double(willpaymoney.get(i)));
		}

		return blist;
	}

}
