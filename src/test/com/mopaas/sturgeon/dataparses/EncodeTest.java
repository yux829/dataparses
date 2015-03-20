package com.mopaas.sturgeon.dataparses;

import org.junit.Test;

public class EncodeTest {

	@Test
	public void test1()throws Exception{
		String s="\u591a\u5229\u8fdb\u53d6";
		System.out.println(s);
		System.out.println(new String(s.getBytes("UTF-8")));
		
	}
	
}
