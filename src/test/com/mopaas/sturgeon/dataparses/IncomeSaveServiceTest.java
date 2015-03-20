package com.mopaas.sturgeon.dataparses;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.mopaas.sturgeon.dataparses.service.IncomeSaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class IncomeSaveServiceTest {
	@Autowired
	private IncomeSaveService s;
	@Test
	public void getAndSave() {
//		this.s.getAndSave("YY","欢聚时代");
		this.s.getAndSave("BIDU","百度");
	}
}
