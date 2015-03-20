package com.mopaas.sturgeon.dataparses;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.domain.News;
import com.mopaas.sturgeon.dataparses.service.NewsCURDService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class NewsCURDServiceTest {
	@Autowired
	private NewsCURDService s;
//
	@Test
	public void save() {
		News n = new News();
		n.setSymbol("000001");
		n.setDescription("测试");

		this.s.save(n);
	}
}
