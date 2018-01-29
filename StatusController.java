package com.parking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.model.Status;
import com.parking.repository.StatusRepository;
import com.parking.response.ServiceResponse;
import com.parking.service.CustomerService;
import com.parking.service.StatusService;

/**
 * StatusController Class implementation
 * 
 */
@RestController
public class StatusController {

	@Autowired  
    private StatusService statusService;   
	@Autowired  
    private StatusRepository statusRepository;
	
	private static Logger log = LoggerFactory.getLogger(CustomerService.class);
	
	 /**
   	 * getAllStatus Controller implementation
   	 *
   	 * @return ServiceResponse<Status>
   	 */
	  @RequestMapping("/parking/getAllstatus") 
    public ServiceResponse<List<Status>> getAllStatus(){  
		  return statusService.getAllStatus();  
    }  
	
	  /**
		 * addStatus Controller implementation
		 *
		 * @param  statusRecord
		 * @return ServiceResponse<Status>
		 */
	         
    @RequestMapping(value="/parking/addStatus", method=RequestMethod.POST)  
    public ServiceResponse<Status> addStatus(@RequestBody Status statusRecord){  
    	log.info("add Status controller");
    	return statusService.addStatus(statusRecord); 
    }  
    
    /**
	 * deleteStatus Controller implementation
	 *
	 * @param id
	 * @return ServiceResponse<Status>
	 */
    @RequestMapping(value="/parking/status/{id}", method=RequestMethod.GET)  
    public ServiceResponse<Status> deleteStatus(@PathVariable int id){  
    	return statusService.deleteStatus(id);  
    }  
}
