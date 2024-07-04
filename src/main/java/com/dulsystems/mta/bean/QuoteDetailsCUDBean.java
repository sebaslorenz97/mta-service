package com.dulsystems.mta.bean;

import java.util.List;

public class QuoteDetailsCUDBean {
	
	private List<QuoteDetailBean >lqdb;
	private int[] lqdbForDelete;
	
	public List<QuoteDetailBean> getLqdb() {
		return lqdb;
	}
	public void setLqdb(List<QuoteDetailBean> lqdb) {
		this.lqdb = lqdb;
	}
	public int[] getLqdbForDelete() {
		return lqdbForDelete;
	}
	public void setLqdbForDelete(int[] lqdbForDelete) {
		this.lqdbForDelete = lqdbForDelete;
	}

}
