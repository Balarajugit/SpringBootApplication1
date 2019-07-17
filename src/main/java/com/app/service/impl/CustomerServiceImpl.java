package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.module.Customer;
import com.app.repository.ICustomerRepository;
import com.app.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepository repo;

	@Override
	public Integer saveById(Customer c) {
		Customer cu=repo.save(c);
		Integer i=c.getCustId();
		return i;
	}

	@Transactional(readOnly = true)
	public List<Customer> getAppCustomers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Transactional(readOnly = true)
	@Cacheable(value = "Customer-Object",key = "#custId")
	public Customer getById(Integer custId) {
		// TODO Auto-generated method stub
		Optional<Customer> cu=repo.findById(custId);
		if(cu.isPresent()) {
			return cu.get();
		}
		return null;
	}

	@Transactional
	@CacheEvict(value = "Customer-Object",key = "#custId")
	public void deleteById(Integer custId) {
		repo.deleteById(custId);
		
	}
	
	

}
