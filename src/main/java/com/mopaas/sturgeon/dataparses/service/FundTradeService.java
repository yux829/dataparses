package com.mopaas.sturgeon.dataparses.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jetty.util.log.Log;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mopaas.sturgeon.dataparses.domain.Fund;
import com.mopaas.sturgeon.dataparses.domain.FundTrade;
import com.mopaas.sturgeon.dataparses.domain.Tags;

@Service
public class FundTradeService {
	@Autowired
	private Dao dao;

	@Transactional
	public void getAndSave(String code, String name, String tradedate) {
		FundTrade fd = null;
		String curdate = DateUtils
				.getCurTimeStrByFormate(DateUtils.DATE_FORMAT_DAY);
		if (curdate.equals(tradedate)) {
			fd = FundTradeLoadService.parse(code);
		} else {
			fd = FundTradeLoadService.parseHis(code, tradedate);
		}
		fd.setLastupdatetime(DateUtils.getCurTime());
		fd.setTradetime(tradedate);
		fd.setSymbol(code);
		fd.setCode(code);
		fd.setName(name);
		if (fd.getVolume() > 0 && fd.getAmount() > 0 && fd.getTrade() > 0) {
			save(fd);
		}else{
			System.out.println("code:"+code+"'name:"+name+" tradedate:"+tradedate +" is 0 ");
		}
	}

	private void save(FundTrade bd) {
		if (this.dao.fetchx(FundTrade.class, bd.getSymbol(), bd.getTradetime()) != null) {
			this.dao.update(bd);
		} else {
			this.dao.insert(bd);
		}
	}

	public List<Tags> getAllTags() {
		return dao.query(Tags.class, null);
	}
	
	public Tags getTags(String code){
		return dao.query(Tags.class,Cnd.wrap("symbol='"+code+"'")).get(0);
	}

	public List<FundTrade> queryListByCode(String code) {
		return dao.query(FundTrade.class,
				Cnd.wrap("symbol = '" + code + "' ORDER BY tradetime "));
	}
	
	

	public List<Date> queryDestDate(String starttime, String endtime,
			String code) {
		List<String> datelist = this.transDateList(this.queryListByCode(code));
		List<Date> workdatelist = DateNoHolidaysUtils.getWeekDayslist(
				starttime, endtime);
		List<Date> destlist = new ArrayList<Date>();
		for (Date d : workdatelist) {
			String srcDate = DateUtils
					.date2String(d, DateUtils.DATE_FORMAT_DAY);
			if (datelist.contains(srcDate)) {
				continue;
			} else {
				destlist.add(d);
			}

		}
		return destlist;
	}

	private List<String> transDateList(List<FundTrade> ftlist) {
		List<String> dlist = new ArrayList<String>();
		for (FundTrade f : ftlist) {
			Date src = DateUtils.string2Date(f.getTradetime(),
					DateUtils.DATE_FORMAT_DAY);
			dlist.add(DateUtils.date2String(src, DateUtils.DATE_FORMAT_DAY));

		}
		return dlist;

	}
}
