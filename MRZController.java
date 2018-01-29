package com.parking.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jboss.jandex.Main;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.model.MRZ;
import com.parking.model.ScriptResult;
import com.parking.model.ScriptResultReader;

@RestController 
public class MRZController {

	
	// private MRZ mrz;
	
	 /**
		 * MRZResponse Controller implementation
		 * @param resuest
		 * @return MRZResponse
		 */
	     
	    @RequestMapping(value="/MRZResponse", method=RequestMethod.POST)  
	    public ScriptResult generateMRZCode(@RequestBody MRZRequest request){ 
	   
	    	ScriptResult scriptResult = new ScriptResult();
	    	MRZ mrz = new MRZ();	
	    System.out.println(request.toString());
	    
	   String surname= request.getSurNames();
	    
	    String cgiTestFileLocation = Main.class.getClassLoader().getResource("uniqueid_1.cgi").getPath().substring(1);

        // cmd command with relevant arguments
        String[] commands = {
                "perl", "-wT", cgiTestFileLocation,
                "givennames="+request.getGivenNames(),
                "surnames="+request.getSurNames(),
                "by="+request.getBirthYear(), "bm="+request.getBirthMonth(), "bd="+request.getBirthDate(),
                "sex="+request.getSex(),
                "issuer="+request.getIssuer(),
                "ey="+request.getExpireYear(), "em="+request.getExpireMonth(), "ed="+request.getExpireDate(),
                "passportnumber="+request.getPassportNum(),
                "pin="+request.getPersonalNum(),
                "nationality="+request.getNationality(),
                "step=1"
        };

        Runtime rt = Runtime.getRuntime();
        ScriptResultReader scriptResultReader = new ScriptResultReader();
        try {
            Process proc = null;
            proc = rt.exec(commands);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String s = stdInput.readLine();
            while (stdInput.ready()) {
                s += stdInput.readLine();
            }
            scriptResult = scriptResultReader.read(s);
            System.out.println(scriptResult);
           
        } catch (IOException e) {
            e.printStackTrace();
        }
		return scriptResult;
	
    
	
	    	
//	    	return  mrz.getMRZResponse(request); 
	   
	    } 
}
