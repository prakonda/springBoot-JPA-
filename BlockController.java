package com.parking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;  

import com.parking.model.Block;
import com.parking.repository.BlockRepository;
import com.parking.response.ServiceResponse;
import com.parking.service.BlockService;
import com.parking.service.CustomerService;

import java.util.List;

/**
 * BlockController Class implementation
 * 
 */
@RestController 
public class BlockController {
		
			@Autowired  
		    private BlockService blockService;   
			@Autowired  
		    private BlockRepository blockRepository;
			
			private static Logger log = LoggerFactory.getLogger(CustomerService.class);
		   
			  /**
		   	 * getAllBlocks Controller implementation
		   	 *
		   	 * @return ServiceResponse<Block>
		   	 */
			@RequestMapping("/parking/blocks")  
		    public ServiceResponse<List<Block>> getAllBlocks(){  
		         return blockService.getAllBlocks(); 
		    }  
			 /**
		   	 * addBlock Controller implementation
		   	 *
		   	 * @param blockRecord
		   	 * @return ServiceResponse<Block>
		   	 */  
		    @RequestMapping(value="/parking/addBlock", method=RequestMethod.POST)  
		    public ServiceResponse<Block> addBlock(@RequestBody Block blockRecord){  
		    	return blockService.addBlock(blockRecord);  
		    }  
		    
		    /**
		   	 * updateBlock Controller implementation
		   	 *
		   	 * @param blockRecord
		   	 * @return ServiceResponse<Block>
		   	 */
		        
		       @RequestMapping(value="/parking/updateBlock", method=RequestMethod.POST)  
		       public ServiceResponse<Block> updateBlock(@RequestBody Block blockRecord){  
		       	log.info("update Block controller");
		       	return blockService.updateBlock(blockRecord); 
		       }  
		       
		      /**
			   * getBlocksByLotID Controller implementation
			   *
			   * @param id
			   * @return ServiceResponse<Block>
			   */
		    
		    @RequestMapping(value="/parking/block/{id}", method=RequestMethod.GET)  
		    public ServiceResponse<List<Object>> getBlock(@PathVariable int id){  
		    	return blockService.getBlock(id);  
		    }  
		    
		    /**
			   *deletBlockByID Controller implementation
			   *
			   * @param id
			   * @return ServiceResponse<Block>
			   */
		    @RequestMapping(value="/parking/deleteBlock/{id}", method=RequestMethod.GET)  
		    public ServiceResponse<Block> deleteBlock(@PathVariable int id){  
		    	log.info("delete Block controller");
		    	return blockService.deleteBlock(id);
		    }  
		
	}

