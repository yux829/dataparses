package com.mopaas.sturgeon.dataparses.domain;

public class StatTotalTags {
	public final static String SQL_SEG_TOTAL_TAGS = "SELECT t1.*, ROUND(t1.all_amount*100/t2.total_amount,2) amount_rate ," +
			" ROUND(t1.all_vol*100/t2.total_vol,2) vol_rate FROM (SELECT t.tagname ,SUM(f.amount) all_amount ,SUM(f.volume) all_vol" +
			" FROM t_fundtrades f ,t_tags t WHERE t.symbol=f.symbol AND f.tradetime=@tradetime AND t.tagtype='00'" +
			" GROUP BY t.tagname)t1,(SELECT SUM(f.amount) total_amount ,SUM(f.volume) total_vol FROM t_fundtrades f ,t_tags t" +
			" WHERE t.symbol=f.symbol AND f.tradetime=@tradetime AND t.tagtype='00')t2 ORDER BY t1.all_amount DESC ";

	private String tagname;
	private long all_amount;
	private long all_vol;
	private double amount_rate;
	private double vol_rate;
	

	public double getAmount_rate() {
		return amount_rate;
	}

	public void setAmount_rate(double amount_rate) {
		this.amount_rate = amount_rate;
	}

	public double getVol_rate() {
		return vol_rate;
	}

	public void setVol_rate(double vol_rate) {
		this.vol_rate = vol_rate;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public long getAll_amount() {
		return all_amount;
	}

	public void setAll_amount(long all_amount) {
		this.all_amount = all_amount;
	}

	public long getAll_vol() {
		return all_vol;
	}

	public void setAll_vol(long all_vol) {
		this.all_vol = all_vol;
	}

}
