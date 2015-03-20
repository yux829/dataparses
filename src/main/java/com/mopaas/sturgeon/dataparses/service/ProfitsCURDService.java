package com.mopaas.sturgeon.dataparses.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mopaas.sturgeon.dataparses.domain.Profits;

@Service
public class ProfitsCURDService {
	@Autowired
	private Dao dao;
	@Autowired
	private ProfitsLoadDataService service;

	@Transactional
	public void getAndSave(String symbol) {
		Profits[] blist = this.service.get(symbol);
		for (Profits b : blist) {
			this.save(b);
		}
	}

	private void save(Profits b) {
		if (this.dao.fetchx(Profits.class, b.getSymbol(), b.getCurdate()) != null) {
			this.dao.update(b);
		} else {
			this.dao.insert(b);
		}
	}

	public List<Profits> queryListByDate(String symbol, String curdate_suffix) {
		String wrapsql="symbol='"+symbol+"' AND CURDATE LIKE '%"+curdate_suffix+"' ORDER BY CURDATE DESC";
		return dao.query(Profits.class, Cnd.wrap(wrapsql));
	}
}
