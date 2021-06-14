package dao;

import java.util.List;

import model.Bear;

public interface BearDao {

	public int insertBear(Bear b);
	public List<Bear> selectAllBear();
	public Bear selectBearById(int id);
	public void updateBear(Bear change);
	public void deleteBearById(int id);
}
