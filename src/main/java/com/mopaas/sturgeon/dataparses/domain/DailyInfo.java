package com.mopaas.sturgeon.dataparses.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;
@Table("t_dailyinfos")
public class DailyInfo {
	public final static String URL_DailyInfo = "http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodeData?page=1&num=30000&sort=symbol&asc=1&node=hs_a&symbol=&_s_r_a=page";
	public final static String URL_FUN_SEG = "http://hq.sinajs.cn/rn=3pa4l&list=sz${CODE}";
	
	@Name
	private String symbol;
	@Column
	private String code;
	@Column
	private String name;
	@Column
	private double trade;//现价
	@Column
	private double pricechange;//涨额
	@Column
	private double changepercent;//涨幅
	@Column
	private double buy;//买1
	@Column
	private double sell;//卖1
	@Column
	private double settlement;//昨收盘
	@Column
	private double open;//今开盘
	@Column
	private double high;//最高
	@Column
	private double low;//最低
	@Column
	private long volume;
	@Column
	private long amount;
	@Column
	private String ticktime;
	@Column
	private double per;
	@Column
	private double pb;
	@Column
	private double mktcap;
	@Column
	private double nmc;
	@Column
	private double turnoverratio;
	@Column
	private Date lastupdatetime;
	

	public Date getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

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

	public double getTrade() {
		return trade;
	}

	public void setTrade(double trade) {
		this.trade = trade;
	}

	public double getPricechange() {
		return pricechange;
	}

	public void setPricechange(double pricechange) {
		this.pricechange = pricechange;
	}

	public double getChangepercent() {
		return changepercent;
	}

	public void setChangepercent(double changepercent) {
		this.changepercent = changepercent;
	}

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	}

	public double getSettlement() {
		return settlement;
	}

	public void setSettlement(double settlement) {
		this.settlement = settlement;
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

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getTicktime() {
		return ticktime;
	}

	public void setTicktime(String ticktime) {
		this.ticktime = ticktime;
	}

	public double getPer() {
		return per;
	}

	public void setPer(double per) {
		this.per = per;
	}

	public double getPb() {
		return pb;
	}

	public void setPb(double pb) {
		this.pb = pb;
	}

	public double getMktcap() {
		return mktcap;
	}

	public void setMktcap(double mktcap) {
		this.mktcap = mktcap;
	}

	public double getNmc() {
		return nmc;
	}

	public void setNmc(double nmc) {
		this.nmc = nmc;
	}

	public double getTurnoverratio() {
		return turnoverratio;
	}

	public void setTurnoverratio(double turnoverratio) {
		this.turnoverratio = turnoverratio;
	}

}
