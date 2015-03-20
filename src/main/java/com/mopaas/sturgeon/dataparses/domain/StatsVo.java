package com.mopaas.sturgeon.dataparses.domain;

import java.util.List;

public class StatsVo {
	private List<String> labels ;
    private List<StatsDetailVo> datasets;

	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public List<StatsDetailVo> getDatasets() {
		return datasets;
	}
	public void setDatasets(List<StatsDetailVo> datasets) {
		this.datasets = datasets;
	}

    
    
			
   

}
