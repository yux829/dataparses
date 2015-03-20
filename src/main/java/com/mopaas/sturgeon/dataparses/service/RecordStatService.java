package com.mopaas.sturgeon.dataparses.service;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopaas.sturgeon.dataparses.domain.RecordDomain;

import com.mopaas.sturgeon.dataparses.domain.StatsDetailVo;
import com.mopaas.sturgeon.dataparses.domain.StatsVo;

@Service
public class RecordStatService {
	@Autowired
	private Dao dao;
	@Autowired
	private RecordCURDService s;

	public double queryTotalAsset(String trade_date) {
		return s.queryTotalAsset(trade_date);
	}

	public StatsVo queryNetAsset(){
		StatsVo totalstats = new StatsVo();
		List<StatsDetailVo> datasets = new ArrayList<StatsDetailVo>();
		List<String> labels = new ArrayList<String>();
		List<Double> my1_data = new ArrayList<Double>();
		String my1_color = "rgba(255,0,0,1)";
		List<RecordDomain> list1 = s.list(RecordDomain.NAME_MY1);
		for (RecordDomain r : list1) {
			labels.add(r.getTrade_date());
			long total=s.queryTotalAsset(r.getTrade_date());
			my1_data.add(HelpUtils.str2Double(String.valueOf(total)));

		}
		StatsDetailVo my1_detail = new StatsDetailVo();
		my1_detail.setData(my1_data);
		my1_detail.setPointColor(my1_color);
		my1_detail.setStrokeColor(my1_color);
		datasets.add(my1_detail);
		totalstats.setLabels(labels);
		totalstats.setDatasets(datasets);
		return totalstats;
	}
	
	public StatsVo queryNetValue() {
		StatsVo totalstats = new StatsVo();
		List<StatsDetailVo> datasets = new ArrayList<StatsDetailVo>();

		List<String> labels = new ArrayList<String>();
		List<Double> my1_data = new ArrayList<Double>();
		String my1_color = "rgba(255,0,0,1)";
		List<RecordDomain> list1 = s.list(RecordDomain.NAME_MY1);
		for (RecordDomain s : list1) {
			labels.add(s.getTrade_date());
			my1_data.add(HelpUtils.str2Double(String.valueOf(s.getNetvalue())));

		}
		StatsDetailVo my1_detail = new StatsDetailVo();
		my1_detail.setData(my1_data);
		my1_detail.setPointColor(my1_color);
		my1_detail.setStrokeColor(my1_color);
		datasets.add(my1_detail);

		List<Double> my2_data = new ArrayList<Double>();
		String my2_color = "rgba(255,0,255,1)";
		List<RecordDomain> list2 = s.list(RecordDomain.NAME_MY2);
		for (RecordDomain s : list2) {
			my2_data.add(HelpUtils.str2Double(String.valueOf(s.getNetvalue())));

		}
	
		StatsDetailVo my2_detail = new StatsDetailVo();
		my2_detail.setData(my2_data);
		my2_detail.setPointColor(my2_color);
		my2_detail.setStrokeColor(my2_color);
		datasets.add(my2_detail);
		/*
		List<Double> my4_data = new ArrayList<Double>();
		String my4_color = "rgba(0,0,255,1)";
		List<RecordDomain> list4 = s.list(RecordDomain.NAME_MY3);
		for (RecordDomain s : list4) {
			my4_data.add(HelpUtils.str2Double(String.valueOf(s.getNetvalue())));

		}
		StatsDetailVo my4_detail = new StatsDetailVo();
		my4_detail.setData(my4_data);
		my4_detail.setPointColor(my4_color);
		my4_detail.setStrokeColor(my4_color);
		datasets.add(my4_detail);
*/
		List<Double> my3_data = new ArrayList<Double>();
		String my3_color = "rgba(0,255,0,1)";
		List<RecordDomain> list3 = s.list(RecordDomain.NAME_HS300);
		for (RecordDomain s : list3) {
			my3_data.add(HelpUtils.str2Double(String.valueOf(s.getNetvalue())));

		}
		StatsDetailVo my3_detail = new StatsDetailVo();
		my3_detail.setData(my3_data);
		my3_detail.setPointColor(my3_color);
		my3_detail.setStrokeColor(my3_color);
		datasets.add(my3_detail);

		totalstats.setLabels(labels);
		totalstats.setDatasets(datasets);

		// System.out.println(Json.toJson(totalstats));
		return totalstats;
	}

}
