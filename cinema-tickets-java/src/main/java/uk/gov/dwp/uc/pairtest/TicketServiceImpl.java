package uk.gov.dwp.uc.pairtest;

import thirdparty.paymentgateway.TicketPaymentService;
import thirdparty.paymentgateway.TicketPaymentServiceImpl;
import thirdparty.seatbooking.SeatReservationService;
import thirdparty.seatbooking.SeatReservationServiceImpl;
import uk.gov.dwp.uc.pairtest.domain.Booking;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;
import uk.gov.dwp.uc.pairtest.utils.BookingValidator;
import uk.gov.dwp.uc.pairtest.utils.BookingValidatorImpl;
import uk.gov.dwp.uc.pairtest.utils.TicketPriceCalculator;
import uk.gov.dwp.uc.pairtest.utils.TicketPriceCalculatorImpl;

public class TicketServiceImpl implements TicketService {
	/**
	 * Should only have private methods other than the one below.
	 */

	private BookingValidator validator;
	private TicketPriceCalculator ticketPriceCalculator;
	private SeatReservationService seatReservationService;
	private TicketPaymentService ticketPaymentService;

	public TicketServiceImpl() {
		ticketPriceCalculator = new TicketPriceCalculatorImpl();
		validator = new BookingValidatorImpl();
		seatReservationService = new SeatReservationServiceImpl();
		ticketPaymentService = new TicketPaymentServiceImpl();
	}

	@Override
	public void purchaseTickets(Long accountId, TicketTypeRequest... ticketTypeRequests)
			throws InvalidPurchaseException {

		Booking booking = new Booking(accountId);
		validator.setBooking(booking);
		
		for (TicketTypeRequest ticketTypeRequest : ticketTypeRequests) {

			int ticketPrice = ticketPriceCalculator.calculate(ticketTypeRequest);

			switch (ticketTypeRequest.getTicketType()) {
				case ADULT: {
					booking.addAdultTickets(ticketTypeRequest.getNoOfTickets());
				}
				case CHILD: {
					booking.addChildTickets(ticketTypeRequest.getNoOfTickets());
				}
	
				case INFANT: {
					booking.addInfantTickets(ticketTypeRequest.getNoOfTickets());
				}
			}
			
			booking.addToTotal(ticketPrice);
		}
		
		if(validator.validate())
		{
			ticketPaymentService.makePayment(booking.getAccountId(), booking.getTotal());
			seatReservationService.reserveSeat(booking.getAccountId(), booking.getSeatableTickets());
		}
	}
}
