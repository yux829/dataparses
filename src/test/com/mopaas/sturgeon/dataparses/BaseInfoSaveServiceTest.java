package com.mopaas.sturgeon.dataparses;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.service.BaseInfoSaveService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BaseInfoSaveServiceTest {
	@Resource
	private BaseInfoSaveService s;

	@Test
	public void getAndSave() {
		this.s.getAllAndSave();
	}
}
