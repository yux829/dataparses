package com.mopaas.sturgeon.dataparses;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import junit.framework.TestCase;

public class ParseTest extends TestCase {
 private final static String URL1="http://vip.stock.finance.sina.com.cn/usstock/balance.php?s=SINA&t=quarter";
 private final static String URL2="http://money.finance.sina.com.cn/corp/go.php/vDOWN_CashFlow/displaytype/4/stockid/600000/ctrl/all.phtml";
 
 public void testGet()  throws Exception{
	 Parse p = new Parse();
	 Document doc= p.get(URL1);
//	 Document doc= p.get(URL2);
	 System.out.println(doc.toString());
//	 System.out.println("__________________________________________________\n");
//	 Element elist=doc.getElementsByClass("data_tbl").get(1);
//	 System.out.println(elist.toString());
//	 System.out.println("__________________________________________________\n");
		
//	 elist=doc.getElementsByTag("table");
//	 System.out.println(elist.toString());
 }

}

class Parse {
	public Document get(String url) throws IOException{
		return Jsoup.connect(url).get();
		
	}
}
