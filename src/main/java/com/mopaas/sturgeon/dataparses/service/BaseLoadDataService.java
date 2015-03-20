package com.mopaas.sturgeon.dataparses.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.nutz.castor.Castors;

public class BaseLoadDataService {
	private final static String URL_EXCHANGE = "http://download.finance.yahoo.com/d/quotes.html?s=USDCNY=X&f=sl1d1t1ba&e=.html";
	private final static double EXCHANGE_RATE_DEFAULT = 6.2;
	protected static String REPORT_TYPE_ANNU = "00";
	protected static String REPORT_TYPE_QUAR = "01";

	protected static Document getURLContent(String URL) {
		try {
			return Jsoup.connect(URL).get();
		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;

	}

	protected static String[] parseTdContentFromTr(Element tr_content) {
		StringBuffer sb = new StringBuffer("");
		Elements td_list = tr_content.getElementsByTag("td");
		for (Element td : td_list) {
			sb.append(td.text()).append(";");
		}
		return sb.toString().split(";");
	}

	protected static String parseThContentFromTr(Element tr_content) {
		return tr_content.getElementsByTag("th").get(0).text();
	}



	protected static String getJsonString(String URL, String encoding) {
		try {
			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			// 对应的字符编码转换
			Reader reader = new InputStreamReader(inputStream, encoding);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String str = null;
			StringBuffer sb = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
			}
			reader.close();
			connection.disconnect();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static double getExchangeRate() {
		String[] v = getJsonString(URL_EXCHANGE, "GBK").split(",");
		if (v == null | v.length < 1)
			return EXCHANGE_RATE_DEFAULT;
		return Castors.me().castTo(v[1], Double.class);

	}

}
