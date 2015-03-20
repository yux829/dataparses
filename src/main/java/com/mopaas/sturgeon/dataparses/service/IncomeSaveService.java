package com.mopaas.sturgeon.dataparses.service;

import java.util.Date;
import java.util.List;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mopaas.sturgeon.dataparses.domain.IncomeDomain;
@Service
public class IncomeSaveService {
	@Autowired
	private Dao dao;
	@Transactional
	public void getAndSave(String symbol,String name) {
		List<IncomeDomain> bdlist = IncomeLoadDataService.parse(symbol);
		for (IncomeDomain bd : bdlist) {
			bd.setSymbol(symbol);
			bd.setName(name);
			this.save(bd);
		}
	}


	private void save(IncomeDomain bd) {
		bd.setLastUpdateTime(new Date());
		if (this.dao.fetchx(IncomeDomain.class, bd.getSymbol(),bd.getCurdate()) != null) {
			this.dao.update(bd);
		} else {
			this.dao.insert(bd);
		}
	}
}
