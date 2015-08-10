package com.spring.integrate.hibernate.webservice.dao;



import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.integrate.hibernate.webservice.DataDao;
import com.spring.integrate.hibernate.webservice.Employee;

public class DataDaoImpl implements DataDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int insertRow(Employee employee) {
		  Session session = sessionFactory.openSession();  
		  Transaction tx = session.beginTransaction();  
		  session.save(employee);  
		  tx.commit();  
		  Serializable id = session.getIdentifier(employee);  
		  session.close();  
		  return (Integer) id;  
	}

	@Override
	public List<Employee> getList() {
		  Session session = sessionFactory.openSession();		
		  Statistics stats = sessionFactory.getStatistics();
		  stats.setStatisticsEnabled(true);
		  @SuppressWarnings("unchecked")
		  List<Employee> employeeList = session.createQuery("from Employee").setCacheable(true).list();  		  
		  session.close();  		  
		  Statistics stat = sessionFactory.getStatistics();
		    String regions[] = stat.getSecondLevelCacheRegionNames();
		    System.out.println(regions.toString());
		    for(String regionName:regions) {
		        SecondLevelCacheStatistics stat2 = stat.getSecondLevelCacheStatistics(regionName);
		        System.out.println("2nd Level Cache(" +regionName+") Put Count: "+stat2.getPutCount());
		        System.out.println("2nd Level Cache(" +regionName+") HIt Count: "+stat2.getHitCount());
		        System.out.println("2nd Level Cache(" +regionName+") Miss Count: "+stat2.getMissCount());
		    }
		  return employeeList;
	}

	@Override
	public Employee getRowById(int id) {
		Session session=sessionFactory.openSession();
		Employee employee=(Employee) session.load(Employee.class, id);
		return employee;
	}

	@Override
	public int updateRow(Employee employee) {
		Session session=sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();  
		  session.saveOrUpdate(employee);  
		  tx.commit();  
		  Serializable id = session.getIdentifier(employee);  
		  session.close();  
		  return (Integer) id; 
		
	}

	@Override
	public int deleteRow(int id) {
		 Session session = sessionFactory.openSession();  
		  Transaction tx = session.beginTransaction();  
		  Employee employee = (Employee) session.load(Employee.class, id);  
		  session.delete(employee);  
		  tx.commit();  
		  Serializable ids = session.getIdentifier(employee);  
		  session.close();  
		  return (Integer) ids; 
	}

}
