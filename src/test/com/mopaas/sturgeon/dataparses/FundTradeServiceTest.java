package com.mopaas.sturgeon.dataparses;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.domain.FundTrade;
import com.mopaas.sturgeon.dataparses.domain.StatTotalDatas;
import com.mopaas.sturgeon.dataparses.domain.Tags;
import com.mopaas.sturgeon.dataparses.service.DateNoHolidaysUtils;
import com.mopaas.sturgeon.dataparses.service.DateUtils;
import com.mopaas.sturgeon.dataparses.service.FundSaveService;
import com.mopaas.sturgeon.dataparses.service.FundTradeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class FundTradeServiceTest {
	@Autowired
	private FundTradeService s;
	@Autowired
	private FundSaveService sdao;


	@Test
	public void getAndSave() {
		String starttime = "2014-12-19";
		String endtime = DateUtils.getCurTimeStr();
		List<Tags> flist = s.getAllTags();
		for (Tags f : flist) {
//			List<Date> dlist = s.queryDestDate(starttime, endtime,f.getSymbol());
			List<Date> dlist =DateNoHolidaysUtils.getWeekDayslist(starttime, endtime);
			for (Date d : dlist) {
				String dstr = DateUtils.date2String(d,
						DateUtils.DATE_FORMAT_DAY);
				try {
					s.getAndSave(f.getSymbol(), f.getName(), dstr);
					System.out.println("......" + f.getSymbol() + ".." + dstr
							+ "...ok...");

				} catch (Exception e) {
					System.out.println("......" + f.getSymbol() + "..." + dstr
							+ "....error...");
					System.out.println(e.getMessage());
				}
			}

		}
	}
	
	public void getAndSaveSpeci() {
		String code = "150208";
		String time = "2014-12-22";
		Tags t = s.getTags(code);
		s.getAndSave(code, t.getName(), time);

	}

}
