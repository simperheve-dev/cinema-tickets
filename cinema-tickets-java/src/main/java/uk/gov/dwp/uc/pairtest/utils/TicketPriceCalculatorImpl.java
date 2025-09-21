package uk.gov.dwp.uc.pairtest.utils;

import java.util.HashMap;
import java.util.Map;

import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest.Type;

public class TicketPriceCalculatorImpl implements TicketPriceCalculator{

	private Map<Type, Integer> priceMap; 
	
	public TicketPriceCalculatorImpl() {
		priceMap = new HashMap<TicketTypeRequest.Type, Integer>();
		priceMap.put(Type.ADULT, 25);
		priceMap.put(Type.CHILD, 15);
		priceMap.put(Type.INFANT, 0);
	}
	
	@Override
	public int calculate(TicketTypeRequest request) {
		
		return request.getNoOfTickets() * priceMap.get(request.getTicketType());
	}
}
