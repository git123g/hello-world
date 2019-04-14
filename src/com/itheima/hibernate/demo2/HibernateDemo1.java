package com.itheima.hibernate.demo2;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.hibernate.domain.Customer;
import com.itheima.hibernate.utils.HibernateUtils;

/**
 * Hibernate的延迟加载
 * @author jt
 *
 */
public class HibernateDemo1 {

	@Test
	/**
	 * 类级别的延迟加载
	 * * 在<class>的标签上配置的lazy
	 */
	public void demo1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.load(Customer.class, 1l);
		Hibernate.initialize(customer);
		System.out.println(customer);
		
		tx.commit();
	}
}
