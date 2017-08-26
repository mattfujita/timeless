package com.libertymutual.goforcode.timeless.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.timeless.models.Timeless;
import com.libertymutual.goforcode.timeless.services.TimelessRepository;

@Controller
@RequestMapping("/")
public class TimelessController {

	private TimelessRepository repository;
	
	Timeless row = new Timeless();
	Timeless currentWeek = new Timeless();
	List<Timeless> submission = new ArrayList<Timeless>();
	
    public TimelessController (TimelessRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("")
    public String redirectToApplication() {
        return "redirect:/tracker";
    }
    
    @GetMapping("tracker")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("timeless/default");
        
        submission = repository.getAll();
        return mv;
    }
    
    @PostMapping("tracker")
    public ModelAndView create(String action, Timeless time) {
    	ModelAndView mv = new ModelAndView("timeless/default");
    	
    	String totalHours = Double.toString(time.calculateTotalHours());
    	
    	if(action.equals("update")) {
    		mv.addObject("tempDate", time.getDateText());
    		mv.addObject("tempMon", time.getMondayHours());
    		mv.addObject("tempTue", time.getTuesdayHours());
    		mv.addObject("tempWed", time.getWednesdayHours());
    		mv.addObject("tempThur", time.getThursdayHours());
    		mv.addObject("tempFri", time.getFridayHours());
    		mv.addObject("totalHours", totalHours);
    		
    		repository.update(time);
    		mv.addObject("submittedEntry", submission);

    		mv.addObject("rowEntry", row);

    	} else if(action.equals("submit")) {
    		
    		repository.submit(time);
    		submission = repository.getAll();
    		mv.addObject("submittedEntry", submission);
    		
    	}
    	return mv;
    }


}
