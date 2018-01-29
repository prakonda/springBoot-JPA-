package com.parking.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.model.Customer;
import com.parking.repository.CustomerRepository;
import com.parking.response.ServiceResponse;
import com.parking.service.CustomerService;

/**
 * CustomerController Class implementation
 * 
 */
@RestController 
public class CustomerController {

	@Autowired  
    private CustomerService customerService;   
	
	@Autowired  
    private CustomerRepository customerRepository;
		
	/**
     * getAllCustomers controller implementation
     *
     * @return ServiceResponse<Customer>
     */
    @RequestMapping("/parking/customers")  
    public ServiceResponse<Collection<Customer>> getAllCustomers(){  
    	return customerService.getAllCustomers();  
    }     
    
    /**
     * getAllCustomerIDs controller implementation
     * 
     * @return ServiceResponse<Customer>
     */
    @RequestMapping("/parking/customerIDs")  
    public ServiceResponse<List<Integer>> getAllCustomerID(){  
        return customerService.getAllCustomerID();  
    }   
    
    /**
     * addCustomer controller implementation
     * 
     * @param customerRecord
     * @return ServiceResponse<Customer>
     */
    @RequestMapping(value="/parking/customerdetails", method=RequestMethod.POST)  
    public ServiceResponse<Customer> addCustomer(@RequestBody Customer customerRecord){  
    	return customerService.addCustomer(customerRecord);  
    }  
    
    /**
     * getCustomer controller implementation
     * 
     * @param id
     * @return ServiceResponse<Customer>
     */
    @RequestMapping(value="/parking/customer/{id}", method=RequestMethod.GET)  
    public ServiceResponse<Customer> getCustomer(@PathVariable int id){  
        return customerService.getCustomer(id);  
    }  
}
