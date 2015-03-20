package com.mopaas.sturgeon.dataparses;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.json.Json;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mopaas.sturgeon.dataparses.service.FinanceQueryService;
import com.mopaas.sturgeon.dataparses.vo.FinanceQueryVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class FinanceQueryServiceTest {
	@Resource
	private FinanceQueryService s;

	@Test
	public void testquerylList() {
		String symbol = "300058";
		String curdate_suffix = "1231";
		List<FinanceQueryVo> list = s.queryList(symbol, curdate_suffix);
		for (FinanceQueryVo p : list) {
			System.out.println(Json.toJson(p));
		}
	}
}
