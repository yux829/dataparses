package com.mopaas.sturgeon.dataparses.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelpUtils {
	private static Log logger = LogFactory.getLog(HelpUtils.class);

	public static String getRandColorCode() {
		String r, g, b;
		Random random = new Random();
		r = Integer.toHexString(random.nextInt(256)).toUpperCase();
		g = Integer.toHexString(random.nextInt(256)).toUpperCase();
		b = Integer.toHexString(random.nextInt(256)).toUpperCase();

		r = r.length() == 1 ? "0" + r : r;
		g = g.length() == 1 ? "0" + g : g;
		b = b.length() == 1 ? "0" + b : b;

		return "#"+r + g + b;
	}

	/**
	 * double 型 相加
	 * 
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static double doubleAddDouble(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b2.add(b1).doubleValue();
	}

	/**
	 * double 型 相加
	 * 
	 * @param doublearray
	 * @return
	 */
	public static double doubleAddDoule(double[] doublearray) {
		if (doublearray == null)
			return 0;
		if (doublearray.length < 2)
			return doublearray[0];
		double total = 0;
		for (int i = 0, j = doublearray.length; i < j; i++) {
			total = doubleAddDouble(total, doublearray[i]);
		}
		return total;
	}

	/**
	 * double 型 相减
	 * 
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static double doubleSubtractDouble(double subtrahend, double minuend) {
		BigDecimal b1 = new BigDecimal(Double.toString(subtrahend));
		BigDecimal b2 = new BigDecimal(Double.toString(minuend));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * * 两个Double数相乘 *
	 * 
	 * @param v1
	 *            *
	 * @param v2
	 *            *
	 * @return Double
	 */
	public static double doubleMultiplyDouble(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return new Double(b1.multiply(b2).doubleValue());
	}

	/**
	 * * 两个Double数相除 *
	 * 
	 * @param v1
	 *            *
	 * @param v2
	 *            *
	 * @return Double
	 */
	public static double doubleDivideDouble(double dividendValue,
			double divisorValue) {
		BigDecimal b1 = new BigDecimal(Double.toString(dividendValue));
		BigDecimal b2 = new BigDecimal(Double.toString(divisorValue));
		return new Double(b1.divide(b2, 10, BigDecimal.ROUND_HALF_UP)
				.doubleValue());
	}

	/**
	 * * 两个Double数相除，并保留scale位小数 *
	 * 
	 * @param v1
	 *            *
	 * @param v2
	 *            *
	 * @param scale
	 *            *
	 * @return Double
	 */
	public static double DoubleDivideDouble(double dividendValue,
			double divisorValue, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(dividendValue));
		BigDecimal b2 = new BigDecimal(Double.toString(divisorValue));
		return new Double(b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP)
				.doubleValue());
	}

	/**
	 * 高精度指定小数位数四舍五入
	 * 
	 * @param dividendValue
	 * @param scale
	 * @return
	 */
	public static double setScaleDouble(double divisorValue, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal sorBigDecimal = new BigDecimal(Double.toString(divisorValue));
		return sorBigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	public static String scaleTwo(double value) {
		BigDecimal db = new BigDecimal(String.valueOf(value));
		db = db.setScale(2, BigDecimal.ROUND_HALF_UP);
		return db.toPlainString();
	}

	public static String scaleTwo(String value) {
		BigDecimal db = new BigDecimal(value);
		db = db.setScale(2, BigDecimal.ROUND_HALF_UP);
		return db.toPlainString();
	}

	public static long double2long(double value) {
		return Math.round(value);

	}

	/**
	 * 判断是否为空
	 * 
	 * @param str
	 * @return
	 */
	public final static boolean isNull(String str) {
		if (str != null && str.length() > 0)
			return false;
		else
			return true;
	}

	/**
	 * 字符串转整型
	 * 
	 * @param str
	 * @return
	 */
	public final static int str2Int(String str) {
		int iNumber = -1;
		try {
			iNumber = Integer.parseInt(str);
		} catch (Exception e) {
			logger.error(e);
		}
		return iNumber;
	}

	/**
	 * 字符串转double型
	 * 
	 * @param str
	 * @return
	 */
	public final static double str2Double(String str) {
		double iNumber = 0;
		if (str == null || str.length() < 1)
			return iNumber;
		try {
			iNumber = Double.parseDouble(str);
		} catch (Exception e) {
			logger.error(e);
		}
		return iNumber;
	}

	/**
	 * 取字符串前 指定位
	 * 
	 * @param str
	 * @param size
	 * @return
	 */
	public final static String getSubStrFromStart(String str, int size) {
		return getSubStr(str, size, 0);
	}

	/**
	 * 取字符串后 指定位
	 * 
	 * @param str
	 * @param size
	 * @return
	 */
	public final static String getSubStrFromEnd(String str, int size) {
		return getSubStr(str, size, 1);
	}

	/**
	 * STRING 数组 转换 MAP
	 * 
	 * @param keylist
	 * @param valuelist
	 * @return
	 */
	public final static <T> Map<String, T> strArray2Map(String[] keylist,
			T[] valuelist) {
		if (keylist == null || valuelist == null
				|| keylist.length != valuelist.length) {
			logger.error("method :strArray2Map()参数为空或二者长度不一致!");
		}
		Map<String, T> map = new HashMap<String, T>();
		for (int i = 0, j = keylist.length; i < j; i++) {
			map.put(keylist[i], valuelist[i]);
		}
		return map;
	}

	/**
	 * 取字符串的前或后 指定位数
	 * 
	 * @param str
	 * @param size
	 * @param type
	 *            0 从前面取 1从后面取
	 * @return
	 */
	private final static String getSubStr(String str, int size, int type) {
		if (isNull(str) || str.length() < size) {
			logger.error("参数为空或位数不够:str:" + str + ";size:" + size);
			return null;
		}
		if (type == 0) {
			return str.substring(0, size);
		} else {
			return str.substring(str.length() - size, str.length());
		}
	}

	/**
	 * 字符串数组转sql语句中in字符串
	 * 
	 * @param sArray
	 * @return
	 */
	public static String sArrayToSqlInString(String[] sArray) {
		if (sArray == null || sArray.length < 1)
			return "('')";
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		for (int i = 0, j = (sArray.length - 1); i < j; i++) {
			sb.append("'").append(sArray[i]).append("',");
		}
		sb.append("'").append(sArray[sArray.length - 1]).append("'");
		sb.append(")");
		return sb.toString();
	}

	public static String sArrayToSqlInString(List<String> sList) {
		if (sList == null || sList.size() < 1)
			return "('')";
		return sArrayToSqlInString(sList.toArray(new String[] {}));
	}

	/***
	 * 处理sql语句中 in 过长的问题 String sql = HelpUtils.generMuchInsql(data, "#{1}");
	 * System.out.println(sql);// and #{1}('0','1','2','3','4','5','6','7')
	 * String temp = sql.replace("#{1}"," t.subid in ");
	 * System.out.println(temp);// and t.subid in
	 * ('0','1','2','3','4','5','6','7')
	 * 
	 * @param lists
	 * @param witchFiledIn
	 * @return
	 */
	public static String generMuchInsql(List<String> lists, String witchFiledIn) {
		int len = lists.size();
		int mod = 100;
		if (len > 100) {
			int size = len / mod + 1;
			String sql = " and (   ";
			int flag = 0;
			for (int c = 0; c < size; c++) {
				List<String> tempdata = new ArrayList<String>();
				for (int i = 0; i < mod; i++) {
					try {
						tempdata.add(lists.get(c * mod + i));
					} catch (Exception e) {
						break;
					}
				}
				if (tempdata.size() > 0) {
					if (flag == 0) {
						sql = sql + "   " + witchFiledIn
								+ HelpUtils.sArrayToSqlInString(tempdata) + "";
					} else {
						sql = sql + " or " + witchFiledIn
								+ HelpUtils.sArrayToSqlInString(tempdata) + "";
					}
					flag++;
				}

			}
			sql = sql + " ) ";
			return sql;
		} else {
			String sql = " and " + witchFiledIn
					+ HelpUtils.sArrayToSqlInString(lists);
			return sql;
		}
	}

	/**
	 * 保留小数点后两位小数（四舍五入）
	 * 
	 * @param val
	 * @param precision
	 * @return
	 */
	public static Double roundDouble(double val, int precision) {
		Double ret = null;
		try {
			double factor = Math.pow(10, precision);
			ret = Math.floor(val * factor + 0.5) / factor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 算出数字的折扣后的值
	 * 
	 * @param srcVal
	 * @param discount
	 *            如80,代表8折
	 * @return
	 */
	public static double getDiscountValue(double srcVal, int discount) {
		BigDecimal basicVal = new BigDecimal(srcVal);
		BigDecimal rate = new BigDecimal(discount);
		BigDecimal hundred = new BigDecimal("100");
		BigDecimal tmp = rate.divide(hundred, 2, BigDecimal.ROUND_HALF_UP);
		BigDecimal tmp1 = basicVal.multiply(tmp);
		Double tmp2 = roundDouble(tmp1.doubleValue(), 2);
		return tmp2.doubleValue();
	}

}
