package com.dagim.search.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.dagim.search.model.Flight;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class FlightSearchController {
	
	@Autowired
	private Environment environment;
	

	@RequestMapping(value = "/searchFlights", method = RequestMethod.POST)
	public ModelAndView flightSearch(@Valid @ModelAttribute("command") Flight searchFlights,
		BindingResult bindingResult, ModelMap model, HttpSession session) {

		RestTemplate restTemplate = new RestTemplate();
		String url = (String) session.getAttribute("RestUrl");
		ModelAndView modelAndView = null;
		
		if (bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("searchFlights", "command", searchFlights);
		} 
		
		try {
			@SuppressWarnings("unchecked")
			List<Flight> availableFlights = restTemplate.getForObject(url + "/FlightAPI/" + searchFlights.getSource()
			+ "/" + searchFlights.getDestination() + "/" + searchFlights.getJourneyDate(), List.class);

	/*		List<String> sources = restTemplate.getForObject( url+ "/FlightAPI/source" , List.class);
			List<String> destinations = restTemplate.getForObject(url +"/FlightAPI/destination" , List.class);
	*/
			model.addAttribute("availableFlights", availableFlights);
			model.addAttribute("size", availableFlights.size());
	/*		modelAndView.addObject("sourceList", sources);
			modelAndView.addObject("destinationList", destinations);
	*/		modelAndView = new ModelAndView("searchFlights", "command", searchFlights);

			return modelAndView;
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("size", 0);
			modelAndView = new ModelAndView("searchFlights", "command", searchFlights);
			return modelAndView;
		}
			
	}

}
