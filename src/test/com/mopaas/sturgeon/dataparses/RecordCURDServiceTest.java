package com.mopaas.sturgeon.dataparses;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopaas.sturgeon.dataparses.domain.RecordDomain;
import com.mopaas.sturgeon.dataparses.service.HelpUtils;
import com.mopaas.sturgeon.dataparses.service.RecordCURDService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RecordCURDServiceTest {
	@Autowired
	private RecordCURDService rs;

	@Test
	public void testSave() {
		for (RecordDomain r : get20150319datas()) {
			rs.save(r);
		}
		/*
		for (RecordDomain r : get20150217datas()) {
			rs.save(r);
		}
		
		 * for (RecordDomain r : get20150210datas()) { rs.save(r); }
		 * 
		 * for (RecordDomain r : get20150209datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150206datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150130datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150129datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150127datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150126datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150123datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150122datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150116datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150113datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150112datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150108datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150107datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150106datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150105datas()) { rs.save(r); } for
		 * (RecordDomain r : get20141231datas()) { rs.save(r); } for
		 * (RecordDomain r : get20150106datas()) { rs.save(r); } for
		 * (RecordDomain r : get20141228datas()) { rs.save(r); }
		 */

	}
	private RecordDomain[] get20150319datas(){
		String trade_date = "20150319";
		return this.getDatas2(trade_date, 807006, 365288, 3507505, 1481684,
				3839.74);
	}
	private RecordDomain[] get20150317datas(){
		String trade_date = "20150317";
		return this.getDatas2(trade_date, 432363, 4954, 3312619, 1480981,
				3757.12);
	}
	private RecordDomain[] get20150316datas(){
		String trade_date = "20150316";
		return this.getDatas2(trade_date, 751187, 330044, 3301685, 1480630,
				3705.67);
	}
	private RecordDomain[] get20150313datas(){
		String trade_date = "20150313";
		return this.getDatas2(trade_date, 720534, 308159, 3233506, 1480278,
				3617.66);
	}
	private RecordDomain[] get20150309datas(){
		String trade_date = "20150309";
		return this.getDatas2(trade_date, 770355, 354370, 3338504, 1478169,
				3537.75);
	}
	private RecordDomain[] get20150306datas(){
		String trade_date = "20150306";
		return this.getDatas2(trade_date, 721430, 316323, 3134628, 1477817,
				3507.9);
	}
	private RecordDomain[] get20150303datas() {
		String trade_date = "20150303";
		return this.getDatas2(trade_date, 736201, 324505, 3097917, 1476059,
				3507.9);
	}
	private RecordDomain[] get20150227datas() {
		String trade_date = "20150227";
		return this.getDatas2(trade_date, 700267, 298081, 3020735, 1475356,
				3572.84);
	}

	private RecordDomain[] get20150225datas() {
		String trade_date = "20150225";
		return this.getDatas2(trade_date, 641933, 244031, 3002955, 1473599,
				3478.73);
	}

	private RecordDomain[] get20150217datas() {
		String trade_date = "20150217";
		return this.getDatas(trade_date, 559550, 244031, 2281823, 1066959,
				3522.32, 72847);
	}

	private RecordDomain[] get20150211datas() {
		String trade_date = "20150211";
		return this.getDatas(trade_date, 570688, 243222, 2302848, 1063674,
				3434.12, 75047);
	}

	private RecordDomain[] get20150210datas() {
		String trade_date = "20150210";
		return this.getDatas(trade_date, 565045, 248478, 2253237, 1063421,
				3406.94, 41504);
	}

	private RecordDomain[] get20150209datas() {
		String trade_date = "20150209";
		return this.getDatas(trade_date, 562784, 259056, 2215007, 1063168,
				3345.92, 41412);
	}

	private RecordDomain[] get20150206datas() {
		String trade_date = "20150206";
		return this.getDatas(trade_date, 566776, 258995, 2203847, 1062915,
				3312.4);
	}

	private RecordDomain[] get20150130datas() {
		String trade_date = "20150130";
		return this.getDatas(trade_date, 605057, 262774, 2250294, 1060388,
				3434.39);
	}

	private RecordDomain[] get20150129datas() {
		String trade_date = "20150129";
		return this.getDatas(trade_date, 723157, 366636, 2273352, 1060388,
				3481.80);
	}

	private RecordDomain[] get20150127datas() {
		String trade_date = "20150127";
		return this.getDatas(trade_date, 781087, 366461, 2359047, 1059883,
				3574.93);
	}

	private RecordDomain[] get20150126datas() {
		String trade_date = "20150126";
		return this.getDatas(trade_date, 638791, 236988, 2375107, 1059630,
				3607.99);
	}

	private RecordDomain[] get20150123datas() {
		String trade_date = "20150123";
		return this.getDatas(trade_date, 470657, 78313, 2265723, 1059377,
				3571.73);
	}

	private RecordDomain[] get20150122datas() {
		String trade_date = "20150122";
		return this.getDatas(trade_date, 711680, 306890, 2285670, 1058689,
				3567.61);
	}

	private RecordDomain[] get20150116datas() {
		String trade_date = "20150116";
		return this.getDatas(trade_date, 642611.86, 285650.18, 2099767.41,
				1061856.9, 3635.15);
	}

	private RecordDomain[] get20150113datas() {
		String trade_date = "20150113";
		return this.getDatas(trade_date, 579852.2, 232638, 1362446.66,
				653042.09, 3514.04);
	}

	private RecordDomain[] get20150112datas() {
		String trade_date = "20150112";
		return this.getDatas(trade_date, 344178.41, 0, 1328406.66, 652887.00,
				3513.58);
	}

	private RecordDomain[] get20150108datas() {
		String trade_date = "20150108";
		return this.getDatas(trade_date, 345127.95, 0, 1350082.66, 652266.64,
				3559.26);
	}

	private RecordDomain[] get20150107datas() {
		String trade_date = "20150107";
		return this.getDatas(trade_date, 624271.18, 277917.76, 1359232.66,
				652111.55, 3643.79);
	}

	private RecordDomain[] get20150106datas() {
		String trade_date = "20150106";
		return this.getDatas(trade_date, 626145.40, 277851.66, 1342874.00,
				651956.46, 3641.06);
	}

	private RecordDomain[] get20150105datas() {
		String trade_date = "20150105";
		return this.getDatas(trade_date, 579300.38, 277785.56, 1373320.66,
				651801.37, 3641.54);
	}

	private RecordDomain[] get20141231datas() {
		String trade_date = "20141231";
		return this.getDatas(trade_date, 529487.10, 238414.81, 1429916,
				651646.28, 3533.71);
	}

	private RecordDomain[] get20141228datas() {
		String trade_date = "20141228";
		return this.getDatas(trade_date, 563768.62, 261317.57, 1424946.66,
				650560.66, 3455.46);

	}

	private RecordDomain[] getDatas2(String trade_date, double my1_market,
			double my1_debet, double my2_market, double my2_debt, double hs300) {
		RecordDomain[] list = new RecordDomain[3];

		list[0] = new RecordDomain();
		list[0].setName(RecordDomain.NAME_MY1);
		list[0].setMarket_values(my1_market);
		list[0].setDebt(my1_debet);
		list[0].setTrade_date(trade_date);
		list[0].setAsset(HelpUtils.doubleSubtractDouble(
				list[0].getMarket_values(), list[0].getDebt()));
		list[0].setNetvalue(HelpUtils.DoubleDivideDouble(
				list[0].getAsset() * 100, RecordDomain.MY1_ORGINAL2, 2));

		list[1] = new RecordDomain();
		list[1].setName(RecordDomain.NAME_MY2);
		list[1].setMarket_values(my2_market);
		list[1].setDebt(my2_debt);
		list[1].setTrade_date(trade_date);
		double my2_assert1 = HelpUtils.doubleSubtractDouble(
				list[1].getMarket_values(), list[1].getDebt());
		
//		my2_assert1 = my2_assert1 * 0.554 + 135000;
//		my2_assert1 = ((my2_assert1 -1529356)*0.8+1529356)*0.546
//				    =(my2_assert1*0.8+1529356*0.2)*0.546
				    
//		my2_assert1 = my2_assert1*0.4368+167005;
		
		my2_assert1 =  ((my2_assert1 -2023500)*0.8+2023500)*0.5179;

		
		list[1].setAsset(my2_assert1);
		list[1].setNetvalue(HelpUtils.DoubleDivideDouble(
				list[1].getAsset() * 100, RecordDomain.MY2_ORGINAL, 2));

		list[2] = new RecordDomain();
		list[2].setName(RecordDomain.NAME_HS300);
		list[2].setMarket_values(hs300);
		list[2].setDebt(0);
		list[2].setTrade_date(trade_date);
		list[2].setAsset(HelpUtils.doubleSubtractDouble(
				list[2].getMarket_values(), list[2].getDebt()));
		list[2].setNetvalue(HelpUtils.DoubleDivideDouble(
				list[2].getAsset() * 100, RecordDomain.HS300_ORGINAL, 2));

		return list;
	}

	private RecordDomain[] getDatas(String trade_date, double my1_market,
			double my1_debet, double my2_market, double my2_debt, double hs300,
			double lp_value) {
		RecordDomain[] list = new RecordDomain[4];

		list[0] = new RecordDomain();
		list[0].setName(RecordDomain.NAME_MY1);
		list[0].setMarket_values(my1_market);
		list[0].setDebt(my1_debet);
		list[0].setTrade_date(trade_date);
		list[0].setAsset(HelpUtils.doubleSubtractDouble(
				list[0].getMarket_values(), list[0].getDebt()));
		list[0].setNetvalue(HelpUtils.DoubleDivideDouble(
				list[0].getAsset() * 100, RecordDomain.MY1_ORGINAL, 2));

		list[1] = new RecordDomain();
		list[1].setName(RecordDomain.NAME_MY2);
		list[1].setMarket_values(my2_market);
		list[1].setDebt(my2_debt);
		list[1].setTrade_date(trade_date);
		double my2_assert1 = HelpUtils.doubleSubtractDouble(
				list[1].getMarket_values(), list[1].getDebt());
		my2_assert1 = my2_assert1 * 0.554 + 135000;
		list[1].setAsset(my2_assert1);
		list[1].setNetvalue(HelpUtils.DoubleDivideDouble(
				list[1].getAsset() * 100, RecordDomain.MY2_ORGINAL, 2));

		list[2] = new RecordDomain();
		list[2].setName(RecordDomain.NAME_HS300);
		list[2].setMarket_values(hs300);
		list[2].setDebt(0);
		list[2].setTrade_date(trade_date);
		list[2].setAsset(HelpUtils.doubleSubtractDouble(
				list[2].getMarket_values(), list[2].getDebt()));
		list[2].setNetvalue(HelpUtils.DoubleDivideDouble(
				list[2].getAsset() * 100, RecordDomain.HS300_ORGINAL, 2));

		list[3] = new RecordDomain();
		list[3].setName(RecordDomain.NAME_MY3);
		list[3].setMarket_values(lp_value);
		list[3].setDebt(0);
		list[3].setTrade_date(trade_date);
		list[3].setAsset(HelpUtils.doubleSubtractDouble(
				list[3].getMarket_values(), list[3].getDebt()));
		list[3].setNetvalue(HelpUtils.DoubleDivideDouble(
				list[3].getAsset() * 100, RecordDomain.MY3_ORGINAL, 2));

		return list;
	}

	private RecordDomain[] getDatas(String trade_date, double my1_market,
			double my1_debet, double my2_market, double my2_debt, double hs300) {
		return this.getDatas(trade_date, my1_market, my1_debet, my2_market,
				my2_debt, hs300, RecordDomain.MY3_ORGINAL);
	}

}
