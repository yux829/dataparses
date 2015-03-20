package com.mopaas.sturgeon.dataparses;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.domain.FundTrade;
import com.mopaas.sturgeon.dataparses.domain.PieStatsVo;
import com.mopaas.sturgeon.dataparses.domain.StatTotalDatas;
import com.mopaas.sturgeon.dataparses.domain.StatTotalTags;
import com.mopaas.sturgeon.dataparses.domain.StatsVo;
import com.mopaas.sturgeon.dataparses.service.FundTradeQueryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class FundTradeQueryServiceTest {
	@Autowired
	private FundTradeQueryService s;

	public void testStatsTotal() {
		List<StatTotalDatas> list = s.statsTotal();
		for (StatTotalDatas s : list) {
			System.out.println(Json.toJson(s));
		}
	}
	
	public void teststatsTotalTags() {
		List<StatTotalTags> list = s.statsTotalTags("2014-12-24");
		for (StatTotalTags s : list) {
			System.out.println(Json.toJson(s));
		}
	}
	@Test
	public void testqueryPieTagStats(){
		List<PieStatsVo> list=s.queryPieTagStats("2014-12-24");
		System.out.println(Json.toJson(list));
	}

	public void teststatsOne() {
		List<StatTotalDatas> list = s.statsOne("150178");
		for (StatTotalDatas s : list) {
			System.out.println(Json.toJson(s));
		}
	}

	
	public void testqueryTop10ListByTradetime() {
		List<FundTrade> list = s.queryTop10ListByTradetime("2014-12-19");
		for (FundTrade s : list) {
			System.out.println(Json.toJson(s));
		}
	}
	
	public void testqueryAllStats(){
		StatsVo vo =s.queryAllStats();
		System.out.println(Json.toJson(vo));
		
	}

}
