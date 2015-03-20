package com.mopaas.sturgeon.dataparses.service;

import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mopaas.sturgeon.dataparses.vo.FinanceQueryVo;

@Service
public class FinanceQueryService {
	@Autowired
	private Dao dao;

	public List<FinanceQueryVo> queryList(String symbol, String curdate_suffix) {
		String sqlstr = "SELECT b.symbol, b.curdate, assets_total, assets_flow, assets_fixed, owners_equity, salary, stock, "
				+ "flow_business, flow_invest, flow_finance, flow_netvalue, income, cost, profit	FROM t_balances_new b,"
				+ " t_cashflows_new c, t_profits_new p WHERE b.symbol = c.symbol  AND c.symbol = p.symbol  AND "
				+ " b.curdate = c.curdate    AND c.curdate = p.curdate  AND p.symbol =@symbol  AND p.curdate LIKE '%"
				+ curdate_suffix
				+ "'"
				+ "ORDER BY CURDATE asc";
		Sql sql = Sqls.create(sqlstr);
		sql.params().set("symbol",symbol);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(FinanceQueryVo.class));
		dao.execute(sql);
		List<FinanceQueryVo> list = sql.getList(FinanceQueryVo.class);
		return countAddRate(countRate(list));
	}

	private List<FinanceQueryVo> countAddRate(List<FinanceQueryVo> list) {
		if (list == null || list.size() < 2)
			return list;
		int size = list.size();
		for (int i = 0; i < size - 1; i++) {
			double income_first = list.get(i + 1).getIncome();
			double cost_first = list.get(i + 1).getCost();
			double profit_first = list.get(i + 1).getProfit();
			double grossprofit_first = list.get(i + 1).getGrossprofit();
			double income = list.get(i).getIncome();
			double cost = list.get(i).getCost();
			double profit = list.get(i).getProfit();
			double grossprofit = list.get(i).getGrossprofit();

			list.get(i).setIncome_add(
					HelpUtils.DoubleDivideDouble(HelpUtils
							.doubleSubtractDouble(income, income_first) * 100,
							income_first, 2));
			list.get(i)
					.setCost_add(
							HelpUtils.DoubleDivideDouble(
									HelpUtils.doubleSubtractDouble(cost,
											cost_first) * 100, cost_first, 2));
			list.get(i).setProfit_add(
					HelpUtils.DoubleDivideDouble(HelpUtils
							.doubleSubtractDouble(profit, profit_first) * 100,
							profit_first, 2));
			list.get(i).setGrossprofit_add(
					HelpUtils.DoubleDivideDouble(HelpUtils
							.doubleSubtractDouble(grossprofit,
									grossprofit_first) * 100,
							grossprofit_first, 2));
		}
		return list;
	}
	
	private List<FinanceQueryVo> countRate(List<FinanceQueryVo> list) {
		if (list == null || list.size() < 2)
			return list;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			list.get(i).setGrossprofit(HelpUtils.doubleSubtractDouble(list.get(i).getIncome(),
					list.get(i).getCost()));
			list.get(i).setGross_rate(HelpUtils.DoubleDivideDouble(
					list.get(i).getGrossprofit() * 100, list.get(i).getIncome(), 2));
			list.get(i).setProfit_rate(HelpUtils.DoubleDivideDouble(
					list.get(i).getProfit() * 100, list.get(i).getIncome(), 2));
			list.get(i).setRoe(HelpUtils.DoubleDivideDouble(list.get(i).getProfit()*100, list.get(i).getAssets_total(), 2));
		}
		return list;
	}
}
