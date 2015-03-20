package com.mopaas.sturgeon.dataparses.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;
@Table("t_profits_new")
@PK({ "symbol", "curdate" })
public class Profits {
	@Column
	private String symbol;//
	@Column
	private String curdate;//
	@Column
	private Date lastUpdateTime;//
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
	public double getCurrent_income() {
		return current_income;
	}
	public void setCurrent_income(double current_income) {
		this.current_income = current_income;
	}
	public double getCurrent_cost() {
		return current_cost;
	}
	public void setCurrent_cost(double current_cost) {
		this.current_cost = current_cost;
	}
	public double getCurrent_profit() {
		return current_profit;
	}
	public void setCurrent_profit(double current_profit) {
		this.current_profit = current_profit;
	}
	
	
	
	
	
	
	
}
