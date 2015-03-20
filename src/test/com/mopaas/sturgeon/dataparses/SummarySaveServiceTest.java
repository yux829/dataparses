package com.mopaas.sturgeon.dataparses;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.domain.DailyInfo;
import com.mopaas.sturgeon.dataparses.service.DailyService;
import com.mopaas.sturgeon.dataparses.service.SummarySaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SummarySaveServiceTest {
	@Autowired
	private SummarySaveService ss;
	@Autowired
	private DailyService ds;

	@Test
	public void getAndSave() {
//		List<DailyInfo> dlist = ds.getDestList();
		List<DailyInfo> dlist = ds.getAll();
		System.out.println("size:"+dlist.size());
		for (DailyInfo d : dlist) {
			System.out.println(""+d.getCode() +" is start...........");
			try{
			ss.getAndSave(d.getCode());
			}catch(Exception e){
				System.out.println(""+d.getCode() +" is error..........."+e.getMessage());
				continue;
			}
		}

	}
}
