package com.parking.controller;

import java.math.BigDecimal;
import java.util.List;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.parking.model.Lot;
import com.parking.repository.LotRepository;
import com.parking.response.ServiceResponse;
import com.parking.service.CustomerService;
import com.parking.service.LotService;


/**
 * LotController Class implementation
 * 
 */
@RestController 
public class LotController {
	
	@Autowired  
    private LotService lotService;   
	@Autowired  
    private LotRepository lotRepository;
	
	private static Logger log = LoggerFactory.getLogger(CustomerService.class);
	
	 /**
		 * getAllAvailableLots Controller implementation
		 * 
		 * @param lat
		 * @param lon
		 * @return ServiceResponse<List<Object>>
		 * @throws JSONException 
		 */
    @GetMapping("/parking/lotsAvailable")  
    public ServiceResponse<List<Object>> getAllAvailableLots(@RequestParam("lat") BigDecimal lat, @RequestParam("lon") BigDecimal lon) throws JSONException{ 
    	log.info(lat+" "+lon+ " Lots available controller");
    	return lotService.getAllAvailableLots(lat,lon);
    }
  
    /**
   	 * getAllLots Controller implementation
   	 *
   	 * @return ServiceResponse<Lot>
   	 */
	@RequestMapping("/parking/lots")  
    public ServiceResponse<List<Lot>> getAllLots(){  
         return lotService.getAllLots(); 
    }  
	
	
    /**
	 * addLot Controller implementation
	 * @param lotRecord
	 * @return ServiceResponse<Lot>
	 */
     
    @RequestMapping(value="/parking/addLot", method=RequestMethod.POST)  
    public ServiceResponse<Lot> addLot(@RequestBody Lot lotRecord){  
    	log.info("add lot controller");
    	return  lotService.addLot(lotRecord); 
    }  
    
    
    /**
   	 * updateLot Controller implementation
   	 *
   	 * @param lotRecord
   	 * @return ServiceResponse<Lot>
   	 */
        
       @RequestMapping(value="/parking/updateLot", method=RequestMethod.POST)  
       public ServiceResponse<Lot> updateLot(@RequestBody Lot lotRecord){  
    	   log.info("update lot controller");
    	   return lotService.updateLot(lotRecord); 
       }  
       
       
    /**
	 * deleteLotByID Controller implementation
	 * 
	 * @param id
	 * @return ServiceResponse<Lot>
	 */
    
    @RequestMapping(value="/parking/deleteLot/{id}", method=RequestMethod.GET)  
    public ServiceResponse<Lot> deleteLot(@PathVariable int id){  
    	log.info("delete lot controller");
    	return lotService.deleteLot(id);
    }  
 
}
