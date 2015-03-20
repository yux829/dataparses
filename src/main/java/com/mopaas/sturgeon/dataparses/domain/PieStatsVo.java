package com.mopaas.sturgeon.dataparses.domain;

public class PieStatsVo {
	public final static String COLOR_RED="#561612";
	public final static String COLOR_ORAGONE="#565212";
	public final static String COLOR_YELLOW="#f7ed45";
	public final static String COLOR_GREEN="#45f74e";
	public final static String COLOR_QIN="#c0f745";
	public final static String COLOR_BLUE="#4567f7";
	public final static String COLOR_ZI="#d245f7";
	
	
	public PieStatsVo(double value, String color, String label) {
		this.value = value;
		this.color = color;
		this.label = label;
	}

	private double value;
	private String color;
	private String label;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
