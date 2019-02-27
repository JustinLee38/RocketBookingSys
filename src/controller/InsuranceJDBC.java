package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import entity.Insurance;

public class InsuranceJDBC {
	Statement stmt;
	//constructor
	public InsuranceJDBC () throws SQLException, Exception {
		//1. load driver
		Class.forName("com.mysql.jdbc.Driver");
		//2. connect to mydatbase 
		String url = "jdbc:mysql://localhost:3306/rocketbookingsystem";
		String user= "root";
		String password="";
		Connection con = DriverManager.getConnection(url, user, password);
		//3. create statement
		stmt = con.createStatement();
	}

	public boolean addInsurance(Insurance ins)throws SQLException{
		//4. sql statement			
		String insert = String.format("INSERT INTO `insurance`(`insNo`, `insurer`, `insName`, `insPrice`, `description`) "
				+ "VALUES ('%d','%s','%s','%.2f','%s')",ins.getInsNo(),ins.getInsurer(), ins.getInsName(), 
				ins.getInsPrice(), ins.getDescription()); 
		//date format : 'YYYY-MM-DD HH:MM:SS'
		System.out.println(insert);
		//5. execute update
		int rows = stmt.executeUpdate(insert);
		//6. return result
		if (rows ==1)
			return true;
		else
			return false;
	}

	public boolean deleteInsurance(String insNo) throws SQLException{
		//4: sql
		String delete = String.format("DELETE FROM `insurance` WHERE "
				+ "insNo='%s'", insNo);
		//5. execute update
		int rows = stmt.executeUpdate(delete);
		//6. return result
		if (rows > 0)
			return true;
		else
			return false;

	}

	public boolean updateInsurance(Insurance ins) throws SQLException{
		
		String update = String.format("UPDATE `insurance` SET `insurer`='%s',`insName`='%s',`insPrice`='%.2f',"
				+ "`description`='%s' WHERE `insNo`= '%d'", ins.getInsurer(),ins.getInsName(), 
				ins.getInsPrice(), ins.getDescription(), ins.getInsNo());
		System.out.println(update);
		int rows = stmt.executeUpdate(update);

		if (rows == 1)
			return true;
		else
			return false;
	}
	
	
	public boolean insuranceValidation(String insurer, String insName) throws Exception{
		int insNo = 100;
		String view = String.format("SELECT EXISTS (SELECT * FROM insurance WHERE `insurer`= \"%s\" AND `insName`= \"%s\")", insurer, insName);
		System.out.println(view);
		ResultSet rs = stmt.executeQuery(view);		
		String s = ("EXISTS (SELECT * FROM insurance WHERE `insurer`= \"" + insurer + "\" AND `insName`= \"" + insName + "\")");
		
		while (rs.next()){
			insNo = rs.getInt(s);
			
		}
		System.out.println(insNo);
		if(insNo == 1)
			return true;
		else
			return false;
		
	}

	public ArrayList <Insurance> ViewAllInsurance () throws Exception{
		ArrayList <Insurance>insList=new ArrayList<Insurance>();
		//String view = "select * from 'insurance' order by 'insNo'";
		String view = "SELECT * FROM `insurance` ORDER BY insNo";
		ResultSet rs = stmt.executeQuery(view);

		while (rs.next()){
			int insNo = rs.getInt("insNo");
			String insurer = rs.getString("insurer");
			String insName = rs.getString("insName");
			double insPrice = rs.getDouble("insPrice");
			String description = rs.getString("description");

			Insurance ins = new Insurance(insNo, insurer, insName, description, insPrice);
			insList.add(ins);
		}
		return insList;
	}

	public ArrayList <String> ViewAllInsNo() throws Exception{
		ArrayList <String> insList=new ArrayList<String>();
		String view = "SELECT `insNo` FROM `insurance`";
		System.out.println(view);
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()){
			String seatNo = rs.getString("insNo");			
			insList.add(seatNo);
		}
		return insList;
	}
	
	public double getInsPrice(int userInsNo) throws SQLException {
		String view = String.format("select insPrice from insurance where insNo = '%s'", userInsNo);
		ResultSet rs = stmt.executeQuery(view);
		System.out.println(view);
		double insPrice = 0.0;
		while (rs.next()){

			insPrice = rs.getDouble("insPrice");
		}
		return insPrice;
	}
	

	public int insNoValidation() {
		ArrayList <Integer> insList=new ArrayList<Integer>();
		String view = "SELECT `insNo` FROM `insurance`";
		System.out.println(view);
		ResultSet rs;
		try {
			rs = stmt.executeQuery(view);
			while (rs.next()){
				int insNo = rs.getInt("insNo");			
				insList.add(insNo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator <Integer> insListIterator = insList.iterator();
		int min = 0;
		while(insListIterator.hasNext()) {
			int p = insListIterator.next();
			if(p != min) {
				break;
			}
			System.out.println("p= " + p);
			min = min + 1;
		}
		int yourMinimum = min;
		return yourMinimum;
	}


	public static void main(String[] args) {
		/*int min = 7;
		for(int z = 1; min != z; z++) {
			System.out.println("min= " + min);
			System.out.println("z= " + z);*/
		/*if(min == z) {
				System.out.println("das" + min);
				break;
			}*/
		try{
			InsuranceJDBC jdbc = new InsuranceJDBC();
			System.out.println(jdbc.insuranceValidation("Allianz","Elite"));
			
			Insurance insurance = new Insurance(0, "AIG", "AIG Primiere","BlaBa",3.3);
			/*boolean result = jdbc.addStudent(insurance);
			System.out.println(result);
			boolean dltResult = jdbc.deleteInsurance(insurance);
			System.out.println(dltResult);
			Insurance insurance2 = new Insurance(9,"Mexico","Saturn","2018-11-03 19:00:00","2225-11-03 22:22:22");
				boolean updateResult = jdbc.updateInsurance(insurance2);
				System.out.println(updateResult);
			ArrayList<Insurance> viewResult = jdbc.ViewAllInsurance();
				System.out.println(viewResult);
			 */
			System.out.println(jdbc.ViewAllInsNo());
			jdbc.insNoValidation();
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}

}