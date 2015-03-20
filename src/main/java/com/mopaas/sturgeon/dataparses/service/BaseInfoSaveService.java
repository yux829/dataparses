package com.mopaas.sturgeon.dataparses.service;

import java.util.Date;
import java.util.List;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mopaas.sturgeon.dataparses.domain.BaseInfoDomain;

@Service
public class BaseInfoSaveService {
	@Autowired
	private Dao dao;

	public void getAllAndSave() {
		for (int pageno = 1; pageno <= BaseInfoLoadDataService.PAGENO_MAX; pageno++) {
			this.getAndSave(pageno);
			System.out.println(" save ok ,pageno: "+pageno);
		}
	}

	@Transactional
	public void getAndSave(int pageno) {
		BaseInfoDomain[] bdlist = BaseInfoLoadDataService.getList(pageno);
		for (BaseInfoDomain bd : bdlist) {
			this.save(bd);
		}
	}

	private void save(BaseInfoDomain bd) {
		bd.setLastUpdateTime(new Date());
		if (this.dao.fetch(BaseInfoDomain.class, bd.getSymbol()) != null) {
			this.dao.update(bd);
		} else {
			this.dao.insert(bd);
		}
	}

}
