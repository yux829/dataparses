package com.mopaas.sturgeon.dataparses.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mopaas.sturgeon.dataparses.domain.Fund;

@Service
public class FundSaveService {
	@Autowired
	private Dao dao;

	@Transactional
	public void getAndSave() {
		Fund[] bdlist = FundLoadService.parse();
		for (Fund bd : bdlist) {
			this.save(bd);
		}
	}

	private void save(Fund bd) {
		if (this.dao.fetchx(Fund.class, bd.getSymbol(), bd.getNav_date()) != null) {
			this.dao.update(bd);
		} else {
			this.dao.insert(bd);
		}
	}

	public List<Fund> getAllByDate(String date) {
		return dao.query(Fund.class, Cnd.wrap("nav_date='" + date + "'"));
	}
}
