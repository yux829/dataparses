package com.mopaas.sturgeon.dataparses.service;

import java.util.Date;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopaas.sturgeon.dataparses.domain.News;

@Service
public class NewsCURDService {
	@Autowired
	private Dao dao;

	public void save(News n) {
		n.setLastUpdateTime(new Date());
		if (this.dao.fetch(News.class, n.getId()) != null) {
			this.dao.update(n);
		} else {
			this.dao.insert(n);
		}
	}

}
