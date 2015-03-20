package com.mopaas.sturgeon.dataparses.domain;

import java.util.List;

public class StatsDetailVo {
	private String strokeColor;
	private String pointColor;
	private List<Double> data;
	public String getStrokeColor() {
		return strokeColor;
	}
	public void setStrokeColor(String strokeColor) {
		this.strokeColor = strokeColor;
	}
	public String getPointColor() {
		return pointColor;
	}
	public void setPointColor(String pointColor) {
		this.pointColor = pointColor;
	}
	public List<Double> getData() {
		return data;
	}
	public void setData(List<Double> data) {
		this.data = data;
	}

	
	
}
