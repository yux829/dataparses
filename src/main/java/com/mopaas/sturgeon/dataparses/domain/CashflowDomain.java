package com.mopaas.sturgeon.dataparses.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;
@Table("t_cashflows")
@PK({"symbol","curdate","reporttype"})
public class CashflowDomain {
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
	private double operation_case;//运营活动所产生现金
	@Column
	private double invest_case;//投资活动所产生现金
	@Column
	private double financing_case;//融资活动所产生现金
	@Column
	private double net_case;//现金净增减额

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

	public String getReporttype() {
		return reporttype;
	}
	public void setReporttype(String reporttype) {
		this.reporttype = reporttype;
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
	public double getOperation_case() {
		return operation_case;
	}
	public void setOperation_case(double operation_case) {
		this.operation_case = operation_case;
	}
	public double getInvest_case() {
		return invest_case;
	}
	public void setInvest_case(double invest_case) {
		this.invest_case = invest_case;
	}
	public double getFinancing_case() {
		return financing_case;
	}
	public void setFinancing_case(double financing_case) {
		this.financing_case = financing_case;
	}
	public double getNet_case() {
		return net_case;
	}
	public void setNet_case(double net_case) {
		this.net_case = net_case;
	}
	
	
}
