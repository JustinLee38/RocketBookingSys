package entity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Flight {
	String origin, destination, departureTime, arrivalTime;
	int flightNo;

	public Flight(int flightNo, String origin, String destination, String departureTime, String arrivalTime) {
		setFlightNo(flightNo);
		setOrigin(origin);
		setDestination(destination);
		setDepartureTime(departureTime);
		setArrivalTime(arrivalTime);
		
	}
	public Flight(){
		
	}
	
	public ArrayList <String> defaultOriginList(){
		ArrayList <String> originList=new ArrayList<String>();
		
		originList.add("Malaysia");
		originList.add("USA");
		originList.add("United Kingdom");
		originList.add("China");
		return originList;
	}
	public ArrayList <String> defaultDestinationList(){
		ArrayList <String> destinationList=new ArrayList<String>();
		
		destinationList.add("Mars");
		destinationList.add("Moon");
		return destinationList;
	}
	public ArrayList <String> defaultDepartureDate(){
		ArrayList <String> departureDateList=new ArrayList<String>();
		
		departureDateList.add("2018-5-15 19:00:00");
		departureDateList.add("2018-6-15 19:00:00");
		departureDateList.add("2018-7-15 19:00:00");
		/*departureDateList.add("2018-8-15 19:00:00");
		departureDateList.add("2018-9-15 19:00:00");
		departureDateList.add("2018-10-15 19:00:00");*/
		return departureDateList;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "Flight " + flightNo + "[origin= " + origin + ", destination=" + destination + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + "]\n";
	}


}
