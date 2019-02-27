 package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import entity.Seat;
import entity.Ticket;

public class SeatJDBC {
	Statement stmt;
	//constructor
	public SeatJDBC () throws SQLException, Exception {
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

	public boolean addSeat(Seat seat)throws SQLException{
		//4. sql statement
		String insert = String.format("INSERT INTO `seat`(`seatNo`, `seatType`, `seatFood`, `seatPrice`, `seatDescription`) VALUES"
				+"('%d','%s','%s','%.2f','%s')",seat.getSeatNo(), seat.getSeatType(), seat.getSeatFood(), seat.getSeatPrice(), 
				seat.getSeatDescription()); 
		
		System.out.println(insert);
		//5. execute update
		int rows = stmt.executeUpdate(insert);
		//6. return result
		if (rows ==1)
			return true;
		else
			return false;
	}

	public boolean deleteSeat(String seatNo) throws SQLException{
		//4: sql
		String delete = String.format("DELETE FROM `seat` WHERE "
				+ "seatNo='%s'", seatNo);
		
		//5. execute update
		int rows = stmt.executeUpdate(delete);
		//6. return result
		if (rows > 0)
			return true;
		else
			return false;

	}

	public boolean updateSeat(Seat seat) throws SQLException{
		int seatNo = seat.getSeatNo();
		
		String update = String.format("UPDATE `seat` SET `seatType`='%s',`seatFood`='%s',`seatPrice`='%.2f', "
				+ "`seatDescription`='%s' WHERE seatNo = '%d'", seat.getSeatType(),seat.getSeatFood(),
				seat.getSeatPrice(), seat.getSeatDescription(), seatNo );
		
		System.out.println(update);
		int rows = stmt.executeUpdate(update);

		if (rows == 1)
			return true;
		else
			return false;
	}

	public ArrayList <Seat> ViewAllSeat () throws Exception{
		ArrayList <Seat> seatList = new ArrayList<Seat>();
		String view = "select * from seat order by seatNo";
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()){
			int seatNo = rs.getInt("seatNo");
			String seatType = rs.getString("seatType");
			String seatFood = rs.getString("seatFood");
			double seatPrice = rs.getDouble("seatPrice");
			String seatDescription = rs.getString("seatDescription");

			Seat seat = new Seat(seatNo, seatType, seatFood, seatPrice, seatDescription);
			seatList.add(seat);
		}
		return seatList;
	}
	
	public boolean seatValidation() throws Exception{
		int seatNo = 100;
		String view = "SELECT COUNT(`seatNo`) FROM seat";
		System.out.println(view);
		ResultSet rs = stmt.executeQuery(view);
		
		while (rs.next()){
			seatNo = rs.getInt("COUNT(`seatNo`)");
		}
		System.out.println(seatNo);
		if(seatNo < 16)
			return true;
		else
			return false;
		
	}
	
	public ArrayList <String> ViewAllSeatNo() throws Exception{
		ArrayList <String> seatList=new ArrayList<String>();
		String view = "SELECT `seatNo` FROM `seat`";
		System.out.println(view);
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()){
			String seatNo = rs.getString("seatNo");			
			seatList.add(seatNo);
		}
		return seatList;
	}
	
	public double getSeatPrice(int userSeatNo) throws SQLException {
		String view = String.format("select seatPrice from seat where seatNo = '%s'", userSeatNo);
		ResultSet rs = stmt.executeQuery(view);
		System.out.println(view);
		double seatPrice = 0.0;
		while (rs.next()){

			seatPrice = rs.getDouble("seatPrice");
		}
		return seatPrice;
	}
	
	
	
/*	public int getSeatNo() throws SQLException {
		String view = String.format("select seatNo from seat");
		ResultSet rs = stmt.executeQuery(view);
		System.out.println(view);
		int seatNo = 0;
		while (rs.next()){

			seatNo = rs.getInt("seatNo");
		}
		return seatNo;
	}*/
	
	public int seatNoValidation() {
		ArrayList <Integer> seatList=new ArrayList<Integer>();
		String view = "SELECT `seatNo` FROM `seat`";
		System.out.println(view);
		ResultSet rs;
		try {
			rs = stmt.executeQuery(view);
			while (rs.next()){
				int seatNo = rs.getInt("seatNo");			
				seatList.add(seatNo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator <Integer> seatListIterator = seatList.iterator();
		int min = 1;
		while(seatListIterator.hasNext()) {
			int p = seatListIterator.next();
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

		try{
			SeatJDBC jdbc = new SeatJDBC();
			System.out.println(jdbc.seatValidation());
			System.out.println(jdbc.getSeatPrice(6)); 
			/*Seat seat = new Seat(103,"First Class","Japanese Bento",10.2,"Good");
			boolean result = jdbc.addSeat(seat);
			System.out.println(result);
			boolean dltResult = jdbc.deleteSeat(seat);
			System.out.println(dltResult);
			Seat seat2 = new Seat(101,"First Class","American Big Breakfast",10.5,"Good");
			boolean updateResult = jdbc.updateSeat(seat2);
			System.out.println(updateResult);
			ArrayList<Seat> viewResult = jdbc.ViewAllSeat();
			System.out.println(viewResult);
*/
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
}