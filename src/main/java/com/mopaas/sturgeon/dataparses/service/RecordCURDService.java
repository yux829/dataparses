package com.mopaas.sturgeon.dataparses.service;

import java.util.Date;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopaas.sturgeon.dataparses.domain.FundTrade;
import com.mopaas.sturgeon.dataparses.domain.RecordDomain;

@Service
public class RecordCURDService {
	@Autowired
	private Dao dao;

	public void save(RecordDomain rd) {
		rd.setLastUpdateTime(new Date());
		if (this.dao.fetchx(RecordDomain.class, rd.getName(),
				rd.getTrade_date()) != null) {
			this.dao.update(rd);
		} else {
			this.dao.insert(rd);
		}
	}

	public List<RecordDomain> list(String name) {
		return dao.query(RecordDomain.class,
				Cnd.wrap("name='" + name + "' ORDER BY trade_date  "));
	}

	public long queryTotalAsset(String trade_date) {
		double total = 0;
		List<RecordDomain> list = dao.query(
				RecordDomain.class,
				Cnd.wrap("name in ('" + RecordDomain.NAME_MY1 + "','"
						+ RecordDomain.NAME_MY2 + "','" + RecordDomain.NAME_MY3
						+ "') and trade_date='" + trade_date + "'"));
		for (RecordDomain r : list) {
			total += r.getAsset();
		}
		return HelpUtils.double2long(total);

	}
}
