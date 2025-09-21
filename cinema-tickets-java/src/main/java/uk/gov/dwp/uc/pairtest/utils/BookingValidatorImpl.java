package uk.gov.dwp.uc.pairtest.utils;

public class BookingValidatorImpl extends BookingValidator {

	@Override
	public boolean validate() {
		
		return validAccountId()
				&& atLeastOneAdult()
				&& infantsLessOrEqualToAdults() 
				&& equalOrBelowMaxTickets();
	}
	
	// Maximum of 25 tickets
	// Equal or less infants to adults
	// Minimum of 1 adult ticket
	// Business rules do not specify ratio of child to adult tickets

	private boolean validAccountId()
	{
		return getBooking().getAccountId() > 0;
	}
	
	private boolean atLeastOneAdult()
	{
		return getBooking().getAdultTickets() > 0;
	}
	
	private boolean infantsLessOrEqualToAdults()
	{
		return getBooking().getInfantTickets() <= getBooking().getAdultTickets();
	}
	
	private boolean equalOrBelowMaxTickets() {
		return (getBooking().getAdultTickets() + getBooking().getChildTickets() + getBooking().getInfantTickets()) <= 25;
	}
}
