package uk.gov.dwp.uc.pairtest.domain;

public class Booking {
	
	private int adultTickets;
	private int childTickets;
	private int infantTickets;
	private float total;
	
	public Booking() {
		// TODO Auto-generated constructor stub
		adultTickets = 0;
		childTickets = 0;
		infantTickets = 0;
		total = 0;
	}
	
	public int getAdultTickets() {
		return adultTickets;
	}
	
	public void addAdultTickets(int amount)
	{
		adultTickets += amount;
	}
	
	public int getChildTickets() {
		return childTickets;
	}
	
	public void addChildTickets(int amount)
	{
		childTickets += amount;
	}
	
	public int getInfantTickets() {
		return infantTickets;
	}
	
	public void addInfantTickets(int amount)
	{
		infantTickets += amount;
	}
	
	public float getTotal() {
		return total;
	}
}
