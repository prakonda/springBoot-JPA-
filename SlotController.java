package com.parking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;  

import com.parking.model.Slot;
import com.parking.repository.SlotRepository;
import com.parking.response.ServiceResponse;
import com.parking.service.BlockService;
import com.parking.service.CustomerService;
import com.parking.service.SlotService;

import java.util.List;

/**
 * SlotController Class implementation
 * 
 */
@RestController 
public class SlotController {
	
		@Autowired  
	    private SlotService slotService;   
		@Autowired  
	    private SlotRepository slotRepository;
		
		@Autowired  
	    private BlockService blockService;   
		
		private static Logger log = LoggerFactory.getLogger(CustomerService.class);
		
		/**
		 * getAllSlots Controller implementation
		 *  
		 * @return ServiceResponse<Slot>
		 */
	    @RequestMapping("/parking/slots")  
	    public ServiceResponse<List<Slot>> getAllSlots(){  
	    	return  slotService.getAllSlots(); 
	        
	    }  
	    
	    /**
		 * addSlot Controller implementation
		 * 
		 * @param slotRecord
		 * @return ServiceResponse<Slot>
		 */
	    @RequestMapping(value="/parking/addSlot", method=RequestMethod.POST)  
	    public ServiceResponse<Slot> addSlot(@RequestBody Slot slotRecord){  
	    	return slotService.addSlot(slotRecord);  
	    } 
	    
	    /**
		 * getSlotByBlockID Controller implementation
		 * 
		 * @param id
		 * @return ServiceResponse<Slot>
		 */
	    @RequestMapping(value="/parking/slot/{id}", method=RequestMethod.GET)  
	    public ServiceResponse<List<Slot>> getSlotByBlockID(@PathVariable int id){  
	    	return slotService.getSlotByBlockID(id); 
	    }  
	    
	    /**
	   	 * updateSlot Controller implementation
	   	 *
	   	 * @param slotRecord
	   	 * @return ServiceResponse<Slot>
	   	 */
	        
	       @RequestMapping(value="/parking/updateSlot", method=RequestMethod.POST)  
	       public ServiceResponse<Slot> updateSlot(@RequestBody Slot slotRecord){  
	       	log.info("update Slot controller");
	       	return slotService.updateSlot(slotRecord); 
	       }  
	       
	       /**
		   	 * bookingSlot Controller implementation
		   	 *
		   	 * @param slotRecord
		   	 * @return ServiceResponse<Slot>
		   	 */
		        
		       @RequestMapping(value="/parking/updateSlotStatusByID", method=RequestMethod.POST)  
		       public ServiceResponse<Slot> updateSlotStatusByID(@RequestBody Slot slotRecord){  
		    	   log.info("updating available Slot status controller");
		    	   return slotService.updateSlotStatusByID(slotRecord); 
		       }  
	     
	       /**
		   	 * bookingSlot Controller implementation
		   	 *
		   	 * @param slotRecord
		   	 * @return ServiceResponse<Slot>
		   	 */
		        
		       @RequestMapping(value="/parking/bookSlot", method=RequestMethod.POST)  
		       public ServiceResponse<Slot> bookSlot(@RequestBody Slot slotRecord){  
		    	   log.info("Checking available Slot controller");
		    	   return slotService.bookSlot(slotRecord); 
		       }     
	
	    /**
		 * deleteSlotByBlockID Controller implementation
		 * 
		 * @param id
		 * @return ServiceResponse<Slot>
		 */
	    
	    @RequestMapping(value="/parking/deleteSlot/{id}", method=RequestMethod.GET)  
	    public ServiceResponse<Slot> deleteSlot(@PathVariable int id){  
	    	log.info("delete slot controller");
	    	return slotService.deleteSlot(id);
	    }
	    
	    /**
		 * freeingReserveSlot Controller implementation
		 * 
		 */
	    
	    @Scheduled(fixedRate=300000)
	    public void releaseReserveSlot(){  
	    	log.info("freeingReserveSlot in lot controller");
	    	slotService.releaseReserveSlot();
	    } 
}
