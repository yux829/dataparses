package com.mopaas.sturgeon.dataparses.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateNoHolidaysUtils {
	/**
	 * @title 判断两个日期是否在指定工作日内
	 * @detail (只计算周六和周日) 例如：前时间2008-12-05，后时间2008-12-11
	 * @author chanson
	 * @param beforeDate
	 *            前时间
	 * @param afterDate
	 *            后时间
	 * @param deadline
	 *            最多相隔时间
	 * @return 是的话，返回true，否则返回false
	 */
	public static boolean compareWeekday(String beforeDate, String afterDate,
			int deadline) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = sdf.parse(beforeDate);
			Date d2 = sdf.parse(afterDate);

			// 工作日
			int workDay = 0;
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(d1);
			// 两个日期相差的天数
			long time = d2.getTime() - d1.getTime();
			long day = time / 3600000 / 24 + 1;
			if (day < 0) {
				// 如果前日期大于后日期，将返回false
				return false;
			}
			for (int i = 0; i < day; i++) {
				if (isWeekday(gc.getTime())) {
					workDay++;
					// System.out.println(gc.getTime());
				}
				// 往后加1天
				gc.add(GregorianCalendar.DATE, 1);
			}
			return workDay <= deadline;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static List<Date> getWeekDayslist(String fromdate, String todate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date d1 = sdf.parse(fromdate);
			Date d2 = sdf.parse(todate);
			// 两个日期相差的天数
			long time = d2.getTime() - d1.getTime();
			long day = time / 3600000 / 24 + 1;
			if (day < 0) {
				// 如果前日期大于后日期，将返回false
				return null;
			}
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(d1);
			List<Date> datelist = new ArrayList<Date>();
			for (int i = 0; i < day; i++) {
				if (isWeekday(gc.getTime())) {
					datelist.add(gc.getTime());
				}
				gc.add(GregorianCalendar.DATE, 1);
			}
			return datelist;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean isWeekdays(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = sdf.parse(date);
			return isWeekday(d);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * @title 判断是否为工作日
	 * @detail 工作日计算: 1、正常工作日，并且为非假期 2、周末被调整成工作日
	 * @author chanson
	 * @param date
	 *            日期
	 * @return 是工作日返回true，非工作日返回false
	 */
	public static boolean isWeekday(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (calendar.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SATURDAY
				&& calendar.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY) {
			// 平时
			return !getWeekdayIsHolidayList().contains(
					sdf.format(calendar.getTime()));
		} else {
			// 周末
			return getWeekendIsWorkDateList().contains(
					sdf.format(calendar.getTime()));
		}
	}

	/**
	 * @title 获取周六和周日是工作日的情况（手工维护） 注意，日期必须写全： 2009-1-4必须写成：2009-01-04
	 * @author chanson
	 * @return 周末是工作日的列表
	 */
	private static List getWeekendIsWorkDateList() {
		List list = new ArrayList();
		list.add("2009-01-04");
		list.add("2009-01-24");
		list.add("2009-02-01");
		list.add("2009-05-31");
		list.add("2009-09-27");
		list.add("2009-10-10");
		return list;
	}

	/**
	 * @title 获取周一到周五是假期的情况（手工维护） 注意，日期必须写全： 2009-1-4必须写成：2009-01-04
	 * @author chanson
	 * @return 平时是假期的列表
	 */
	private static List getWeekdayIsHolidayList() {
		List list = new ArrayList();
		list.add("2009-01-29");
		list.add("2009-01-30");
		list.add("2009-04-06");
		list.add("2009-05-01");
		list.add("2009-05-28");
		list.add("2009-05-29");
		list.add("2014-10-01");
		list.add("2014-10-02");
		list.add("2014-10-03");
		list.add("2014-10-04");
		list.add("2014-10-05");
		list.add("2014-10-06");
		list.add("2014-10-07");

		return list;
	}

	public static void main(String[] args) {
		/*
		 * String day1 = "2014-10-2"; String day2 = "2014-12-13"; String day3 =
		 * "2014-12-14"; String day4 = "2014-12-15"; String day5 = "2014-12-16";
		 * 
		 * boolean ok1 = DateNoHolidaysUtils.isWeekdays(day1); boolean ok2 =
		 * DateNoHolidaysUtils.isWeekdays(day2); boolean ok3 =
		 * DateNoHolidaysUtils.isWeekdays(day3); boolean ok4 =
		 * DateNoHolidaysUtils.isWeekdays(day4); boolean ok5 =
		 * DateNoHolidaysUtils.isWeekdays(day5);
		 * 
		 * System.out.println(day1 + "--" + ok1); System.out.println(day2 + "--"
		 * + ok2); System.out.println(day3 + "--" + ok3);
		 * System.out.println(day4 + "--" + ok4); System.out.println(day5 + "--"
		 * + ok5);
		 */

		List<Date> dlist = DateNoHolidaysUtils.getWeekDayslist("2014-10-1",
				"2014-12-18");
		for (Date d : dlist) {
			System.out.println(d.getDate());
		}
	}
}
