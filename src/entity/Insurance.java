package entity;

import java.util.ArrayList;

public class Insurance {
	String insurer, insName, description;
	double insPrice;
	int insNo;
	//static int insNo;

	public Insurance(int insNo, String insurer, String insName, String decription, double insPrice) {
		setInsNo(insNo);
		setInsurer(insurer);
		setInsName(insName);
		setDescription(decription);
		setInsPrice(insPrice);
	}
	
	public Insurance(){
		
	}
	
	public ArrayList <String> defaultInsurer(){
		ArrayList <String> insurerList=new ArrayList<String>();
		
		insurerList.add("AIG");
		insurerList.add("Allianz");
		insurerList.add("JS Insurance");
		return insurerList;
	}
	
	public ArrayList <String> defaultInsName(){
		ArrayList <String> insNameList=new ArrayList<String>();
		
		insNameList.add("Basic");
		insNameList.add("Elite");
		insNameList.add("Premier");
		return insNameList;
	}
	
	public double insPrice(String insName) {
		if(insName.equalsIgnoreCase("Basic")) {
			return 49.90;
		}else if(insName.equalsIgnoreCase("Elite")) {
			return 124.90;
		}else if(insName.equalsIgnoreCase("Premier")) {
			return 235.60;
		}else {
			return 0;
		}
	}
	
	public String insDesc(String insName) {
		if(insName.equalsIgnoreCase("Basic")) {
			return "Personal Accident up to $100,000";
		}else if(insName.equalsIgnoreCase("Elite")) {
			return "Personal Accident up to $500,000";
		}else if(insName.equalsIgnoreCase("Premier")) {
			return "Personal Accident up to $1,000,000";
		}else {
			return "null";
		}
	}
	
	public int getInsNo() {
		return insNo;
	}

	public void setInsNo(int insNo) {
		this.insNo = insNo;
	}

	public String getInsurer() {
		return insurer;
	}

	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}

	public String getInsName() {
		return insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getInsPrice() {
		return insPrice;
	}

	public void setInsPrice(double insPrice) {
		this.insPrice = insPrice;
	}

	@Override
	public String toString() {
		return "Insurance [insurer=" + insurer + ", insName=" + insName + ", description=" + description + ", insPrice=" + insPrice + "]";
	}
}
