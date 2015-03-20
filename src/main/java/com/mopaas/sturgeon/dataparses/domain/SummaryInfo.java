package com.mopaas.sturgeon.dataparses.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;
@Table("t_summaryinfos")
@PK({"code","publictime"})
public class SummaryInfo {
	public final static String URL_SEG_ALL = "http://vip.stock.finance.sina.com.cn/corp/go.php/vFD_FinanceSummary/stockid/${CODE}.phtml";
	public final static String URL_SEG_SHORT ="http://vip.stock.finance.sina.com.cn/corp/go.php/vFD_FinanceSummary/stockid/${CODE}/displaytype/4.phtml";
	@Column
	private String code;
	@Column
	private Date endtime;
	@Column
	private String publictime;
	@Column
	private double nav; //股东权益/总股数
	@Column
	private double eps;//利润/股本总数
	@Column
	private double cps;//经营活动产生的现金流量净额/总股本。
	@Column
	private double ecr;//企业公积金/总股本 
	@Column
	private double noliquidasset;//万元
	@Column
	private double liquidasset;//万元
	@Column
	private double asset;//万元
	@Column
	private double longdebt;//万元
	@Column
	private double income;//万元
	@Column
	private double financialcost;//万元
	@Column
	private double netprofit;//万元
	@Column
	private Date lastupdatetime;
	/*
	 * 每股净资产	5.7455元
每股收益	0.25元
每股现金含量	0.3225元
每股资本公积金	3.0562元
固定资产合计	 
流动资产合计	131823万元
资产总计	165967万元
长期负债合计	3966.32万元
主营业务收入	49800.1万元
财务费用	-989.35万元
净利润	6041.69万元
	 */

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}



	public String getPublictime() {
		return publictime;
	}

	public void setPublictime(String publictime) {
		this.publictime = publictime;
	}

	public double getNav() {
		return nav;
	}

	public void setNav(double nav) {
		this.nav = nav;
	}

	public double getEps() {
		return eps;
	}

	public void setEps(double eps) {
		this.eps = eps;
	}

	public double getCps() {
		return cps;
	}

	public void setCps(double cps) {
		this.cps = cps;
	}

	public double getEcr() {
		return ecr;
	}

	public void setEcr(double ecr) {
		this.ecr = ecr;
	}

	public double getNoliquidasset() {
		return noliquidasset;
	}

	public void setNoliquidasset(double noliquidasset) {
		this.noliquidasset = noliquidasset;
	}

	public double getLiquidasset() {
		return liquidasset;
	}

	public void setLiquidasset(double liquidasset) {
		this.liquidasset = liquidasset;
	}

	public double getAsset() {
		return asset;
	}

	public void setAsset(double asset) {
		this.asset = asset;
	}

	public double getLongdebt() {
		return longdebt;
	}

	public void setLongdebt(double longdebt) {
		this.longdebt = longdebt;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getFinancialcost() {
		return financialcost;
	}

	public void setFinancialcost(double financialcost) {
		this.financialcost = financialcost;
	}

	public double getNetprofit() {
		return netprofit;
	}

	public void setNetprofit(double netprofit) {
		this.netprofit = netprofit;
	}

	public Date getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

}
