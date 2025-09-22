package uk.gov.dwp.uc.pairtest.utils;

public class BookingValidatorImpl extends BookingValidator {

	@Override
	public boolean validate() {

		//Captured in variables for easier debugging
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

	//Check account ID is greater than 0
	private boolean validAccountId()
	{
		return getBooking().getAccountId() > 0;
	}
	
	// Minimum of 1 adult ticket to prevent booking of child/infant tickets
	private boolean atLeastOneAdult()
	{
		return getBooking().getAdultTickets() > 0;
	}

	// Equal or less infants to adults
	private boolean infantsLessOrEqualToAdults()
	{
		return getBooking().getInfantTickets() <= getBooking().getAdultTickets();
	}
	
	// Maximum of 25 tickets
	private boolean equalOrBelowMaxTickets() {
		return (getBooking().getAdultTickets() + getBooking().getChildTickets() + getBooking().getInfantTickets()) <= 25;
	}
}
