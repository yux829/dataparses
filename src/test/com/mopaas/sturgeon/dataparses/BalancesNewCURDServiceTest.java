package com.mopaas.sturgeon.dataparses;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.domain.DailyInfo;
import com.mopaas.sturgeon.dataparses.service.BalancesNewCURDService;
import com.mopaas.sturgeon.dataparses.service.BalancesNewLoadDataService;
import com.mopaas.sturgeon.dataparses.service.DailyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BalancesNewCURDServiceTest {
	@Resource
	private BalancesNewCURDService s;

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
	
	@Test
	public void testGetAndSaveOther() {
		List<DailyInfo> list = ds.getNotInBalances();
		for (DailyInfo d : list) {
			try {
				s.getAndSave(d.getCode());
				System.out.println(d.getCode() +"            is ok..........");

			} catch (Exception e) {
				System.out.println("error:"+ d.getCode() +"........."+e.getMessage());
			}
		}
	}

}


