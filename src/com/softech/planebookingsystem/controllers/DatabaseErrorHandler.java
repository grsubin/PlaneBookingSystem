package com.softech.planebookingsystem.controllers;

import org.springframework.dao.DataAccessException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseErrorHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleDatabaseException(Exception ex){
		return "error";
	}
	

}
