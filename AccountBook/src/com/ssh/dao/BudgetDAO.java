package com.ssh.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.entity.Budget;
import com.ssh.entity.BudgetId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Budget entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ssh.entity.Budget
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class BudgetDAO {
	private static final Logger log = LoggerFactory.getLogger(BudgetDAO.class);
	// property constants
	public static final String AMOUNT = "amount";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Budget transientInstance) {
		log.debug("saving Budget instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Budget persistentInstance) {
		log.debug("deleting Budget instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Budget findById(com.ssh.entity.BudgetId id) {
		log.debug("getting Budget instance with id: " + id);
		try {
			Budget instance = (Budget) getCurrentSession().get("com.ssh.entity.Budget", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Budget instance) {
		log.debug("finding Budget instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.ssh.entity.Budget").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Budget instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Budget as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findAll() {
		log.debug("finding all Budget instances");
		try {
			String queryString = "from Budget";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Budget merge(Budget detachedInstance) {
		log.debug("merging Budget instance");
		try {
			Budget result = (Budget) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Budget instance) {
		log.debug("attaching dirty Budget instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Budget instance) {
		log.debug("attaching clean Budget instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BudgetDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BudgetDAO) ctx.getBean("BudgetDAO");
	}
}