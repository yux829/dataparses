package com.mopaas.sturgeon.dataparses;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.json.Json;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.domain.Balances;
import com.mopaas.sturgeon.dataparses.service.BalancesNewLoadDataService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BalancesNewLoadDataServiceTest {
	@Resource
	private BalancesNewLoadDataService s;

	@Test
	public void testGet() {
		Balances[] blist=s.get("000001");
		for(Balances b:blist){
			System.out.println(Json.toJson(b));
		}
	}

}
