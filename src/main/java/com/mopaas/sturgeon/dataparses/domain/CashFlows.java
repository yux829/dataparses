package com.mopaas.sturgeon.dataparses.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;

@Table("t_cashflows_new")
@PK({ "symbol", "curdate" })
public class CashFlows {
	@Column
	private String symbol;//
	@Column
	private String curdate;//
	@Column
	private Date lastUpdateTime;//
	@Column
	private double flow_business; // 经营现金流

	@Column
	private double flow_invest; // 投资现金流

	@Column
	private double flow_finance; // 筹资现金流

	@Column
	private double flow_netvalue; // 现金流量净额

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

}
