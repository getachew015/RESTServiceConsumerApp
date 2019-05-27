package com.dagim.search.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.dagim.search.model.Flight;



@Controller
@SessionAttributes("contextPath")
public class HomeController {

    @Autowired
    private Environment environment;

    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    
	@RequestMapping(value="/" , method= RequestMethod.GET)
	public ModelAndView home(HttpSession session, HttpServletRequest request){
		//return Model and view Name

		session.setAttribute("RestUrl", "http://localhost:8080/ReservSys/");
		return new ModelAndView("searchFlights","command", new Flight());
	}
	    

    @RequestMapping(value = "/flight", method = RequestMethod.GET)
    public ModelAndView getSourceDestinationDetails(HttpSession session, HttpServletRequest request) {
        String restUrl = (String) session.getAttribute("RestUrl");
        session.setAttribute("contextPath", request.getContextPath());
        RestTemplate restTemplate = new RestTemplate();
        List<String> sources = restTemplate.getForObject( restUrl+ "/FlightAPI/source" , List.class);
        
        List<String> destinations = restTemplate.getForObject( restUrl +"/FlightAPI/destination" , List.class);
        ModelAndView modelAndView = new ModelAndView("searchFlights", "command", new Flight());
        modelAndView.addObject("sourceList", sources);
        modelAndView.addObject("destinationList", destinations);
        
        return modelAndView;
    }  


}
