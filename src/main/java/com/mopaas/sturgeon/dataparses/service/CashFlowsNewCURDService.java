package com.mopaas.sturgeon.dataparses.service;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mopaas.sturgeon.dataparses.domain.CashFlows;

@Service
public class CashFlowsNewCURDService {
	@Autowired
	private Dao dao;
	@Autowired
	private CashFlowsNewLoadDataService service;

	@Transactional
	public void getAndSave(String symbol) {
		CashFlows[] blist = this.service.get(symbol);
		for (CashFlows b : blist) {
			this.save(b);
		}
	}

	private void save(CashFlows b) {
		if (this.dao.fetchx(CashFlows.class, b.getSymbol(), b.getCurdate()) != null) {
			this.dao.update(b);
		} else {
			this.dao.insert(b);
		}
	}
}
