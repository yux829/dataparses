package com.mopaas.sturgeon.dataparses.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;
@Table("t_baseinfos")
public class BaseInfoDomain {
/*
 * {name:"Apple Inc.",cname:"苹果公司",category:"计算机",symbol:"AAPL",price:"592.09",
 * diff:"-0.74",chg:"-0.12",preclose:"592.83",open:"592.00",high:"592.73",
 * low:"591.31",amplitude:"0.24%",volume:"197827",mktcap:"510663776721",
 * pe:"14.14791036",market:"NASDAQ",category_id:"5"}
 * 
 */
	
	@Name
	private String symbol;//AAPL
	@Column
	private String name;//Apple Inc
	@Column
	private String cname;//苹果公司
	@Column
	private String category;//计算机
	@Column
	private String market;//NASDAQ
	@Column
	private int category_id;//5
	@Column
	private double price;//592.09
	@Column
	private double diff;//-0.74 涨跌额
	@Column
	private double chg;//-0.12涨跌幅
	@Column
	private double preclose;
	@Column
	private double open;
	@Column
	private double high;
	@Column
	private double low;
	@Column
	private String amplitude;//振幅0.24%
	@Column
	private double volume;
	@Column
	private double mktcap;//市值
	@Column
	private double pe;
	@Column
	private Date lastUpdateTime;//
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiff() {
		return diff;
	}
	public void setDiff(double diff) {
		this.diff = diff;
	}
	public double getChg() {
		return chg;
	}
	public void setChg(double chg) {
		this.chg = chg;
	}
	public double getPreclose() {
		return preclose;
	}
	public void setPreclose(double preclose) {
		this.preclose = preclose;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}

	public String getAmplitude() {
		return amplitude;
	}
	public void setAmplitude(String amplitude) {
		this.amplitude = amplitude;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getMktcap() {
		return mktcap;
	}
	public void setMktcap(double mktcap) {
		this.mktcap = mktcap;
	}
	public double getPe() {
		return pe;
	}
	public void setPe(double pe) {
		this.pe = pe;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
	
	
	
	
	
}
