package com.mopaas.sturgeon.dataparses.service;

import java.util.Date;
import java.util.List;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mopaas.sturgeon.dataparses.domain.BalanceDomain;

@Service
public class BlanceSaveService {
	@Autowired
	private Dao dao;

	public List<BalanceDomain> queryList() {
		return this.dao.query(BalanceDomain.class, null);
	}

	@Transactional
	public void getAndSave(String symbol,String name) {
		List<BalanceDomain> bdlist = BalanceLoadDataService.parse(symbol);
		for (BalanceDomain bd : bdlist) {
			bd.setSymbol(symbol);
			bd.setName(name);
			this.save(bd);
		}
	}


	private void save(BalanceDomain bd) {
		bd.setLastUpdateTime(new Date());
		if (this.dao.fetchx(BalanceDomain.class, bd.getSymbol(),bd.getCurdate()) != null) {
			this.dao.update(bd);
		} else {
			this.dao.insert(bd);
		}
	}

}
