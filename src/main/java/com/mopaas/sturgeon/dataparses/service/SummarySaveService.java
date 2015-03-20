package com.mopaas.sturgeon.dataparses.service;

import java.util.List;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mopaas.sturgeon.dataparses.domain.SummaryInfo;

@Service
public class SummarySaveService {
	@Autowired
	private Dao dao;

	@Transactional
	public void getAndSave(String code) {
		List<SummaryInfo> bdlist = SummaryLoadDataService.parse(code);
		for (SummaryInfo bd : bdlist) {
			this.save(bd);
		}
	}

	private void save(SummaryInfo bd) {
		bd.setLastupdatetime(DateUtils.getCurTime());
		if (this.dao
				.fetchx(SummaryInfo.class, bd.getCode(), bd.getPublictime()) != null) {
			this.dao.update(bd);
		} else {
			this.dao.insert(bd);
		}
	}
}
