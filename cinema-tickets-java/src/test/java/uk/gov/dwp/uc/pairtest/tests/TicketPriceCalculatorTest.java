package uk.gov.dwp.uc.pairtest.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest.Type;
import uk.gov.dwp.uc.pairtest.utils.TicketPriceCalculator;
import uk.gov.dwp.uc.pairtest.utils.TicketPriceCalculatorImpl;

public class TicketPriceCalculatorTest {

	private TicketPriceCalculator ticketPriceCalculator;
	
	@BeforeEach
	public void before()
	{
		ticketPriceCalculator = new TicketPriceCalculatorImpl();
	}
	
	@Test
	public void singleAdultTicketTest() {
		
		int expected = 25;
		int result = 0;
		
		TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(Type.ADULT, 1);
		
		result = ticketPriceCalculator.calculate(ticketTypeRequest);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void singleChildTicketTest() {
		
		int expected = 15;
		int result = 0;
		
		TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(Type.CHILD, 1);
		
		result = ticketPriceCalculator.calculate(ticketTypeRequest);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void doubleAdultTicketTest() {
		
		int expected = 50;
		int result = 0;
		
		TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(Type.ADULT, 2);
		
		result = ticketPriceCalculator.calculate(ticketTypeRequest);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void doubleChildTicketTest() {
		
		int expected = 30;
		int result = 0;
		
		TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(Type.CHILD, 2);
		
		result = ticketPriceCalculator.calculate(ticketTypeRequest);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void singleInfantTicketTest() {
		
		int expected = 0;
		int result = 0;
		
		TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(Type.INFANT, 0);
		
		result = ticketPriceCalculator.calculate(ticketTypeRequest);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void thousandAdultTicketTest() {
		
		int expected = 25000;
		int result = 0;
		
		TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(Type.ADULT, 1000);
		
		result = ticketPriceCalculator.calculate(ticketTypeRequest);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void thousandChildTicketTest() {
		
		int expected = 15000;
		int result = 0;
		
		TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(Type.CHILD, 1000);
		
		result = ticketPriceCalculator.calculate(ticketTypeRequest);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void thousandInfantTicketTest() {
		
		int expected = 0;
		int result = 0;
		
		TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(Type.INFANT, 1000);
		
		result = ticketPriceCalculator.calculate(ticketTypeRequest);
		
		assertEquals(expected, result);
	}
}
