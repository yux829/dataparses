package com.mopaas.sturgeon.dataparses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.Test;
import org.nutz.lang.Files;

public class JXLTest {

	@Test
	public void testGet() throws Exception {
		String code = "603611";
		String url1 = "http://money.finance.sina.com.cn/corp/go.php/vDOWN_BalanceSheet/displaytype/4/stockid/"
				+ code + "/ctrl/all.phtml";
		
		URL url = new URL(url1);
		// 打开连接
		HttpURLConnection httpConnection = (HttpURLConnection) url
				.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), Charset.forName("GBK")));
		StringBuilder sb = new StringBuilder();
		String str;
		while((str = br.readLine()) != null){
			sb.append(str).append(";");
		}
		br.close();
		
		String[] contentlist=new String(sb).split(";");
		for(String s:contentlist){
		System.out.println(new String(s));
		}
		String s=contentlist[3];
		String[] slist=s.split("	");
		System.out.println("..."+slist.length+"...");
		for(String s1:slist){
			System.out.println("..."+s1+"....");
		}
		
		/*
		Workbook book = Workbook.getWorkbook(new File("603611.xls"));
		// 获得第一个工作表对象
		Sheet sheet = book.getSheet(0);
		// 得到第一列第一行的单元格
		Cell cell1 = sheet.getCell(0, 0);
		String result = cell1.getContents();
		System.out.println(result);
		book.close();
		*/
	}

	private void savefile(String sURL, String code) {
		try {
			int nRead = 0;
			URL url = new URL(sURL);
			// 打开连接
			HttpURLConnection httpConnection = (HttpURLConnection) url
					.openConnection();
			// 获得文件长度
			// long nEndPos =getFileSize(sURL);
			RandomAccessFile oSavedFile = new RandomAccessFile(code + ".txt",
					"rw");
			httpConnection
					.setRequestProperty("User-Agent", "Internet Explorer");
			// String sProperty = "bytes=" + nStartPos + "-";
			// //告诉服务器book.rar这个文件从nStartPos字节开始传
			// httpConnection.setRequestProperty("RANGE", sProperty);
			// System.out.println(sProperty);
			InputStream input = httpConnection.getInputStream();
			byte[] b = new byte[1024];
			// 读取网络文件,写入指定的文件中
			while ((nRead = input.read(b, 0, 1024)) > 0) {
				oSavedFile.write(b, 0, nRead);
			}
			oSavedFile.close();
			httpConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private StringBuffer  getcontent(String sURL, String code) {
		StringBuffer sb = new StringBuffer();
		try {
			int nRead = 0;
			URL url = new URL(sURL);
			// 打开连接
			HttpURLConnection httpConnection = (HttpURLConnection) url
					.openConnection();
			// 获得文件长度
			// long nEndPos =getFileSize(sURL);
			RandomAccessFile oSavedFile = new RandomAccessFile(code + ".txt",
					"rw");
			httpConnection
					.setRequestProperty("User-Agent", "Internet Explorer");
			// String sProperty = "bytes=" + nStartPos + "-";
			// //告诉服务器book.rar这个文件从nStartPos字节开始传
			// httpConnection.setRequestProperty("RANGE", sProperty);
			// System.out.println(sProperty);
			InputStream input = httpConnection.getInputStream();
			byte[] b = new byte[1024];
			// 读取网络文件,写入指定的文件中
			while ((nRead = input.read(b, 0, 1024)) > 0) {
				sb.append(b);
				oSavedFile.write(b, 0, nRead);
			}
			oSavedFile.close();
			httpConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb;
	}

}
