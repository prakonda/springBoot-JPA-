package com.parking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.parking.model.Bookingdetail;
import com.parking.repository.BookingDetailRepository;
import com.parking.response.ServiceResponse;
import com.parking.service.BookingDetailService;

/**
 * BookingdetailController Class implementation
 * 
 */
@RestController
public class BookingdetailController {

	@Autowired  
    private BookingDetailService bookingDetailService;   
	@Autowired  
    private BookingDetailRepository bookingDetailRepository;
	
	
    @RequestMapping("/BookingDetails")  
    public List<Bookingdetail> getAllBookingdetails(){  
        return bookingDetailService.getAllBookingdetails();  
    }     
    
    /**
   	 * addBookingdetail Controller implementation
   	 *
   	 * @param bookingdetails
   	 * @return ServiceResponse<Bookingdetail>
   	 */  
    @RequestMapping(value="/parking/addBookingDetail", method=RequestMethod.POST)  
    public ServiceResponse<Bookingdetail> addBookingDetails(@RequestBody Bookingdetail bookingdetails){  
    	return bookingDetailService.addBookingDetails(bookingdetails);
    } 
    
    
    /**
   	 * addBookingdetail Controller implementation
   	 *
   	 * @param id
   	 * @return ServiceResponse<Bookingdetail>
   	 */  
    @RequestMapping(value="/parking/getBookingDetailsByID/{id}", method=RequestMethod.GET)  
    public ServiceResponse<Bookingdetail> getBookingDetailsByID(@PathVariable int id){  
    	return bookingDetailService.getBookingDetailsByID(id);
    } 
    
    /**
   	 * updateActualInTimeByID Controller implementation
   	 *
   	 * @param actualInTime
   	 * @return ServiceResponse<Bookingdetail>
   	 */  
    @RequestMapping(value="/parking/updateActualInTimeByID", method=RequestMethod.POST)  
    public ServiceResponse<Bookingdetail> updateActualInTimeByID(@RequestBody Bookingdetail actualInTime){  
    	return bookingDetailService.updateActualInTimeByID(actualInTime); 
    }
    
    /**
   	 * updateActualOuttimeByID Controller implementation
   	 *
   	 * @param actualOuttime
   	 * @return ServiceResponse<Bookingdetail>
   	 */  
    @RequestMapping(value="/parking/updateActualOuttimeByID", method=RequestMethod.POST)  
    public ServiceResponse<Bookingdetail> updateActualOuttimeByID(@RequestBody Bookingdetail actualOuttime){  
    	return bookingDetailService.updateActualOuttimeByID(actualOuttime); 
    }
    
    /**
   	 * updateBookingdetailById Controller implementation
   	 *
   	 * @param bookingdetails
   	 * @return ServiceResponse<Bookingdetail>
   	 */  
    @RequestMapping(value="/parking/updateBookingDetail", method=RequestMethod.POST)  
    public ServiceResponse<Bookingdetail> updateBookingDetailsById(@RequestBody Bookingdetail bookingdetails){  
    	return bookingDetailService.updateBookingDetailsByID(bookingdetails);  
    }
    
    /**
   	 * deleteBookingDetail Controller implementation
   	 *
   	 * @param id
   	 * @return ServiceResponse<Bookingdetail>
   	 */
    @RequestMapping(value="/deleteBookingdetail/{id}", method=RequestMethod.GET)  
    public ServiceResponse<Bookingdetail> deleteBookingDetail(@PathVariable int id){  
    	return bookingDetailService.deleteBookingDetail(id);
    }  
}
