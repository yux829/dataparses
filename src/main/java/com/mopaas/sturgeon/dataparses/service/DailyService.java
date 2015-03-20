package com.mopaas.sturgeon.dataparses.service;

import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mopaas.sturgeon.dataparses.domain.DailyInfo;

@Service
public class DailyService {
	@Autowired
	private Dao dao;

	@Transactional
	public void getAndSave() {
		DailyInfo[] bdlist = DailyLoadADataService.parse();
		for (DailyInfo bd : bdlist) {
			this.save(bd);
		}
	}

	public List<DailyInfo> getAll() {
		return this.dao.query(DailyInfo.class, null);
	}

	public List<DailyInfo> getDestList() {
		Sql sql = Sqls
				.create("SELECT CODE FROM t_dailyinfos d WHERE NOT EXISTS (SELECT 1 FROM t_summaryinfos s WHERE s.code=d.code AND s.publictime='2014-09-30')");
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(DailyInfo.class));
		dao.execute(sql);
		List<DailyInfo> list = sql.getList(DailyInfo.class);
		return list;
	}
	
	public List<DailyInfo> getNotInBalances() {
		Sql sql = Sqls
				.create("SELECT CODE FROM t_dailyinfos d WHERE NOT EXISTS (SELECT 1  FROM t_balances_new s   WHERE s.symbol = d.code)");
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(DailyInfo.class));
		dao.execute(sql);
		List<DailyInfo> list = sql.getList(DailyInfo.class);
		return list;
	}
	
	public List<DailyInfo> getNotInProfits() {
		Sql sql = Sqls
				.create("SELECT CODE FROM t_dailyinfos d WHERE NOT EXISTS (SELECT 1  FROM t_profits_new s   WHERE s.symbol = d.code)");
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(DailyInfo.class));
		dao.execute(sql);
		List<DailyInfo> list = sql.getList(DailyInfo.class);
		return list;
	}

	private void save(DailyInfo bd) {
		bd.setLastupdatetime(DateUtils.getCurTime());
		if (this.dao.fetch(DailyInfo.class, bd.getSymbol()) != null) {
			this.dao.update(bd);
		} else {
			this.dao.insert(bd);
		}
	}
}
