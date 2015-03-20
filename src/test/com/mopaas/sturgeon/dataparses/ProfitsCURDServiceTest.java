package com.mopaas.sturgeon.dataparses;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.json.Json;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.domain.DailyInfo;
import com.mopaas.sturgeon.dataparses.domain.Profits;
import com.mopaas.sturgeon.dataparses.service.DailyService;
import com.mopaas.sturgeon.dataparses.service.ProfitsCURDService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ProfitsCURDServiceTest {
	@Resource
	private ProfitsCURDService s;

	@Resource
	private DailyService ds;


	public void testGetAndSave() {
		List<DailyInfo> list = ds.getAll();
		for (DailyInfo d : list) {
			try {
				s.getAndSave(d.getCode());
				System.out.println(d.getCode() +"            is ok..........");

			} catch (Exception e) {
				System.out.println("error:"+ d.getCode() +e.getMessage());
			}
		}
	}
	
	
	public void testGetAndSaveOther() {
		List<DailyInfo> list = ds.getNotInProfits();
		for (DailyInfo d : list) {
			try {
				s.getAndSave(d.getCode());
				System.out.println(d.getCode() +"            is ok..........");

			} catch (Exception e) {
				System.out.println("error:"+ d.getCode() +"........."+e.getMessage());
			}
		}
	}
	@Test
	public void testqueryListByDate(){
		String symbol="300427";
		String curdate_suffix="1231";
		
		 List<Profits>  list = s.queryListByDate(symbol, curdate_suffix);
		 for(Profits p:list){
			 System.out.println(Json.toJson(p));
		 }
	}
}
