package com.mopaas.sturgeon.dataparses.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;

@Table("t_funds")
@PK({"symbol","nav_date"})
public class Fund {
	public final static String URL = "http://vip.stock.finance.sina.com.cn/fund_center/data/jsonp.php/IO.XSRV2.CallbackList['yhGsXJfHQCfxvkRb']/NetValue_Service.getNetValueCX?page=1&num=200&sort=nav_date&asc=0&ccode=&type2=8&type3=";
/**
 * symbol:150124,sname:"建信央视财经50指数分级B",per_nav:"1.2523",nav_date:"2014-12-15",total_nav:"1.2523",nav_rate:1.1469,
 * discount_rate:"4.27268",start_date:"2013-03-28",end_date:"",fund_manager:"叶乐天",jjlx:"偏股型基金",zjzfe:"161747"
 * 序号	基金代码	基金名称	         单位净值	累计净值	增长率(%)	折溢价率(%)	净值日期	成立日期	基金经理	
 * 1	150124	建信央视财经50指数分级B		1.2523	1.2523		1.1469		4.2727		2014-12-15	2013-03-28	叶乐天
 */
	@Column
	private String symbol;
	@Column
	private String nav_date;
	@Column
	private String sname;
	@Column
	private double per_nav;
	@Column
	private double total_nav;
	@Column
	private double nav_rate;
	@Column
	private String discount_rate;
	@Column
	private String start_date;
	@Column
	private String end_date;
	@Column
	private String fund_manager;
	@Column
	private String jjlx;
	@Column
	private String zjzfe;
	
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getNav_date() {
		return nav_date;
	}
	public void setNav_date(String nav_date) {
		this.nav_date = nav_date;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getPer_nav() {
		return per_nav;
	}
	public void setPer_nav(double per_nav) {
		this.per_nav = per_nav;
	}
	public double getTotal_nav() {
		return total_nav;
	}
	public void setTotal_nav(double total_nav) {
		this.total_nav = total_nav;
	}
	public double getNav_rate() {
		return nav_rate;
	}
	public void setNav_rate(double nav_rate) {
		this.nav_rate = nav_rate;
	}
	public String getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(String discount_rate) {
		this.discount_rate = discount_rate;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getFund_manager() {
		return fund_manager;
	}
	public void setFund_manager(String fund_manager) {
		this.fund_manager = fund_manager;
	}
	public String getJjlx() {
		return jjlx;
	}
	public void setJjlx(String jjlx) {
		this.jjlx = jjlx;
	}
	public String getZjzfe() {
		return zjzfe;
	}
	public void setZjzfe(String zjzfe) {
		this.zjzfe = zjzfe;
	}
	

}
