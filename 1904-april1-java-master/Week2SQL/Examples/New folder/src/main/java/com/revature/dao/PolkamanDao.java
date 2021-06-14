package com.revature.dao;

import java.util.List;

import com.revature.beans.Polkaman;

public interface PolkamanDao {
	public Boolean insertPolkaman(Polkaman p);
	public Polkaman selectPolkamanById(Integer id);
	public List<Polkaman> selectAllPolkaman();
	public Boolean updatePolkamanById(Integer id);
	/*
	 * In practice, you should NEVER delete data from a DB
	 */
	public Boolean deletePolkamanById(Integer id);
}
