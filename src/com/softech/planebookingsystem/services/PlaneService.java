package com.softech.planebookingsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softech.planebookingsystem.dao.Plane;
import com.softech.planebookingsystem.dao.PlaneDAO;

@Service("planeService")
public class PlaneService {
	
	@Autowired
	private PlaneDAO planeDao;
	
	public List<Plane> getPlanes(){
		
		return planeDao.getPlanes();
	}
	
	public void save(Plane plane){
		planeDao.create(plane);
	}
	
	public List<Plane> getRecent(){
		return planeDao.getRecent();
	}
	
	

}
