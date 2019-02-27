package entity;

import java.util.ArrayList;

public class Seat {
	private String seatType, seatDescription, seatFood;
	private int seatNo;
	private double seatPrice;
	
	public Seat(int seatNo, String seatType, String seatFood, double seatPrice, String seatDescription) {
		
		setSeatNo(seatNo);
		setSeatType(seatType);
		setSeatFood(seatFood);
		setSeatPrice(seatPrice);
		setSeatDescription(seatDescription);
	}
	
public Seat(){
		
	}
	
	public ArrayList <String> defaultSeatType(){
		ArrayList <String> seatTypeList=new ArrayList<String>();
		seatTypeList.add("First Class");
		return seatTypeList;
	}
	
	public ArrayList <String> defaultSeatFood(){
		ArrayList <String> seatFoodList=new ArrayList<String>();
		seatFoodList.add("Balsamic-Glazed Steak Rolls");
		seatFoodList.add("Melt-In-Your-Mouth Baked Chicken");
		seatFoodList.add("Baked Shrimp with Orzo and Feta");
		seatFoodList.add("One-Pot Chicken Lo Mein");	
		return seatFoodList;
	}
	
	public double seatPrice(String seatFood) {
		if(seatFood.equalsIgnoreCase("Balsamic-Glazed Steak Rolls")) {
			return 1025.90;
		}else if(seatFood.equalsIgnoreCase("Melt-In-Your-Mouth Baked Chicken")) {
			return 1020.90;
		}else if(seatFood.equalsIgnoreCase("Baked Shrimp with Orzo and Feta")) {
			return 1033.90;
		}else if(seatFood.equalsIgnoreCase("One-Pot Chicken Lo Mein")){
			return 1028.90;
		}else {
			return 0;
		}
	}
	
	public ArrayList <String> defaultSeatDescription(){
		ArrayList <String> seatDescList=new ArrayList<String>();
		seatDescList.add("More space with 5cm wider seat");
		seatDescList.add("AC power outlet");
		seatDescList.add("The MAGIC inflight entertainment system.");	
		return seatDescList;
	}
	
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	
	public String getSeatFood() {
		return seatFood;
	}

	public void setSeatFood(String seatFood) {
		this.seatFood = seatFood;
	}

	public double getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

	public String getSeatDescription() {
		return seatDescription;
	}

	public void setSeatDescription(String seatDescription) {
		this.seatDescription = seatDescription;
	}

	@Override
	public String toString() {
		return "Seat [seatNo=" + seatNo + ", seatType=" + seatType + ", flightNo=" + seatFood + ", seatPrice=" + seatPrice
				+ "]\n";
	}



}
