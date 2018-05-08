package com.softech.planebookingsystem.dao;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Plane {

	
	private int planeId;
	
	@NotEmpty
	@Size(min = 3, max= 100, message = "Name must be beteen 3 and 100")
	private String planeName;
	
	@NotNull
	private String planeNo;
	
	@NotNull
	@NotEmpty
	private String passengerSeat;
	
	public Plane(){}
	
	public Plane(int planeId, String planeName, String planeNo, String passengerSeat) {
		super();
		this.planeId = planeId;
		this.planeName = planeName;
		this.planeNo = planeNo;
		this.passengerSeat = passengerSeat;
	}
	public int getPlaneId() {
		return planeId;
	}
	public void setPlaneId(int planeId) {
		this.planeId = planeId;
	}
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public String getPlaneNo() {
		return planeNo;
	}
	public void setPlaneNo(String planeNo) {
		this.planeNo = planeNo;
	}
	public String getPassengerSeat() {
		return passengerSeat;
	}
	public void setPassengerSeat(String passengerSeat) {
		this.passengerSeat = passengerSeat;
	}
	
	public void setNull(){
		this.planeName = null;
		this.planeNo = null;
		this.passengerSeat = null;
	}
	@Override
	public String toString() {
		return "Plane [planeId=" + planeId + ", planeName=" + planeName + ", planeNo=" + planeNo + ", passengerSeat="
				+ passengerSeat + "]";
	}
	
	
}
