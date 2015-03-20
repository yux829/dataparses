package com.mopaas.sturgeon.dataparses.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;
@Table("t_incomes")
@PK({"symbol","curdate","reporttype"})
public class IncomeDomain {
	//单位：百万美元
	@Column
	private String symbol;//
	@Column
	private String name;//
	@Column
	private String curdate;//
	@Column
	private String reporttype;//00 年报 01 季报
	@Column
	private Date lastUpdateTime;//
	@Column
	private double income;//营业收入
	@Column
	private double gross_profit;//毛利
	@Column
	private double operating_costs;//运营成本
	@Column
	private double operating_profits;//运营利润
	@Column
	private double pretax_profits;//税前利润
	@Column
	private double net_profit;//净利润
	@Column
	private double net_profit_exclude;//不计非经常项目净利润
	@Column
	private double per_share;//每股收益
	@Column
	private String unit="USD";//USD/CNY 美元/人民币

	public String getReporttype() {
		return reporttype;
	}
	public void setReporttype(String reporttype) {
		this.reporttype = reporttype;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCurdate() {
		return curdate;
	}
	public void setCurdate(String curdate) {
		this.curdate = curdate;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getGross_profit() {
		return gross_profit;
	}
	public void setGross_profit(double gross_profit) {
		this.gross_profit = gross_profit;
	}
	public double getOperating_costs() {
		return operating_costs;
	}
	public void setOperating_costs(double operating_costs) {
		this.operating_costs = operating_costs;
	}
	public double getOperating_profits() {
		return operating_profits;
	}
	public void setOperating_profits(double operating_profits) {
		this.operating_profits = operating_profits;
	}
	public double getPretax_profits() {
		return pretax_profits;
	}
	public void setPretax_profits(double pretax_profits) {
		this.pretax_profits = pretax_profits;
	}
	public double getNet_profit() {
		return net_profit;
	}
	public void setNet_profit(double net_profit) {
		this.net_profit = net_profit;
	}
	public double getNet_profit_exclude() {
		return net_profit_exclude;
	}
	public void setNet_profit_exclude(double net_profit_exclude) {
		this.net_profit_exclude = net_profit_exclude;
	}
	public double getPer_share() {
		return per_share;
	}
	public void setPer_share(double per_share) {
		this.per_share = per_share;
	}
	
	
}
