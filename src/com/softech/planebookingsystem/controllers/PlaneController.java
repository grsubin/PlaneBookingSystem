package com.softech.planebookingsystem.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softech.planebookingsystem.dao.Plane;
import com.softech.planebookingsystem.services.PlaneService;

@Controller
public class PlaneController {
	
	@Autowired
	private PlaneService planeService;
	
	
	@RequestMapping("/planes")
	public String showPlanes(Model model){
		
		
		List<Plane> planes = planeService.getPlanes();
		model.addAttribute("planes",planes);
		
		return "planes";
	}
	
	@RequestMapping(value="/plane-form", method=RequestMethod.GET)
	public String showPlaneForm(ModelMap model){
		model.addAttribute("plane", new Plane());
		return "plane-form";
	}
	
	@RequestMapping(value = "/do-add-details", method = RequestMethod.POST)
	public String addPlaneDetails(Model model,@Valid Plane plane,BindingResult result ){
		
		List<Plane> recentPlane =null;
//		if(result.hasErrors()){
//			System.out.println("Form does not validate.");
//				
//			List<ObjectError> errors = result.getAllErrors();
//			
//			for(ObjectError error: errors){
//				System.out.println(error.getDefaultMessage());
//			}
//			model.addAttribute("plane", recentPlane);
//
//		}else{
//			System.out.println("Form validated.");
//			System.out.println(plane);
//			planeService.save(plane);
//			recentPlane = planeService.getRec	ent();		
//			model.addAttribute("plane", recentPlane);
//			model.addAttribute("success", "Entry Successful!");
//		}
		
//		if(result.hasErrors()){
//			model.addAttribute("plane", recentPlane);		
//
//			return "plane-form";
//		}else{
//			System.out.println("Form validated.");
//			System.out.println(plane);
//			planeService.save(plane);
//			recentPlane = planeService.getRecent();		
//			model.addAttribute("plane", recentPlane);
//			model.addAttribute("success", "Entry Successful!");
//			return "plane-form";
//		}
		
		if(result.hasErrors()){
			
			model.addAttribute("recPlane", recentPlane);
			return "plane-form";
			
		}else{
			recentPlane = planeService.getRecent();		
			
			planeService.save(plane);
			
			model.addAttribute("recPlane", recentPlane);
			model.addAttribute("success", "Entry Successful!");
			plane.setNull();
			return"plane-form";
		}
		
		
		
	}

}
