package com.mopaas.sturgeon.dataparses.domain;

public class StatTotalDatas {
	public final static String SQL_ALL_STATS = "SELECT f.tradetime ,ROUND(SUM(f.amount/1000000000),2)  all_amount ,ROUND(SUM(f.volume/1000000000),2) all_vol,"
			+ "ROUND(SUM(f.amount)/SUM(f.volume) ,2) avg_trade FROM t_fundtrades f ,t_tags t WHERE t.symbol=f.symbol AND "
			+ "STR_TO_DATE(f.tradetime,'%Y-%m-%d') > ADDDATE(CURDATE(),-60) GROUP BY f.tradetime ORDER BY f.tradetime";
	
	
	public final static String SQL_ONE_STATS="SELECT f.tradetime, f.amount all_amount , f.volume all_vol, ROUND(f.amount /f.volume, 2) avg_trade" +
			" FROM t_fundtrades f WHERE STR_TO_DATE(f.tradetime,'%Y-%m-%d') > ADDDATE(CURDATE(), - 90) AND f.symbol =@code " +
			" ORDER BY f.tradetime";

	private double all_amount;
	private double all_vol;
	private String tradetime;
	private double avg_trade;
	public double getAll_amount() {
		return all_amount;
	}
	public void setAll_amount(double all_amount) {
		this.all_amount = all_amount;
	}
	public double getAll_vol() {
		return all_vol;
	}
	public void setAll_vol(double all_vol) {
		this.all_vol = all_vol;
	}
	public String getTradetime() {
		return tradetime;
	}
	public void setTradetime(String tradetime) {
		this.tradetime = tradetime;
	}
	public double getAvg_trade() {
		return avg_trade;
	}
	public void setAvg_trade(double avg_trade) {
		this.avg_trade = avg_trade;
	}


}
