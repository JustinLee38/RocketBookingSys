package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.mysql.jdbc.log.Log;

import entity.Flight;

public class FlightJDBC {
	Statement stmt;
	//constructor
	public FlightJDBC () throws SQLException, Exception {
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

	public boolean addFlight (Flight flight)throws SQLException{
		//4. sql statement
		String insert = String.format("INSERT INTO `flight`(`flightNo`, `origin`, `destination`, `departureTime`, `arrivalTime`) VALUES "
				+"('%d','%s','%s','%s','%s')",flight.getFlightNo(),flight.getOrigin(), flight.getDestination(), 
				flight.getDepartureTime(), flight.getArrivalTime());
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

	public boolean deleteFlight(String flightNo) throws SQLException{
		//4: sql
		String delete = String.format("DELETE FROM `flight` WHERE"
				+ " flightNo='%s'", flightNo); //need to put new FlightNo
		//5. execute update
		System.out.println(delete);
		int rows = stmt.executeUpdate(delete);
		//6. return result
		if (rows > 0)
			return true;
		else
			return false;

	}

	public boolean updateFlight(Flight flight) throws SQLException{
		int flightNo = flight.getFlightNo();
		String update = String.format("UPDATE `flight` SET `origin`='%s',"
				+ "`destination`='%s',`departuretime`='%s',`arrivaltime`='%s' WHERE flightno = '%d'", flight.getOrigin(),
				flight.getDestination(), flight.getDepartureTime(), flight.getArrivalTime(), flightNo);
		System.out.println(update);
		int rows = stmt.executeUpdate(update);

		if (rows == 1)
			return true;
		else
			return false;
	}

	public ArrayList <Flight> ViewAllFlight() throws Exception{
		ArrayList <Flight>flightList=new ArrayList<Flight>();
		String view = "select * from flight order by flightNo";
		System.out.println(view);
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()){
			int flightNo = rs.getInt("flightNo");
			String origin = rs.getString("origin");
			String destination = rs.getString("destination");
			String departureTime = rs.getString("departuretime");
			String arrivalTime = rs.getString("arrivaltime");				

			Flight flight = new Flight(flightNo, origin, destination, departureTime, arrivalTime);
			flightList.add(flight);
		}
		return flightList;
	}

	public ArrayList <String> ViewAllFlightNo() throws Exception{
		ArrayList <String> flightList=new ArrayList<String>();
		String view = "SELECT `flightNo` FROM `flight`";
		System.out.println(view);
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()){
			String flightNo = rs.getString("flightNo");			
			flightList.add(flightNo);
		}
		return flightList;
	}

	public int flightNoCount() throws Exception{
		String count = "SELECT COUNT(flightNo) AS FlightCount FROM flight";
		int rowCount = 0;
		System.out.println(count);
		ResultSet rs = stmt.executeQuery("select count(*) from flight");

		while (rs.next()) {
			rowCount = rs.getInt(1);
		}
		return 1;
	}

	public int flightNoValidation() {
		ArrayList <Integer> flightList=new ArrayList<Integer>();
		String view = "SELECT `flightNo` FROM `flight`";
		System.out.println(view);
		ResultSet rs;
		try {
			rs = stmt.executeQuery(view);
			while (rs.next()){
				int flightNo = rs.getInt("flightNo");			
				flightList.add(flightNo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator <Integer> flightListIterator = flightList.iterator();
		int min = 1;
		while(flightListIterator.hasNext()) {
			int p = flightListIterator.next();
			if(p != min) {
				break;
			}
			System.out.println("p= " + p);
			min = min + 1;
		}
		int yourMinimum = min;
		return yourMinimum;
	}

	private ArrayList<Integer> getIntegerArray(ArrayList<String> stringArray) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(String stringValue : stringArray) {
			try {
				//Convert String to Integer, and store it into integer array list.
				result.add(Integer.parseInt(stringValue));
			} catch(NumberFormatException nfe) {
				System.out.println("Could not parse " + nfe);
			} 
		}       
		return result;
	}


	public static void main(String[] args) {

		try{
			FlightJDBC jdbc = new FlightJDBC();
			jdbc.flightNoCount();
			/*Flight flight = new Flight(10,"Mexico","Saturn","2018-11-03 19:00:00","2225-11-03 19:00:00");*/
			/*boolean result = jdbc.addStudent(flight);
			System.out.println(result);*/
			/*boolean dltResult = jdbc.deleteFlight(flight);
			System.out.println(dltResult);*/
			/*Flight flight2 = new Flight(9,"Mexico","Saturn","2018-11-03 19:00:00","2225-11-03 22:22:22");
			boolean updateResult = jdbc.updateFlight(flight2);
			System.out.println(updateResult);*/
			/*ArrayList<Flight> viewResult = jdbc.ViewAllFlight();
			System.out.println(viewResult);
			System.out.println(jdbc.flightNoCount());*/

		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}