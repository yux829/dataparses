package com.mopaas.sturgeon.dataparses.domain;

import java.util.Date;

public class BalanceDomain {
//单位：百万美元
	private String code;//
	private String name;//
	private Date curdate;//
	private double cash_shortinvest;//现金及短期投资
	private double receivables;//应收账款总计
	private double stock;//库存
	private double assets_current;//流动资产总额
	private double assets_total; //总资产
	private double debts_current;//流动负债
	private double debts_total;//总负债
	private double shareholders;//股东权益
	private double stocks_numbers;//普通股数
	private Date lastUpdateTime;//
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCurdate() {
		return curdate;
	}
	public void setCurdate(Date curdate) {
		this.curdate = curdate;
	}
	public double getCash_shortinvest() {
		return cash_shortinvest;
	}
	public void setCash_shortinvest(double cash_shortinvest) {
		this.cash_shortinvest = cash_shortinvest;
	}
	public double getReceivables() {
		return receivables;
	}
	public void setReceivables(double receivables) {
		this.receivables = receivables;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	public double getAssets_current() {
		return assets_current;
	}
	public void setAssets_current(double assets_current) {
		this.assets_current = assets_current;
	}
	public double getAssets_total() {
		return assets_total;
	}
	public void setAssets_total(double assets_total) {
		this.assets_total = assets_total;
	}
	public double getDebts_current() {
		return debts_current;
	}
	public void setDebts_current(double debts_current) {
		this.debts_current = debts_current;
	}
	public double getDebts_total() {
		return debts_total;
	}
	public void setDebts_total(double debts_total) {
		this.debts_total = debts_total;
	}
	public double getShareholders() {
		return shareholders;
	}
	public void setShareholders(double shareholders) {
		this.shareholders = shareholders;
	}
	public double getStocks_numbers() {
		return stocks_numbers;
	}
	public void setStocks_numbers(double stocks_numbers) {
		this.stocks_numbers = stocks_numbers;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
	
	
	
}
