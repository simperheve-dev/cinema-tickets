package uk.gov.dwp.uc.pairtest.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.gov.dwp.uc.pairtest.domain.Booking;
import uk.gov.dwp.uc.pairtest.utils.BookingValidator;
import uk.gov.dwp.uc.pairtest.utils.BookingValidatorImpl;

public class BookingValidatorTest {

	private BookingValidator bookingValidator;
	
	@BeforeEach
	public void before() {
		bookingValidator = new BookingValidatorImpl();
	}
	
	@Test
	public void testMaximumTicketsWhereNumberValid() {
		
		Booking booking = new Booking(1);
		booking.addAdultTickets(1);
		
		booking.addToTotal(1);
		
		bookingValidator.setBooking(booking);
		
		assertTrue(bookingValidator.validate());
	}
	
	@Test
	public void testValidWhenAdultAndInfantTicketsValid() {
		
		Booking booking = new Booking(1);
		booking.addAdultTickets(1);
		booking.addInfantTickets(1);
		
		booking.addToTotal(1);
		
		bookingValidator.setBooking(booking);
		
		assertTrue(bookingValidator.validate());
	}
	
	@Test
	public void testInValidWhenNoAdultTickets() {
		
		Booking booking = new Booking(1);
		booking.addAdultTickets(0);
		booking.addInfantTickets(1);
		
		booking.addToTotal(1);
		
		bookingValidator.setBooking(booking);
		
		assertFalse(bookingValidator.validate());
	}
	
	@Test
	public void testInvalidAccountId() {
		Booking booking = new Booking(0);
		booking.addAdultTickets(1);
		
		booking.addToTotal(1);
		
		bookingValidator.setBooking(booking);
		
		assertFalse(bookingValidator.validate());
	}
	
	@Test
	public void testInvalidTicketNumber()
	{
		Booking booking = new Booking(1);
		booking.addAdultTickets(100);
		booking.addInfantTickets(1);
		booking.addToTotal(1);
		
		bookingValidator.setBooking(booking);
		
		assertFalse(bookingValidator.validate());
	}
	
	@Test
	public void testInvalidNoOfInfantsToAdults()
	{
		Booking booking = new Booking(1);
		booking.addAdultTickets(1);
		booking.addInfantTickets(7);
		booking.addToTotal(1);
		
		bookingValidator.setBooking(booking);
		
		assertFalse(bookingValidator.validate());
	}
}
