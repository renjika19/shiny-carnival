package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Beehive;
import util.HibernateUtil;

public class BeehiveDaoImpl implements BeehiveDao {

	@Override
	public int insertBeehive(Beehive b) {
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
	public List<Beehive> selectAllBeehive() {
		Session session = HibernateUtil.getSession();
		List<Beehive> beehives = null;
		
		try {
			beehives = session.createQuery("FROM Beehive").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return beehives;
	}

	@Override
	public Beehive selectBeehiveById(int id) {
		Session session = HibernateUtil.getSession();
		Beehive beehive = null;
		
		try {
			beehive = (Beehive) session.get(Beehive.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return beehive;
	}

	@Override
	public void updateBeehive(Beehive change) {
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
	public void deleteBeehiveById(int id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(session.get(Beehive.class, id));
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
