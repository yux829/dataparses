package com.mopaas.sturgeon.dataparses;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.domain.BalanceDomain;
import com.mopaas.sturgeon.dataparses.service.BlanceSaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BlanceServiceTest  {
	
	@Resource
    private BlanceSaveService s;

	public void testquerylist() {
		this.s.queryList();
	}
	
	@Test
	public void getAndSave() {
		this.s.getAndSave("SINA","新浪");
	}

}
