package uk.gov.dwp.uc.pairtest.utils;

public class BookingValidatorImpl extends BookingValidator {

	@Override
	public boolean validate() {
		
		boolean validAccountId = validAccountId();
		boolean atLeastOneAdult = atLeastOneAdult();
		boolean infantsLessOrEqualToAdults = infantsLessOrEqualToAdults();
		boolean equalOrBelowMaxTickets = equalOrBelowMaxTickets();
		
		if(getBooking() != null) {
			return validAccountId
					&& atLeastOneAdult
					&& infantsLessOrEqualToAdults 
					&& equalOrBelowMaxTickets;
		}
		
		return false;
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
