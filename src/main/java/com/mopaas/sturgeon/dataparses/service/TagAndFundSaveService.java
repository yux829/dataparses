package com.mopaas.sturgeon.dataparses.service;

import java.util.List;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mopaas.sturgeon.dataparses.domain.FundTradeJisilu;
import com.mopaas.sturgeon.dataparses.domain.Tags;

@Service
public class TagAndFundSaveService {
	@Autowired
	private Dao dao;

	@Transactional
	public void getAndsaveTagsFunds() {
		List<FundTradeJisilu> bdlist = FundTradeLoadService.parseFromjisulu();
		dao.clear(Tags.class);
		for (FundTradeJisilu f : bdlist) {
			Tags t = new Tags();
			t.setSymbol(f.getFundb_id());
			t.setTagtype(Tags.TYPE_INDEX);
			t.setTagname(f.getFundb_index_name());
			t.setTagcode(f.getFundb_index_id());
			t.setName(f.getFundb_name());
			if (HelpUtils.str2Double(f.getFundb_volume()) >= 500
					&& isIndex(t.getTagname()))
				saveTags(t);

		}
	}

	private boolean isIndex(String indexname) {
		if (indexname.indexOf("债") > -1 || indexname.indexOf("恒生") > -1
				|| indexname.indexOf("主动") > -1) {
			return false;
		}
		return true;
	}

	private void saveTags(Tags t) {
		if (this.dao.fetchx(Tags.class, t.getSymbol(), t.getTagcode(),
				t.getTagtype()) != null) {
			this.dao.update(t);
		} else {
			this.dao.insert(t);
		}
	}



}
