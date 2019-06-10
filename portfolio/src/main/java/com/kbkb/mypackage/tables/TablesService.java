package com.kbkb.mypackage.tables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TablesService {
	@Autowired
	TablesDAO mda;
	
	public int Test() {
		return mda.getTest();
	}
	
	public void doinsert() {
		mda.insert();
	}
}
