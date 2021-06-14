package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Flower;
import util.HibernateUtil;

public class FlowerDaoImpl implements FlowerDao {

	@Override
	public int insertFlower(Flower f) {
		Session session = HibernateUtil.getSession(); //Connect to db
		int id = 0;
		
		try {
			session.beginTransaction();	//Opens the transaction block
			//session.persist(f);
			/*
			 * Persist vs Save
			 * 
			 * Persist will save to the database and has a void return
			 * 
			 * Save will save to the database and return a serializable int.
			 */
			id = (int) session.save(f);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
		return id;
	}

	@Override
	public List<Flower> selectAllFlower() {
		Session session = HibernateUtil.getSession();
		List<Flower> flowers = null;
		
		try {
			flowers = session.createQuery("FROM Flower").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return flowers;
	}

	@Override
	public Flower selectFlowerById(int id) {
		Session session = HibernateUtil.getSession();
		Flower flower = null;
		
		try {
			flower = (Flower) session.load(Flower.class, id);
			/*
			 * Get vs Load
			 * 
			 * get() - Eager loading - immediately go to the database
			 * and get all the information associated with the object.
			 * 
			 * load() - Lazy loading - will return a proxy object with
			 * many fields not having a value. Those values are only
			 * loaded when they are specifically requested later in the code.
			 * 
			 * 
			 */
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return flower;
	}

	@Override
	public void updateFlower(Flower change) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Flower flower = null;
		
		try {
			tx = session.beginTransaction();
			flower = (Flower) session.get(Flower.class, change.getId());
			
			flower.setPetals(change.getPetals());
			session.persist(flower);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteFlowerById(int id) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(session.get(Flower.class, id));
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
