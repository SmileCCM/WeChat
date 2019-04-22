package com.ssh.dao;

import java.util.Date;
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

import com.ssh.entity.Bills;

/**
 * A data access object (DAO) providing persistence and search support for Bills
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ssh.entity.Bills
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class BillsDAO {
	private static final Logger log = LoggerFactory.getLogger(BillsDAO.class);
	// property constants
	public static final String LX = "lx";
	public static final String ACCT = "acct";
	public static final String CLASS_ = "class_";
	public static final String MONEY = "money";
	public static final String REMARK = "remark";

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

	public void save(Bills transientInstance) {
		log.debug("saving Bills instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bills persistentInstance) {
		log.debug("deleting Bills instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bills findById(java.lang.Integer id) {
		log.debug("getting Bills instance with id: " + id);
		try {
			Bills instance = (Bills) getCurrentSession().get("com.ssh.entity.Bills", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Bills instance) {
		log.debug("finding Bills instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.ssh.entity.Bills").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Bills instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Bills as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLx(Object lx) {
		return findByProperty(LX, lx);
	}

	public List findByAcct(Object acct) {
		return findByProperty(ACCT, acct);
	}

	public List findByClass_(Object class_) {
		return findByProperty(CLASS_, class_);
	}

	public List findByMoney(Object money) {
		return findByProperty(MONEY, money);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all Bills instances");
		try {
			String queryString = "from Bills";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findByMonth(String openid,String bdate) {
		log.debug("finding bills by month");
		try {
			String queryString="from Bills where DATE_FORMAT(billdate,'%Y-%m')=? AND users.openid=? ORDER BY billdate DESC";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, bdate);
			queryObject.setParameter(1, openid);
			return queryObject.list();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("find all failed", e);
			throw e;
		}
	}
	public List findByItems(Double min,Double max,String classes,String seek,String openid) {
		log.debug("finding bills by many conditions");
		try {
			String hql="from Bills where ";
			if (min!=null&&max!=null) {
				hql=hql+"money BETWEEN "+min+" AND "+max+" AND ";
			}
	     	else if (min==null&&max!=null) {
	     		hql=hql+"money <= "+max+" AND ";
			}
	     	else if (min!=null&&max==null) {
	     		hql=hql+"money >= "+min+" AND ";
			}
	     	if (classes!=null) {
	     		hql=hql+"class_=\'"+classes+"\' AND ";
			}
	     	if (seek!=null) {
	     		hql=hql+"remark LIKE '%"+seek+"%' AND ";
			}
	     	hql=hql+"users.openid='"+openid+"' ORDER BY billdate DESC";
	     	Query queryObject = getCurrentSession().createQuery(hql);
	     	return queryObject.list();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("find all failed", e);
			throw e;
		}
	}
	public Bills merge(Bills detachedInstance) {
		log.debug("merging Bills instance");
		try {
			Bills result = (Bills) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bills instance) {
		log.debug("attaching dirty Bills instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bills instance) {
		log.debug("attaching clean Bills instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BillsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BillsDAO) ctx.getBean("BillsDAO");
	}
}