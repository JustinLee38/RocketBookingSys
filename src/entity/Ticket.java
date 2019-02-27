package entity;

public class Ticket {
	private int ticketNo;
	private Flight flight;
	private Seat seat;
	private Insurance insurance;
	private double ticketPrice;
	private int flightNo;
	private int seatNo;
	private int insNo;
	private double seatPrice,insPrice;
	
	Ticket(int ticketNo, double ticketPrice, Flight flight, Seat seat, Insurance insurance){
		setTicketNo(ticketNo);
		setTicketPrice(ticketPrice);
		setFlight(flight);
		setSeat(seat);
		setInsurance(insurance);
	}
	

	
	
	public Ticket(int ticketNo, double ticketPrice, int flightNo, int seatNo, int insNo, double seatPrice, double insPrice) {
		setTicketNo(ticketNo);
		setTicketPrice(ticketPrice);
		setFlightNo(flightNo);
		setSeatNo(seatNo);
		setInsNo(insNo);
		setSeatPrice(seatPrice);
		setInsPrice(insPrice);
	}
	
	public Ticket(int ticketNo, double ticketPrice, int flightNo, int seatNo, int insNo) {
		setTicketNo(ticketNo);
		setTicketPrice(ticketPrice);
		setFlightNo(flightNo);
		setSeatNo(seatNo);
		setInsNo(insNo);
	}
	
	
	public Ticket(int ticketNo, double ticketPrice, int flightNo, int insNo) {
		setTicketNo(ticketNo);
		setTicketPrice(ticketPrice);
		setFlightNo(flightNo);
		setSeatNo(seatNo);
		setInsNo(insNo);
	}
	
	public Ticket(int ticketNo, double ticketPrice, int seatNo) {
		setTicketNo(ticketNo);
		setTicketPrice(ticketPrice);
		setSeatNo(seatNo);
	}
	public Ticket() {
		
	}


	public double getSeatPrice() {
		return seatPrice;
	}


	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}




	public double getInsPrice() {
		return insPrice;
	}




	public void setInsPrice(double insPrice) {
		this.insPrice = insPrice;
	}




	public int getFlightNo() {
		return flightNo;
	}


	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}


	public int getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}


	public int getInsNo() {
		return insNo;
	}


	public void setInsNo(int insNo) {
		this.insNo = insNo;
	}


	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}


	@Override
	public String toString() {
		return "Ticket [ticketNo=" + ticketNo + ", ticketPrice=" + ticketPrice + ", flightNo=" + flightNo + ", seatNo="
				+ seatNo + ", insNo=" + insNo + "]";
	}
	
	

}
