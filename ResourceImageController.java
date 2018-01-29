package com.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.parking.repository.ResourceRepository;
import com.parking.service.ResourceImageService;

@RestController
public class ResourceImageController {

	
	@Autowired  
    private ResourceImageService resImgService;  
	
	@Autowired 
	private ResourceRepository resourceRepo;
	
	/**
   	 * getResourceImage Controller implementation
   	 *
   	 * @return ServiceResponse<Status>
   	 */
	  @RequestMapping(value = "/getResources/{resource_ID}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getResourceImage(@PathVariable String resource_ID){  
		  return resImgService.getImagesByID(resource_ID);  
    }  
	
    
    /**
   	 * getResourceVideo Controller implementation
   	 *
   	 * @return ServiceResponse<Status>
   	 */
	  @RequestMapping(value = "/getResourceVideo/{resource_ID}", method = RequestMethod.GET, produces = "video/mp4")
    public ResponseEntity<byte[]> getResourceVideo(@PathVariable String resource_ID){  
		  return resImgService.getVideoByID(resource_ID);  
    }  
}
