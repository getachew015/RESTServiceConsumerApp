package com.dagim.search.model;


public class Flight {
	
	 private String source;
	 private String destination;
	 private String journeyDate;
	 private String fare;
	 private String flightId;
	 private String flightAvailableDate;
	 private String seatCount;
	 private String departureTime;
	 private String arrivalTime;
	 private String airlines;

	 public Flight(){
		 
	 }
	 public Flight(String source, String destination, String journeyDate, String fare, String flightId,
			String flightAvailableDate, String seatCount, String departureTime, String arrivalTime, String airlines) {
		super();
		this.source = source;
		this.destination = destination;
		this.journeyDate = journeyDate;
		this.fare = fare;
		this.flightId = flightId;
		this.flightAvailableDate = flightAvailableDate;
		this.seatCount = seatCount;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airlines = airlines;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getFlightAvailableDate() {
		return flightAvailableDate;
	}
	public void setFlightAvailableDate(String flightAvailableDate) {
		this.flightAvailableDate = flightAvailableDate;
	}
	public String getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(String seatCount) {
		this.seatCount = seatCount;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	@Override
	public String toString() {
		return "Flight [source=" + source + ", destination=" + destination + ", journeyDate=" + journeyDate + ", fare="
				+ fare + ", flightId=" + flightId + ", flightAvailableDate=" + flightAvailableDate + ", seatCount="
				+ seatCount + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", airlines="
				+ airlines + "]";
	}


}
