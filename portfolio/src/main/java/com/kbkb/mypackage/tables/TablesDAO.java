package com.kbkb.mypackage.tables;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TablesDAO {

	@Autowired
	SqlSession sql;
	
	private int test;
	
	public int getTest() {
		return test;
	}
	public void setTest(int test) {
		this.test = test;
	}
	
	public void insert() {
		sql.insert("tables.insert");
	}
}
