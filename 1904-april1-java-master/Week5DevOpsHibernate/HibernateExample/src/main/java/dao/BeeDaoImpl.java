package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Bee;
import util.HibernateUtil;

public class BeeDaoImpl implements BeeDao {

	@Override
	public int insertBee(Bee b) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int id = 0;
		
		try {
			tx = session.beginTransaction();
			id = (int) session.save(b);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return id;
	}

	@Override
	public List<Bee> selectAllBee() {
		Session session = HibernateUtil.getSession();
		List<Bee> bees = null;
		
		try {
			bees = session.createQuery("FROM Bee").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bees;
	}

	@Override
	public Bee selectBeeById(int id) {
		Session session = HibernateUtil.getSession();
		Bee bee = null;
		
		try {
			bee = (Bee) session.get(Bee.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bee;
	}

	@Override
	public void updateBee(Bee change) {
		
		/*
		 * Update vs merge
		 * 
		 * Hibernate does not allow two objects with the same id in
		 * the same session. 
		 * 
		 * Update on one object in the session with same id will throw
		 * an exception because it doesn't know which object should
		 * actually be changed.
		 * 
		 * Merge will replace the object with another object in the session.
		 */
		
		Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(change);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteBeeById(int id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			session.beginTransaction();
			session.delete(session.get(Bee.class, id));
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
