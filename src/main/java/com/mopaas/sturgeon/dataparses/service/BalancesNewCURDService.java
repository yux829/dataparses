package com.mopaas.sturgeon.dataparses.service;


import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mopaas.sturgeon.dataparses.domain.Balances;


@Service
public class BalancesNewCURDService {
	@Autowired
	private Dao dao;
	@Autowired
	private BalancesNewLoadDataService service;

	@Transactional
	public void getAndSave(String symbol) {
		Balances[] blist = this.service.get(symbol);
		for (Balances b : blist) {
			this.save(b);
		}
	}


	private void save(Balances b) {
		if (this.dao.fetchx(Balances.class, b.getSymbol(), b.getCurdate()) != null) {
			this.dao.update(b);
		} else {
			this.dao.insert(b);
		}
	}
}
