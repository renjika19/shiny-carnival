package com.revature.services;

import java.util.List;

import com.revature.beans.Polkaman;
import com.revature.dao.PolkamanDao;
import com.revature.dao.PolkamanDaoImpl;

public class PolkamanService {
	private PolkamanDao pd = null;
	
	public Boolean addNewPolkaman(Polkaman p) {
		pd = new PolkamanDaoImpl();
		return pd.insertPolkaman(p);
	}

	public List<Polkaman> getAllPolkamans(){
		pd = new PolkamanDaoImpl();
		return pd.selectAllPolkaman();
	}
	
	public Polkaman getPolkamansById(Integer id){
		pd = new PolkamanDaoImpl();
		return pd.selectPolkamanById(id);
	}
	
	public Boolean deletePolkamanById(Integer id){
		pd = new PolkamanDaoImpl();
		return pd.deletePolkamanById(id);
	}
}
