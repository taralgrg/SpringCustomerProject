package com.fdmgroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fdmgroup.dao.CustomerDao;
import com.fdmgroup.database.Customer;

@Component
public class CustomerService {

	
	private CustomerDao customerDao;
	
	
	@Autowired
	public CustomerService(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}



	public List<Customer> listAll() {
		return customerDao.getAllCustomer();
	}

	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}
	
	
	
	//  public List<T> findAll() {
	//  EntityManager em = emf.createEntityManager();
	//  return em.createQuery("from " + entityClass.getName()).getResultList();
	//}
}
