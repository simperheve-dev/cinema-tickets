package uk.gov.dwp.uc.pairtest.utils;

import uk.gov.dwp.uc.pairtest.domain.Booking;

public abstract class BookingValidator {

	private Booking booking;

	public BookingValidator() {
		// TODO Auto-generated constructor stub
	}

	public abstract boolean validate();

	public void setBooking(Booking booking) {
		if(this.booking == null)
		{
			this.booking = booking;
		}
	}

	Booking getBooking() {
		return booking;
	}
}
