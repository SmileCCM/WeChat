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

import com.ssh.entity.Classes;

/**
 * A data access object (DAO) providing persistence and search support for
 * Classes entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ssh.dao.Classes
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ClassesDAO {
	private static final Logger log = LoggerFactory.getLogger(ClassesDAO.class);
	// property constants
	public static final String CNAME = "cname";
	public static final String LX = "lx";

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

	public void save(Classes transientInstance) {
		log.debug("saving Classes instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Classes persistentInstance) {
		log.debug("deleting Classes instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Classes findById(java.lang.Integer id) {
		log.debug("getting Classes instance with id: " + id);
		try {
			Classes instance = (Classes) getCurrentSession().get("com.ssh.dao.Classes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Classes instance) {
		log.debug("finding Classes instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.ssh.dao.Classes").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Classes instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Classes as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCname(Object cname) {
		return findByProperty(CNAME, cname);
	}

	public List findByLx(Object lx) {
		return findByProperty(LX, lx);
	}

	public List findAll() {
		log.debug("finding all Classes instances");
		try {
			String queryString = "from Classes";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Classes merge(Classes detachedInstance) {
		log.debug("merging Classes instance");
		try {
			Classes result = (Classes) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Classes instance) {
		log.debug("attaching dirty Classes instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Classes instance) {
		log.debug("attaching clean Classes instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClassesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClassesDAO) ctx.getBean("ClassesDAO");
	}
}