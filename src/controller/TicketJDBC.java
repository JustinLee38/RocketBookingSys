package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import entity.Seat;
import entity.Ticket;

public class TicketJDBC {
	Statement stmt;
	Statement stmt2;
	Statement stmt3;
	//constructor
	public TicketJDBC () throws SQLException, Exception {
		//1. load driver
		Class.forName("com.mysql.jdbc.Driver");
		//2. connect to mydatbase 
		String url = "jdbc:mysql://localhost:3306/rocketbookingsystem";
		String user= "root";
		String password="";
		Connection con = DriverManager.getConnection(url, user, password);
		//3. create statement
		stmt = con.createStatement();
		stmt2 = con.createStatement();
		stmt3 = con.createStatement();
	}

	public boolean addTicket (Ticket ticket)throws SQLException{
		//4. sql statement

		String insert = String.format("INSERT INTO `ticket`(`ticketNo`, `ticketPrice`, `flightNo`, `seatNo`, `insNo`) VALUES "
				+"('%d',%.2f,'%d','%d','%d')",ticket.getTicketNo(), ticket.getTicketPrice(), 
				ticket.getFlightNo(), ticket.getSeatNo(), ticket.getInsNo()); 
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

	public boolean deleteTicket(String ticketNo) throws SQLException{
		//4: sql
		String delete = String.format("DELETE FROM `ticket` WHERE "
				+ "ticketno='%s'", ticketNo);

		System.out.println(delete);
		//5. execute update
		int rows = stmt.executeUpdate(delete);
		//6. return result
		if (rows > 0)
			return true;
		else
			return false;

	}

	public boolean updateTicket(Ticket ticket) throws SQLException{

		String update = String.format("UPDATE `ticket` SET `ticketPrice`='%.2f',`flightNo`='%d',`seatNo`='%d',"
				+ "`insNo`='%d' WHERE ticketNo = '%d'", ticket.getTicketPrice(), ticket.getFlightNo(), 
				ticket.getSeatNo(), ticket.getInsNo(), ticket.getTicketNo());

		int rows = stmt.executeUpdate(update);

		if (rows == 1)
			return true;
		else
			return false;
	}

	public boolean updateTicket2(Ticket ticket) throws SQLException{
		String update = String.format("UPDATE `ticket` SET `seatNo`='%d', `ticketPrice`='%.2f' WHERE `ticketNo` = '%d'"
				, ticket.getSeatNo(), ticket.getTicketPrice(), ticket.getTicketNo());
		System.out.println("GEt TICKET NO " + ticket.getTicketNo());
		System.out.println(update);
		int rows = stmt.executeUpdate(update);

		if (rows == 1)
			return true;
		else
			return false;
	}


	public ArrayList <Ticket> ViewAllTicket(String userFlightNo) throws Exception{
		ArrayList <Ticket>ticketList=new ArrayList<Ticket>();
		double seatPrice = 0;
		double insPrice = 0;
		String url = "jdbc:mysql://localhost:3306/rocketbookingsystem";
		String user= "root";
		String password="";
		Connection con = DriverManager.getConnection(url, user, password);
		stmt2 = con.createStatement();
		stmt3 = con.createStatement();
		String view = String.format("select ticket.* from ticket where ticket.flightNo in (select flight.flightNo "
				+ "from flight where flight.flightNo = '%s')", userFlightNo);
		ResultSet rs = stmt.executeQuery(view);
		System.out.println(view);
		while (rs.next()){
			int ticketNo = rs.getInt("ticketNo");
			Double ticketPrice = rs.getDouble("ticketPrice");
			int flightNo = rs.getInt("flightNo");
			int seatNo = rs.getInt("seatNo");
			int insNo = rs.getInt("insNo");

			String view2 = String.format("SELECT `seatPrice` FROM `seat` WHERE `seatNo`='%s'", seatNo);
			ResultSet rs2 = stmt2.executeQuery(view2);
			System.out.println(view2);

			while (rs2.next()){
				seatPrice = rs2.getDouble("seatPrice");
			}



			String view3 = String.format("SELECT `insPrice` FROM `insurance` WHERE `insNo`='%s'", insNo);
			ResultSet rs3 = stmt3.executeQuery(view3);
			System.out.println(view3);
			while (rs3.next()){
				insPrice = rs3.getDouble("insPrice");
			}

			Ticket newTicket = new Ticket(ticketNo, ticketPrice, flightNo, seatNo, insNo, seatPrice, insPrice);
			ticketList.add(newTicket);
		}
		return ticketList;
	}

	public ArrayList <String> ViewAllTicketNo() throws Exception{
		ArrayList <String> ticketList=new ArrayList<String>();
		String view = "SELECT `ticketNo` FROM `ticket` ORDER BY `ticketNo`";
		System.out.println(view);
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()){
			String ticketNo = rs.getString("ticketNo");			
			ticketList.add(ticketNo);
		}
		return ticketList;
	}


	public ArrayList <String> ViewAllSeatNo(int flightNo) throws Exception{
		ArrayList <String> seatList=new ArrayList<String>();
		String view = String.format("SELECT `seatNo` FROM `ticket` WHERE `flightNo`=%s", flightNo);
		System.out.println(view);
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()){
			String seatNo = rs.getString("seatNo");			
			seatList.add(seatNo);
		}
		return seatList;
	}


	public int getTicketNo(int userSeatNo) throws SQLException {
		String view = String.format("select ticketNo from ticket where seatNo = '0'", userSeatNo);
		ResultSet rs = stmt.executeQuery(view);
		System.out.println(view);
		int ticNo = 0;
		while (rs.next()){

			ticNo = rs.getInt("ticketNo");
		}
		return ticNo;
	}

	public double getPrice(int userSeatNo) throws SQLException {
		String view = String.format("select ticketPrice from ticket where seatNo = '0'", userSeatNo);
		ResultSet rs = stmt.executeQuery(view);
		System.out.println(view);
		double ticPrice = 0;
		while (rs.next()){

			ticPrice = rs.getDouble("ticketPrice");
		}
		return ticPrice;
	}

	public int ticketNoValidation() {
		ArrayList <Integer> ticketList=new ArrayList<Integer>();
		String view = "SELECT `ticketNo` FROM `ticket` order by ticketNo";
		System.out.println(view);
		ResultSet rs;
		try {
			rs = stmt.executeQuery(view);
			while (rs.next()){
				int ticketNo = rs.getInt("ticketNo");			
				ticketList.add(ticketNo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator <Integer> ticketListIterator = ticketList.iterator();
		int min = 1;
		while(ticketListIterator.hasNext()) {
			int p = ticketListIterator.next();
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
			TicketJDBC jdbc = new TicketJDBC();

			Ticket ticket = new Ticket(3, 12.11, 11, 10, 1);
			/*boolean result = jdbc.addTicket(ticket);
				System.out.println(result);*/
			/*boolean dltResult = jdbc.deleteTicket(ticket);
				System.out.println(dltResult);*/
			Ticket ticket2 = new Ticket(1, 21312, 321, 312, 1);
			boolean updateResult = jdbc.updateTicket(ticket2);
			System.out.println(updateResult);
			ArrayList<Ticket> viewResult = jdbc.ViewAllTicket("1");
			System.out.println(viewResult);

		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}