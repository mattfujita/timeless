package com.libertymutual.goforcode.timeless.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.timeless.services.TimelessRepository;

@Controller
@RequestMapping("/")
public class TimelessController {

	private TimelessRepository repository;
	
    public TimelessController (TimelessRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("")
    public String redirectToApplication() {
        return "timeless/default";
    }

}
