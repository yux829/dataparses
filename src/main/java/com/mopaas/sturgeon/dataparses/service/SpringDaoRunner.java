package com.mopaas.sturgeon.dataparses.service;

import java.sql.Connection;

import javax.sql.DataSource;

import org.nutz.dao.ConnCallback;
import org.nutz.dao.impl.DaoRunner;
import org.springframework.jdbc.datasource.DataSourceUtils;

public class SpringDaoRunner implements DaoRunner {
	public void run(DataSource dataSource, ConnCallback callback) {
		Connection con = null;
		try {
			con = DataSourceUtils.doGetConnection(dataSource);
			callback.invoke(con);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DataSourceUtils.releaseConnection(con, dataSource);
		}
	}
}
