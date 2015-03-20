package com.mopaas.sturgeon.dataparses;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.service.TagAndFundSaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TagAndFundSaveServiceTest {
	@Autowired
	private TagAndFundSaveService s;

	@Test
	public void testsave() {
		s.getAndsaveTagsFunds();
	}
}
