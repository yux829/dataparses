package com.mopaas.sturgeon.dataparses.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.nutz.lang.Lang;

public class LoadDataForExcelService {

	protected String[] getFromSina(String url) {
		try {
			URL url1 = new URL(url);
			// 打开连接
			HttpURLConnection httpConnection = (HttpURLConnection) url1
					.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					httpConnection.getInputStream(), Charset.forName("GBK")));
			StringBuilder sb = new StringBuilder();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str).append(";");
			}
			br.close();
			return new String(sb).split(";");
		} catch (Exception e) {
			throw Lang.makeThrow("Error for %d [%s]", e);
		}
	}
	
	protected List<String> parseValue(String s) {
		List<String> resultlist = new ArrayList<String>();
		String[] slist = s.split("	");
		for (int i = 1; i < slist.length - 1; i++) {
			resultlist.add(slist[i].trim());
		}
		return resultlist;

	}
	
	protected int countSize(String[] datalist) {
		String s = datalist[0];
		String[] slist = s.split("	");
		return slist.length - 2;
	}
}
