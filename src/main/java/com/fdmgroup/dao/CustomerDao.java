package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fdmgroup.database.Customer;

@Component
public class CustomerDao {

	private EntityManagerFactory emf;
	
//	private List<Customer> customer;
	
	@Autowired
	public CustomerDao (EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void save(Customer customer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(customer);
		et.commit();
		em.close();
	}
	
	public void update(Customer customer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(customer);
		et.commit();
		em.close();
	}
	
	public Customer getCustomerById(Long id) {
		EntityManager em = emf.createEntityManager();
		Customer customer = em.find(Customer.class, id);
		em.close();
		return customer;
	}
	
	public List<Customer> getAllCustomer() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from "+Customer.class.getName()).getResultList();
	}
	
//	  public List<Customer> findAll(){
//		  EntityManager em = emf.createEntityManager();
//	      return em.createQuery( "from " + Customer.getName() )
//	       .getResultList();
//	   }
	
	
}
