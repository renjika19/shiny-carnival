package dao;

import java.util.List;

import model.Flower;

public interface FlowerDao {
	
	public int insertFlower(Flower f);
	public List<Flower> selectAllFlower();
	public Flower selectFlowerById(int id);
	public void updateFlower(Flower change);
	public void deleteFlowerById(int id);
}
