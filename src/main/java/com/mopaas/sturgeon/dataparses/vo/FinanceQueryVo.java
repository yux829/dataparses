package com.mopaas.sturgeon.dataparses.vo;


import org.nutz.dao.entity.annotation.Column;

public class FinanceQueryVo {
	@Column
	private String symbol;//
	@Column
	private String curdate;//
	@Column
	private double income; //营业收入
	@Column
	private double cost; //营业成本
	@Column
	private double profit; //净利润
	@Column
	private double assets_total; //总资产
	@Column
	private double assets_flow;//流动资产
	@Column
	private double assets_fixed;//固定资产
	@Column
	private double owners_equity;//所有者权益
	@Column
	private double salary;//职工薪水
	@Column
	private double stock;//存货
	@Column
	private double willpaymoney;//应收款项
	@Column
	private double flow_business; // 经营现金流
	@Column
	private double flow_invest; // 投资现金流
	@Column
	private double flow_finance; // 筹资现金流
	@Column
	private double flow_netvalue; // 现金流量净额
	
	private double grossprofit; //毛利
	private double income_add; //收入增长
	private double cost_add; //成本增长
	private double profit_add; //净利润增长
	private double grossprofit_add; //毛利增长
	private double gross_rate;//毛利率
	private double profit_rate;//净利率
	private double roe;//roe
	
	
	public double getAssets_total() {
		return assets_total;
	}
	public void setAssets_total(double assets_total) {
		this.assets_total = assets_total;
	}
	public double getAssets_flow() {
		return assets_flow;
	}
	public void setAssets_flow(double assets_flow) {
		this.assets_flow = assets_flow;
	}
	public double getAssets_fixed() {
		return assets_fixed;
	}
	public void setAssets_fixed(double assets_fixed) {
		this.assets_fixed = assets_fixed;
	}
	public double getOwners_equity() {
		return owners_equity;
	}
	public void setOwners_equity(double owners_equity) {
		this.owners_equity = owners_equity;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	public double getWillpaymoney() {
		return willpaymoney;
	}
	public void setWillpaymoney(double willpaymoney) {
		this.willpaymoney = willpaymoney;
	}
	public double getFlow_business() {
		return flow_business;
	}
	public void setFlow_business(double flow_business) {
		this.flow_business = flow_business;
	}
	public double getFlow_invest() {
		return flow_invest;
	}
	public void setFlow_invest(double flow_invest) {
		this.flow_invest = flow_invest;
	}
	public double getFlow_finance() {
		return flow_finance;
	}
	public void setFlow_finance(double flow_finance) {
		this.flow_finance = flow_finance;
	}
	public double getFlow_netvalue() {
		return flow_netvalue;
	}
	public void setFlow_netvalue(double flow_netvalue) {
		this.flow_netvalue = flow_netvalue;
	}
	public double getRoe() {
		return roe;
	}
	public void setRoe(double roe) {
		this.roe = roe;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCurdate() {
		return curdate;
	}
	public void setCurdate(String curdate) {
		this.curdate = curdate;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public double getGrossprofit() {
		return grossprofit;
	}
	public void setGrossprofit(double grossprofit) {
		this.grossprofit = grossprofit;
	}
	public double getIncome_add() {
		return income_add;
	}
	public void setIncome_add(double income_add) {
		this.income_add = income_add;
	}
	public double getCost_add() {
		return cost_add;
	}
	public void setCost_add(double cost_add) {
		this.cost_add = cost_add;
	}
	public double getProfit_add() {
		return profit_add;
	}
	public void setProfit_add(double profit_add) {
		this.profit_add = profit_add;
	}
	public double getGrossprofit_add() {
		return grossprofit_add;
	}
	public void setGrossprofit_add(double grossprofit_add) {
		this.grossprofit_add = grossprofit_add;
	}
	public double getGross_rate() {
		return gross_rate;
	}
	public void setGross_rate(double gross_rate) {
		this.gross_rate = gross_rate;
	}
	public double getProfit_rate() {
		return profit_rate;
	}
	public void setProfit_rate(double profit_rate) {
		this.profit_rate = profit_rate;
	}
	
}
