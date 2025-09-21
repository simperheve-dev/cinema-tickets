package uk.gov.dwp.uc.pairtest.utils;

import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;

public interface TicketPriceCalculator {

	int calculate(TicketTypeRequest request);
}
