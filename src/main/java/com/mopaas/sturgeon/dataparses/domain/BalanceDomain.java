package com.mopaas.sturgeon.dataparses.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;
@Table("t_balance")
@PK({"symbol","curdate","reporttype"})
public class BalanceDomain {
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
	private double cash_shortinvest;//现金及短期投资
	@Column
	private double receivables;//应收账款总计
	@Column
	private double stock;//库存
	@Column
	private double assets_current;//流动资产总额
	@Column
	private double assets_total; //总资产
	@Column
	private double debts_current;//流动负债
	@Column
	private double debts_total;//总负债
	@Column
	private double shareholders;//股东权益
	@Column
	private double stocks_numbers;//普通股数
	@Column
	private Date lastUpdateTime;//


	public String getReporttype() {
		return reporttype;
	}
	public void setReporttype(String reporttype) {
		this.reporttype = reporttype;
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
