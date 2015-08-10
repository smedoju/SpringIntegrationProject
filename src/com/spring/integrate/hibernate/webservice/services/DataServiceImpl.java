package com.spring.integrate.hibernate.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.integrate.hibernate.webservice.DataDao;
import com.spring.integrate.hibernate.webservice.DataService;
import com.spring.integrate.hibernate.webservice.Employee;

public class DataServiceImpl implements DataService {

	@Autowired  
	 DataDao dataDao;  
	  
	 @Override  
	 public int insertRow(Employee employee) {  
	  return dataDao.insertRow(employee);  
	 }  
	  
	 @Override  
	 public List<Employee> getEmployeeList() {  
	  return dataDao.getList();  
	 }  
	  
	 @Override  
	 public Employee getRowById(int id) {  
	  return dataDao.getRowById(id);  
	 }  
	  
	 @Override  
	 public int updateRow(Employee employee) {  
	  return dataDao.updateRow(employee);  
	 }  
	  
	 @Override  
	 public int deleteRow(int id) {  
	  return dataDao.deleteRow(id);  
	 }


}
