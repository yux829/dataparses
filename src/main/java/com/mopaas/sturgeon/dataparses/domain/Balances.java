package com.mopaas.sturgeon.dataparses.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;
@Table("t_balances_new")
@PK({"symbol","curdate"})
public class Balances {
	@Column
	private String symbol;//
	@Column
	private String curdate;//
	@Column
	private Date lastUpdateTime;//
	
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
	
	
	public double getWillpaymoney() {
		return willpaymoney;
	}
	public void setWillpaymoney(double willpaymoney) {
		this.willpaymoney = willpaymoney;
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
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
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
	
	

}
