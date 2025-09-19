package uk.gov.dwp.uc.pairtest;

import uk.gov.dwp.uc.pairtest.domain.Booking;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;
import uk.gov.dwp.uc.pairtest.utils.TicketPriceCalculator;
import uk.gov.dwp.uc.pairtest.utils.TicketPriceCalculatorImpl;

public class TicketServiceImpl implements TicketService {
	/**
	 * Should only have private methods other than the one below.
	 */
	
	private final Booking booking;
	private TicketPriceCalculator ticketPriceCalculator;

	public TicketServiceImpl() {
		ticketPriceCalculator = new TicketPriceCalculatorImpl();
		booking = new Booking();
	}
	
	@Override
	public void purchaseTickets(Long accountId, TicketTypeRequest... ticketTypeRequests)
			throws InvalidPurchaseException {

		for (TicketTypeRequest ticketTypeRequest : ticketTypeRequests) {
			
			float ticketPrice = ticketPriceCalculator.calculate(ticketTypeRequest);
		}
	}
}
