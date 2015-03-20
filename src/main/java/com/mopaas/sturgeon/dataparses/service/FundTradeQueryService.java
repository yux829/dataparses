package com.mopaas.sturgeon.dataparses.service;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopaas.sturgeon.dataparses.domain.FundTrade;
import com.mopaas.sturgeon.dataparses.domain.PieStatsVo;
import com.mopaas.sturgeon.dataparses.domain.StatTotalDatas;
import com.mopaas.sturgeon.dataparses.domain.StatTotalTags;
import com.mopaas.sturgeon.dataparses.domain.StatsDetailVo;
import com.mopaas.sturgeon.dataparses.domain.StatsVo;

@Service
public class FundTradeQueryService {

	@Autowired
	private Dao dao;
	
	public List<PieStatsVo> queryPieTagStats(String tradetime){
		List<StatTotalTags>  list=statsTotalTags(tradetime);
		List<PieStatsVo> plist= new ArrayList<PieStatsVo>();
		for(StatTotalTags s:list){
			PieStatsVo p = new PieStatsVo(s.getAmount_rate(),HelpUtils.getRandColorCode(),s.getTagname());
			plist.add(p);
		}
		return plist;
	}

	public StatsVo queryAllStats() {
		StatsVo totalstats = new StatsVo();
		List<StatsDetailVo> datasets = new ArrayList<StatsDetailVo>();
		List<String> labels = new ArrayList<String>();
		List<Double> amount_data = new ArrayList<Double>();
		List<Double> vol_data = new ArrayList<Double>();
		String amount_color = "rgba(0,0,128,1)";
		String vol_color = "rgba(151,187,205,1)";
		List<StatTotalDatas> list = statsTotal();
		for (StatTotalDatas s : list) {
			labels.add(s.getTradetime());
			amount_data.add(HelpUtils.str2Double(String.valueOf(s
					.getAll_amount())));
			vol_data.add(HelpUtils.str2Double(String.valueOf(s.getAll_vol())));

		}
		StatsDetailVo amount_detail = new StatsDetailVo();
		amount_detail.setData(amount_data);
		amount_detail.setPointColor(amount_color);
		amount_detail.setStrokeColor(amount_color);
		datasets.add(amount_detail);
		StatsDetailVo vol_detail = new StatsDetailVo();
		vol_detail.setData(vol_data);
		vol_detail.setPointColor(vol_color);
		vol_detail.setStrokeColor(vol_color);
		datasets.add(vol_detail);
		totalstats.setLabels(labels);
		totalstats.setDatasets(datasets);

		// System.out.println(Json.toJson(totalstats));
		return totalstats;
	}

	public StatsVo queryAvg_priceStats() {
		StatsVo totalstats = new StatsVo();
		List<StatsDetailVo> datasets = new ArrayList<StatsDetailVo>();
		List<String> labels = new ArrayList<String>();
		List<Double> avg_data = new ArrayList<Double>();
		String color_avg_data = "rgba(139,0,0,1)";

		List<StatTotalDatas> list = statsTotal();
		for (StatTotalDatas s : list) {
			labels.add(s.getTradetime());
			avg_data.add(HelpUtils.str2Double(String.valueOf(s.getAvg_trade())));

		}
		StatsDetailVo amount_detail = new StatsDetailVo();
		amount_detail.setData(avg_data);
		amount_detail.setPointColor(color_avg_data);
		amount_detail.setStrokeColor(color_avg_data);
		datasets.add(amount_detail);
		totalstats.setLabels(labels);
		totalstats.setDatasets(datasets);

		return totalstats;
	}

	public List<StatTotalDatas> statsTotal() {
		Sql sql = Sqls.create(StatTotalDatas.SQL_ALL_STATS);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(StatTotalDatas.class));
		dao.execute(sql);
		List<StatTotalDatas> list = sql.getList(StatTotalDatas.class);
		return list;
	}

	public List<StatTotalDatas> statsOne(String code) {
		Sql sql = Sqls.create(StatTotalDatas.SQL_ONE_STATS);
		sql.params().set("code", code);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(StatTotalDatas.class));
		dao.execute(sql);
		List<StatTotalDatas> list = sql.getList(StatTotalDatas.class);
		return list;
	}

	public List<StatTotalTags> statsTotalTags(String tradetime) {
		Sql sql = Sqls.create(StatTotalTags.SQL_SEG_TOTAL_TAGS);
		sql.params().set("tradetime", tradetime);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(StatTotalTags.class));
		dao.execute(sql);
		List<StatTotalTags> list = sql.getList(StatTotalTags.class);
		return list;
	}

	public List<FundTrade> queryTop10ListByTradetime(String tradetime) {
		return dao.query(
				FundTrade.class,
				Cnd.wrap("tradetime='" + tradetime
						+ "' ORDER BY amount DESC  LIMIT 0, 10  "));
	}
}
