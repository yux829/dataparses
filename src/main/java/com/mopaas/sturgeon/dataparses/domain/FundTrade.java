package com.mopaas.sturgeon.dataparses.domain;



import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;
@Table("t_fundtrades")
@PK({"symbol","tradetime"})
public class FundTrade {
	public final static String URL_FUN_SEG = "http://hq.sinajs.cn/rn=3pa4l&list=sz${CODE}";
	public final static String URL_FUN_SEG_HIS = "http://money.finance.sina.com.cn/quotes_service/view/vMS_tradehistory.php?symbol=sz${CODE}&date=${TRADETIME}";
	public final static String URL_FUN_SEG_JISILU="http://www.jisilu.cn/jisiludata/fundB.php?___t=${TRADETIME}";
	
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
	private String tradetime;
	@Column
	private Date lastupdatetime;
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
	
	public String getTradetime() {
		return tradetime;
	}
	public void setTradetime(String tradetime) {
		this.tradetime = tradetime;
	}
	public Date getLastupdatetime() {
		return lastupdatetime;
	}
	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	

}
