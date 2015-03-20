package com.mopaas.sturgeon.dataparses;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.service.BlanceSaveService;
import com.mopaas.sturgeon.dataparses.service.CashflowSaveService;
import com.mopaas.sturgeon.dataparses.service.IncomeSaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AllSaveServiceTest {
	@Resource
    private BlanceSaveService bss;
	@Resource
	private IncomeSaveService iss;
	@Resource
	private CashflowSaveService css;
	@Test
	public void getAndSave() {
		String code="SINA";
		this.bss.getAndSave(code,null);
		this.iss.getAndSave(code,null);
		this.css.getAndSave(code,null);
		
	}
}
