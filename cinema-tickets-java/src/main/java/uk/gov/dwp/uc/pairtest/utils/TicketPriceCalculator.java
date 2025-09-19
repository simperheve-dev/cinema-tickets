package uk.gov.dwp.uc.pairtest.utils;

import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;

public interface TicketPriceCalculator {

	float calculate(TicketTypeRequest request);
}
