package com.revature.dao;

import java.util.List;

import com.revature.beans.Owner;

public interface OwnerDao {
	public Owner selectOwnerById(Integer id);
	public Boolean insertOwner(Owner own);
	public List<Owner> selectAllUsers();
	public Owner selectOwnerByUsername(String username);
}
