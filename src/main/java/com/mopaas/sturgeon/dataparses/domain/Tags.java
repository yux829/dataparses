package com.mopaas.sturgeon.dataparses.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;

@Table("t_tags")
@PK({ "symbol", "tagcode", "tagtype" })
public class Tags {

	public final static String TYPE_INDEX = "00";

	@Column
	protected String tagcode;
	@Column
	protected String tagname;
	@Column
	protected String tagtype;
	@Column
	protected String symbol;
	@Column
	protected String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getTagcode() {
		return tagcode;
	}

	public void setTagcode(String tagcode) {
		this.tagcode = tagcode;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public String getTagtype() {
		return tagtype;
	}

	public void setTagtype(String tagtype) {
		this.tagtype = tagtype;
	}
}
