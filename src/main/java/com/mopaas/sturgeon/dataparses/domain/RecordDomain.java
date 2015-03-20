package com.mopaas.sturgeon.dataparses.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;

@Table("t_records")
@PK({ "name", "trade_date" })
public class RecordDomain {
	public final static String NAME_MY1="MY1"; //小账号
	public final static String NAME_MY2="MY2";//大账号
	public final static String NAME_MY3="MY3";//LP账号
	public final static String NAME_HS300="HS300";//HS300指数
	public final static double MY1_ORGINAL=302451.05; //20141228
	public final static double MY1_ORGINAL2=374826.05; //20141228
	public final static double MY2_ORGINAL=774386; //20141228
	public final static double MY3_ORGINAL=71412; //20150209
	public final static double HS300_ORGINAL=3455.46;//HS300指数 20141228
	
	
	@Column
	private String name;
	@Column
	private String trade_date;
	@Column
	private double debt;
	@Column
	private double market_values;
	@Column
	private double netvalue;
	@Column
	private double asset;
	
	
	public double getAsset() {
		return asset;
	}

	public void setAsset(double asset) {
		this.asset = asset;
	}

	@Column
	private Date lastUpdateTime;//
	

	public double getNetvalue() {
		return netvalue;
	}

	public void setNetvalue(double netvalue) {
		this.netvalue = netvalue;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(String trade_date) {
		this.trade_date = trade_date;
	}

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}

	public double getMarket_values() {
		return market_values;
	}

	public void setMarket_values(double market_values) {
		this.market_values = market_values;
	}

}
