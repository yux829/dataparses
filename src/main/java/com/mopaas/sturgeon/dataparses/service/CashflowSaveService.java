package com.mopaas.sturgeon.dataparses.service;

import java.util.Date;
import java.util.List;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mopaas.sturgeon.dataparses.domain.CashflowDomain;

@Service
public class CashflowSaveService {
	@Autowired
	private Dao dao;
	@Transactional
	public void getAndSave(String symbol,String name) {
		List<CashflowDomain> bdlist = CashflowLoadDataService.parse(symbol);
		for (CashflowDomain bd : bdlist) {
			bd.setSymbol(symbol);
			bd.setName(name);
			this.save(bd);
		}
	}


	private void save(CashflowDomain bd) {
		bd.setLastUpdateTime(new Date());
		if (this.dao.fetchx(CashflowDomain.class, bd.getSymbol(),bd.getCurdate()) != null) {
			this.dao.update(bd);
		} else {
			this.dao.insert(bd);
		}
	}
}
